package com.example.mybolasepak.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@AllArgsConstructor
@Data
@Builder
public class Event implements Parcelable {
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

    public Event(String strHomeTeam, String intHomeScore, String strAwayTeam, String intAwayScore, String dateEvent) {
        this.strHomeTeam = strHomeTeam;
        this.intHomeScore = intHomeScore;
        this.strAwayTeam = strAwayTeam;
        this.intAwayScore = intAwayScore;
        this.dateEvent = dateEvent;
    }

    protected Event(Parcel in) {
        id = in.readString();
        idSoccerXML = in.readString();
        idAPIfootball = in.readString();
        strEvent = in.readString();
        strSeason = in.readString();
        strSport = in.readString();
        strDescriptionEN = in.readString();
        idLeague = in.readString();
        strLeague = in.readString();
        intSpectators = in.readString();
        idHomeTeam = in.readString();
        strHomeTeam = in.readString();
        intHomeScore = in.readString();
        intHomeShots = in.readString();
        idAwayTeam = in.readString();
        strAwayTeam = in.readString();
        intAwayScore = in.readString();
        intAwayShots = in.readString();
        dateEvent = in.readString();
        strTime = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(idSoccerXML);
        dest.writeString(idAPIfootball);
        dest.writeString(strEvent);
        dest.writeString(strSeason);
        dest.writeString(strSport);
        dest.writeString(strDescriptionEN);
        dest.writeString(idLeague);
        dest.writeString(strLeague);
        dest.writeString(intSpectators);
        dest.writeString(idHomeTeam);
        dest.writeString(strHomeTeam);
        dest.writeString(intHomeScore);
        dest.writeString(intHomeShots);
        dest.writeString(idAwayTeam);
        dest.writeString(strAwayTeam);
        dest.writeString(intAwayScore);
        dest.writeString(intAwayShots);
        dest.writeString(dateEvent);
        dest.writeString(strTime);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Event> CREATOR = new Creator<Event>() {
        @Override
        public Event createFromParcel(Parcel in) {
            return new Event(in);
        }

        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };

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
