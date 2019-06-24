package com.example.dormmanage.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.dormmanage.R;

public class FunctionFragment extends Fragment implements View.OnClickListener {
    public FunctionFragment() {

        // Required empty public constructor
    }
    private static final String ARG_PARAM1 = "param1";
    private Button save2;
    private String mParam1;
    private View view;
    public static FunctionFragment newInstance(String param1) {
        FunctionFragment fragment=new FunctionFragment();
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
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("个人信息");
        if (view == null){
            view = inflater.inflate(R.layout.fragment_function,container,false);
        }
        save2 = view.findViewById(R.id.btn_save2);

        save2.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_save2:
                Intent intent = new Intent(getContext(), PersonalActivity.class);
                startActivity(intent);
        }
    }
}
