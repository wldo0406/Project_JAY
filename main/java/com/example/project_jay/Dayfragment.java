package com.example.project_jay;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.Notification;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by 전지연 on 2016-11-23.
 */
public class Dayfragment extends Fragment{
    public Dayfragment(){


    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        final View view3 = inflater.inflate(R.layout.day_fragment,container,false);
        getActivity().setTitle("Daily Calendar");
        Button button4 = (Button)view3.findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                TextView resultd = (TextView)view3.findViewById(R.id.resultd);
                EditText selectmonthinday = (EditText) view3.findViewById(R.id.selectmonthinday);
                EditText selectd = (EditText) view3.findViewById(R.id.selectd);

                String sql2 = String.format("SELECT * FROM scheduled WHERE month,day IN(%s,%s)",selectmonthinday.getText(),selectd.getText());
                Cursor cursor2 = MyDBHelper.getInstance(getActivity()).getReadableDatabase().rawQuery(sql2,null);
                StringBuffer buffer = new StringBuffer();

                while (cursor2.moveToNext()) {
                    buffer.append(cursor2.getString(1)+"\t");
                    buffer.append(cursor2.getString(2)+"/");
                    buffer.append(cursor2.getString(3)+"\n");
                }
                resultd.setText(buffer);

            }
        });



        return view3;
    }
}
