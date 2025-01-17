package com.example.mybolasepak.database.model;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.example.mybolasepak.database.model.EventDbModel;
import com.example.mybolasepak.database.model.TeamDbModel;
import com.example.mybolasepak.database.model.Weather;

import com.example.mybolasepak.database.model.EventDbModelDao;
import com.example.mybolasepak.database.model.TeamDbModelDao;
import com.example.mybolasepak.database.model.WeatherDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig eventDbModelDaoConfig;
    private final DaoConfig teamDbModelDaoConfig;
    private final DaoConfig weatherDaoConfig;

    private final EventDbModelDao eventDbModelDao;
    private final TeamDbModelDao teamDbModelDao;
    private final WeatherDao weatherDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        eventDbModelDaoConfig = daoConfigMap.get(EventDbModelDao.class).clone();
        eventDbModelDaoConfig.initIdentityScope(type);

        teamDbModelDaoConfig = daoConfigMap.get(TeamDbModelDao.class).clone();
        teamDbModelDaoConfig.initIdentityScope(type);

        weatherDaoConfig = daoConfigMap.get(WeatherDao.class).clone();
        weatherDaoConfig.initIdentityScope(type);

        eventDbModelDao = new EventDbModelDao(eventDbModelDaoConfig, this);
        teamDbModelDao = new TeamDbModelDao(teamDbModelDaoConfig, this);
        weatherDao = new WeatherDao(weatherDaoConfig, this);

        registerDao(EventDbModel.class, eventDbModelDao);
        registerDao(TeamDbModel.class, teamDbModelDao);
        registerDao(Weather.class, weatherDao);
    }
    
    public void clear() {
        eventDbModelDaoConfig.clearIdentityScope();
        teamDbModelDaoConfig.clearIdentityScope();
        weatherDaoConfig.clearIdentityScope();
    }

    public EventDbModelDao getEventDbModelDao() {
        return eventDbModelDao;
    }

    public TeamDbModelDao getTeamDbModelDao() {
        return teamDbModelDao;
    }

    public WeatherDao getWeatherDao() {
        return weatherDao;
    }

}
