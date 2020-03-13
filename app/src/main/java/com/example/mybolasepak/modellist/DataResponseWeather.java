package com.example.mybolasepak.modellist;

import com.example.mybolasepak.database.model.Weather;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class DataResponseWeather {
    private long dt;
    private String dt_text;

    @SerializedName("weather")
    private ArrayList<Weather> weathers;

    @SerializedName("wind.speed")
    private Double windSpeed;

    @SerializedName("wind.deg")
    private Double windDeg;

    @SerializedName("main.temp")
    private Double temperature;
}
