package com.example.dormmanage.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dormmanage.R;

import java.util.ArrayList;
import java.util.List;

public class SetFragment extends Fragment {
    public SetFragment() {

        // Required empty public constructor
    }
    private static final String ARG_PARAM1 = "param1";
    private String mParam1;
    private ListView lv1;
    private View view;
    public static SetFragment newInstance(String param1) {
        SetFragment fragment=new SetFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("楼层信息");
        // Inflate the layout for this fragment

        return view;
    }

}
