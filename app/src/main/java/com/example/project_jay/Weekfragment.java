package com.example.project_jay;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 전지연 on 2016-11-23.
 */
public class Weekfragment extends Fragment {
    public Weekfragment(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view2 = inflater.inflate(R.layout.week_fragment,container,false);
        getActivity().setTitle("Weekly Calendar");
        return view2;
    }
}
