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

public class Set2Fragment extends Fragment {
    public Set2Fragment() {

        // Required empty public constructor
    }
    private static final String ARG_PARAM1 = "param1";
    private String mParam1;
    private ListView lv2;
    private View view;
    public static Set2Fragment newInstance(String param1) {
        Set2Fragment fragment=new Set2Fragment();
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
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("设置");
        // Inflate the layout for this fragment
        if (view == null){
            view = inflater.inflate(R.layout.fragment_set2,container,false);
        }
        //0.获取数据
        initData();
        //1.初始化控件
        lv2 = view.findViewById(R.id.lv_set2);
        //2.创建Adapter
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),//上下文
                android.R.layout.simple_list_item_1,//布局
                datas);//数据
        //3.给ListView设置Adatper
        lv2.setAdapter(adapter);
        //4.给Item设置监听事件
        lv2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                String data = (String) parent.getItemAtPosition(position);
                Toast.makeText(parent.getContext(),data,Toast.LENGTH_LONG).show();
                if ("楼层管理".equals(data)){
                    Intent intent=new Intent(getActivity(),ManagerActivity.class);
                    intent.putExtra("title","楼层管理");
                    startActivity(intent);
                }
                if ("宿舍管理".equals(data)){
                    Intent intent=new Intent(getActivity(),ManagerActivity.class);
                    intent.putExtra("title","宿舍管理");
                    startActivity(intent);
                }
            }
        });
        lv2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long l) {
                datas.remove(parent.getItemAtPosition(position));
                adapter.notifyDataSetChanged();
                return true;
            }
        });
        return view;
    }
    private List<String> datas;
    //private String[]datas={""};
    private void initData() {
        datas=new ArrayList<>();
        datas.add("楼层管理");
        datas.add("宿舍管理");
    }
}
