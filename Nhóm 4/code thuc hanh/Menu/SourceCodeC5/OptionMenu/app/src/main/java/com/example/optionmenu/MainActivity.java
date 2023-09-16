package com.example.optionmenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }


//    public  boolean onOptionsItemSelected(@NonNull MenuItem item){
//        switch (item.getItemId()){
//            case R.id.settingsId:
//                Toast.makeText(MainActivity.this, "hi", Toast.LENGTH_SHORT).show();
//                return true;
//            case R.id.toolsId:
//                Toast.makeText(MainActivity.this, "hello", Toast.LENGTH_SHORT).show();
//                return true;
//            case R.id.ExitId:
//                finish();
//                return true;
//            default:
//                return  super.onOptionsItemSelected(item);
//        }
//    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.settingsId) {
            Toast.makeText(MainActivity.this, "Bạn đã chọn Settings", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.toolsId) {
            Toast.makeText(MainActivity.this, "Bạn đã chọn Tools", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.ExitId) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



}