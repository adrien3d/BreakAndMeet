package com.breakandmeet.android.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.breakandmeet.android.R;
import com.breakandmeet.android.Types.CardItemType;
import com.breakandmeet.android.ViewHolder.ResaViewHolder;

import java.util.List;

/**
 * Created by adrien on 14/11/2015.
 */
public class ResaAdapter extends RecyclerView.Adapter<ResaViewHolder> {
    OnItemClickListener mItemClickListener;
    List<CardItemType> list;

    //ajouter un constructeur prenant en entrée une liste
    public ResaAdapter(List<CardItemType> list) {
        this.list = list;
        /*this.setOnItemClickListener(new ResaAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                System.out.println(position);
                //Intent intent = new Intent(this, CityActivity.class);
                //startActivity(intent);
            }
        });*/
    }

    //cette fonction permet de créer les viewHolder
    //et par la même indiquer la vue à inflater (à partir des layout xml)
    @Override
    public ResaViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_cards,viewGroup,false);
        return new ResaViewHolder(view);
    }

    //c'est ici que nous allons remplir notre cellule avec le texte/image de chaque MyObjects
    @Override
    public void onBindViewHolder(ResaViewHolder myViewHolder, int position) {
        CardItemType myObject = list.get(position);
        myViewHolder.bind(myObject);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

}