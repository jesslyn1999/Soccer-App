package com.example.mybolasepak.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybolasepak.R;
import com.example.mybolasepak.model.Event;

import java.util.ArrayList;

public class EventDetailAdapter extends RecyclerView.Adapter<EventDetailAdapter.EventDetailViewHolder> {

    private ArrayList<Event> dataList;

    public EventDetailAdapter(ArrayList<Event> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public EventDetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.fragment_match_info, parent, false);
        return new EventDetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EventDetailViewHolder holder, int position) {
        holder.txtDateEvent.setText(dataList.get(position).getDateEvent());
        holder.txtNameTeamA.setText(dataList.get(position).getStrHomeTeam());
        holder.txtNameTeamB.setText(dataList.get(position).getStrAwayTeam());
        holder.txtScoreTeamA.setText(dataList.get(position).getIntHomeScore());
        holder.txtScoreTeamB.setText(dataList.get(position).getIntAwayScore());
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class EventDetailViewHolder extends RecyclerView.ViewHolder{
        private TextView txtDateEvent, txtNameTeamA, txtNameTeamB,txtScoreTeamA,txtScoreTeamB;

        public EventDetailViewHolder(View itemView) {
            super(itemView);
            txtDateEvent = (TextView) itemView.findViewById(R.id.date_event_detail);
            txtNameTeamA = (TextView) itemView.findViewById(R.id.text_name_team_a);
            txtNameTeamB = (TextView) itemView.findViewById(R.id.text_name_team_b);
            txtScoreTeamA = (TextView) itemView.findViewById(R.id.score_team_a);
            txtScoreTeamB = (TextView) itemView.findViewById(R.id.score_team_b);
        }
    }

}
