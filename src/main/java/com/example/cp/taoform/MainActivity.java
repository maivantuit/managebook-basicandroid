package com.example.cp.taoform;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {// main chính 2(activity_main2.xml), gồm listview (các cuốn sách) và SQLie (thầy hướng dẫn bổ sung)
    EditText edituser, editpassword;//ánh xạ từ layout
    Button btndangky, btndangnhap, btnthoat;
    String ten, mk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        ControlButton();
    }

    private void ControlButton() {//thực hiện chức năng của Nút Button: Thoát
        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, android.R.style.Theme_DeviceDefault_Light_Dialog);
                builder.setTitle("Bạn có chắc muốn thoát khoải app");
                builder.setMessage("Hãy lựa chọn bên dưới để xác nhận");
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {//Onlick enter
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        onBackPressed();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });
        btndangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setTitle("Hộp thoại xữ lý");
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.customdialog);
                final EditText edttk = (EditText) dialog.findViewById(R.id.edittk);
                final EditText edtmk = (EditText) dialog.findViewById(R.id.editmk);
                Button btnhuy = (Button) dialog.findViewById(R.id.buttonhuy);
                Button btndongy = (Button) dialog.findViewById(R.id.buttondongy);
                btndongy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ten = edttk.getText().toString().trim();
                        mk = edtmk.getText().toString().trim();

                        edituser.setText(ten);
                        editpassword.setText(mk);

                        dialog.cancel();
                    }
                });
                btnhuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                dialog.show();

            }
        });
        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {// kiem tra tk mat khau co dung hay không, chuyển sang màn hình thứ 2
                if (edituser.getText().length() != 0 && editpassword.getText().length() != 0) {
                    if (edituser.getText().toString().equals(ten) && editpassword.getText().toString().equals(mk)) {
                        Toast.makeText(MainActivity.this, "Bạn đã đăng nhập thành công", Toast.LENGTH_SHORT);
                        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                        startActivity(intent);
                    } else if (edituser.getText().toString().equals("Phat") && editpassword.getText().toString().equals("123")) {
                        Toast.makeText(MainActivity.this, "Bạn đã đăng nhập thành công", Toast.LENGTH_SHORT);
                        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "Bạn đã đăng nhập thất bại", Toast.LENGTH_SHORT);
                    }
                }else {
                    Toast.makeText(MainActivity.this,"Mời bạn nhập đủ thông tin", Toast.LENGTH_SHORT);

                }
            }
        });
    }


    private void Anhxa() {
        edituser = (EditText) findViewById(R.id.edittextuser);
        editpassword = (EditText) findViewById(R.id.edittextuserpassword);
        btndangnhap = (Button) findViewById(R.id.buttondangnhap);
        btndangky = (Button) findViewById(R.id.buttondangky);
        btnthoat = (Button) findViewById(R.id.buttonthoat);
    }
}
