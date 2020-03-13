package com.example.mybolasepak;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.mybolasepak.adapter.ViewPagerAdapter;
import com.example.mybolasepak.model.Event;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class TeamDetail extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private Fragment tabSebelum;
    private Fragment tabSekarang;
    private ArrayList<Event> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_detail);

        viewPager = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.tabs);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        dataList = new ArrayList<Event>();

        Event event1 = new Event("TeamA","2","TeamB","1","12 Februari 2020");
        this.dataList.add(event1);
//
        tabSebelum = new TabSebelum();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("ARG_PARAM1",dataList);
        tabSebelum.setArguments(bundle);

        tabSekarang = new TabSekarang();
        tabSekarang.setArguments(bundle);

        adapter.addFragment(tabSebelum,"Sebelum");
        adapter.addFragment(tabSekarang,"Sekarang");
//
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}
