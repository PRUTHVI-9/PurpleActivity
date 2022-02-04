package com.example.purpleactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class StudioActivity extends AppCompatActivity {
    LinearLayout dotslayout;
    SliderAdapter adapter;
    ViewPager2 pager2;
    int List[];
    TextView[] dots;
    RecyclerView offerlist,discunts,bumper,best;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studio);
        dotslayout = findViewById(R.id.dots_container);
        pager2 = findViewById(R.id.vp_offers);
        offerlist = findViewById(R.id.offerlist);
        discunts = findViewById(R.id.discounts);
        bumper = findViewById(R.id.bumper);
        best = findViewById(R.id.best);

        List = new int[5];
        List[0]= (R.drawable.s1);
        List[1]= (R.drawable.s2);
        List[2]= (R.drawable.s3);
        List[3]= (R.drawable.s5);
        List[4]= (R.drawable.s6);

        adapter = new SliderAdapter(List);
        pager2.setAdapter(adapter);

        dots = new TextView[List.length];
        dotsIndicator();

        pager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {

                selectedIndicator(position);
                super.onPageSelected(position);
            }

            private void selectedIndicator(int position) {
                for (int i=0;i<dots.length;i++)
                {
                    if (i==position)
                    {
                        dots[i].setTextColor(getResources().getColor(R.color.purple_200));
                    }
                    else
                    {
                        dots[i].setTextColor(getResources().getColor(android.R.color.darker_gray));
                    }
                }
            }
        });
        

        RecyclerView.LayoutManager manager= new LinearLayoutManager(StudioActivity.this,RecyclerView.HORIZONTAL,false);
        RecyclerView.LayoutManager manager2= new GridLayoutManager(StudioActivity.this,2);
        RecyclerView.LayoutManager manager3= new GridLayoutManager(StudioActivity.this,2);
        RecyclerView.LayoutManager manager4= new LinearLayoutManager(StudioActivity.this,RecyclerView.HORIZONTAL,false);
        offerlist.setLayoutManager(manager);
        discunts.setLayoutManager(manager2);
        bumper.setLayoutManager(manager3);
        best.setLayoutManager(manager4);

        List<Integer> firstList = new ArrayList<>();
        firstList.add(R.drawable.n1);
        firstList.add(R.drawable.n2);
        firstList.add(R.drawable.n3);
        firstList.add(R.drawable.n4);
        firstList.add(R.drawable.n5);
        firstList.add(R.drawable.n6);
        firstList.add(R.drawable.n7);
        OfferListAdapter myaAdaper = new OfferListAdapter(StudioActivity.this,firstList);
        offerlist.setAdapter(myaAdaper);

        List<Integer> secondlist = new ArrayList<>();
        secondlist.add(R.drawable.k1);
        secondlist.add(R.drawable.sc);
        secondlist.add(R.drawable.personal);
        secondlist.add(R.drawable.k2);
        OfferListAdapter secondAdapter = new OfferListAdapter(StudioActivity.this,secondlist);
        discunts.setAdapter(secondAdapter);
        discunts.setNestedScrollingEnabled(false);

        List<Integer> thirdlist = new ArrayList<>();
        thirdlist.add(R.drawable.i1);
        thirdlist.add(R.drawable.i2);
        thirdlist.add(R.drawable.i3);
        thirdlist.add(R.drawable.i7);
        OfferListAdapter thirdAdapter = new OfferListAdapter(StudioActivity.this,thirdlist);
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
        ItemListAdapter adapter = new ItemListAdapter(StudioActivity.this,list);
        best.setAdapter(adapter);





    }

    private void dotsIndicator() {
        for (int i=0;i<dots.length;i++){

            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#9679"));
            dots[i].setTextSize(18);
            dotslayout.addView(dots[i]);

        }
    }

}