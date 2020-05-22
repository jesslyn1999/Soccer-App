package com.example.mybolasepak.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mybolasepak.R;
import com.example.mybolasepak.activity.EventDetail;
import com.example.mybolasepak.database.model.EventDbModel;
import com.example.mybolasepak.utils.LoadImage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventDetailAdapter extends RecyclerView.Adapter<EventDetailAdapter.EventDetailViewHolder> {

    private static final String TAG = "EventDetailAdapter";
    private Context mcon;

    private List<EventDbModel> dataList;
    private List<EventDbModel> filteredDataList;

    public EventDetailAdapter(Context con, List<EventDbModel> dataList) {
        this.dataList = dataList;
        filteredDataList = dataList;
        mcon = con;
    }

    @NonNull
    @Override
    public EventDetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.activity_event_detail, parent, false);
        return new EventDetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EventDetailViewHolder holder, int position) {
        EventDbModel event = filteredDataList.get(position);
        DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy", new Locale("in"));
        Glide.with(holder.itemView.getContext())
                .load(LoadImage.decodeDrawable(holder.itemView.getContext(), event.getHomeTeam().getBase64TeamBadge()))
                .into(holder.imageTeamA);
        Glide.with(holder.itemView.getContext())
                .load(LoadImage.decodeDrawable(holder.itemView.getContext(), event.getAwayTeam().getBase64TeamBadge()))
                .into(holder.imageTeamB);
        holder.dateEventDetail.setText(dateFormat.format(event.getDatetimeEvent()));
        holder.textNameTeamA.setText(event.getHomeTeam().getName());
        holder.textNameTeamB.setText(event.getAwayTeam().getName());
        holder.scoreTeamA.setText(String.valueOf(event.getHomeScore()));
        holder.scoreTeamB.setText(String.valueOf(event.getAwayScore()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(),
                        "Choose " + filteredDataList.get(holder.getAdapterPosition()).getHomeTeam().getName(),
                        Toast.LENGTH_SHORT)
                        .show();
                Intent moveIntent = new Intent(mcon, EventDetail.class);
                moveIntent.putExtra(EventDetail.EXTRA_EVENT_ID, filteredDataList.get(holder.getAdapterPosition()).getId());
                mcon.startActivity(moveIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (filteredDataList != null) ? filteredDataList.size() : 0;
    }

    public class EventDetailViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.date_event_detail)
        TextView dateEventDetail;
        @BindView(R.id.image_team_a)
        ImageView imageTeamA;
        @BindView(R.id.text_name_team_a)
        TextView textNameTeamA;
        @BindView(R.id.score_team_a)
        TextView scoreTeamA;
        @BindView(R.id.score_team_b)
        TextView scoreTeamB;
        @BindView(R.id.image_team_b)
        ImageView imageTeamB;
        @BindView(R.id.text_name_team_b)
        TextView textNameTeamB;

        public EventDetailViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
