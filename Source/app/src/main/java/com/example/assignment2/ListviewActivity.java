package com.example.assignment2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListviewActivity extends AppCompatActivity {
    SQLiteHelper SQLITEHELPER;
    SQLiteDatabase SQLITEDATABASE;
    Cursor cursor;
    SQLiteListAdapter ListAdapter ;

    ArrayList<String> ID_ArrayList = new ArrayList<String>();
    ArrayList<String> NAME_ArrayList = new ArrayList<String>();
    ArrayList<String> PHONE_NUMBER_ArrayList = new ArrayList<String>();
    ArrayList<String> SUBJECT_ArrayList = new ArrayList<String>();
    ListView LISTVIEW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        SQLITEHELPER = new SQLiteHelper(this);
        LISTVIEW = (ListView) findViewById(R.id.listView1);

       // SQLITEHELPER = new SQLiteHelper(this);

    }
    @Override
    protected void onResume() {

        ShowSQLiteDBdata() ;

        super.onResume();
    }

    private void ShowSQLiteDBdata() {

        SQLITEDATABASE = SQLITEHELPER.getReadableDatabase();
        cursor = SQLITEDATABASE.rawQuery("SELECT * FROM demoTable", null);

        ID_ArrayList.clear();
        NAME_ArrayList.clear();
        PHONE_NUMBER_ArrayList.clear();
        SUBJECT_ArrayList.clear();

        if (cursor.moveToFirst()) {
            do {
                ID_ArrayList.add(cursor.getString(cursor.getColumnIndex(SQLiteHelper.KEY_ID)));

                NAME_ArrayList.add(cursor.getString(cursor.getColumnIndex(SQLiteHelper.KEY_Name)));

                PHONE_NUMBER_ArrayList.add(cursor.getString(cursor.getColumnIndex(SQLiteHelper.KEY_PhoneNumber)));

                SUBJECT_ArrayList.add(cursor.getString(cursor.getColumnIndex(SQLiteHelper.KEY_Subject)));

            } while (cursor.moveToNext());
        }

        ListAdapter = new SQLiteListAdapter(ListviewActivity.this,

                ID_ArrayList,
                NAME_ArrayList,
                PHONE_NUMBER_ArrayList,
                SUBJECT_ArrayList

        );

        LISTVIEW.setAdapter(ListAdapter);

        cursor.close();
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

