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

public class FunctionFragment extends Fragment {
    public FunctionFragment() {

        // Required empty public constructor
    }
    private static final String ARG_PARAM1 = "param1";
    private String mParam1;
    private ListView lv1;
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
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("功能");
        // Inflate the layout for this fragment
        if (view == null){
            view = inflater.inflate(R.layout.fragment_function,container,false);
        }
        //0.获取数据
        initData();
        //1.初始化控件
        lv1 = view.findViewById(R.id.lv_function);
        //2.创建Adapter
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),//上下文
                android.R.layout.simple_list_item_1,//布局
                datas);//数据
        //3.给ListView设置Adatper
        lv1.setAdapter(adapter);
        //4.给Item设置监听事件
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                String data = (String) parent.getItemAtPosition(position);
                Toast.makeText(parent.getContext(),data,Toast.LENGTH_LONG).show();
                if ("查询个人信息".equals(data)){
                    Intent intent=new Intent(getActivity(),MainActivity.class);
                    intent.putExtra("title","查询个人信息");
                    startActivity(intent);
                }
                if ("楼层信息查询".equals(data)){
                    Intent intent=new Intent(getActivity(),MainActivity.class);
                    intent.putExtra("title","楼层信息查询");
                    startActivity(intent);
                }
            }
        });

        return view;
    }
        private List<String> datas;
        //private String[]datas={""};
        private void initData() {
            datas=new ArrayList<>();
            datas.add("查询个人信息");
            datas.add("楼层信息查询");
           }
}
