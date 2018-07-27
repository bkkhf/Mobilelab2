package com.example.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class Gridview extends AppCompatActivity implements RecyclerViewAdapter.ItemListener{
    RecyclerView recyclerView;
    ArrayList<DataModel> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        arrayList = new ArrayList<>();
        arrayList.add(new DataModel(" ", R.drawable.battle, "#09A9FF"));
        arrayList.add(new DataModel(" ", R.drawable.beer, "#3E51B1"));
        arrayList.add(new DataModel(" ", R.drawable.ferrari, "#673BB7"));
        arrayList.add(new DataModel(" ", R.drawable.jetpack_joyride, "#4BAA50"));
        arrayList.add(new DataModel(" ", R.drawable.three_d, "#F94336"));
        arrayList.add(new DataModel(" ", R.drawable.terraria, "#0A9B88"));
        arrayList.add(new DataModel(" ", R.drawable.beer, "#3E51B1"));
        arrayList.add(new DataModel(" ", R.drawable.ferrari, "#673BB7"));


        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, arrayList, this);
        recyclerView.setAdapter(adapter);


        /**
         AutoFitGridLayoutManager that auto fits the cells by the column width defined.
         **/

        AutoFitGridLayoutManager layoutManager = new AutoFitGridLayoutManager(this, 500);
        recyclerView.setLayoutManager(layoutManager);


        /**
         Simple GridLayoutManager that spans two columns
         **/
        /*GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);*/

    }

    @Override
    public void onItemClick(DataModel item) {

     //   Intent i = new Intent(Gridview.this,Fullimage.class) ;
       // i.putExtra("id", getPosition());
      //  startActivity(i);

        Toast.makeText(getApplicationContext(), item.text + " is clicked", Toast.LENGTH_SHORT).show();

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //Write your logic here
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
