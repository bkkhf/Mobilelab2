package com.example.assignment2;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DatabaseActivity extends AppCompatActivity {
    EditText GetName,GetPhoneNumber,GetSubject ;
    Button Submit, ShowValues;
    SQLiteDatabase SQLITEDATABASE;
    SQLiteHelper helpher;
    String Name, PhoneNumber, Subject ;
    Boolean CheckEditTextEmpty ;
    String SQLiteQuery ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        GetName = (EditText) findViewById(R.id.editText1);

        GetPhoneNumber = (EditText) findViewById(R.id.editText2);

        GetSubject = (EditText) findViewById(R.id.editText3);

        Submit = (Button) findViewById(R.id.button1);

        ShowValues = (Button) findViewById(R.id.button2);

        Submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                DBCreate();

                SubmitData2SQLiteDB();

            }
        });
        ShowValues.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent = new Intent(DatabaseActivity.this, ListviewActivity.class);
                startActivity(intent);

            }
        });
    }

    public void DBCreate(){

        SQLITEDATABASE = openOrCreateDatabase("DemoDataBase", Context.MODE_PRIVATE, null);

        SQLITEDATABASE.execSQL("CREATE TABLE IF NOT EXISTS demoTable(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name VARCHAR, phone_number VARCHAR, subject VARCHAR);");
    }

    public void SubmitData2SQLiteDB(){

        Name = GetName.getText().toString();

        PhoneNumber = GetPhoneNumber.getText().toString();

        Subject = GetSubject.getText().toString();

        CheckEditTextIsEmptyOrNot( Name,PhoneNumber, Subject);

        if(CheckEditTextEmpty == true)
        {
            //SQLITEDATABASE = helpher.getWritableDatabase();

            SQLiteQuery = "INSERT INTO demoTable (name,phone_number,subject) VALUES('"+Name+"', '"+PhoneNumber+"', '"+Subject+"');";

            SQLITEDATABASE.execSQL(SQLiteQuery);

            Toast.makeText(DatabaseActivity.this,"Data Submit Successfully", Toast.LENGTH_LONG).show();

            ClearEditTextAfterDoneTask();

        }
        else {

            Toast.makeText(DatabaseActivity.this,"Please Fill All the Fields", Toast.LENGTH_LONG).show();
        }
    }

    public void CheckEditTextIsEmptyOrNot(String Name,String PhoneNumber, String subject ){

        if(TextUtils.isEmpty(Name) || TextUtils.isEmpty(PhoneNumber) || TextUtils.isEmpty(Subject)){

            CheckEditTextEmpty = false ;

        }
        else {
            CheckEditTextEmpty = true ;
        }
    }

    public void ClearEditTextAfterDoneTask(){

        GetName.getText().clear();
        GetPhoneNumber.getText().clear();
        GetSubject.getText().clear();

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
