package com.example.dormmanage.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dormmanage.R;

public class PersonalActivity extends AppCompatActivity implements View.OnClickListener {
    private Button save1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);

        save1 = findViewById(R.id.btn_save1);

        save1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_save1:
                Intent intent= new Intent(PersonalActivity.this, MainActivity.class);
                startActivity(intent);
        }

    }
}
