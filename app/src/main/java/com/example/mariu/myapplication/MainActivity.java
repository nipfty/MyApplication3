package com.example.mariu.myapplication;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.content.Intent;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private ImageButton b;
    private ImageButton b1;
    private ImageButton b2;
    private ImageButton b3;
    private ImageButton b4;
    private ImageButton b5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DishList.getInstance().reloadItems();
        setContentView(R.layout.activity_main);


        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        LinearLayout b1 = (LinearLayout) findViewById(R.id.catmaki);
        LinearLayout b2 = (LinearLayout) findViewById(R.id.catrole);
        LinearLayout b3 = (LinearLayout) findViewById(R.id.catsalate);
        LinearLayout b4 = (LinearLayout) findViewById(R.id.catset);
        LinearLayout b5 = (LinearLayout) findViewById(R.id.catng);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                init("maki");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                init("role");
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                init("salata");
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                init("set");
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                init("ng");
            }
        });
        setNavigationViewListner();
}

    public boolean onCreateOptionsMenu(Menu menu){
        //getMenuInflater().inflate(R.menu.menu_nav, menu);
        getMenuInflater().inflate(R.menu.menu_add_to_cart, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        switch (item.getItemId()) {

            case R.id.MARIUS: {
                mDrawerLayout.closeDrawers();
                break;

            }
            case R.id.settings: {
                goSettings(); mDrawerLayout.closeDrawers();
                break;

            }

            case R.id.abouts : {
                goAboutUs(); mDrawerLayout.closeDrawers();
                break;
            }
        }
        //close navigation drawer

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.shopping:
                ShoppingMenuitem();
                break;



        }
        return true;
    }
    public void init(String catname){
        Intent intent = new Intent(MainActivity.this, BrowsingActivity.class);
        intent.putExtra("category",catname);
        startActivity(intent);
    }



    public void ShoppingMenuitem(){
     Intent i = new Intent(MainActivity.this, CartActivity.class);
     Log.d("problem","here");
        startActivity(i);
        }
    public void goHome(){
        Intent i = new Intent(this, MainActivity.class);
        finish();
        startActivity(i);
    }
    public void goSettings(){
        Intent i = new Intent(this, SettingsActivity.class);
        startActivity(i);
    }

    private void setNavigationViewListner() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.menu_nav);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
    public void goAboutUs(){
        Intent i = new Intent(this, MapsActivity.class);
        startActivity(i);
    }
}



