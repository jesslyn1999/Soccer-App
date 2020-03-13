package com.example.mybolasepak.modellist;

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
    private EventList Last5EventList;
    private EventList Next5EventList;

    private boolean subscribed;

    public String getStrTeam() { return this.strTeam; }
    public String getStrTeamBadge() { return (this.strTeamBadge + "/preview"); }

    @Override
    public String toString() {
        return "Team{" +
                "id='" + id + '\'' +
                ", strTeam='" + strTeam + '\'' +
                ", strAlternate='" + strAlternate + '\'' +
                ", strTeamBadge='" + strTeamBadge + '\'' +
                '}';
    }
    public boolean getSubscribed() { return this.subscribed; }
    public void enableSubsc() { this.subscribed = true; }
    public void disableSubsc() { this.subscribed = false; }
}

