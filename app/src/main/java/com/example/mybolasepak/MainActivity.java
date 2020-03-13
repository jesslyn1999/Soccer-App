package com.example.mybolasepak;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mybolasepak.service.EventGetIntractorsImpl;
import com.example.mybolasepak.service.EventPresenterImpl;
import com.example.mybolasepak.service.MainInterface;
import com.example.mybolasepak.service.step.StepDetector;
import com.example.mybolasepak.service.step.StepListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements SensorEventListener, StepListener, MainInterface.MainView {

    @BindView(R.id.step_counter)
    TextView tvStepCount;
    @BindView(R.id.btn_start)
    Button BtnStart;
    @BindView(R.id.btn_stop)
    Button BtnStop;

    private StepDetector simpleStepDetector;
    private int numSteps = 0;
    private MainInterface.presenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // Get an instance of the SensorManager
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor accel = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        simpleStepDetector = new StepDetector();
        simpleStepDetector.registerListener(this);

        BtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Log.i("NEHH", "Button start counter is clicked");
                numSteps = 0;
                sensorManager.registerListener(MainActivity.this, accel, SensorManager.SENSOR_DELAY_FASTEST);
            }
        });

        BtnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                sensorManager.unregisterListener(MainActivity.this);

            }
        });

        presenter = new EventPresenterImpl(this, new EventGetIntractorsImpl());
        presenter.requestDataFromServer();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            simpleStepDetector.updateAccel(
                    event.timestamp, event.values[0], event.values[1], event.values[2]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override
    public void step(long timeNs) {
        numSteps++;
        tvStepCount.setText(numSteps + " Step Today");
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void setDataToRecyclerView(ArrayList DataList) {

    }

    @Override
    public void onResponseFailure(Throwable throwable) {

    }
}
