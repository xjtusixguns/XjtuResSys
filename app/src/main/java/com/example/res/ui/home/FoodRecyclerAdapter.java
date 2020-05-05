package com.example.res.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.res.Food;
import com.example.res.R;

import java.util.ArrayList;

public class FoodRecyclerAdapter extends RecyclerView.Adapter<FoodRecyclerAdapter.myViewHolder> {
    private Context context;
    private ArrayList<Food> foods;

    public FoodRecyclerAdapter(Context context, ArrayList<Food> foods){
        this.context = context;
        this.foods = foods;
    }

    @NonNull
    @Override
        public FoodRecyclerAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = View.inflate(context, R.layout.food_item, null);
        return new myViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodRecyclerAdapter.myViewHolder holder, int position) {
        Food food = foods.get(position);
        holder.foodImage.setImageResource(food.getImageId());
        holder.foodName.setText(food.getName());
        holder.foodCost.setText("￥"+food.getCost()+""); //这里传的一定是str，int要转str
    }

    class myViewHolder extends RecyclerView.ViewHolder{
        private ImageView foodImage;
        private TextView foodName;
        private TextView foodCost;


        public myViewHolder(View itemView){
            super(itemView);
            foodImage = itemView.findViewById(R.id.foodImage);
            foodName = itemView.findViewById(R.id.foodName);
            foodCost = itemView.findViewById(R.id.foodCost);

            //接下来写两个fragment之间的监听传递
            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    if(onItemClickListener != null){
                        onItemClickListener.OnItemClick(v, foods.get(getLayoutPosition()));
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return foods.size();
    }

    public interface OnItemClickListener{
        void OnItemClick(View view, Food data);
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }
}
