package com.example.dormmanage.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dormmanage.R;
import com.example.dormmanage.model.Room;
import com.example.dormmanage.service.RoomService;
import com.example.dormmanage.service.RoomServiceImpl;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bnSureSearch,bnReturn;
    private EditText Search;
    private TextView Su1,Su2,Su3,Su4;
    private Room room;
    private RoomService roomService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        bnSureSearch = findViewById(R.id.bn_sure_search1);
        bnReturn = findViewById(R.id.bn_return1);
        Search = findViewById(R.id.et_srarch1);
        Su1=findViewById(R.id.su1);
        Su2=findViewById(R.id.su2);
        Su3=findViewById(R.id.su3);
        Su4=findViewById(R.id.su4);

        bnSureSearch.setOnClickListener(this);
        bnReturn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bn_sure_search1:
                searchName();
                break;
            case R.id.bn_return1:
                break;
        }

    }

    private void searchName() {
        roomService=new RoomServiceImpl(this);
        String roomName = Search.getText().toString();
        room=roomService.select(roomName);
        if (room!=null){

            Su1.setText(room.getRoomName());
            Su2.setText(String.valueOf(room.getExpectNumber()));
            Su3.setText(String.valueOf(room.getRealNumber()));
            Su4.setText(String.valueOf(room.getCost()));
        }
    }
}
