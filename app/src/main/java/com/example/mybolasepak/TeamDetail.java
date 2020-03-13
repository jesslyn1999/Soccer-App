package com.example.mybolasepak;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.mybolasepak.adapter.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class TeamDetail extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_detail);

        viewPager = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.tabs);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new TabSebelum(),"Sebelum");
        adapter.addFragment(new TabSekarang(),"Sekarang");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}
