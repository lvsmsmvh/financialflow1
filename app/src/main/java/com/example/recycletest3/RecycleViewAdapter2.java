package com.example.recycletest3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


// для вкладки Wallets
public class RecycleViewAdapter2 extends RecyclerView.Adapter<RecycleViewAdapter2.MyViewHolder> {


    Context mContext;
    List<CardItem> mData;

    public RecycleViewAdapter2(Context mContext, List<CardItem> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.frag2_item, parent, false);
        MyViewHolder vHolder = new MyViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_name.setText(mData.get(position).getName());
        holder.tv_amount.setText(mData.get(position).getAmount());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {


        private TextView tv_name;
        private TextView tv_amount;

         public MyViewHolder(@NonNull View itemView) {
             super(itemView);

             tv_name = (TextView) itemView.findViewById(R.id.tvNameCard);
             tv_amount = (TextView) itemView.findViewById(R.id.tvAmountCard);
         }
     }
}
