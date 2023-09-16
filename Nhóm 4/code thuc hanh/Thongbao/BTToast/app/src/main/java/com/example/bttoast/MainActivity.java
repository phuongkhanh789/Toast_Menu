package com.example.bttoast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Khai báo các biến của chương trình
    Button btnShowToast, btnExit;
    Toast toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Ánh xạ view
        InitWidget();
        //Xử lý sự kiện Click trên Button Show Toast
        btnShowToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Hiển thị Toast trên MainActivity
                Context context = MainActivity.this;
                //Nội dung thông báo
                String msg = "Toast xin chào !";
                //Thời gian hiển thị Toast
                int duration = Toast.LENGTH_LONG;
                //Tạo Toast và Show lên màn hình
                toast = Toast.makeText(context,msg,duration);
                //Xác định vị trí hiển thị Toast
                toast.setGravity(Gravity.CENTER|Gravity.CENTER_HORIZONTAL,0,0);
                //Hiển thị Toast
                toast.show();
            }
        });
        //Xử lý sự kiện Click trên Button Exit
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void InitWidget() {
        btnShowToast = (Button) findViewById(R.id.btnShowToast);
        btnExit = (Button) findViewById(R.id.btnExit);
    }
}