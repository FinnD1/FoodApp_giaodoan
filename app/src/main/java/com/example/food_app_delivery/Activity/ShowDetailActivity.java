package com.example.food_app_delivery.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.food_app_delivery.Domain.FoodDomain;
import com.example.food_app_delivery.Helper.ManagementCart;
import com.example.food_app_delivery.R;

public class ShowDetailActivity extends AppCompatActivity {
    private TextView addToCartBtn,titleTxt,feeTxt,descriptionTxt,numberOrderTxt;
    private ImageView picFood,minusBtn,plusBtn;
    private FoodDomain object;
    int numberOrder=1;
    private ManagementCart managementCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);

        managementCart=new ManagementCart(this);
        initView();
        getBundle();
    }

    private void getBundle() {
        object=(FoodDomain) getIntent().getSerializableExtra("object");

        int drawableResourceId=this.getResources().getIdentifier(object.getPic(),"drawable",this.getPackageName());
        Glide.with(this).load(drawableResourceId).load(picFood);

        titleTxt.setText(object.getTitle());
        feeTxt.setText(object.getFee()+"VND");
        descriptionTxt.setText(object.getDescription());
        numberOrderTxt.setText(String.valueOf(numberOrder));

        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberOrder++;
                numberOrderTxt.setText(String.valueOf(numberOrder));
            }
        });

        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numberOrder>1)
                {
                    numberOrder--;
                }
                numberOrderTxt.setText(String.valueOf(numberOrder));
            }
        });

        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                object.setNumberInCart(numberOrder);
                managementCart.insertFood(object);
            }
        });
    }

    private void initView() {
        addToCartBtn=findViewById(R.id.addToCartBtn);
        titleTxt=findViewById(R.id.titleTxt);
        feeTxt=findViewById(R.id.feeTxt);
        descriptionTxt=findViewById(R.id.descriptionTxt);
        numberOrderTxt=findViewById(R.id.numberOrderTxt);
        picFood=findViewById(R.id.picFood);
        minusBtn=findViewById(R.id.minusBtn);
        plusBtn=findViewById(R.id.plusBtn);
        picFood=findViewById(R.id.picFood);
    }
}