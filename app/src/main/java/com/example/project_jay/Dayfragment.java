package com.example.project_jay;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.Notification;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 전지연 on 2016-11-23.
 */
public class Dayfragment extends Fragment{
    public Dayfragment(){


    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view3 = inflater.inflate(R.layout.day_fragment,container,false);
        getActivity().setTitle("Daily Calendar");
        return view3;
    }
}
