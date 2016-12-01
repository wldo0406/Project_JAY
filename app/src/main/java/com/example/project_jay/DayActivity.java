package com.example.project_jay;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day);

        TextView result = (TextView)findViewById(R.id.result);
        String sql = "Select * FROM schedulew";

        StringBuffer buffer = new StringBuffer();

        result.setText(buffer);
    }
}
