package com.psf.petagram.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.psf.petagram.interactors.DataBase;

import java.util.ArrayList;

/**
 * Created by paulsalcedo on 15/2/18.
 */

public class MascotaTable extends DataBase {

    static String TABLE_NAME = "mascotas";
    private static int VERSION = 1;

    public static final String FOTO = "foto";
    public static final String NOMBRE = "nombre";
    public static final String LIKES = "likes";

    private static String[] FIELDS = {
            FOTO + " int(11)",
            NOMBRE + " varchar(30)",
            LIKES + " int(11)",
    };

    private Context context;

    public MascotaTable(Context context) {
        super(context, TABLE_NAME, FIELDS, VERSION);
        this.context = context;
    }

    public ArrayList<Mascota> getAll() {
        ArrayList<Mascota> mascotas = new ArrayList<>();

        SQLiteDatabase db = this.getWritableDatabase();
        if (db != null) {
            Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

            while (cursor.moveToNext()) {
                Mascota mascota = new Mascota();
                mascota.setId(cursor.getInt(0));
                mascota.setFoto(cursor.getInt(1));
                mascota.setNombre(cursor.getString(2));
                mascota.setLikes(cursor.getInt(3));

                mascotas.add(mascota);
            }
            db.close();
        }
        return mascotas;
    }

    public ArrayList<Mascota> getTopFive() {
        ArrayList<Mascota> mascotas = new ArrayList<>();

        SQLiteDatabase db = this.getWritableDatabase();
        if (db != null) {
            String query = "SELECT * FROM " + TABLE_NAME + " ORDER BY " + LIKES + " DESC LIMIT 5";
            Cursor cursor = db.rawQuery(query, null);

            while (cursor.moveToNext()) {
                Mascota mascota = new Mascota();
                mascota.setId(cursor.getInt(0));
                mascota.setFoto(cursor.getInt(1));
                mascota.setNombre(cursor.getString(2));
                mascota.setLikes(cursor.getInt(3));

                mascotas.add(mascota);
            }
            db.close();
        }
        return mascotas;
    }

    public void insertMascota(ContentValues values) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public void addLike(Mascota mascota) {
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "UPDATE " + TABLE_NAME + " SET " +
                LIKES + " = (" + LIKES + " + 1) WHERE id = '" +
                String.valueOf(mascota.getId()) +"' ";
        db.execSQL(query);
        db.close();
    }

    public int getLikes(Mascota mascota) {
        int likes = 0;
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "SELECT " + LIKES + " FROM " + TABLE_NAME +
                " WHERE id ='" + mascota.getId() +  "'";

        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToNext()) {
            likes = cursor.getInt(0);
        }

        db.close();
        return likes;
    }

}
