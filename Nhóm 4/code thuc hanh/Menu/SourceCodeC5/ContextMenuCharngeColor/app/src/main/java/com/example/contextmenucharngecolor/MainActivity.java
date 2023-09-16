package com.example.contextmenucharngecolor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtChangeColor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtChangeColor = findViewById(R.id.txtChangeColorId);
        registerForContextMenu(txtChangeColor);
    }
    @Override
    public void onCreateContextMenu (ContextMenu menu, View v , ContextMenu.ContextMenuInfo menuInfo ){
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

//    public  boolean onContextItemSelected(MenuItem item){
//        switch (item.getItemId()){
//            case R.id.RedId:
//                txtChangeColor.setText(getResources().getColor(R.color.color_Red));
//                return true;
//            case R.id.GreenId:
//                txtChangeColor.setText(getResources().getColor(R.color.color_Green));
//                return true;
//            case R.id.BlueId:
//                txtChangeColor.setText(getResources().getColor(R.color.color_Blue));
//                return true;
//            default: return super.onContextItemSelected(item);
//
//        }
//    }
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.RedId) {
            txtChangeColor.setTextColor(getResources().getColor(R.color.color_Red));
            return true;
        } else if (item.getItemId() == R.id.GreenId) {
            txtChangeColor.setTextColor(getResources().getColor(R.color.color_Green));
            return true;
        } else if (item.getItemId() == R.id.BlueId) {
            txtChangeColor.setTextColor(getResources().getColor(R.color.color_Blue));
            return true;
        } else {
            return super.onContextItemSelected(item);
        }
    }


}