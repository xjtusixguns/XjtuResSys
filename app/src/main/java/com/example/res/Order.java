package com.example.res;

import java.util.*;

public class Order {
    public ArrayList<Food> foodList = new ArrayList<Food>();
    int price = 0;


    public int calPayment() {
        foodList.add(new Food("苹果", R.drawable.apple_pic, 1));
        foodList.add(new Food("苹果", R.drawable.apple_pic, 2));

        int res = 0;
        for (Food temp : foodList) {
            res += temp.getCost();
        }
        this.price = res;
        return res;

    }

    public void addFood(Food food) {
        foodList.add(food);
    }

    public void minusFood(Food food) {
        for (Food temp : foodList) {
            if (temp.getName() == food.getName() &&
                    temp.getCost() == food.getCost()) {
                foodList.remove(temp);
            }

        }

    }
};