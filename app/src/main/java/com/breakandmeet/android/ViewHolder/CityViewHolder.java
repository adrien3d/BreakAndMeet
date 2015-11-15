package com.breakandmeet.android.ViewHolder;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.breakandmeet.android.CityActivity;
import com.breakandmeet.android.R;
import com.breakandmeet.android.Types.CardItemType;
import com.squareup.picasso.Picasso;

/**
 * Created by adrien on 14/11/2015.
 */
public class CityViewHolder extends RecyclerView.ViewHolder {
    private TextView textViewView;
    private ImageView imageView;

    //itemView est la vue correspondante à 1 cellule
    public CityViewHolder(final View itemView) {
        super(itemView);
        //final RecyclerView.ViewHolder holder = new ResaViewHolder(itemView);

        textViewView = (TextView) itemView.findViewById(R.id.text);
        imageView = (ImageView) itemView.findViewById(R.id.image);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Activity activity = (Activity) view.getContext();
                //intent.putExtra("position", 2);
                Intent intent = new Intent(view.getContext(), CityActivity.class);
                System.out.println("Start City");
                view.getContext().startActivity(intent);
            }
        });
    }

    //puis ajouter une fonction pour remplir la cellule en fonction d'un MyObject
    public void bind(CardItemType myObject){
        textViewView.setText(myObject.getText());
        Picasso.with(imageView.getContext()).load(myObject.getImageUrl()).centerCrop().fit().into(imageView);
    }
}
