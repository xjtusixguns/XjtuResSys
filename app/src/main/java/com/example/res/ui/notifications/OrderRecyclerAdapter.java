package com.example.res.ui.notifications;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.res.R;

import java.util.ArrayList;

public class OrderRecyclerAdapter extends RecyclerView.Adapter<OrderRecyclerAdapter.myViewHolder> {
    private Context context;
    private ArrayList<String> orders;

    public OrderRecyclerAdapter(Context context, ArrayList<String> orders) {

        this.context = context;
        this.orders = orders;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = View.inflate(context, R.layout.order_item, null);
        return new myViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        String order = orders.get(position);
        holder.order_content.setText(order);
    }

    @Override
    public int getItemCount() {
        if (orders.size() <= 0)
            return 0;
        return orders.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder {
        private TextView order_content;

        public myViewHolder(View itemView) {
            super(itemView);
            order_content = itemView.findViewById(R.id.order_content);
        }
    }
}
