package com.example.project_jay;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class DailyActivity extends AppCompatActivity {
    final static String TAG="DailyActivity";
    private MyDBHelper helper;
    public ContactsAdapter adapter3;
    ArrayList<Contact> contacts3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily);
        helper =  MyDBHelper.getInstance(this);

        Button search = (Button) findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                TextView resultd = (TextView)findViewById(R.id.dresult);
                EditText dmonth = (EditText) findViewById(R.id.dmonth);
                EditText dday = (EditText) findViewById(R.id.dday);

                String dsql = String.format("SELECT * FROM schedulew WHERE month IN(%s) AND day IN(%s)",dmonth.getText(),dday.getText());
                Cursor dcursor = helper.getReadableDatabase().rawQuery(dsql,null);
                StringBuffer buffer = new StringBuffer();

                while (dcursor.moveToNext()) {
                    buffer.append(dcursor.getString(2) + "/");
                    buffer.append(dcursor.getString(3) + ":");
                    buffer.append(dcursor.getString(1) + "\n");
                    String str1 = dcursor.getString(2) + "/" + dcursor.getString(3) + ":" + dcursor.getString(1);
                }
                resultd.setText(buffer);

            }
        });

        Button dedit = (Button) findViewById(R.id.dedit);
        dedit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent editintent = new Intent(getApplicationContext(), EditActivity.class);
                startActivity(editintent);
            }
        });
    }


}
