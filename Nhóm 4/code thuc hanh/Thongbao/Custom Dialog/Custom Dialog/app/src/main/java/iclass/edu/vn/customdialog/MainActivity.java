package iclass.edu.vn.customdialog;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {



    private void DialogXacNhan() {
        final Dialog dialog = new Dialog(this);
        dialog.setTitle("Xác nhận ?");
        dialog.setContentView(R.layout.custom_dialog_xac_nhan);
        Button btnDongY = (Button) dialog.findViewById(R.id.btnDongYId);
        Button btnHuy = (Button) dialog.findViewById(R.id.btnHuyId);
        btnDongY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnThoat = (Button) findViewById(R.id.btnShowId);
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogXacNhan();
            }
        });
    }
}