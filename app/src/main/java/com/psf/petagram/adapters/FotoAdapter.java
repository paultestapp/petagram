package com.psf.petagram.adapters;

import android.app.Activity;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.psf.petagram.R;
import com.psf.petagram.models.Foto;

import java.util.ArrayList;

/**
 * Created by paulsalcedo on 13/2/18.
 */

public class FotoAdapter extends  RecyclerView.Adapter<FotoAdapter.FotoViewHolder> {

    View view;
    private ArrayList<Foto> fotos;

    public FotoAdapter(ArrayList<Foto> fotos) {
        this.fotos = fotos;
    }

    @Override
    public FotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.carview_fotos, parent, false);
        return new FotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FotoViewHolder fotoViewHolder, int i) {
        final Foto foto = fotos.get(i);

//        fotoViewHolder.iv_photo.setImageResource(foto.getFoto());
        Glide.with(view)
                .load(foto.getFoto_url())
                .apply(new RequestOptions().placeholder(R.drawable.ic_camera_24dp))
                .into(fotoViewHolder.iv_photo);
        fotoViewHolder.tv_likes.setText(String.valueOf(foto.getLikes()));
    }

    @Override
    public int getItemCount() {
        return fotos.size();
    }

    public static class FotoViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_photo;
        private TextView tv_likes;

        public FotoViewHolder(View itemView) {
            super(itemView);

            iv_photo = itemView.findViewById(R.id.iv_photo);
            tv_likes = itemView.findViewById(R.id.tv_likes);
        }
    }
}
