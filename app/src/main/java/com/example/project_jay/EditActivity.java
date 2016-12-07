package com.example.project_jay;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    private SQLiteDatabase mDB;
    String month;
    String day;
    String etext;
    String estarthourtext;
    String estartminutetext;
    String efinishhourtext;
    String efinishminutetext;

    int eid;
    private MyDBHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        helper = MyDBHelper.getInstance(this);
        Intent formIntent = getIntent();

        ActionBar actionBar = getSupportActionBar();
        if(actionBar !=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            Drawable drawable = getDrawable(R.drawable.ic_chevron_left_black_24dp);
            if(drawable !=null){
                drawable.setTint(Color.BLACK);
                actionBar.setHomeAsUpIndicator(drawable);
            }
        }




        month = formIntent.getStringExtra("editmonth");
        day = formIntent.getStringExtra("editday");



        EditText emonth = (EditText) findViewById(R.id.emonth);
        EditText eday = (EditText) findViewById(R.id.eday);
        EditText ecal = (EditText) findViewById(R.id.ecal);
        EditText estarthour = (EditText)findViewById(R.id.estarthour);
        EditText estartminute = (EditText)findViewById(R.id.estartminute);
        EditText efinishhhour = (EditText)findViewById(R.id.efinishhour);
        EditText efinishminute = (EditText)findViewById(R.id.efinishminute);


        String esql = String.format("SELECT * FROM schedulev WHERE month1 IN(%s) AND day1 IN(%s)",month,day);
        Cursor ecursor = MyDBHelper.getInstance(this).getReadableDatabase().rawQuery(esql,null);
        StringBuffer buffer = new StringBuffer();

        while (ecursor.moveToNext()) {
            buffer.append(ecursor.getString(2) + "/");
            buffer.append(ecursor.getString(3) + ":");
            buffer.append(ecursor.getString(1) + "\n");
            buffer.append(ecursor.getString(4)+"\t");
            buffer.append(ecursor.getString(5)+"\t");
            buffer.append(ecursor.getString(6)+"\t");
            buffer.append(ecursor.getString(7)+"\t");

            eid = ecursor.getInt(0);
            etext = ecursor.getString(1);
            estarthourtext = ecursor.getString(4);
            estartminutetext = ecursor.getString(5);
            efinishhourtext = ecursor.getString(6);
            efinishminutetext = ecursor.getString(7);

        }

        emonth.setText(month);
        eday.setText(day);
        ecal.setText(etext);
        estarthour.setText(estarthourtext);
        estartminute.setText(estartminutetext);
        efinishhhour.setText(efinishhourtext);
        efinishminute.setText(efinishminutetext);

        Button check = (Button) findViewById(R.id.check);
        check.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                EditText imonth = (EditText) findViewById(R.id.emonth);
                EditText iday = (EditText) findViewById(R.id.eday);
                EditText ical = (EditText) findViewById(R.id.ecal);
                EditText istarthour = (EditText)findViewById(R.id.estarthour);
                EditText istartminute = (EditText)findViewById(R.id.estartminute);
                EditText ifinishhour = (EditText)findViewById(R.id.efinishhour);
                EditText ifinishminute = (EditText)findViewById(R.id.efinishminute);


                String sql = String.format(
                        "UPDATE schedulev \n"+
                                "SET title1 = '%s',"+
                                " month1 = '%s',"+
                                " day1 = '%s',"+
                                " starth1 = '%s',"+
                                " startm1 = '%s',"+
                                " finishh1 = '%s',"+
                                " finishm1 = '%s'"+
                                "WHERE _id ='%s'",
                        ical.getText(), imonth.getText(), iday.getText(),istarthour.getText(),
                        istartminute.getText(),ifinishhour.getText(),ifinishminute.getText(),eid);
                helper.getWritableDatabase().execSQL(sql);
            }
        });


    }

}
