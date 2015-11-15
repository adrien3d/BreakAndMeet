package com.breakandmeet.android.ViewHolder;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.breakandmeet.android.CreateTableActivity;
import com.breakandmeet.android.R;
import com.breakandmeet.android.Types.CardItemType;
import com.squareup.picasso.Picasso;

/**
 * Created by adrien on 14/11/2015.
 */
public class ResaViewHolder  extends RecyclerView.ViewHolder {
    private TextView textViewView;
    private ImageView imageView;

    //itemView est la vue correspondante à 1 cellule
    public ResaViewHolder(final View itemView) {
        super(itemView);
        //final RecyclerView.ViewHolder holder = new ResaViewHolder(itemView);

        textViewView = (TextView) itemView.findViewById(R.id.text);
        imageView = (ImageView) itemView.findViewById(R.id.image);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity activity = (Activity) view.getContext();
                Intent intent = new Intent(view.getContext(), CreateTableActivity.class);
                intent.putExtra("position", 2);
                System.out.println("Start Create Table");
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
