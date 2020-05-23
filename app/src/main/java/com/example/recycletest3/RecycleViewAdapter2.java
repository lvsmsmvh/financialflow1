package com.example.recycletest3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


/**
 * recycler view adapter for Wallets tab
 */
public class RecycleViewAdapter2 extends RecyclerView.Adapter<RecycleViewAdapter2.MyViewHolder> {


    Context mContext;
    List<CardItem> mData;
    /**
     * default constructor
     * @param mContext context.
     * @param mData data containing list of actions.
     */
    public RecycleViewAdapter2(Context mContext, List<CardItem> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }
    /**
     * overriding  create view holder method
     * @param parent view
     * @param viewType viewType.
     * @return new holder
     */
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.frag2_item, parent, false);
        MyViewHolder vHolder = new MyViewHolder(v);
        return vHolder;
    }
    /**
     * overrides method that binds data on view holder
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_name.setText(mData.get(position).getName());
        holder.tv_amount.setText(mData.get(position).getAmount());
    }
    /**
     * gets a number of items
     * @return number of items
     */
    @Override
    public int getItemCount() {
        return mData.size();
    }


    /**
     * inner class that initializes all textViews
     */
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
