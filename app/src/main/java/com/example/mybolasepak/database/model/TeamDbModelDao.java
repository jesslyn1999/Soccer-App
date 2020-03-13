package com.example.mybolasepak.database.model;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "TEAM_DB_MODEL".
*/
public class TeamDbModelDao extends AbstractDao<TeamDbModel, Long> {

    public static final String TABLENAME = "TEAM_DB_MODEL";

    /**
     * Properties of entity TeamDbModel.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, long.class, "id", true, "_id");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property UrlTeamBadge = new Property(2, String.class, "urlTeamBadge", false, "URL_TEAM_BADGE");
        public final static Property Base64TeamBadge = new Property(3, String.class, "base64TeamBadge", false, "BASE64_TEAM_BADGE");
        public final static Property StadiumLocation = new Property(4, String.class, "stadiumLocation", false, "STADIUM_LOCATION");
    }

    private DaoSession daoSession;


    public TeamDbModelDao(DaoConfig config) {
        super(config);
    }
    
    public TeamDbModelDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"TEAM_DB_MODEL\" (" + //
                "\"_id\" INTEGER PRIMARY KEY NOT NULL ," + // 0: id
                "\"NAME\" TEXT NOT NULL ," + // 1: name
                "\"URL_TEAM_BADGE\" TEXT NOT NULL ," + // 2: urlTeamBadge
                "\"BASE64_TEAM_BADGE\" TEXT NOT NULL ," + // 3: base64TeamBadge
                "\"STADIUM_LOCATION\" TEXT);"); // 4: stadiumLocation
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"TEAM_DB_MODEL\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, TeamDbModel entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
        stmt.bindString(2, entity.getName());
        stmt.bindString(3, entity.getUrlTeamBadge());
        stmt.bindString(4, entity.getBase64TeamBadge());
 
        String stadiumLocation = entity.getStadiumLocation();
        if (stadiumLocation != null) {
            stmt.bindString(5, stadiumLocation);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, TeamDbModel entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
        stmt.bindString(2, entity.getName());
        stmt.bindString(3, entity.getUrlTeamBadge());
        stmt.bindString(4, entity.getBase64TeamBadge());
 
        String stadiumLocation = entity.getStadiumLocation();
        if (stadiumLocation != null) {
            stmt.bindString(5, stadiumLocation);
        }
    }

    @Override
    protected final void attachEntity(TeamDbModel entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 0);
    }    

    @Override
    public TeamDbModel readEntity(Cursor cursor, int offset) {
        TeamDbModel entity = new TeamDbModel( //
            cursor.getLong(offset + 0), // id
            cursor.getString(offset + 1), // name
            cursor.getString(offset + 2), // urlTeamBadge
            cursor.getString(offset + 3), // base64TeamBadge
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4) // stadiumLocation
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, TeamDbModel entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setName(cursor.getString(offset + 1));
        entity.setUrlTeamBadge(cursor.getString(offset + 2));
        entity.setBase64TeamBadge(cursor.getString(offset + 3));
        entity.setStadiumLocation(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(TeamDbModel entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(TeamDbModel entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(TeamDbModel entity) {
        throw new UnsupportedOperationException("Unsupported for entities with a non-null key");
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}