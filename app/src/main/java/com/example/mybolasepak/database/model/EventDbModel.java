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


@Entity
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

    @SerializedName("intHomeScore")
    private int homeScore;
    @SerializedName("intHomeShots")
    private int homeShots;

    @NotNull
    @SerializedName("idAwayTeam")
    private long awayTeamId;

    @SerializedName("intAwayScore")
    private int awayScore;
    @SerializedName("intAwayShots")
    private int awayShots;

    @NotNull
    @SerializedName("dateEvent")
    private Date dateEvent;

    @ToOne(joinProperty = "homeTeamId")
    private TeamDbModel homeTeam;
    @ToOne(joinProperty = "awayTeamId")
    private TeamDbModel awayTeam;

    @Override
    public String toString() {
        return "EventDbModel{" +
                "Id=" + id +
                ", name='" + name + '\'' +
                ", homeTeamId=" + homeTeamId +
                ", homeScore=" + homeScore +
                ", homeShots=" + homeShots +
                ", awayTeamId=" + awayTeamId +
                ", awayScore=" + awayScore +
                ", awayShots=" + awayShots +
                ", dateEvent=" + dateEvent +
                ", homeTeam=" + homeTeam +
                ", awayTeam=" + awayTeam +
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
        dest.writeInt(this.homeScore);
        dest.writeInt(this.homeShots);
        dest.writeLong(this.awayTeamId);
        dest.writeInt(this.awayScore);
        dest.writeInt(this.awayShots);
        dest.writeLong(this.dateEvent != null ? this.dateEvent.getTime() : -1);
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

    public long getAwayTeamId() {
        return this.awayTeamId;
    }

    public void setAwayTeamId(long awayTeamId) {
        this.awayTeamId = awayTeamId;
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

    public Date getDateEvent() {
        return this.dateEvent;
    }

    public void setDateEvent(Date dateEvent) {
        this.dateEvent = dateEvent;
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

    public EventDbModel() {
    }

    protected EventDbModel(Parcel in) {
        this.id = in.readLong();
        this.name = in.readString();
        this.homeTeamId = in.readLong();
        this.homeScore = in.readInt();
        this.homeShots = in.readInt();
        this.awayTeamId = in.readLong();
        this.awayScore = in.readInt();
        this.awayShots = in.readInt();
        long tmpDateEvent = in.readLong();
        this.dateEvent = tmpDateEvent == -1 ? null : new Date(tmpDateEvent);
    }

    @Generated(hash = 1616430694)
    public EventDbModel(long id, @NotNull String name, long homeTeamId, int homeScore,
            int homeShots, long awayTeamId, int awayScore, int awayShots,
            @NotNull Date dateEvent) {
        this.id = id;
        this.name = name;
        this.homeTeamId = homeTeamId;
        this.homeScore = homeScore;
        this.homeShots = homeShots;
        this.awayTeamId = awayTeamId;
        this.awayScore = awayScore;
        this.awayShots = awayShots;
        this.dateEvent = dateEvent;
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
}
