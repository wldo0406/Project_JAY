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
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DBMake extends AppCompatActivity {
    final static String TAG="SQLITEDBTEST";
    private MyDBHelper helper;

    //public EditText monthtext;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbmake);

        helper =  MyDBHelper.getInstance(this);

        Button button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                EditText caltext = (EditText)findViewById(R.id.caltext);
                EditText monthtext = (EditText)findViewById(R.id.monthtext);
                EditText daytext = (EditText)findViewById(R.id.daytext);
                try{
                    String sql = String.format (
                            "INSERT INTO scheduled(_id, title, month, day)\n"+
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
                TextView result = (TextView)findViewById(R.id.result);

                String sql = "Select * FROM scheduled";
                Cursor cursor = helper.getReadableDatabase().rawQuery(sql,null);
                StringBuffer buffer = new StringBuffer();

                while (cursor.moveToNext()) {
                    buffer.append(cursor.getString(1)+"\t");
                    buffer.append(cursor.getString(2)+"/");
                    buffer.append(cursor.getString(3)+"\n");
                }
                result.setText(buffer);

            }
        });




        Button button4 = (Button)findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                //삭제 다이얼로그받기
            }
        });
    }

}
