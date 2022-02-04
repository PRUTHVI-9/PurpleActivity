package com.example.purpleactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OfferListAdapter extends RecyclerView.Adapter<OfferListAdapter.CustomViewHolder> {
    Context context;
    List<Integer> imagelist;




    public OfferListAdapter(Context context, List<Integer> imagelist) {
        this.context = context;
        this.imagelist = imagelist;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.offer_list_row,parent,false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        String text = String.valueOf(position+1);
//        holder.pageno.setText(text);
        holder.image.setImageResource(imagelist.get(position));
    }

    @Override
    public int getItemCount() {
        return imagelist.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
//        TextView pageno;
        ImageView image;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
//            pageno =itemView.findViewById(R.id.pageno);
            image =itemView.findViewById(R.id.image);
        }
    }
}
