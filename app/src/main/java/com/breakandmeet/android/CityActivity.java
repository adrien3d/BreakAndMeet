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
import com.breakandmeet.android.adapters.ResaAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adrien on 14/11/2015.
 */
public class CityActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<CardItemType> types = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        /*String ancestor = getIntent().getStringExtra("position").toString();
        System.out.println(ancestor);*/
        getSupportActionBar().setTitle("Lille");

        types.add(new CardItemType("Créer une table", "http://vps159782.ovh.net/bam/imageCache/empty_table.png"));
        types.add(new CardItemType("Rejoindre une table", "http://vps159782.ovh.net/bam/imageCache/full_table.jpg"));

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        //définit l'agencement des cellules, ici de façon verticale, comme une ListView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(new ResaAdapter(types));
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
