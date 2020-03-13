package com.example.mybolasepak;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mybolasepak.adapter.EventDetailAdapter;
import com.example.mybolasepak.api.RetrofitClientApi;
import com.example.mybolasepak.api.RetrofitServiceInterface;
import com.example.mybolasepak.database.model.DaoSession;
import com.example.mybolasepak.database.model.EventDbModel;
import com.example.mybolasepak.database.model.TeamDbModel;
import com.example.mybolasepak.model.TeamList;
import com.example.mybolasepak.service.event.EventGetIntractorsImpl;
import com.example.mybolasepak.service.event.EventPresenterImpl;
import com.example.mybolasepak.service.MainInterface;
import com.example.mybolasepak.service.step.StepDetector;
import com.example.mybolasepak.utils.LoadImage;
import com.example.mybolasepak.utils.Network;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;


public class MainActivity extends AppCompatActivity implements MainInterface.MainView<EventDbModel> {

    private static final String TAG = "MainActivity";
    private static final String STATE_NUMSTEP = "NumStepsSate";

    @BindView(R.id.step_counter)
    TextView tvStepCount;

    private StepDetector simpleStepDetector;
    private EventPresenterImpl presenter;
    private RecyclerView recyclerView;
    private EventDetailAdapter adapter;
    private DaoSession daoSession;
    private BroadcastReceiver receiver;
    private boolean flag = true;
    private String serviceData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        daoSession = ((GreenDaoApp) getApplication()).getDaoSession();
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        ButterKnife.bind(this);

        receiver = new PlayingReceiver();
        IntentFilter mainFilter = new IntentFilter("count.step");
        registerReceiver(receiver, mainFilter);
        Intent intent = new Intent(MainActivity.this, StepDetector.class);
        startService(intent);

        recyclerView = findViewById(R.id.list_of_match);
        List<EventDbModel> eventDbModelList = daoSession.getEventDbModelDao().loadAll();
        if (eventDbModelList.size()<=0) {
            Toast.makeText(MainActivity.this,
                    "No data in database" ,
                    Toast.LENGTH_LONG).show();
        }
        adapter = new EventDetailAdapter(eventDbModelList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        if (Network.isNetworkAvailable(this)) {
            EventGetIntractorsImpl eventGetIntractors = new EventGetIntractorsImpl();
            presenter = new EventPresenterImpl(this, eventGetIntractors);
            presenter.requestDataFromServer();
        }
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(receiver);
        super.onDestroy();
    }

    @Override
    public void showProgress() {
    }

    @Override
    public void hideProgress() {
    }

    @Override
    public void setDataToRecyclerView(ArrayList<EventDbModel> DataList) {
        RetrofitServiceInterface service = RetrofitClientApi.getInstance().create(RetrofitServiceInterface.class);
        String[] columns = daoSession.getEventDbModelDao().getAllColumns();
        Log.e(TAG, "Start executing setDataToRecyclerView: ");

        List<EventDbModel> eventList = presenter.getEventDbModelList();
        try {
            for (int i = 0; i < eventList.size(); i++) {
                Log.i(TAG, "event " + i + " consist of response : " + eventList.get(i));
                if (daoSession.getEventDbModelDao().load(eventList.get(i).getId()) == null) {
                    daoSession.getEventDbModelDao().insert(eventList.get(i));
                }
                if (daoSession.getTeamDbModelDao().load(eventList.get(i).getHomeTeamId()) == null) {
                    Call<TeamList> call = service.getTeamListById(eventList.get(i).getHomeTeamId());
                    Log.i(TAG, "Get teamCallHome from url= " + call.request().url());
                    TeamDbModel teamDbModel = call.execute().body().getTeams().get(0);
                    Log.i(TAG, "Success teamCallHome with resp=" + teamDbModel);
                    teamDbModel.setBase64TeamBadge(LoadImage.getByteArrayFromImageURL(teamDbModel.getUrlTeamBadge()));
                    daoSession.getTeamDbModelDao().insertOrReplace(teamDbModel);
                }
                if (daoSession.getTeamDbModelDao().load(eventList.get(i).getAwayTeamId()) == null) {
                    Call<TeamList> call = service.getTeamListById(eventList.get(i).getAwayTeamId());
                    Log.i(TAG, "Get teamCallAway from url= " + call.request().url());
                    TeamDbModel teamDbModel = call.execute().body().getTeams().get(0);
                    Log.i(TAG, "Success teamCallAway with resp=" + teamDbModel);
                    teamDbModel.setBase64TeamBadge(LoadImage.getByteArrayFromImageURL(teamDbModel.getUrlTeamBadge()));
                    daoSession.getTeamDbModelDao().insertOrReplace(teamDbModel);
                }
            }
        } catch (Exception exc) {
            Log.e(TAG, "failed at fetching team", exc);
        }

        List<EventDbModel> eventDbModelList = daoSession.getEventDbModelDao().loadAll();
        adapter = new EventDetailAdapter(eventDbModelList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onResponseFailure(Throwable throwable) {
        Toast.makeText(MainActivity.this,
                "Something went wrong...Error message: " + throwable.getMessage(),
                Toast.LENGTH_LONG).show();
    }

    class PlayingReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            serviceData = intent.getStringExtra("stepService");
            tvStepCount.setText(serviceData + " Steps Today");
        }
    }
}
