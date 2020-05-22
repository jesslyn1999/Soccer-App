package com.example.mybolasepak;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybolasepak.adapter.EventDetailAdapter;
import com.example.mybolasepak.api.RetrofitClientApi;
import com.example.mybolasepak.api.RetrofitServiceInterface;
import com.example.mybolasepak.database.model.DaoSession;
import com.example.mybolasepak.database.model.EventDbModel;
import com.example.mybolasepak.database.model.TeamDbModel;
import com.example.mybolasepak.database.model.Weather;
import com.example.mybolasepak.modellist.DataResponseWeather;
import com.example.mybolasepak.modellist.ResponseWeather;
import com.example.mybolasepak.modellist.TeamList;
import com.example.mybolasepak.service.MainInterface;
import com.example.mybolasepak.service.event.EventGetIntractorsImpl;
import com.example.mybolasepak.service.event.EventPresenterImpl;
import com.example.mybolasepak.service.step.StepDetector;
import com.example.mybolasepak.utils.LoadImage;
import com.example.mybolasepak.utils.Network;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;


public class MainActivity extends AppCompatActivity implements MainInterface.MainView<EventDbModel> {

    private static final String TAG = "MainActivity";
    private static final String STATE_NUMSTEP = "NumStepsSate";

    @BindView(R.id.step_counter)
    TextView tvStepCount;
    @BindView(R.id.searchView2)
    SearchView searchView2;
    @BindView(R.id.list_of_match)
    RecyclerView recyclerView;

    private StepDetector simpleStepDetector;
    private EventPresenterImpl presenter;
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
        if (Build.VERSION.SDK_INT >= 21) {
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
        if (eventDbModelList.size() <= 0) {
            Toast.makeText(MainActivity.this,
                    "No data in database",
                    Toast.LENGTH_LONG).show();
        } else {
            Log.i(TAG, "Im here : " + eventDbModelList.size());
            adapter = new EventDetailAdapter(this, eventDbModelList);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
        }

        if (Network.isNetworkAvailable(this)) {
            EventGetIntractorsImpl eventGetIntractors = new EventGetIntractorsImpl();
            presenter = new EventPresenterImpl(this, eventGetIntractors);
            presenter.requestDataFromServer();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (searchView2 != null) {
            Log.i(TAG, "STEP 0 ..");
            searchView2.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    List<EventDbModel> dataList = daoSession.getEventDbModelDao().loadAll();
                    List<EventDbModel> filteredEventList = new ArrayList<>();
                    if (newText== null || newText.length() <= 0) {
                        filteredEventList.addAll(dataList);
                    } else {
                        String filterPattern = newText.toLowerCase().trim();
                        for (EventDbModel eventDbModel : dataList) {
                            if (eventDbModel.getHomeTeam().getName().toLowerCase().contains(filterPattern) ||
                                    eventDbModel.getAwayTeam().getName().toLowerCase().contains(filterPattern))
                                filteredEventList.add(eventDbModel);
                        }
                    }

                    adapter = new EventDetailAdapter(MainActivity.this, filteredEventList);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setAdapter(adapter);
                    return true;
                }
            });
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
        RetrofitServiceInterface service = RetrofitClientApi.getSportDbInstance().create(RetrofitServiceInterface.class);
        RetrofitServiceInterface serviceWeather = RetrofitClientApi.getApiOpenWeatherInstance().create(RetrofitServiceInterface.class);
        RetrofitServiceInterface serviceIcon = RetrofitClientApi.getOpenWeatherInstance().create(RetrofitServiceInterface.class);

        String[] columns = daoSession.getEventDbModelDao().getAllColumns();
        Log.e(TAG, "Start executing setDataToRecyclerView: ");

