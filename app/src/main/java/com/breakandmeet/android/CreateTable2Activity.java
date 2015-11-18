package com.breakandmeet.android;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

import com.breakandmeet.android.Types.RestaurantType;
import com.breakandmeet.android.adapters.SimpleRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adrien on 14/11/2015.
 */
public class CreateTable2Activity extends AppCompatActivity {

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_table_2);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        System.out.println("lala");
    }*/

    CollapsingToolbarLayout collapsingToolbar;
    RecyclerView recyclerView;
    int mutedColor = R.attr.colorPrimary;
    SimpleRecyclerAdapter simpleRecyclerAdapter;
    private SwipeRefreshLayout refreshLayout;
    Context context;
    //String token = getSharedPreferences("prefs", Context.MODE_PRIVATE).getString("token", null);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_create_table_2);
        Intent myIntent = getIntent();
        final String cityName = myIntent.getStringExtra("ville");

        final Toolbar toolbar = (Toolbar) findViewById(R.id.anim_toolbar_city);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(cityName);

        ImageView header = (ImageView) findViewById(R.id.header);


            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.lille);
            header.setImageResource(R.drawable.lille);

        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @SuppressWarnings("ResourceType")
            @Override
            public void onGenerated(Palette palette) {
                mutedColor = palette.getMutedColor(R.color.primary_500);
                collapsingToolbar.setContentScrimColor(mutedColor);
                collapsingToolbar.setStatusBarScrimColor(R.color.black_trans80);
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.ScrollableViewGuides);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        List<String> listNoms = new ArrayList<String>();
        List<String> listTypes = new ArrayList
                <String>();
        int ct = 0;
        for (int i = 0; i < RestaurantType.fake_noms.length; i++) {
            listNoms.add(RestaurantType.fake_noms[ct]);
            listTypes.add(RestaurantType.fake_types[ct]);
            ct++;
            if (ct == RestaurantType.fake_noms.length) {
                ct = 0;
            }
        }


        if (simpleRecyclerAdapter == null) {
            simpleRecyclerAdapter = new SimpleRecyclerAdapter(listNoms, listTypes);
            recyclerView.setAdapter(simpleRecyclerAdapter);
        }

        View fab = findViewById(R.id.fabMapView);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(Tab1City.this, AirmapActivity.class);
                Intent intent = new Intent(CreateTable2Activity.this, GMapActivity.class);
                //intent.putExtra("ville", cityName);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
