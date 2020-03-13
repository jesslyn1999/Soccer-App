package com.example.mybolasepak.database.model;

import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;
import org.greenrobot.greendao.DaoException;

@Entity
public class Weather {
    @Id
    @SerializedName("id")
    private long id;

    @NotNull
    @SerializedName("main")
    private String condition;

    @NotNull
    private String description;

    @NotNull
    @SerializedName("icon")
    private String iconId;

    @NotNull
    private String byte64icon;

    @ToMany(referencedJoinProperty = "weatherId")
    private List<EventDbModel> events;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1275646288)
    private transient WeatherDao myDao;

    @Generated(hash = 811033428)
    public Weather(long id, @NotNull String condition, @NotNull String description,
            @NotNull String iconId, @NotNull String byte64icon) {
        this.id = id;
        this.condition = condition;
        this.description = description;
        this.iconId = iconId;
        this.byte64icon = byte64icon;
    }

    @Generated(hash = 556711069)
    public Weather() {
    }

    @Override
    public String toString() {
        return "Weather{" +
                "id=" + id +
                ", condition='" + condition + '\'' +
                ", description='" + description + '\'' +
                ", iconId='" + iconId + '\'' +
                '}';
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCondition() {
        return this.condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIconId() {
        return this.iconId;
    }

    public void setIconId(String iconId) {
        this.iconId = iconId;
    }

    public String getByte64icon() {
        return this.byte64icon;
    }

    public void setByte64icon(String byte64icon) {
        this.byte64icon = byte64icon;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1655241163)
    public List<EventDbModel> getEvents() {
        if (events == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            EventDbModelDao targetDao = daoSession.getEventDbModelDao();
            List<EventDbModel> eventsNew = targetDao._queryWeather_Events(id);
            synchronized (this) {
                if (events == null) {
                    events = eventsNew;
                }
            }
        }
        return events;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1830105409)
    public synchronized void resetEvents() {
        events = null;
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
    @Generated(hash = 1342418174)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getWeatherDao() : null;
    }
}
