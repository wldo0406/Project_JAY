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

import java.util.ArrayList;

/**
 * Created by 전지연 on 2016-11-23.
 */
public class WeekFragment extends Fragment {

    private ContactsAdapter adapter3;
    ArrayList<Contact> contacts3;
    int selecteditem = 0;
    int mCurCheckPosition = -1;

    public interface OnNameSelectedListener{
        public void onNameSelected(int i);
    }

    public WeekFragment(){

    }



    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        final View view2 = inflater.inflate(R.layout.week_fragment,container,false);
        getActivity().setTitle("Weekly Calendar");


       // Button button5 = (Button)view2.findViewById(R.id.button5);
         Button button51 = (Button)view2.findViewById(R.id.button51);
        Button button52 = (Button)view2.findViewById(R.id.button52);
        Button button53 = (Button)view2.findViewById(R.id.button53);
        Button button54 = (Button)view2.findViewById(R.id.button54);
        Button button55 = (Button)view2.findViewById(R.id.button55);

        RecyclerView rvContacts4 = (RecyclerView) view2.findViewById(R.id.rvContacts4);

        contacts3 = Contact.createContactsList2(0);
        adapter3 = new ContactsAdapter(getActivity(), contacts3);
        rvContacts4.setAdapter(adapter3);

        StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        rvContacts4.setLayoutManager(gridLayoutManager);



        button51.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                // TextView resultw = (TextView)view2.findViewById(R.id.resultw);
                EditText selectw = (EditText) view2.findViewById(R.id.selectw);

                String sql4 = String.format("SELECT * FROM schedulev WHERE month1 IN(%s) AND day1 IN('1','2','3','4','5','6','7')",selectw.getText());
                Cursor cursor4 = MyDBHelper.getInstance(getActivity()).getReadableDatabase().rawQuery(sql4,null);
                StringBuffer buffer = new StringBuffer();

