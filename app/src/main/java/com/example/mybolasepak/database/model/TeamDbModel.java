package com.example.mybolasepak.database.model;

import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;

import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;

import lombok.Data;
import org.greenrobot.greendao.DaoException;

@Data
@Entity
public class TeamDbModel {
    @Id
    @SerializedName("idTeam")
    private long id;

    @NotNull
    @SerializedName("strTeam")
    private String name;

    @NotNull
    @SerializedName("strTeamBadge")
    private String urlTeamBadge;

    @NotNull
    private String base64TeamBadge;

    @ToMany(referencedJoinProperty = "homeTeamId")
    private List<EventDbModel> homeTeamEvents;
    @ToMany(referencedJoinProperty = "awayTeamId")
    private List<EventDbModel> awayTeamEvents;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1513918748)
    private transient TeamDbModelDao myDao;

    @Generated(hash = 2010122707)
    public TeamDbModel(long id, @NotNull String name, @NotNull String urlTeamBadge,
            @NotNull String base64TeamBadge) {
        this.id = id;
        this.name = name;
        this.urlTeamBadge = urlTeamBadge;
        this.base64TeamBadge = base64TeamBadge;
    }

    @Generated(hash = 434480944)
    public TeamDbModel() {
    }

    @Override
    public String toString() {
        return "TeamDbModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", urlTeamBadge='" + urlTeamBadge + '\'' +
                '}';
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

    public String getUrlTeamBadge() {
        return this.urlTeamBadge;
    }

    public void setUrlTeamBadge(String urlTeamBadge) {
        this.urlTeamBadge = urlTeamBadge;
    }

    public String getBase64TeamBadge() {
        return this.base64TeamBadge;
    }

    public void setBase64TeamBadge(String base64TeamBadge) {
        this.base64TeamBadge = base64TeamBadge;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1010820191)
    public List<EventDbModel> getHomeTeamEvents() {
        if (homeTeamEvents == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            EventDbModelDao targetDao = daoSession.getEventDbModelDao();
            List<EventDbModel> homeTeamEventsNew = targetDao
                    ._queryTeamDbModel_HomeTeamEvents(id);
            synchronized (this) {
                if (homeTeamEvents == null) {
                    homeTeamEvents = homeTeamEventsNew;
                }
            }
        }
        return homeTeamEvents;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1139104422)
    public synchronized void resetHomeTeamEvents() {
        homeTeamEvents = null;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 649791168)
    public List<EventDbModel> getAwayTeamEvents() {
        if (awayTeamEvents == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            EventDbModelDao targetDao = daoSession.getEventDbModelDao();
            List<EventDbModel> awayTeamEventsNew = targetDao
                    ._queryTeamDbModel_AwayTeamEvents(id);
            synchronized (this) {
                if (awayTeamEvents == null) {
                    awayTeamEvents = awayTeamEventsNew;
                }
            }
        }
        return awayTeamEvents;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 307200351)
    public synchronized void resetAwayTeamEvents() {
        awayTeamEvents = null;
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
    @Generated(hash = 1392873266)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getTeamDbModelDao() : null;
    }
}
