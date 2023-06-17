package com.example.food_app_delivery.Adaptor;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.food_app_delivery.Activity.ShowDetailActivity;
import com.example.food_app_delivery.Domain.FoodDomain;
import com.example.food_app_delivery.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class PopularApdapter extends RecyclerView.Adapter<PopularApdapter.ViewHolder> {
    ArrayList<FoodDomain> foodList;
    public PopularApdapter(ArrayList<FoodDomain> foodList) {
        this.foodList=foodList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_popular,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularApdapter.ViewHolder holder, int position) {
        holder.title.setText(foodList.get(position).getTitle());
        holder.fee.setText(String.valueOf(foodList.get(position).getFee()));

        int drawableResourceId=holder.itemView.getContext().getResources().getIdentifier(foodList.get(position).getPic(),"drawable",holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.pic);

        holder.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(holder.itemView.getContext(), ShowDetailActivity.class);
                intent.putExtra("object",foodList.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title,fee,addBtn;
        ImageView pic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            fee=itemView.findViewById(R.id.fee);
            addBtn=itemView.findViewById(R.id.addBtn);
            pic=itemView.findViewById(R.id.pic);

        }
    }
}
