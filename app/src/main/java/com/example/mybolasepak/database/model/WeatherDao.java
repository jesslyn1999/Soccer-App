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
 * DAO for table "WEATHER".
*/
public class WeatherDao extends AbstractDao<Weather, Long> {

    public static final String TABLENAME = "WEATHER";

    /**
     * Properties of entity Weather.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, long.class, "id", true, "_id");
        public final static Property Condition = new Property(1, String.class, "condition", false, "CONDITION");
        public final static Property Description = new Property(2, String.class, "description", false, "DESCRIPTION");
        public final static Property IconId = new Property(3, String.class, "iconId", false, "ICON_ID");
        public final static Property Byte64icon = new Property(4, String.class, "byte64icon", false, "BYTE64ICON");
    }

    private DaoSession daoSession;


    public WeatherDao(DaoConfig config) {
        super(config);
    }
    
    public WeatherDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"WEATHER\" (" + //
                "\"_id\" INTEGER PRIMARY KEY NOT NULL ," + // 0: id
                "\"CONDITION\" TEXT NOT NULL ," + // 1: condition
                "\"DESCRIPTION\" TEXT NOT NULL ," + // 2: description
                "\"ICON_ID\" TEXT NOT NULL ," + // 3: iconId
                "\"BYTE64ICON\" TEXT NOT NULL );"); // 4: byte64icon
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"WEATHER\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Weather entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
        stmt.bindString(2, entity.getCondition());
        stmt.bindString(3, entity.getDescription());
        stmt.bindString(4, entity.getIconId());
        stmt.bindString(5, entity.getByte64icon());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Weather entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
        stmt.bindString(2, entity.getCondition());
        stmt.bindString(3, entity.getDescription());
        stmt.bindString(4, entity.getIconId());
        stmt.bindString(5, entity.getByte64icon());
    }

    @Override
    protected final void attachEntity(Weather entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 0);
    }    

    @Override
    public Weather readEntity(Cursor cursor, int offset) {
        Weather entity = new Weather( //
            cursor.getLong(offset + 0), // id
            cursor.getString(offset + 1), // condition
            cursor.getString(offset + 2), // description
            cursor.getString(offset + 3), // iconId
            cursor.getString(offset + 4) // byte64icon
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Weather entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setCondition(cursor.getString(offset + 1));
        entity.setDescription(cursor.getString(offset + 2));
        entity.setIconId(cursor.getString(offset + 3));
        entity.setByte64icon(cursor.getString(offset + 4));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Weather entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Weather entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Weather entity) {
        throw new UnsupportedOperationException("Unsupported for entities with a non-null key");
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
