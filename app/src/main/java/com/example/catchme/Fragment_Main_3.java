package com.example.catchme;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Fragment_Main_3 extends Fragment {



    public Fragment_Main_3() {}



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) { //Simply declares that this java file is for the fragment_main_3
        return inflater.inflate(R.layout.fragment__main_3, container, false);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button b1=getActivity().findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {      //ClickListener for the button1 that contains the intent for the Activity2
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}