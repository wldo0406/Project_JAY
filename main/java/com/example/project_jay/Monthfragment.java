package com.example.project_jay;

import android.app.ActionBar;
import android.app.Fragment;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by 전지연 on 2016-11-23.
 */
public class Monthfragment extends Fragment{

  public  TextView resultm; // = (TextView)findViewById(R.id.resultm);
  public   EditText selectm; //= (EditText) findViewById(R.id.selectm);

    public Monthfragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view1 = inflater.inflate(R.layout.month_fragment,container,false);
        getActivity().setTitle("Monthly Calendar");
        Button button3 = (Button)view1.findViewById(R.id.button3);
        //EditText selectm = (EditText) findViewById(R.id.selectm);

        button3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                TextView resultm = (TextView)view1.findViewById(R.id.resultm);
                EditText selectm = (EditText) view1.findViewById(R.id.selectm);

                String sql1 = String.format("SELECT * FROM scheduled WHERE month IN(%s)",selectm.getText());
                Cursor cursor1 = MyDBHelper.getInstance(getActivity()).getReadableDatabase().rawQuery(sql1,null);
                StringBuffer buffer = new StringBuffer();

                while (cursor1.moveToNext()) {
                    buffer.append(cursor1.getString(1)+"\t");
                    buffer.append(cursor1.getString(2)+"/");
                    buffer.append(cursor1.getString(3)+"\n");
                }
                resultm.setText(buffer);

            }
        });

        return view1;
    }
}

