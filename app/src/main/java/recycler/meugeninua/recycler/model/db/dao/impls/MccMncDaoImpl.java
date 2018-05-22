package recycler.meugeninua.recycler.model.db.dao.impls;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import recycler.meugeninua.recycler.app.managers.AppTransactionManager;
import recycler.meugeninua.recycler.model.db.dao.MccMncDao;
import recycler.meugeninua.recycler.model.db.mappings.EntityMapping;
import recycler.meugeninua.recycler.model.entities.MccMncEntity;

/**
 * @author meugen
 */
public class MccMncDaoImpl implements MccMncDao {

    private static final String TABLE = "mccmnc";

    @Inject AppTransactionManager manager;
    @Inject EntityMapping<MccMncEntity> mccMncMapping;

    @Inject
    MccMncDaoImpl() {}

    @Override
    public void insert(final Collection<MccMncEntity> entities) {
        manager.actInTransaction(db -> _insert(db, entities));
    }

    private Void _insert(
            final SQLiteDatabase db,
            final Collection<MccMncEntity> entities) {
        for (MccMncEntity entity : entities) {
            final ContentValues values = new ContentValues();
            mccMncMapping.entityToValues(entity, values);
            db.replaceOrThrow(TABLE, null, values);
        }
        return null;
    }

    @Override
    public int count() {
        return manager.actInTransaction(this::_count);
    }

    private Integer _count(final SQLiteDatabase db) {
        Cursor cursor = null;
        try {
            cursor = db.rawQuery("SELECT count(id) c FROM mccmnc", new String[0]);
            if (cursor.moveToFirst()) {
                return cursor.getInt(0);
            }
            return 0;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    @Override
    public List<MccMncEntity> all() {
        return manager.actInTransaction(this::_all);
    }

    private List<MccMncEntity> _all(final SQLiteDatabase db) {
        Cursor cursor = null;
        try {
            cursor = db.rawQuery("SELECT * FROM mccmnc ORDER BY country_name ASC, operator ASC", new String[0]);

            final List<MccMncEntity> result = new ArrayList<>(cursor.getCount());
            while (cursor.moveToNext()) {
                result.add(mccMncMapping.cursorToEntity(cursor));
            }
            return result;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }
}
