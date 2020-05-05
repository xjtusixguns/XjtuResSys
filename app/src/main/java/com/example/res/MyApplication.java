package com.example.res;

import android.app.Application;

import java.util.ArrayList;

public class MyApplication extends Application {
    public int logIn = 0;
    private ArrayList<Food> food_in_car = new ArrayList<Food>();
    private int UserUsing;

    @Override
    public void onCreate(){
        initData();
        super.onCreate();
    }

    public int getUserUsing() {
        return this.UserUsing;
    }

    public void setUserUsing(int id) {
        this.UserUsing = id;
    }

    public void LogIn() {
        this.logIn = 1;
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
