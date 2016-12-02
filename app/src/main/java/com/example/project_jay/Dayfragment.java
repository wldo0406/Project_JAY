package com.example.project_jay;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.Notification;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 전지연 on 2016-11-23.
 */
public class Dayfragment extends Fragment{
    private MyDBHelper helper;
    public ContactsAdapter adapter3;
    ArrayList<Contact> contacts3;

    public Dayfragment(){


    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        final View view3 = inflater.inflate(R.layout.day_fragment,container,false);
        getActivity().setTitle("Daily Calendar");

        RecyclerView rvContacts3 = (RecyclerView) view3.findViewById(R.id.rvContacts3);

        contacts3 = Contact.createContactsList2(0);
        adapter3 = new ContactsAdapter(getActivity(), contacts3);
        rvContacts3.setAdapter(adapter3);

        StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rvContacts3.setLayoutManager(gridLayoutManager);


        Button button4 = (Button)view3.findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                //TextView resultd = (TextView)view3.findViewById(R.id.resultd);
                EditText selectmonthinday = (EditText) view3.findViewById(R.id.selectmonthinday);
                EditText selectd = (EditText) view3.findViewById(R.id.selectd);

                String sql2 = String.format("SELECT * FROM schedulew WHERE month IN(%s) AND day IN(%s)",selectmonthinday.getText(),selectd.getText());
                Cursor cursor2 = MyDBHelper.getInstance(getActivity()).getReadableDatabase().rawQuery(sql2,null);
                StringBuffer buffer = new StringBuffer();

                while (cursor2.moveToNext()) {
                    buffer.append(cursor2.getString(2) + "/");
                    buffer.append(cursor2.getString(3) + ":");
                    buffer.append(cursor2.getString(1) + "\n");
                    String str1 = cursor2.getString(2) + "/" + cursor2.getString(3) + ":" + cursor2.getString(1);
                    contacts3.add(0, new Contact(str1, true));
                    adapter3.notifyItemInserted(0);
                }
                //resultd.setText(buffer);

            }
        });



        return view3;
    }
}
