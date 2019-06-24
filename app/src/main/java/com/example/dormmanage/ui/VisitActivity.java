package com.example.dormmanage.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.dormmanage.R;
import com.example.dormmanage.model.Visit;
import com.example.dormmanage.service.VisitService;
import com.example.dormmanage.service.VisitServiceImpl;

public class VisitActivity extends AppCompatActivity implements View.OnClickListener {

    private Button etsava1;
    private EditText etvname,etvtel,etvtime;

    private Visit visit;
    private VisitService visitservive;
    private String flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visit);

        visitservive =new VisitServiceImpl(this);

        initView();
        initData();
    }
    private void initData() {
        Intent intent = getIntent();
        flag = intent.getStringExtra("flag");

        Bundle bundle = intent.getExtras();
        if(bundle != null) {
            visit = (Visit) bundle.getSerializable("visit");
            if(visit != null) {
                etvtel.setText(String.valueOf(visit.getVisitName()));
                etvtel.setText(String.valueOf(visit.getVisitTime()));
                etvtel.setText(String.valueOf(visit.getVisitTel()));

            }
        }
    }

    private void initView() {
        etvname = findViewById(R.id.et_vname);
        etvtime = findViewById(R.id.et_vtime);
        etvtel = findViewById(R.id.et_vtel);

        etsava1 = findViewById(R.id.btn_save1);
        etsava1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_save1:
                updataVisit();
                break;
        }
    }

    private void updataVisit() {
        if(visit == null) {
            visit = new Visit();
        }
        visit.setVisitName(etvname.getText().toString());
        visit.setVisitTime(etvtime.getText().toString());
        visit.setVisitTel(etvtel.getText().toString());

        if("修改".equals(flag)) {
            visitservive.modifyRealNumber(visit);
        } else if("添加".equals(flag)) {
            visitservive.insert(visit);
        }

        // 将修改的数据返回MainActivity
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable("visit", visit);
        intent.putExtras(bundle);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
