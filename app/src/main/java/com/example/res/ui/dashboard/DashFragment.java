package com.example.res.ui.dashboard;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.res.Food;
import com.example.res.MyApplication;
import com.example.res.MyDatabaseHelper;
import com.example.res.R;
import com.example.res.ui.home.FoodRecyclerAdapter;
import com.example.res.ui.notifications.Orders;

import java.util.ArrayList;

public class DashFragment extends Fragment {
    private View view;
    public RecyclerView FoodRecyclerView;
    private ArrayList<Food> foods_in_car = new ArrayList<Food>();
    public FoodRecyclerAdapter foodRecyclerAdapter;
    private Button certify;
    private int is_login = 0;
    MyApplication application;
    private SQLiteDatabase db;
    private MyDatabaseHelper helper;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        helper = new MyDatabaseHelper(getActivity(), "User.db", null, 2);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        this.application = (MyApplication) this.getActivity().getApplicationContext();
        certify = view.findViewById(R.id.CarButton2);
        initData();
        initRecyclerView();
        if (certify != null)
            certify.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    db = helper.getWritableDatabase();
                    //获取用户输入的数据
                    ArrayList<Food> foods = application.getData();
                    //取得当前购物车中的所有物品，这是存在application中的全局变量
                    Orders order = new Orders(foods);
                    ContentValues values = new ContentValues();
                    values.put("UserId", application.getUserUsing());
                    //获得order的toString()
                    values.put("OrderContext", order.getContent());
                    db.insert("Orders", null, values);
                    if (is_login == 0) {
                        Toast.makeText(getContext(), "您还未登录，请进入‘我’界面登录！", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getContext(), "提交成功，请进入‘我’界面查看。", Toast.LENGTH_LONG).show();
                    }
                }
            });
        return view;
    }

    private void initData() {
        TextView cost = view.findViewById(R.id.CarCost);
        MyApplication application = (MyApplication)this.getActivity().getApplicationContext();
        this.is_login = application.logIn;
        this.foods_in_car = application.getData();
        cost.setText((application.totalCost()));
    }

    public void addFood(String name, int pic, int cost) {
        foods_in_car.add(new Food(name, pic, cost));
    }

    private void initRecyclerView() {
        FoodRecyclerView = view.findViewById(R.id.carRecyclerView);
        foodRecyclerAdapter = new FoodRecyclerAdapter(getActivity(), foods_in_car);
        FoodRecyclerView.setAdapter(foodRecyclerAdapter);
        FoodRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        //设置item的分割线
        FoodRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));

    }

    @Override
    public void onResume() {
        initData();
        FoodRecyclerView = view.findViewById(R.id.carRecyclerView);
        foodRecyclerAdapter = (FoodRecyclerAdapter) FoodRecyclerView.getAdapter();
        foodRecyclerAdapter.notifyDataSetChanged();
        super.onResume();
    }
}
