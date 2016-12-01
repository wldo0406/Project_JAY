package com.example.project_jay;

import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.Toast;

/**
 * Created by 전지연 on 2016-11-23.
 */
public class Monthfragment extends Fragment{


    public Monthfragment(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view1 = inflater.inflate(R.layout.month_fragment,container,false);
        getActivity().setTitle("Monthly Calendar");
        return view1;
    }
}


