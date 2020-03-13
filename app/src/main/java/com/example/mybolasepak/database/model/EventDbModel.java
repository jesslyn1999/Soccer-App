package com.example.mybolasepak.database.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;

import java.util.Date;

import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Transient;

import lombok.Data;


@Entity
@Data
public class EventDbModel implements Parcelable {

    @Id
    @SerializedName("idEvent")
    private long id;

    @NotNull
    @SerializedName("strEvent")
    private String name;

    @NotNull
    @SerializedName("idHomeTeam")
    private long homeTeamId;

    @NotNull
    @SerializedName("idAwayTeam")
    private long awayTeamId;

    private Long weatherId;

    @SerializedName("intHomeScore")
    private int homeScore;
    @SerializedName("intHomeShots")
    private int homeShots;
    @SerializedName("strHomeGoalDetails")
    private String homeGoals;

    @SerializedName("intAwayScore")
    private int awayScore;
    @SerializedName("intAwayShots")
    private int awayShots;
    @SerializedName("strAwayGoalDetails")
    private String awayGoals;

    @SerializedName("strCity")
    private String location;

    @NotNull
    private Date datetimeEvent;

    @SerializedName("dateEvent")
    @Transient
    private String dateEventText;

    @SerializedName(value = "strTimeLocal", alternate = "strTime")
    @Transient
    private String timeEventText;

    @ToOne(joinProperty = "homeTeamId")
    private TeamDbModel homeTeam;
    @ToOne(joinProperty = "awayTeamId")
    private TeamDbModel awayTeam;

    @ToOne(joinProperty = "weatherId")
    private Weather weather;

    @Override
    public String toString() {
        return "EventDbModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", homeTeamId=" + homeTeamId +
                ", awayTeamId=" + awayTeamId +
                ", homeScore=" + homeScore +
                ", homeShots=" + homeShots +
                ", homeGoals=" + homeGoals +
                ", awayScore=" + awayScore +
                ", awayShots=" + awayShots +
                ", awayGoals=" + awayGoals +
                ", location='" + location + '\'' +
                ", dateEvent=" + datetimeEvent +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.name);
        dest.writeLong(this.homeTeamId);
        dest.writeLong(this.awayTeamId);
        dest.writeValue(this.weatherId);
        dest.writeInt(this.homeScore);
        dest.writeInt(this.homeShots);
        dest.writeString(this.homeGoals);
        dest.writeInt(this.awayScore);
        dest.writeInt(this.awayShots);
        dest.writeString(this.awayGoals);
        dest.writeString(this.location);
        dest.writeLong(this.datetimeEvent != null ? this.datetimeEvent.getTime() : -1);
        dest.writeString(this.dateEventText);
        dest.writeString(this.timeEventText);
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getHomeTeamId() {
        return this.homeTeamId;
    }

