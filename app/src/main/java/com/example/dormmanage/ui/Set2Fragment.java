package com.example.dormmanage.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dormmanage.R;

public class Set2Fragment extends Fragment {
    public Set2Fragment() {
        // Required empty public constructor
    }

    public static Set2Fragment newInstance() {
        Set2Fragment fragment=new Set2Fragment();
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
        return inflater.inflate(R.layout.fragment_set2, container, false);
    }
}
