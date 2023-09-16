package com.example.customdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnshow = (Button) findViewById(R.id.btnShowId);
        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogXacNhan();
            }
        });
    }
    private void DialogXacNhan(){
        final Dialog dialog = new Dialog(this);
        dialog.setTitle("Xác nhận?");
        dialog.setContentView(R.layout.custom_dialog_xac_nhan);
        Button btnDongY = (Button) dialog.findViewById(R.id.btnDongYId);
        Button btnHUy = (Button) dialog.findViewById(R.id.btnHuyId);
        btnDongY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnHUy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}