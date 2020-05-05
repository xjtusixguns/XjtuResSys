package com.example.res.ui.home;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.res.Food;
import com.example.res.MyApplication;
import com.example.res.R;
import com.example.res.ui.dashboard.DashFragment;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private View view;
    public RecyclerView FoodRecyclerView;
    private ArrayList<Food> foods = new ArrayList<Food>();
    private FoodRecyclerAdapter foodRecyclerAdapter;
    freshData freshdata;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        freshdata = (freshData)getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        initRecyclerView();
        initData();
        return view;
    }

    private void initData() {
        foods.add(new Food("苹果", R.drawable.apple_pic, 1));
        foods.add(new Food("香蕉", R.drawable.banana_pic, 1));
        foods.add(new Food("樱桃", R.drawable.cherry_pic, 1));
        foods.add(new Food("葡萄", R.drawable.grape_pic, 1));
        foods.add(new Food("芒果", R.drawable.mango_pic, 1));
        foods.add(new Food("橙子", R.drawable.orange_pic, 1));
        foods.add(new Food("梨子", R.drawable.pear_pic, 1));
        foods.add(new Food("菠萝", R.drawable.pineapple_pic,1));
        foods.add(new Food("草莓", R.drawable.strawberry_pic,1));
        foods.add(new Food("哈密瓜", R.drawable.watermelon_pic,1));
        foods.add(new Food("苹果", R.drawable.apple_pic,1));
        foods.add(new Food("香蕉", R.drawable.banana_pic,1));
        foods.add(new Food("樱桃", R.drawable.cherry_pic,1));
        foods.add(new Food("葡萄", R.drawable.grape_pic,1));
        foods.add(new Food("芒果", R.drawable.mango_pic,1));
        foods.add(new Food("橙子", R.drawable.orange_pic,1));
        foods.add(new Food("梨子", R.drawable.pear_pic,1));
        foods.add(new Food("菠萝", R.drawable.pineapple_pic,1));
        foods.add(new Food("草莓", R.drawable.strawberry_pic,1));
        foods.add(new Food("哈密瓜", R.drawable.watermelon_pic,1));
    }

    private void initRecyclerView(){
        MyApplication application = (MyApplication)this.getActivity().getApplicationContext();
        ArrayList<Food> temp = application.getData();
        FoodRecyclerView = view.findViewById(R.id.homeRecyclerView);
        foodRecyclerAdapter = new FoodRecyclerAdapter(getActivity(), foods);
        FoodRecyclerView.setAdapter(foodRecyclerAdapter);
        FoodRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        //设置item的分割线
        FoodRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));

        foodRecyclerAdapter.setOnItemClickListener(new FoodRecyclerAdapter.OnItemClickListener(){

            @Override
            public void OnItemClick (View view, Food data){
                freshdata.freshData(data);
                for(Food i : temp){
                    Toast.makeText(getContext(), i.getName(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public interface freshData{
        void freshData(Food data);
    }



}
