package com.example.res.ui.notifications;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.res.MyApplication;
import com.example.res.MyDatabaseHelper;
import com.example.res.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrdersFragment extends Fragment {
    MyApplication application;
    private View view;
    private ArrayList<String> orders = new ArrayList<>();
    public RecyclerView orderRecyclerView;
    public OrderRecyclerAdapter orderRecyclerAdapter;
    private SQLiteDatabase db;
    private MyDatabaseHelper helper;

    public OrdersFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        helper = new MyDatabaseHelper(getActivity(), "User.db", null, 1);
    }

    private void initData() {
        application = (MyApplication) this.getActivity().getApplicationContext();
        int id = application.getUserUsing();
        helper = new MyDatabaseHelper(getActivity(), "User.db", null, 2);
        db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select OrderContext from Orders where UserId=?", new String[]{id + ""});
        if (cursor.moveToFirst()) {
            do {
                String orderContent = cursor.getString(cursor.getColumnIndex("OrderContext"));
                this.orders.add(orderContent);
            } while (cursor.moveToNext());
        }
    }

    private void initRecyclerView() {
        orderRecyclerView = view.findViewById(R.id.ordersRecyclerView);
        orderRecyclerAdapter = new OrderRecyclerAdapter(getActivity(), orders);
        orderRecyclerView.setAdapter(orderRecyclerAdapter);
        orderRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        //设置item的分割线
        orderRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_orders, container, false);
        initData();
        initRecyclerView();
        return view;
    }


}
