package com.breakandmeet.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.breakandmeet.android.Types.CardItemType;
import com.breakandmeet.android.adapters.CityAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<CardItemType> cities = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);*/

        cities.add(new CardItemType("Lille", "http://vps159782.ovh.net/bam/imageCache/lille.jpg"));
        cities.add(new CardItemType("Paris", "http://vps159782.ovh.net/bam/imageCache/paris.jpg"));
        cities.add(new CardItemType("Londres", "http://vps159782.ovh.net/bam/imageCache/london.jpg"));

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        //définit l'agencement des cellules, ici de façon verticale, comme une ListView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(new CityAdapter(cities));

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        /*resaAdapter.setOnItemClickListener(new ResaAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                System.out.println(position);
                //Intent intent = new Intent(this, CityActivity.class);
                //startActivity(intent);
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_map) {
            Intent intent = new Intent(this, GMapActivity.class);
            System.out.println("Start City");
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
