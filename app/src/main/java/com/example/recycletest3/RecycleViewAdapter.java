package com.example.recycletest3;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


/**
 * recycler view adapter for History tab
 */
public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {


    Context mContext;
    List<ActionItem> mData;

    /**
     * default constructor
     * @param mContext context.
     * @param mData data containing list of actions.
     */
    public RecycleViewAdapter(Context mContext, List<ActionItem> mData) {
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
        v = LayoutInflater.from(mContext).inflate(R.layout.frag1_item, parent, false);
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
        holder.tv_date.setText(mData.get(position).getDate());
        holder.tv_card.setText(mData.get(position).getCard());
        holder.tv_amount.setText(mData.get(position).getAmount());
        String s = mData.get(position).getAmount();
        //Toast.makeText(mContext, s.substring(0,1), Toast.LENGTH_SHORT).show();
        if(s.substring(0, 1).equals("-")){
            //Toast.makeText(mContext, "red", Toast.LENGTH_SHORT).show();
            holder.setRed();
        }
        if(s.substring(0, 1).equals("+")){
            holder.setGreen();
        }

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
        private TextView tv_date;
        private TextView tv_card;
        private TextView tv_amount;

         public MyViewHolder(@NonNull View itemView) {
             super(itemView);

             tv_name = (TextView) itemView.findViewById(R.id.tvName);
             tv_date = (TextView) itemView.findViewById(R.id.tvDate);
             tv_card = (TextView) itemView.findViewById(R.id.tvCard);
             tv_amount = (TextView) itemView.findViewById(R.id.tvAmount);
         }

         public void setRed(){
             tv_amount.setTextColor(Color.parseColor("#C0392B"));
         }

         public void setGreen(){
             tv_amount.setTextColor(Color.parseColor("#229954"));
         }
     }
}
