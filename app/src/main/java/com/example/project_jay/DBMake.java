package com.example.project_jay;

import android.database.Cursor;
import android.database.SQLException;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class DBMake extends AppCompatActivity {
    final static String TAG="SQLITEDBTEST";
    private MyDBHelper helper;
    private ContactsAdapter adapter1;
    ArrayList<Contact> contacts1;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
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
        contacts1 = Contact.createContactsList1(0);
        adapter1 = new ContactsAdapter(this, contacts1);
        rvContacts.setAdapter(adapter1);
        setTitle("Add Calendar");

        StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        rvContacts.setLayoutManager(gridLayoutManager);

        Button button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                EditText caltext = (EditText)findViewById(R.id.caltext);
                EditText monthtext = (EditText)findViewById(R.id.monthtext);
                EditText daytext = (EditText)findViewById(R.id.daytext);
                EditText sh = (EditText)findViewById(R.id.sh);
                EditText sm = (EditText)findViewById(R.id.sm);
                EditText fh = (EditText)findViewById(R.id.fh);
                EditText fm = (EditText)findViewById(R.id.fm);

                try{
                    String sql = String.format (
                            "INSERT INTO schedulev(_id, title1, month1, day1, starth1, startm1, finishh1, finishm1)\n"+
                                    "VALUES (NULL,'%s', '%s', '%s','%s', '%s', '%s', '%s')",
                            caltext.getText(),monthtext.getText(),daytext.getText(),sh.getText(),sm.getText(),fh.getText(),fm.getText());
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
                // TextView result = (TextView)findViewById(R.id.result);

                String sql = "Select * FROM schedulev";
                Cursor cursor = helper.getReadableDatabase().rawQuery(sql,null);
                StringBuffer buffer = new StringBuffer();

                while (cursor.moveToNext()) {
                    buffer.append(cursor.getString(2)+"\t");
                    buffer.append(cursor.getString(3)+"/");
                    buffer.append(cursor.getString(1)+"\t");
                    buffer.append(cursor.getString(4)+"\t");
                    buffer.append(cursor.getString(5)+"\t");
                    buffer.append(cursor.getString(6)+"\t");
                    buffer.append(cursor.getString(7)+"\t");


                    String str = cursor.getString(2) + "/" + cursor.getString(3) + ":" + cursor.getString(1)+"-시간:"
                            +cursor.getString(4)+":"+cursor.getString(5)+"~"+cursor.getString(6)+":"+cursor.getString(7);
                    contacts1.add(0, new Contact(str, true));
                    adapter1.notifyItemInserted(0);
                }
                //result.setText(buffer);

            }
        });


    }

}

