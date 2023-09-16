package com.example.contextmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lstmonhoc;
    private ArrayAdapter adapter;
    String [] monhoc;
    List monhoc_list;
    EditText editTextmonhoc;
    String emonhoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstmonhoc = findViewById(R.id.lvmonhocid);
        monhoc = getResources().getStringArray(R.array.arrmonhoc);
        monhoc_list = new ArrayList(Arrays.asList(monhoc));
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, monhoc_list);
        lstmonhoc.setAdapter(adapter);
        registerForContextMenu(lstmonhoc);
        editTextmonhoc =findViewById(R.id.edtmonhocId);
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

//    public boolean onContextItemSelected (MenuItem item){
//        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
//        int pos = info.position;
//        String i = (String) adapter.getItem(pos);
//        switch (item.getItemId())
//        {
//            case R.id.addId:
//                emonhoc = editTextmonhoc.getText().toString();
//                monhoc_list.add(emonhoc);
//                adapter.notifyDataSetChanged();
//                return true;
//            case R.id.delId:
//                monhoc_list.remove(pos);
//                adapter.notifyDataSetChanged();
//                return true;
//            case R.id.upId:
//                String upln = i.toUpperCase();
//                monhoc_list.set(pos, upln);
//                adapter.notifyDataSetChanged();
//                return true;
//            case R.id.lowId:
//                String lpln = i.toLowerCase();
//                monhoc_list.set(pos, lpln);
//                adapter.notifyDataSetChanged();
//                return true;
//            default:
//                return super.onContextItemSelected(item);
//        }
//
//    }

    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int pos = info.position;
        String i = (String) adapter.getItem(pos);

        if (item.getItemId() == R.id.addId) {
            emonhoc = editTextmonhoc.getText().toString();
            monhoc_list.add(emonhoc);
            adapter.notifyDataSetChanged();
            return true;
        } else if (item.getItemId() == R.id.delId) {
            monhoc_list.remove(pos);
            adapter.notifyDataSetChanged();
            return true;
        } else if (item.getItemId() == R.id.upId) {
            String upln = i.toUpperCase();
            monhoc_list.set(pos, upln);
            adapter.notifyDataSetChanged();
            return true;
        } else if (item.getItemId() == R.id.lowId) {
            String lpln = i.toLowerCase();
            monhoc_list.set(pos, lpln);
            adapter.notifyDataSetChanged();
            return true;
        } else {
            return super.onContextItemSelected(item);
        }
    }



}