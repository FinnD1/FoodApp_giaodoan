package com.example.food_app_delivery.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.food_app_delivery.Adaptor.PopularApdapter;
import com.example.food_app_delivery.Domain.FoodDomain;
import com.example.food_app_delivery.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewPopularList;
    private RecyclerView.Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewPopular();
    }

    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPopularList=findViewById(R.id.recyclerView1);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> foodList= new ArrayList<>();
        foodList.add(new FoodDomain("Peperoni pizza","pizza","asdsdaasddsdsdsd", 9.76));
        foodList.add(new FoodDomain("Cheese Burger","pizza","các thành phần:", 8.89));
        foodList.add(new FoodDomain("Vegetable pizza","pizza","các thành phần:", 8.99));

        adapter=new PopularApdapter(foodList);
        recyclerViewPopularList.setAdapter(adapter);
    }
}