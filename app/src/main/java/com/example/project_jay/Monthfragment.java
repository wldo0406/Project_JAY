package com.example.project_jay;

import android.app.ActionBar;
import android.app.Fragment;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by 전지연 on 2016-11-23.
 */
public class Monthfragment extends Fragment{

    public TextView resultm; // = (TextView)findViewById(R.id.resultm);
    public EditText selectm; //= (EditText) findViewById(R.id.selectm);
    private MyDBHelper helper;
    private ContactsAdapter adapter2;
    ArrayList<Contact> contacts2;

    public Monthfragment(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view1 = inflater.inflate(R.layout.month_fragment,container,false);
        getActivity().setTitle("Monthly Calendar");
        Button button3 = (Button)view1.findViewById(R.id.button3);
        //EditText selectm = (EditText) findViewById(R.id.selectm);

        RecyclerView rvContacts2 = (RecyclerView) view1.findViewById(R.id.rvContacts2);

        contacts2 = Contact.createContactsList2(0);
        adapter2 = new ContactsAdapter(getActivity(), contacts2);
        rvContacts2.setAdapter(adapter2);

        StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rvContacts2.setLayoutManager(gridLayoutManager);

        button3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                //TextView resultm = (TextView)view1.findViewById(R.id.resultm);
                EditText selectm = (EditText) view1.findViewById(R.id.selectm);

                String sql1 = String.format("SELECT * FROM schedulew WHERE month IN(%s)",selectm.getText());
                Cursor cursor1 = MyDBHelper.getInstance(getActivity()).getReadableDatabase().rawQuery(sql1,null);
                StringBuffer buffer = new StringBuffer();

                while (cursor1.moveToNext()) {
                    buffer.append(cursor1.getString(2) + "/");
                    buffer.append(cursor1.getString(3) + ":");
                    buffer.append(cursor1.getString(1) + "\n");
                    String str2 = cursor1.getString(2) + "/" + cursor1.getString(3) + ":" + cursor1.getString(1);
                    contacts2.add(0, new Contact(str2, true));
                    adapter2.notifyItemInserted(0);
                }
                //resultm.setText(buffer);

            }
        });

        return view1;
    }
}


