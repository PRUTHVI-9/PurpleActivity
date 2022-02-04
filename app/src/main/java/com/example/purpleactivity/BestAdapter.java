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

public class BestAdapter extends RecyclerView.Adapter<BestAdapter.NewCoustomHolder> {
    Context context2;
    List<Integer> imagelist2;

    public BestAdapter(Context context2,List<Integer>imagelist2){
        this.context2 = context2;
        this.imagelist2 = imagelist2;
    }


    @NonNull
    @Override
    public NewCoustomHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context2).inflate(R.layout.offer_list_row,parent,false);
        NewCoustomHolder coustomHolder = new NewCoustomHolder(view);
        return coustomHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull NewCoustomHolder holder, int position) {
        String text = String.valueOf(position+1);
//        holder.page.setText(text);
        holder.image2.setImageResource(imagelist2.get(position));
    }

    @Override
    public int getItemCount() {
        return imagelist2.size();
    }

    public class NewCoustomHolder extends RecyclerView.ViewHolder {
//        TextView page;
        ImageView image2;
        public NewCoustomHolder(@NonNull View itemView) {
            super(itemView);
//            page = itemView.findViewById(R.id.pageno);
            image2 = itemView.findViewById(R.id.image);
        }
    }
}
