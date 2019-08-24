package com.angga.submission;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class Home extends AppCompatActivity implements ListPlayerAdapter.OnItemClickListener {
    private RecyclerView rvPlayer;
    private ArrayList<Player> list = new ArrayList<>();
    public static final String EXTRA_URL = "imageURL";
    public static final String EXTRA_NAME = "name";
    public static final String EXTRA_FORM = "form";

    private ListPlayerAdapter mKonsultasiAdapter;

    public void onComposeAction(MenuItem profil) {
        Intent intent = new Intent(Home.this, Profil.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        rvPlayer = findViewById(R.id.rv_player);
        rvPlayer.setHasFixedSize(true);

        list.addAll(PlayerData.getListData());
        /* list = new ArrayList<>();*/
        showRecyclerList();

    }

    private void showRecyclerList() {
        rvPlayer.setLayoutManager(new LinearLayoutManager(this));
        ListPlayerAdapter listPlayerAdapter = new ListPlayerAdapter(list);
        rvPlayer.setAdapter(listPlayerAdapter);

        listPlayerAdapter.setOnItemClickListener(Home.this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.profil:
                Intent intent = new Intent(Home.this, Profil.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(Home.this, Detail.class);
        Player clickedItem = list.get(position);
        intent.putExtra(EXTRA_URL, clickedItem.getFoto());
        intent.putExtra(EXTRA_NAME, clickedItem.getName());
        intent.putExtra(EXTRA_FORM, clickedItem.getFrom());
        startActivity(intent);

    }
}