                while (cursor4.moveToNext()) {
                    buffer.append(cursor4.getString(2)+"/");
                    buffer.append(cursor4.getString(3)+":");
                    buffer.append(cursor4.getString(1)+"\n");
                    buffer.append(cursor4.getString(4)+"\t");
                    buffer.append(cursor4.getString(5)+"\t");
                    buffer.append(cursor4.getString(6)+"\t");
                    buffer.append(cursor4.getString(7)+"\t");

                    String str4 = cursor4.getString(2) + "/" + cursor4.getString(3) + ":" + cursor4.getString(1)
                            +"-시간:" +cursor4.getString(4)+":"+cursor4.getString(5)+"~"+cursor4.getString(6)+":"+cursor4.getString(7);
                    contacts3.add(0, new Contact(str4, true));
                    adapter3.notifyItemInserted(0);
                }
                // resultm.setText(buffer);

            }
        });

        button52.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                // TextView resultw = (TextView)view2.findViewById(R.id.resultw);
                EditText selectw = (EditText) view2.findViewById(R.id.selectw);

                String sql4 = String.format("SELECT * FROM schedulev WHERE month1 IN(%s) AND day1 IN('8','9','10','11','12','13','14')",selectw.getText());
                Cursor cursor4 = MyDBHelper.getInstance(getActivity()).getReadableDatabase().rawQuery(sql4,null);
                StringBuffer buffer = new StringBuffer();

                while (cursor4.moveToNext()) {
                    buffer.append(cursor4.getString(2)+"/");
                    buffer.append(cursor4.getString(3)+":");
                    buffer.append(cursor4.getString(1)+"\n");
                    buffer.append(cursor4.getString(4)+"\t");
                    buffer.append(cursor4.getString(5)+"\t");
                    buffer.append(cursor4.getString(6)+"\t");
                    buffer.append(cursor4.getString(7)+"\t");

                    String str4 = cursor4.getString(2) + "/" + cursor4.getString(3) + ":" + cursor4.getString(1)
                            +"-시간:" +cursor4.getString(4)+":"+cursor4.getString(5)+"~"+cursor4.getString(6)+":"+cursor4.getString(7);
                    contacts3.add(0, new Contact(str4, true));
                    adapter3.notifyItemInserted(0);
                }
                // resultm.setText(buffer);

            }
        });

        button53.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                // TextView resultw = (TextView)view2.findViewById(R.id.resultw);
                EditText selectw = (EditText) view2.findViewById(R.id.selectw);

                String sql4 = String.format("SELECT * FROM schedulev WHERE month1 IN(%s) AND day1 IN('15','16','17','18','19','20','21')",selectw.getText());
                Cursor cursor4 = MyDBHelper.getInstance(getActivity()).getReadableDatabase().rawQuery(sql4,null);
                StringBuffer buffer = new StringBuffer();

                while (cursor4.moveToNext()) {
                    buffer.append(cursor4.getString(2)+"/");
                    buffer.append(cursor4.getString(3)+":");
                    buffer.append(cursor4.getString(1)+"\n");
                    buffer.append(cursor4.getString(4)+"\t");
                    buffer.append(cursor4.getString(5)+"\t");
                    buffer.append(cursor4.getString(6)+"\t");
                    buffer.append(cursor4.getString(7)+"\t");
                    String str4 = cursor4.getString(2) + "/" + cursor4.getString(3) + ":" + cursor4.getString(1)
                            +"-시간:" +cursor4.getString(4)+":"+cursor4.getString(5)+"~"+cursor4.getString(6)+":"+cursor4.getString(7);
                    contacts3.add(0, new Contact(str4, true));
                    adapter3.notifyItemInserted(0);

                }
                // resultm.setText(buffer);

            }
        });

        button54.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                // TextView resultw = (TextView)view2.findViewById(R.id.resultw);
                EditText selectw = (EditText) view2.findViewById(R.id.selectw);

                String sql4 = String.format("SELECT * FROM schedulev WHERE month1 IN(%s) AND day1 IN('22','23','24','25','26','27','28')",selectw.getText());
                Cursor cursor4 = MyDBHelper.getInstance(getActivity()).getReadableDatabase().rawQuery(sql4,null);
                StringBuffer buffer = new StringBuffer();

                while (cursor4.moveToNext()) {
                    buffer.append(cursor4.getString(2)+"/");
                    buffer.append(cursor4.getString(3)+":");
                    buffer.append(cursor4.getString(1)+"\n");
                    buffer.append(cursor4.getString(4)+"\t");
                    buffer.append(cursor4.getString(5)+"\t");
                    buffer.append(cursor4.getString(6)+"\t");
                    buffer.append(cursor4.getString(7)+"\t");
                    String str4 = cursor4.getString(2) + "/" + cursor4.getString(3) + ":" + cursor4.getString(1)
                            +"-시간:" +cursor4.getString(4)+":"+cursor4.getString(5)+"~"+cursor4.getString(6)+":"+cursor4.getString(7);
                    contacts3.add(0, new Contact(str4, true));
                    adapter3.notifyItemInserted(0);
                }
                // resultm.setText(buffer);

            }
        });

        button55.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                // TextView resultw = (TextView)view2.findViewById(R.id.resultw);
                EditText selectw = (EditText) view2.findViewById(R.id.selectw);

                String sql4 = String.format("SELECT * FROM schedulev WHERE month1 IN(%s) AND day1 IN('29','30','31')",selectw.getText());
                Cursor cursor4 = MyDBHelper.getInstance(getActivity()).getReadableDatabase().rawQuery(sql4,null);
                StringBuffer buffer = new StringBuffer();

                while (cursor4.moveToNext()) {
                    buffer.append(cursor4.getString(2)+"/");
                    buffer.append(cursor4.getString(3)+":");
                    buffer.append(cursor4.getString(1)+"\n");
                    buffer.append(cursor4.getString(4)+"\t");
                    buffer.append(cursor4.getString(5)+"\t");
                    buffer.append(cursor4.getString(6)+"\t");
                    buffer.append(cursor4.getString(7)+"\t");
                    String str4 = cursor4.getString(2) + "/" + cursor4.getString(3) + ":" + cursor4.getString(1)
                            +"-시간:" +cursor4.getString(4)+":"+cursor4.getString(5)+"~"+cursor4.getString(6)+":"+cursor4.getString(7);
                    contacts3.add(0, new Contact(str4, true));
                    adapter3.notifyItemInserted(0);
                }
                // resultm.setText(buffer);

            }
        });

        return view2;
    }
}
