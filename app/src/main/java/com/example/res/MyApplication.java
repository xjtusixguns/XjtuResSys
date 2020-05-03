package com.example.res;

import android.app.Application;
import android.text.NoCopySpan;

import java.util.ArrayList;

public class MyApplication extends Application {
    private ArrayList<Food> food_in_car = new ArrayList<Food>();;

    @Override
    public void onCreate(){
        initData();
        super.onCreate();
    }

    private void initData(){
        this.food_in_car.add(new Food("客位", R.drawable.chair_pic, 1));
    }

    public ArrayList<Food> getData(){
        return this.food_in_car;
    }

    public void addData(Food food){
        food_in_car.add(food);
    }

    public String totalCost(){
        int res = 0;
        for(Food i : this.food_in_car){
            res += i.getCost();
        }
        return res+"";
    }
}
