package com.psf.petagram.interactors;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by paulsalcedo on 15/2/18.
 */

public class DataBase extends SQLiteOpenHelper  {

    private Context context;
    private String table_name;
    private String[] fields;
    private int version;

    public DataBase(Context context, String table_name, String[] fields, int version) {
        super(context, table_name, null, version);

        this.context = context;
        this.table_name = table_name;
        this.fields = fields;
        this.version = version;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE IF NOT EXISTS "
                + table_name + " ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, " + implode(fields, ", ")
                + ");";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + table_name);
        onCreate(db);
    }

    private String implode(String[] inputArray, String glueString) {
        String output = "";
        if (inputArray.length > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(inputArray[0]);

            for (int i=1; i<inputArray.length; i++) {
                sb.append(glueString);
                sb.append(inputArray[i]);
            }

            output = sb.toString();
        }
        return output;
    }

}
