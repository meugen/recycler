package recycler.meugeninua.recycler.app.managers;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import javax.inject.Inject;

import recycler.meugeninua.recycler.app.di.scopes.PerApplication;

/**
 * @author meugen
 */
@PerApplication
public class AppTransactionManager {

    private final SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;

    @Inject
    AppTransactionManager(
            final SQLiteOpenHelper openHelper) {
        this.openHelper = openHelper;
    }

    public <T> T actInTransaction(final DbAction<T> action) {
        synchronized (this) {
            if (db == null) {
                db = openHelper.getWritableDatabase();
            }
        }
        if (db.inTransaction()) {
            return action.onAction(db);
        }
        final T result;

        db.beginTransaction();
        try {
            result = action.onAction(db);
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
        return result;
    }

    public interface DbAction<T> {

        T onAction(SQLiteDatabase db);
    }
}
