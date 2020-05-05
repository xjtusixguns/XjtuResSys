package com.example.res.ui.notifications;

import com.example.res.Food;

import java.util.ArrayList;

public class Orders {
    private ArrayList<Food> foods;
    private int price = 0;
    private String tostring = "";

    public Orders(ArrayList<Food> foods) {
        this.foods = foods;
    }

    public String getContent() {
        for (Food i : this.foods) {
            price += i.getCost();
            tostring += i.getName();
            tostring += "\n";
        }
        return this.tostring;
    }
}
