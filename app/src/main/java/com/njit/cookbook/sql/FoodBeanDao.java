package com.njit.cookbook.sql;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import cn.njit.cookbook.model.FoodBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "FOOD_BEAN".
*/
public class FoodBeanDao extends AbstractDao<FoodBean, String> {

    public static final String TABLENAME = "FOOD_BEAN";

    /**
     * Properties of entity FoodBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, String.class, "id", false, "ID");
        public final static Property Title = new Property(1, String.class, "title", true, "TITLE");
        public final static Property Tags = new Property(2, String.class, "tags", false, "TAGS");
        public final static Property Imtro = new Property(3, String.class, "imtro", false, "IMTRO");
        public final static Property Ingredients = new Property(4, String.class, "ingredients", false, "INGREDIENTS");
        public final static Property Burden = new Property(5, String.class, "burden", false, "BURDEN");
        public final static Property ImageUrls = new Property(6, String.class, "imageUrls", false, "IMAGE_URLS");
    }


    public FoodBeanDao(DaoConfig config) {
        super(config);
    }
    
    public FoodBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"FOOD_BEAN\" (" + //
                "\"ID\" TEXT," + // 0: id
                "\"TITLE\" TEXT PRIMARY KEY NOT NULL ," + // 1: title
                "\"TAGS\" TEXT," + // 2: tags
                "\"IMTRO\" TEXT," + // 3: imtro
                "\"INGREDIENTS\" TEXT," + // 4: ingredients
                "\"BURDEN\" TEXT," + // 5: burden
                "\"IMAGE_URLS\" TEXT);"); // 6: imageUrls
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"FOOD_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, FoodBean entity) {
        stmt.clearBindings();
 
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(1, id);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(2, title);
        }
 
        String tags = entity.getTags();
        if (tags != null) {
            stmt.bindString(3, tags);
        }
 
        String imtro = entity.getImtro();
        if (imtro != null) {
            stmt.bindString(4, imtro);
        }
 
        String ingredients = entity.getIngredients();
        if (ingredients != null) {
            stmt.bindString(5, ingredients);
        }
 
        String burden = entity.getBurden();
        if (burden != null) {
            stmt.bindString(6, burden);
        }
 
        String imageUrls = entity.getImageUrls();
        if (imageUrls != null) {
            stmt.bindString(7, imageUrls);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, FoodBean entity) {
        stmt.clearBindings();
 
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(1, id);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(2, title);
        }
 
        String tags = entity.getTags();
        if (tags != null) {
            stmt.bindString(3, tags);
        }
 
        String imtro = entity.getImtro();
        if (imtro != null) {
            stmt.bindString(4, imtro);
        }
 
        String ingredients = entity.getIngredients();
        if (ingredients != null) {
            stmt.bindString(5, ingredients);
        }
 
        String burden = entity.getBurden();
        if (burden != null) {
            stmt.bindString(6, burden);
        }
 
        String imageUrls = entity.getImageUrls();
        if (imageUrls != null) {
            stmt.bindString(7, imageUrls);
        }
    }

    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1);
    }    

    @Override
    public FoodBean readEntity(Cursor cursor, int offset) {
        FoodBean entity = new FoodBean( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // title
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // tags
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // imtro
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // ingredients
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // burden
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6) // imageUrls
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, FoodBean entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setTitle(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setTags(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setImtro(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setIngredients(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setBurden(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setImageUrls(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
     }
    
    @Override
    protected final String updateKeyAfterInsert(FoodBean entity, long rowId) {
        return entity.getTitle();
    }
    
    @Override
    public String getKey(FoodBean entity) {
        if(entity != null) {
            return entity.getTitle();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(FoodBean entity) {
        return entity.getTitle() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
