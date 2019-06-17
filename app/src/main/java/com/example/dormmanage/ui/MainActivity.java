package com.example.dormmanage.ui   ;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.widget.Button;
import android.widget.RadioGroup;

import com.example.dormmanage.R;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    private RadioGroup group;
    private SparseArray<Fragment>fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();

        initView();
    }

    private void initView() {
        //对获取的RadioGroup对象设置监听
        group=findViewById(R.id.btn_group);
        group.setOnCheckedChangeListener(this);
    }

    private void initFragment() {
        fragments=new SparseArray<>();
        fragments.put(R.id.btn_function,FunctionFragment.newInstance(""));
        fragments.put(R.id.btn_set,SetFragment.newInstance(""));
        replaceFragment(fragments.get(R.id.btn_function));
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        replaceFragment(fragments.get(i));

    }

    private void replaceFragment(Fragment fragment) {
        //1.获取fragmentmanager对象
        FragmentManager manger=getSupportFragmentManager();
        //2.开始fragmenttransaction的事务管理
        FragmentTransaction ft=manger.beginTransaction();
        //3.替换为新的fragment
        ft.replace(R.id.btn_fragment,fragment);
        //4.事务提交
        ft.commit();
    }
}
