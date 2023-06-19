package com.example.food_app_delivery.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.food_app_delivery.R;
import com.google.android.material.textfield.TextInputEditText;

public class IntroActivity extends AppCompatActivity {

    TextInputEditText userEditText,passEditText;
    Button btnDangNhap,btnDangKi;
    String ten,mk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        AnhXa();
        ControlButton();
    }

    private void ControlButton() {
        btnDangKi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog=new Dialog(IntroActivity.this);
                dialog.setTitle("Cửa sổ đăng kí");
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.custom_dangki);
                TextInputEditText edittk=dialog.findViewById(R.id.userTK);
                TextInputEditText editmk=dialog.findViewById(R.id.passMK);
                Button btnHuy=dialog.findViewById(R.id.btnHuy);
                Button btndangki1=dialog.findViewById(R.id.btnDangKi1);
                btndangki1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ten=edittk.getText().toString().trim();
                        mk=editmk.getText().toString().trim();

                        userEditText.setText(ten);
                        passEditText.setText(mk);

                        dialog.cancel();
                    }
                });
                btnHuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userEditText.getText().length() !=0 && passEditText.getText().length() !=0)
                {
                    if(userEditText.getText().toString().equals(ten) && passEditText.getText().toString().equals(mk))
                    {
                        Toast.makeText(IntroActivity.this,"Bạn đã đăng nhập thành công",Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(IntroActivity.this,MainActivity.class);
                        startActivity(intent);
                    }
                    else if(userEditText.getText().toString().equals("user1") && passEditText.getText().toString().equals("123")){
                        Toast.makeText(IntroActivity.this,"Bạn đã đăng nhập thành công",Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(IntroActivity.this,MainActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(IntroActivity.this,"Bạn đã đăng nhập thất bại",Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(IntroActivity.this,"Mời bạn nhập đủ thông tin",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void AnhXa(){
        userEditText=findViewById(R.id.userEditText);
        passEditText=findViewById(R.id.passEditText);;
        btnDangNhap=findViewById(R.id.btnDangNhap);;
        btnDangKi=findViewById(R.id.btnDangKi);;

    }
}