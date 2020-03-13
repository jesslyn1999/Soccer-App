package com.example.mybolasepak.model;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class Team {
    @SerializedName("idTeam")
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

    private boolean subscribed;

    public String getStrTeam() { return this.strTeam; }

    public String getStrTeamBadge() { return (this.strTeamBadge + "/preview"); }

    public boolean getSubscribed() { return this.subscribed; }
    public void enableSubsc() { this.subscribed = true; }
    public void disableSubsc() { this.subscribed = false; }
}
