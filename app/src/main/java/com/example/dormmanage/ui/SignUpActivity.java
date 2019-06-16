package com.example.dormmanage.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dormmanage.R;
import com.example.dormmanage.model.Sign;
import com.example.dormmanage.service.SignService;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etusername;
    private EditText etpassword;
    private EditText etpassword1;
    private Button btconfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etusername=findViewById(R.id.et_username);
        etpassword=findViewById(R.id.et_password);
        etpassword=findViewById(R.id.et_password1);
        btconfirm=findViewById(R.id.btn_confirm);

        btconfirm.setOnClickListener(this);

        service = new SignService(this);

    }

    @Override
    public void onClick(View view) {
        register();
    }
    private SignService service;
    private void register() {
        // 1.注册用户名密码
        Sign sign = new Sign();
        boolean result = service.register(sign);
        if (result&&etpassword==etpassword1){
        Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
        startActivity(intent);
    }else {
            Toast.makeText(SignUpActivity.this,"注册失败",Toast.LENGTH_LONG).show();
        }
    }
}
