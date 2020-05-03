package com.example.res.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.res.Food;
import com.example.res.MyApplication;
import com.example.res.Order;
import com.example.res.R;
import com.example.res.ui.home.FoodRecyclerAdapter;

import java.util.ArrayList;

public class DashFragment extends Fragment {
    private Order order;
    private View view;
    public RecyclerView FoodRecyclerView;
    private ArrayList<Food> foods_in_car = new ArrayList<Food>();
    public FoodRecyclerAdapter foodRecyclerAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        initData();
        initRecyclerView();
        return view;
    }

    private void initData() {
        TextView cost = view.findViewById(R.id.CarCost);
        MyApplication application = (MyApplication)this.getActivity().getApplicationContext();
        this.foods_in_car = application.getData();
        cost.setText((application.totalCost()));
    }

    public void addFood(String name, int pic, int cost) {
        foods_in_car.add(new Food(name, pic, cost));
    }

    private void initRecyclerView() {
        FoodRecyclerView = (RecyclerView) view.findViewById(R.id.carRecyclerView);
        foodRecyclerAdapter = new FoodRecyclerAdapter(getActivity(), foods_in_car);
        FoodRecyclerView.setAdapter(foodRecyclerAdapter);
        FoodRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        //设置item的分割线
        FoodRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));

    }

    @Override
    public void onResume() {
        initData();
        FoodRecyclerView = (RecyclerView) view.findViewById(R.id.carRecyclerView);
        foodRecyclerAdapter = (FoodRecyclerAdapter) FoodRecyclerView.getAdapter();
        foodRecyclerAdapter.notifyDataSetChanged();
        super.onResume();
    }
}
