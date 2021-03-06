package com.example.purpleactivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class Page3 extends Fragment {
    RecyclerView offerList;
    RecyclerView discunts;
    RecyclerView bumper;
    RecyclerView best;
    ViewPager2 vp_offers;
    LinearLayout dots_container;
    private String TAG=getClass().getSimpleName();
    int [] List;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setDot(0,List);

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= LayoutInflater.from(getContext()).inflate(R.layout.activity_studio,container,false);
        offerList = view.findViewById(R.id.offerlist);
        discunts = view.findViewById(R.id.discounts);
        vp_offers = view.findViewById(R.id.vp_offers);
        dots_container = view.findViewById(R.id.dots_container);
        bumper = view.findViewById(R.id.bumper);
        best = view.findViewById(R.id.best);
        RecyclerView.LayoutManager manager  = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        RecyclerView.LayoutManager manager4  = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        RecyclerView.LayoutManager manager2= new GridLayoutManager(getContext(),2);
        RecyclerView.LayoutManager manager3= new GridLayoutManager(getContext(),2);

        List<Integer> firstList = new ArrayList<>();
        firstList.add(R.drawable.n1);
        firstList.add(R.drawable.n2);
        firstList.add(R.drawable.n3);
        firstList.add(R.drawable.n4);
        firstList.add(R.drawable.n5);
        firstList.add(R.drawable.n6);
        firstList.add(R.drawable.n7);
        offerList.setLayoutManager(manager);
        OfferListAdapter myaAdaper = new OfferListAdapter(getContext(),firstList);
        offerList.setAdapter(myaAdaper);

        List<Integer> secondlist = new ArrayList<>();
        secondlist.add(R.drawable.k1);
        secondlist.add(R.drawable.sc);
        secondlist.add(R.drawable.personal);
        secondlist.add(R.drawable.k2);
        discunts.setLayoutManager(manager2);
        OfferListAdapter secondAdapter = new OfferListAdapter(getContext(),secondlist);
        discunts.setAdapter(secondAdapter);
        discunts.setNestedScrollingEnabled(false);

        List<Integer> thirdlist = new ArrayList<>();
        thirdlist.add(R.drawable.i1);
        thirdlist.add(R.drawable.i2);
        thirdlist.add(R.drawable.i3);
        thirdlist.add(R.drawable.i7);
        bumper.setLayoutManager(manager3);
        OfferListAdapter thirdAdapter = new OfferListAdapter(getContext(),thirdlist);
        bumper.setAdapter(thirdAdapter);
        bumper.setNestedScrollingEnabled(false);

        List<Integer> fourthList = new ArrayList<>();
        fourthList.add(R.drawable.s1);
        fourthList.add(R.drawable.s2);
        fourthList.add(R.drawable.s3);
        fourthList.add(R.drawable.s6);
        fourthList.add(R.drawable.s5);

        List<Item> list= new ArrayList<>();
        list.add(new Item("test1","test description 1","22/01/2022",R.drawable.s1));
        list.add(new Item("test2","test description 2","22/01/2022",R.drawable.s2));
        list.add(new Item("test3","test description 3","22/01/2022",R.drawable.s3));
        list.add(new Item("test5","test description 5","22/01/2022",R.drawable.s5));
        list.add(new Item("test6","test description 6","22/01/2022",R.drawable.s6));
        ItemListAdapter adapter = new ItemListAdapter(getContext(),list);
        best.setLayoutManager(manager4);
        best.setAdapter(adapter);


       List = new int[5];
        List[0]= (R.drawable.s1);
        List[1]= (R.drawable.s2);
        List[2]= (R.drawable.s3);
        List[3]= (R.drawable.s5);
        List[4]= (R.drawable.s6);

        SliderAdapter adapter1 = new SliderAdapter(List);
        vp_offers.setAdapter(adapter1);
        vp_offers.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                setDot(position,List);
                Log.e(TAG, "onPageScrolled: "+position );
            }
        });
        return view;
    }

    private void setDot(int position, int[] List) {
        int total = List.length;
        dots_container.removeAllViews();
        TextView[] list = new TextView[List.length];
        Log.e(TAG, "setDot: "+position );
        for (int i=0; i<total;i++){
            list[position] = new TextView(getContext());
            list[position].setText(Html.fromHtml("&#9679"));
            if (i == position){
                list[position].setTextColor(getResources().getColor(R.color.purple_200));
            }
            else {
                list[position].setTextColor(getResources().getColor(android.R.color.darker_gray));
            }
            dots_container.addView(list[position]);

        }
        Log.e(TAG, "setDot:position "+position );
        Log.e(TAG, "setDot:length "+List.length );
    }
}