    public void setHomeTeamId(long homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    public long getAwayTeamId() {
        return this.awayTeamId;
    }

    public void setAwayTeamId(long awayTeamId) {
        this.awayTeamId = awayTeamId;
    }

    public Long getWeatherId() {
        return this.weatherId;
    }

    public void setWeatherId(Long weatherId) {
        this.weatherId = weatherId;
    }

    public int getHomeScore() {
        return this.homeScore;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public int getHomeShots() {
        return this.homeShots;
    }

    public void setHomeShots(int homeShots) {
        this.homeShots = homeShots;
    }

    public String getHomeGoals() {
        return this.homeGoals;
    }

    public void setHomeGoals(String homeGoals) {
        this.homeGoals = homeGoals;
    }

    public int getAwayScore() {
        return this.awayScore;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }

    public int getAwayShots() {
        return this.awayShots;
    }

    public void setAwayShots(int awayShots) {
        this.awayShots = awayShots;
    }

    public String getAwayGoals() {
        return this.awayGoals;
    }

    public void setAwayGoals(String awayGoals) {
        this.awayGoals = awayGoals;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDatetimeEvent() {
        return this.datetimeEvent;
    }

    public void setDatetimeEvent(Date datetimeEvent) {
        this.datetimeEvent = datetimeEvent;
    }

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1937397178)
    public TeamDbModel getHomeTeam() {
        long __key = this.homeTeamId;
        if (homeTeam__resolvedKey == null || !homeTeam__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TeamDbModelDao targetDao = daoSession.getTeamDbModelDao();
            TeamDbModel homeTeamNew = targetDao.load(__key);
            synchronized (this) {
                homeTeam = homeTeamNew;
                homeTeam__resolvedKey = __key;
            }
        }
        return homeTeam;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1911201496)
    public void setHomeTeam(@NotNull TeamDbModel homeTeam) {
        if (homeTeam == null) {
            throw new DaoException(
                    "To-one property 'homeTeamId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.homeTeam = homeTeam;
            homeTeamId = homeTeam.getId();
            homeTeam__resolvedKey = homeTeamId;
        }
    }

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 491019757)
    public TeamDbModel getAwayTeam() {
        long __key = this.awayTeamId;
        if (awayTeam__resolvedKey == null || !awayTeam__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TeamDbModelDao targetDao = daoSession.getTeamDbModelDao();
            TeamDbModel awayTeamNew = targetDao.load(__key);
            synchronized (this) {
                awayTeam = awayTeamNew;
                awayTeam__resolvedKey = __key;
            }
        }
        return awayTeam;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 278397936)
    public void setAwayTeam(@NotNull TeamDbModel awayTeam) {
        if (awayTeam == null) {
            throw new DaoException(
                    "To-one property 'awayTeamId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.awayTeam = awayTeam;
            awayTeamId = awayTeam.getId();
            awayTeam__resolvedKey = awayTeamId;
        }
    }

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1385378199)
    public Weather getWeather() {
        Long __key = this.weatherId;
        if (weather__resolvedKey == null || !weather__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            WeatherDao targetDao = daoSession.getWeatherDao();
            Weather weatherNew = targetDao.load(__key);
            synchronized (this) {
                weather = weatherNew;
                weather__resolvedKey = __key;
            }
        }
        return weather;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 746082110)
    public void setWeather(Weather weather) {
        synchronized (this) {
            this.weather = weather;
            weatherId = weather == null ? null : weather.getId();
            weather__resolvedKey = weatherId;
        }
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 2093359451)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getEventDbModelDao() : null;
    }

    protected EventDbModel(Parcel in) {
        this.id = in.readLong();
        this.name = in.readString();
        this.homeTeamId = in.readLong();
        this.awayTeamId = in.readLong();
        this.weatherId = (Long) in.readValue(Long.class.getClassLoader());
        this.homeScore = in.readInt();
        this.homeShots = in.readInt();
        this.homeGoals = in.readString();
        this.awayScore = in.readInt();
        this.awayShots = in.readInt();
        this.awayGoals = in.readString();
        this.location = in.readString();
        long tmpDatetimeEvent = in.readLong();
        this.datetimeEvent = tmpDatetimeEvent == -1 ? null : new Date(tmpDatetimeEvent);
        this.dateEventText = in.readString();
        this.timeEventText = in.readString();
        this.homeTeam = in.readParcelable(TeamDbModel.class.getClassLoader());
        this.awayTeam = in.readParcelable(TeamDbModel.class.getClassLoader());
        this.weather = in.readParcelable(Weather.class.getClassLoader());
    }

    @Generated(hash = 1045103894)
    public EventDbModel(long id, @NotNull String name, long homeTeamId, long awayTeamId,
            Long weatherId, int homeScore, int homeShots, String homeGoals, int awayScore,
            int awayShots, String awayGoals, String location, @NotNull Date datetimeEvent) {
        this.id = id;
        this.name = name;
        this.homeTeamId = homeTeamId;
        this.awayTeamId = awayTeamId;
        this.weatherId = weatherId;
        this.homeScore = homeScore;
        this.homeShots = homeShots;
        this.homeGoals = homeGoals;
        this.awayScore = awayScore;
        this.awayShots = awayShots;
        this.awayGoals = awayGoals;
        this.location = location;
        this.datetimeEvent = datetimeEvent;
    }

    @Generated(hash = 1189926993)
    public EventDbModel() {
    }

    public static final Creator<EventDbModel> CREATOR = new Creator<EventDbModel>() {
        @Override
        public EventDbModel createFromParcel(Parcel source) {
            return new EventDbModel(source);
        }

        @Override
        public EventDbModel[] newArray(int size) {
            return new EventDbModel[size];
        }
    };

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1009658045)
    private transient EventDbModelDao myDao;

    @Generated(hash = 312121295)
    private transient Long homeTeam__resolvedKey;

    @Generated(hash = 1934993098)
    private transient Long awayTeam__resolvedKey;

    @Generated(hash = 665441540)
    private transient Long weather__resolvedKey;
}
