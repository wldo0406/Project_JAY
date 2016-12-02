package com.example.project_jay;

import android.database.Cursor;
import android.database.SQLException;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class DBMake extends AppCompatActivity {
    final static String TAG="SQLITEDBTEST";
    private MyDBHelper helper;
    public ContactsAdapter adapter1;
    ArrayList<Contact> contacts1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbmake);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar !=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            Drawable drawable = getDrawable(R.drawable.ic_chevron_left_black_24dp);
            if(drawable !=null){
                drawable.setTint(Color.BLACK);
                actionBar.setHomeAsUpIndicator(drawable);
            }
        }

        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.rvContacts);

        helper =  MyDBHelper.getInstance(this);
        contacts1 = Contact.createContactsList(0);
        adapter1= new ContactsAdapter(this, contacts1);
        rvContacts.setAdapter(adapter1);
        setTitle("Add Calendar");

        StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rvContacts.setLayoutManager(gridLayoutManager);
        //rvContacts.setHasFixedSize(true);


        Button button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                EditText caltext = (EditText)findViewById(R.id.caltext);
                EditText monthtext = (EditText)findViewById(R.id.monthtext);
                EditText daytext = (EditText)findViewById(R.id.daytext);
                try{
                    String sql = String.format (
                            "INSERT INTO schedulew (_id,title, month, day)\n"+
                                    "VALUES (NULL,'%s', '%s', '%s')",
                            caltext.getText(),monthtext.getText(),daytext.getText());
                    helper.getWritableDatabase().execSQL(sql);
                }catch (SQLException e){
                    Log.e(TAG, "ERROR");
                }
            }
        });


        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TextView result = (TextView)findViewById(R.id.result);
                String sql = "Select * FROM schedulew";
                Cursor cursor = helper.getReadableDatabase().rawQuery(sql,null);
                StringBuffer buffer = new StringBuffer();
                while (cursor.moveToNext()) {
                    buffer.append(cursor.getString(2)+"/");
                    buffer.append(cursor.getString(3)+":");
                    buffer.append(cursor.getString(1)+"\n");
                    String str = cursor.getString(2)+"/"+cursor.getString(3)+":"+cursor.getString(1);
                    contacts1.add(0, new Contact(str,true));
                    adapter1.notifyItemInserted(0);
                }
                //result.setText(buffer);


            }
        });
    }


    private String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);

    }






    /*public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.additem){
            contacts.add(0, new Contact("JINE",true));
            adapter.notifyItemInserted(0);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/
    /*
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }*/
}