        List<EventDbModel> eventList = presenter.getEventDbModelList();
        try {
            for (int i = 0; i < eventList.size(); i++) {
                EventDbModel event = eventList.get(i);
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", new Locale("in"));
                event.setDatetimeEvent(dateFormat.parse(event.getDateEventText() + " " + event.getTimeEventText()));
                Log.i(TAG, "event " + i + " consist of response : " + event);

                Call<TeamList> call = service.getTeamListById(eventList.get(i).getHomeTeamId());
                Log.i(TAG, "Get teamCallHome from url= " + call.request().url());
                TeamDbModel teamDbModel = call.execute().body().getTeams().get(0);
                Log.i(TAG, "Success teamCallHome with resp=" + teamDbModel);
                if (daoSession.getTeamDbModelDao().load(teamDbModel.getId()) == null)
                    teamDbModel.setBase64TeamBadge(LoadImage.getByteArrayFromImageURL(teamDbModel.getUrlTeamBadge()));
                else
                    teamDbModel.setBase64TeamBadge(daoSession.getTeamDbModelDao().load(teamDbModel.getId()).getBase64TeamBadge());
                daoSession.getTeamDbModelDao().insertOrReplace(teamDbModel);

                long diffInMillies = event.getDatetimeEvent().getTime() - new Date().getTime();
                if (diffInMillies >= 0) {
                    try {
                        long diff = TimeUnit.HOURS.convert(diffInMillies, TimeUnit.MILLISECONDS);
                        if (diff < 5 * 24) {
                            String country = eventList.get(i).getLocation();
                            if (country == null) {
                                String location = teamDbModel.getStadiumLocation();
                                country = location.substring(location.indexOf(", ") + 1).trim().replaceAll(" ", "");
                            }
                            Call<ResponseWeather> responseWeatherCall = serviceWeather.getWeatherByCountry(country);
                            Log.i(TAG, "Get Weather from url= " + responseWeatherCall.request().url());

                            DataResponseWeather dataWeatherList = responseWeatherCall.execute().body().getDataResponseWeathers().get((int) diff / 3);
                            Weather weather = dataWeatherList.getWeathers().get(0);

                            Call<ResponseBody> responseWeatherIconCall = serviceIcon.getIconPng(weather.getIconId());
                            Log.i(TAG, "Get Weather Icon from url= " + responseWeatherIconCall.request().url());

                            if (daoSession.getWeatherDao().load(weather.getId()) == null) {
                                weather.setByte64icon(LoadImage.getByteArrayFromImageURL(responseWeatherIconCall.request().url().toString()));
                            } else {
                                weather.setByte64icon(daoSession.getWeatherDao().load(weather.getId()).getByte64icon());
                            }
                            daoSession.getWeatherDao().insertOrReplace(dataWeatherList.getWeathers().get(0));
                            event.setWeather(daoSession.getWeatherDao().load(weather.getId()));
                        }
                    } catch (Exception ignored) {
                    }
                }

                call = service.getTeamListById(eventList.get(i).getAwayTeamId());
                Log.i(TAG, "Get teamCallAway from url= " + call.request().url());
                teamDbModel = call.execute().body().getTeams().get(0);
                Log.i(TAG, "Success teamCallAway with resp=" + teamDbModel);
                if (daoSession.getTeamDbModelDao().load(teamDbModel.getId()) == null)
                    teamDbModel.setBase64TeamBadge(LoadImage.getByteArrayFromImageURL(teamDbModel.getUrlTeamBadge()));
                else
                    teamDbModel.setBase64TeamBadge(daoSession.getTeamDbModelDao().load(teamDbModel.getId()).getBase64TeamBadge());
                daoSession.getTeamDbModelDao().insertOrReplace(teamDbModel);

                daoSession.getEventDbModelDao().insertOrReplace(eventList.get(i));
            }
        } catch (Exception exc) {
            Log.e(TAG, "failed at fetching team", exc);
        }

        List<EventDbModel> eventDbModelList = daoSession.getEventDbModelDao().loadAll();
        adapter = new EventDetailAdapter(this, eventDbModelList);
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
