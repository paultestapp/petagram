package com.psf.petagram.adapters;

import android.app.Activity;
import android.content.res.Resources;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.psf.petagram.R;
import com.psf.petagram.models.Mascota;

import java.util.ArrayList;

/**
 * Created by paulsalcedo on 13/2/18.
 */

public class MascotaAdapter extends  RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder> {

    private ArrayList<Mascota> mascotas;

    private Activity activity;
    private Resources resources;

    public MascotaAdapter(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
        this.resources = activity.getResources();
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.carview_mascotas, parent, false);
        return new MascotaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder mascotaViewHolder, int i) {
        final int idx = i;

        final Mascota mascota = mascotas.get(idx);

        mascotaViewHolder.iv_photo.setImageResource(mascota.getFoto());
        mascotaViewHolder.tv_name.setText(mascota.getNombre());
        mascotaViewHolder.tv_likes.setText(String.valueOf(mascota.getLikes()));

        mascotaViewHolder.ib_addlike.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String message = resources.getString(R.string.label_add_like) + " " + mascota.getNombre();
                Snackbar.make(view, message, Snackbar.LENGTH_SHORT)
                        .show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }


    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_photo;
        private ImageButton ib_addlike;
        private TextView tv_name;
        private TextView tv_likes;

        public MascotaViewHolder(View itemView) {
            super(itemView);

            iv_photo = itemView.findViewById(R.id.iv_photo);
            ib_addlike = itemView.findViewById(R.id.ib_addlike);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_likes = itemView.findViewById(R.id.tv_likes);
        }
    }
}
