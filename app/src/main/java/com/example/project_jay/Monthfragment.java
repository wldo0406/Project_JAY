package com.example.project_jay;

import android.app.Fragment;
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
public class Monthfragment extends Fragment{

     public  TextView resultm; // = (TextView)findViewById(R.id.resultm);
     public   EditText selectm; //= (EditText) findViewById(R.id.selectm);
     private ContactsAdapter adapter2;
     ArrayList<Contact> contacts2;


    public Monthfragment(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view1 = inflater.inflate(R.layout.month_fragment,container,false);
        getActivity().setTitle("Monthly Calendar");



        Button button3 = (Button)view1.findViewById(R.id.button3);

        RecyclerView rvContacts2 = (RecyclerView) view1.findViewById(R.id.rvContacts2);

        contacts2 = Contact.createContactsList2(0);
        adapter2 = new ContactsAdapter(getActivity(), contacts2);
        rvContacts2.setAdapter(adapter2);

        StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        rvContacts2.setLayoutManager(gridLayoutManager);



        button3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                TextView resultm = (TextView)view1.findViewById(R.id.resultm);
                EditText selectm = (EditText) view1.findViewById(R.id.selectm);

                String sql1 = String.format("SELECT * FROM schedulev WHERE month1 IN(%s)",selectm.getText());
                Cursor cursor1 = MyDBHelper.getInstance(getActivity()).getReadableDatabase().rawQuery(sql1,null);
                StringBuffer buffer = new StringBuffer();

                while (cursor1.moveToNext()) {
                    buffer.append(cursor1.getString(2)+"/");
                    buffer.append(cursor1.getString(3)+":");
                    buffer.append(cursor1.getString(1)+"\n");
                    buffer.append(cursor1.getString(4)+"\t");
                    buffer.append(cursor1.getString(5)+"\t");
                    buffer.append(cursor1.getString(6)+"\t");
                    buffer.append(cursor1.getString(7)+"\t");

                    String str2 = cursor1.getString(2) + "/" + cursor1.getString(3) + ":" + cursor1.getString(1)+"-시간:"
                            +cursor1.getString(4)+":"+cursor1.getString(5)+"~"+cursor1.getString(6)+":"+cursor1.getString(7);
                    contacts2.add(0, new Contact(str2, true));
                    adapter2.notifyItemInserted(0);
                }
               // resultm.setText(buffer);

            }
        });

        return view1;
    }
}

