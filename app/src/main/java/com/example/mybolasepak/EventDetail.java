package com.example.mybolasepak;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

public class EventDetail extends AppCompatActivity {

    LinearLayout teamAGoals,teamBGoals;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);

        teamAGoals = findViewById(R.id.list_team_a_goal);
        teamBGoals = findViewById(R.id.list_team_b_goal);
    }
}
