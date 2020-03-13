package com.example.mybolasepak.modellist;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class ResponseWeather {
    private String cod;
    private String message;
    private Integer cnt;

    @SerializedName("list")
    private ArrayList<DataResponseWeather> dataResponseWeathers;

}
