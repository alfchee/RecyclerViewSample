package com.alfchee.recyclerviewsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialice the movies
        List<Movie> items = new ArrayList<>();

        items.add(new Movie(R.drawable.vita_bella,"Life is beautiful",777));
        items.add(new Movie(R.drawable.edge,"Edge of Tomorrow",635));
        items.add(new Movie(R.drawable.ratatouille,"Ratatoullie",456));
        items.add(new Movie(R.drawable.avengers,"Avengers",322));
        items.add(new Movie(R.drawable.super_metroid, "Super Metroid", 177));

        // obtener el recycler
        recycler = (RecyclerView) findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);

        // usar un administrador para linear layout
        linearLayoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(linearLayoutManager);

        // crear un nuevo adaptador
        adapter = new MovieAdapter(items);
        recycler.setAdapter(adapter);
    }
}
