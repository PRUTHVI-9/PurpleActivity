package com.example.purpleactivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.MyViewHolder> {

    int list[];

    public SliderAdapter(int[] list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_item,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.view.setImageResource(list[position]);

    }

    @Override
    public int getItemCount() {
        return list.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView view;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView.findViewById(R.id.iv_image);
        }
    }
}
