package com.example.mybolasepak.model;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class Team {
    @SerializedName("idEvent")
    private String id;

    private String soccerXML;
    private String idAPIfootball;
    private String intLoved;

    private String strTeam;
    private String strAlternate;

    private String intFormedYear;
    private String strSport;
    private String strLeague;
    private String idLeague;

    private String strTeamBadge;
    private String strTeamJersey;
    private String strTeamLogo;
    private String strTeamBanner;

}
