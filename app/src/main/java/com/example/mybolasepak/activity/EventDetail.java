package com.example.mybolasepak.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.bumptech.glide.Glide;
import com.example.mybolasepak.GreenDaoApp;
import com.example.mybolasepak.R;
import com.example.mybolasepak.database.model.DaoSession;
import com.example.mybolasepak.database.model.EventDbModel;
import com.example.mybolasepak.utils.LoadImage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventDetail extends AppCompatActivity {

    private static final String TAG = "EventDetail";

    public static final String EXTRA_EVENT_ID = "extra_event_id";

    public static int RESULT_CODE = 110;

    private DaoSession daoSession;
    private EventDbModel eventDbModel;

    @BindView(R.id.image_weather)
    ImageView imageWeather;

    @BindView(R.id.date_event_detail)
    TextView dateEventDetail;
    @BindView(R.id.image_team_a)
    ImageView imageTeamA;
    @BindView(R.id.text_name_team_a)
    TextView textNameTeamA;
    @BindView(R.id.text_shot_team_a)
    TextView textShotTeamA;
    @BindView(R.id.score_team_a)
    TextView scoreTeamA;
    @BindView(R.id.score_team_b)
    TextView scoreTeamB;
    @BindView(R.id.image_team_b)
    ImageView imageTeamB;
    @BindView(R.id.text_name_team_b)
    TextView textNameTeamB;
    @BindView(R.id.text_shot_team_b)
    TextView textShotTeamB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_detail);
        ButterKnife.bind(this);
        Bundle extras = getIntent().getExtras();
        daoSession = ((GreenDaoApp) getApplication()).getDaoSession();

        if (extras != null) {
            if (extras.containsKey(EXTRA_EVENT_ID)) {
                Long eventId = getIntent().getLongExtra(EXTRA_EVENT_ID, -1);
                DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy", new Locale("in"));
                eventDbModel = daoSession.getEventDbModelDao().load(eventId);
                Glide.with(this)
                        .load(LoadImage.decodeDrawable(this, eventDbModel.getHomeTeam().getBase64TeamBadge()))
                        .into(imageTeamA);
                Glide.with(this)
                        .load(LoadImage.decodeDrawable(this, eventDbModel.getAwayTeam().getBase64TeamBadge()))
                        .into(imageTeamB);

                dateEventDetail.setText(dateFormat.format(eventDbModel.getDatetimeEvent()));
                textNameTeamA.setText(eventDbModel.getHomeTeam().getName());
                textNameTeamB.setText(eventDbModel.getAwayTeam().getName());

                textShotTeamA.setText(String.valueOf(eventDbModel.getHomeShots()));
                scoreTeamA.setText(String.valueOf(eventDbModel.getHomeScore()));
                textShotTeamB.setText(String.valueOf(eventDbModel.getAwayShots()));
                scoreTeamB.setText(String.valueOf(eventDbModel.getAwayScore()));

                if (eventDbModel.getWeather() != null ){
                    Glide.with(this)
                            .load(LoadImage.decodeDrawable(this, eventDbModel.getWeather().getByte64icon()))
                            .into(imageWeather);
                }

            }

        }
    }
}
