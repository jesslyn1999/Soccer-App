package com.example.mybolasepak.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybolasepak.R;
import com.example.mybolasepak.modellist.Event;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventMatchAdapter extends RecyclerView.Adapter<EventMatchAdapter.EventMatchHolder> {

    private List<Event> eventList;

    @NonNull
    @Override
    public EventMatchHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_match_info, parent, false);
        return new EventMatchHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventMatchHolder holder, int position) {
        Event event = eventList.get(position);

        holder.dateEventDetail.setText(event.getDateEvent());

//        Glide.with(holder.itemView.getContext())
//                .load(LoadImage.loadImageFromWebOperations(event.))
//        holder.imageTeamA.set
//        holder.textNameTeamA.set
//        holder.scoreTeamA.set
//        holder.textVs.set
//        holder.scoreTeamB.set
//        holder.imageTeamB.set
//        holder.textNameTeamB.set
//        holder.constraint2.set

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class EventMatchHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.date_event_detail)
        TextView dateEventDetail;
        @BindView(R.id.image_team_a)
        ImageView imageTeamA;
        @BindView(R.id.text_name_team_a)
        TextView textNameTeamA;
        @BindView(R.id.score_team_a)
        TextView scoreTeamA;
        @BindView(R.id.text_vs)
        TextView textVs;
        @BindView(R.id.score_team_b)
        TextView scoreTeamB;
        @BindView(R.id.image_team_b)
        ImageView imageTeamB;
        @BindView(R.id.text_name_team_b)
        TextView textNameTeamB;
        @BindView(R.id.constraint_2)
        ConstraintLayout constraint2;


        EventMatchHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
