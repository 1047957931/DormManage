package com.example.dormmanage.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.dormmanage.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private Button signup;
    private Button studentlogin;
    private Button managerlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        studentlogin=findViewById(R.id.btn_student_login);
        signup=findViewById(R.id.btn_signup);
        managerlogin=findViewById(R.id.btn_manager_login);

        studentlogin.setOnClickListener(this);
        signup.setOnClickListener(this);
        managerlogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_student_login:
                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_signup:
                intent=new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_manager_login:
                intent=new Intent(LoginActivity.this,ManagerActivity.class);
                startActivity(intent);
                break;
        }
    }
}
