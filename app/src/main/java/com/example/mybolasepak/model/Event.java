package com.example.mybolasepak.model;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@AllArgsConstructor
@Data
@Builder
public class Event {
    @SerializedName("idEvent")
    private String id;

    private String idSoccerXML;
    private String idAPIfootball;

    private String strEvent;
    private String strSeason;
    private String strSport;
    private String strDescriptionEN;

    private String idLeague;
    private String strLeague;
    private String intSpectators;

    private String idHomeTeam;
    private String strHomeTeam;
    private String intHomeScore;
    private String intHomeShots;

    private String idAwayTeam;
    private String strAwayTeam;
    private String intAwayScore;
    private String intAwayShots;

    private String dateEvent;  // TT-MM-DD
    private String strTime;

    private Team awayTeam;
    private Team homeTeam;

    @Override
    public String toString() {
        return "Event{" +
                "id='" + id + '\'' +
                ", idHomeTeam='" + idHomeTeam + '\'' +
                ", strHomeTeam='" + strHomeTeam + '\'' +
                ", idAwayTeam='" + idAwayTeam + '\'' +
                ", strAwayTeam='" + strAwayTeam + '\'' +
                '}';
    }

    public String getStrHomeTeam() {
        return strHomeTeam;
    }

    public String getIntHomeScore() {
        return intHomeScore;
    }

    public String getStrAwayTeam() {
        return strAwayTeam;
    }

    public String getIntAwayScore() {
        return intAwayScore;
    }

    public String getDateEvent() {
        return dateEvent;
    }
}
