package com.example.dormmanage.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dormmanage.R;

public class Function2Fragment extends Fragment {
    public Function2Fragment() {
        // Required empty public constructor
    }

    public static Function2Fragment newInstance() {
        Function2Fragment fragment=new Function2Fragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_function2, container, false);
    }
}
