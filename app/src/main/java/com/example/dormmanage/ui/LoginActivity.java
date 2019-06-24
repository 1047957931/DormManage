package com.example.dormmanage.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dormmanage.R;
import com.example.dormmanage.model.Sign;
import com.example.dormmanage.service.SignService;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText signnumber;
    private EditText signpassword;
    private TextView signup;
    private ImageButton studentlogin;
    private ImageButton managerlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        studentlogin=findViewById(R.id.btn_student_login);
        signup=findViewById(R.id.btn_signup);
        managerlogin=findViewById(R.id.btn_manager_login);
        signnumber=findViewById(R.id.sign_number);
        signpassword=findViewById(R.id.sign_password);

        studentlogin.setOnClickListener(this);
        signup.setOnClickListener(this);
        managerlogin.setOnClickListener(this);

        service = new SignService(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_student_login:
                login();
                break;
            case R.id.btn_signup:
                Intent intent=new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_manager_login:
                login1();
                break;
        }
    }

    private void login1() {
        //处理按钮的点击事件
        //获取用户名和密码的值
        String usermame = signnumber.getText().toString().trim();
        String password = signpassword.getText().toString();
        //比较用户名的密码是否正确，然后给出提示
        if (usermame.equals("") && password.equals("")) {
            Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(LoginActivity.this,ManagerActivity.class);//跳转页面
            intent.putExtra("username",usermame);//将要传递的值附加到intent对象
            startActivity(intent);//启动
        } else {
            Toast.makeText(LoginActivity.this, "用户名或密码不正确", Toast.LENGTH_LONG).show();

        }
    }

    private SignService service;
    private void login()  {
        // 1. 获取用户名密码
        Sign sign = new Sign();
        sign.setNumber(signnumber.getText().toString());
        sign.setPassword(signpassword.getText().toString());
        // 2. 判断
        boolean result = service.login(sign);
        // 3. 跳转
        if(result) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(LoginActivity.this,"用户名或密码错误",Toast.LENGTH_LONG).show();
        }
    }
}