package com.example.mybolasepak.database.model;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.SqlUtils;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "EVENT_DB_MODEL".
*/
public class EventDbModelDao extends AbstractDao<EventDbModel, Long> {

    public static final String TABLENAME = "EVENT_DB_MODEL";

    /**
     * Properties of entity EventDbModel.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, long.class, "id", true, "_id");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property HomeTeamId = new Property(2, long.class, "homeTeamId", false, "HOME_TEAM_ID");
        public final static Property AwayTeamId = new Property(3, long.class, "awayTeamId", false, "AWAY_TEAM_ID");
        public final static Property WeatherId = new Property(4, Long.class, "weatherId", false, "WEATHER_ID");
        public final static Property HomeScore = new Property(5, int.class, "homeScore", false, "HOME_SCORE");
        public final static Property HomeShots = new Property(6, int.class, "homeShots", false, "HOME_SHOTS");
        public final static Property HomeGoals = new Property(7, String.class, "homeGoals", false, "HOME_GOALS");
        public final static Property AwayScore = new Property(8, int.class, "awayScore", false, "AWAY_SCORE");
        public final static Property AwayShots = new Property(9, int.class, "awayShots", false, "AWAY_SHOTS");
        public final static Property AwayGoals = new Property(10, String.class, "awayGoals", false, "AWAY_GOALS");
        public final static Property Location = new Property(11, String.class, "location", false, "LOCATION");
        public final static Property DatetimeEvent = new Property(12, java.util.Date.class, "datetimeEvent", false, "DATETIME_EVENT");
    }

    private DaoSession daoSession;

    private Query<EventDbModel> teamDbModel_HomeTeamEventsQuery;
    private Query<EventDbModel> teamDbModel_AwayTeamEventsQuery;
    private Query<EventDbModel> weather_EventsQuery;

    public EventDbModelDao(DaoConfig config) {
        super(config);
    }
    
    public EventDbModelDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"EVENT_DB_MODEL\" (" + //
                "\"_id\" INTEGER PRIMARY KEY NOT NULL ," + // 0: id
                "\"NAME\" TEXT NOT NULL ," + // 1: name
                "\"HOME_TEAM_ID\" INTEGER NOT NULL ," + // 2: homeTeamId
                "\"AWAY_TEAM_ID\" INTEGER NOT NULL ," + // 3: awayTeamId
                "\"WEATHER_ID\" INTEGER," + // 4: weatherId
                "\"HOME_SCORE\" INTEGER NOT NULL ," + // 5: homeScore
                "\"HOME_SHOTS\" INTEGER NOT NULL ," + // 6: homeShots
                "\"HOME_GOALS\" TEXT," + // 7: homeGoals
                "\"AWAY_SCORE\" INTEGER NOT NULL ," + // 8: awayScore
                "\"AWAY_SHOTS\" INTEGER NOT NULL ," + // 9: awayShots
                "\"AWAY_GOALS\" TEXT," + // 10: awayGoals
                "\"LOCATION\" TEXT," + // 11: location
                "\"DATETIME_EVENT\" INTEGER NOT NULL );"); // 12: datetimeEvent
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"EVENT_DB_MODEL\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, EventDbModel entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
        stmt.bindString(2, entity.getName());
        stmt.bindLong(3, entity.getHomeTeamId());
        stmt.bindLong(4, entity.getAwayTeamId());
 
        Long weatherId = entity.getWeatherId();
        if (weatherId != null) {
            stmt.bindLong(5, weatherId);
        }
        stmt.bindLong(6, entity.getHomeScore());
        stmt.bindLong(7, entity.getHomeShots());
 
        String homeGoals = entity.getHomeGoals();
        if (homeGoals != null) {
            stmt.bindString(8, homeGoals);
        }
        stmt.bindLong(9, entity.getAwayScore());
        stmt.bindLong(10, entity.getAwayShots());
 
        String awayGoals = entity.getAwayGoals();
        if (awayGoals != null) {
            stmt.bindString(11, awayGoals);
        }
 
        String location = entity.getLocation();
        if (location != null) {
            stmt.bindString(12, location);
        }
        stmt.bindLong(13, entity.getDatetimeEvent().getTime());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, EventDbModel entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
        stmt.bindString(2, entity.getName());
        stmt.bindLong(3, entity.getHomeTeamId());
        stmt.bindLong(4, entity.getAwayTeamId());
 
        Long weatherId = entity.getWeatherId();
        if (weatherId != null) {
            stmt.bindLong(5, weatherId);
        }
        stmt.bindLong(6, entity.getHomeScore());
        stmt.bindLong(7, entity.getHomeShots());
 
        String homeGoals = entity.getHomeGoals();
        if (homeGoals != null) {
            stmt.bindString(8, homeGoals);
        }
        stmt.bindLong(9, entity.getAwayScore());
        stmt.bindLong(10, entity.getAwayShots());
 
        String awayGoals = entity.getAwayGoals();
        if (awayGoals != null) {
            stmt.bindString(11, awayGoals);
        }
 
        String location = entity.getLocation();
        if (location != null) {
            stmt.bindString(12, location);
        }
        stmt.bindLong(13, entity.getDatetimeEvent().getTime());
    }

    @Override
    protected final void attachEntity(EventDbModel entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 0);
    }    

    @Override
    public EventDbModel readEntity(Cursor cursor, int offset) {
        EventDbModel entity = new EventDbModel( //
            cursor.getLong(offset + 0), // id
            cursor.getString(offset + 1), // name
            cursor.getLong(offset + 2), // homeTeamId
            cursor.getLong(offset + 3), // awayTeamId
            cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4), // weatherId
            cursor.getInt(offset + 5), // homeScore
            cursor.getInt(offset + 6), // homeShots
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // homeGoals
            cursor.getInt(offset + 8), // awayScore
            cursor.getInt(offset + 9), // awayShots
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // awayGoals
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // location
            new java.util.Date(cursor.getLong(offset + 12)) // datetimeEvent
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, EventDbModel entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setName(cursor.getString(offset + 1));
        entity.setHomeTeamId(cursor.getLong(offset + 2));
        entity.setAwayTeamId(cursor.getLong(offset + 3));
        entity.setWeatherId(cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4));
        entity.setHomeScore(cursor.getInt(offset + 5));
        entity.setHomeShots(cursor.getInt(offset + 6));
        entity.setHomeGoals(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setAwayScore(cursor.getInt(offset + 8));
        entity.setAwayShots(cursor.getInt(offset + 9));
        entity.setAwayGoals(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setLocation(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setDatetimeEvent(new java.util.Date(cursor.getLong(offset + 12)));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(EventDbModel entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(EventDbModel entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(EventDbModel entity) {
        throw new UnsupportedOperationException("Unsupported for entities with a non-null key");
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "homeTeamEvents" to-many relationship of TeamDbModel. */
    public List<EventDbModel> _queryTeamDbModel_HomeTeamEvents(long homeTeamId) {
        synchronized (this) {
            if (teamDbModel_HomeTeamEventsQuery == null) {
                QueryBuilder<EventDbModel> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.HomeTeamId.eq(null));
                teamDbModel_HomeTeamEventsQuery = queryBuilder.build();
            }
        }
        Query<EventDbModel> query = teamDbModel_HomeTeamEventsQuery.forCurrentThread();
        query.setParameter(0, homeTeamId);
        return query.list();
    }

    /** Internal query to resolve the "awayTeamEvents" to-many relationship of TeamDbModel. */
    public List<EventDbModel> _queryTeamDbModel_AwayTeamEvents(long awayTeamId) {
        synchronized (this) {
            if (teamDbModel_AwayTeamEventsQuery == null) {
                QueryBuilder<EventDbModel> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.AwayTeamId.eq(null));
                teamDbModel_AwayTeamEventsQuery = queryBuilder.build();
            }
        }
        Query<EventDbModel> query = teamDbModel_AwayTeamEventsQuery.forCurrentThread();
        query.setParameter(0, awayTeamId);
        return query.list();
    }

    /** Internal query to resolve the "events" to-many relationship of Weather. */
    public List<EventDbModel> _queryWeather_Events(Long weatherId) {
        synchronized (this) {
            if (weather_EventsQuery == null) {
                QueryBuilder<EventDbModel> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.WeatherId.eq(null));
                weather_EventsQuery = queryBuilder.build();
            }
        }
        Query<EventDbModel> query = weather_EventsQuery.forCurrentThread();
        query.setParameter(0, weatherId);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getTeamDbModelDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T1", daoSession.getTeamDbModelDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T2", daoSession.getWeatherDao().getAllColumns());
            builder.append(" FROM EVENT_DB_MODEL T");
            builder.append(" LEFT JOIN TEAM_DB_MODEL T0 ON T.\"HOME_TEAM_ID\"=T0.\"_id\"");
            builder.append(" LEFT JOIN TEAM_DB_MODEL T1 ON T.\"AWAY_TEAM_ID\"=T1.\"_id\"");
            builder.append(" LEFT JOIN WEATHER T2 ON T.\"WEATHER_ID\"=T2.\"_id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected EventDbModel loadCurrentDeep(Cursor cursor, boolean lock) {
        EventDbModel entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        TeamDbModel homeTeam = loadCurrentOther(daoSession.getTeamDbModelDao(), cursor, offset);
         if(homeTeam != null) {
            entity.setHomeTeam(homeTeam);
        }
        offset += daoSession.getTeamDbModelDao().getAllColumns().length;

        TeamDbModel awayTeam = loadCurrentOther(daoSession.getTeamDbModelDao(), cursor, offset);
         if(awayTeam != null) {
            entity.setAwayTeam(awayTeam);
        }
        offset += daoSession.getTeamDbModelDao().getAllColumns().length;

        Weather weather = loadCurrentOther(daoSession.getWeatherDao(), cursor, offset);
        entity.setWeather(weather);

        return entity;    
    }

    public EventDbModel loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<EventDbModel> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<EventDbModel> list = new ArrayList<EventDbModel>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<EventDbModel> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<EventDbModel> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
