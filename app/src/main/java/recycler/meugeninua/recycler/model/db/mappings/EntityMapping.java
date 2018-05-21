package recycler.meugeninua.recycler.model.db.mappings;

import android.content.ContentValues;
import android.database.Cursor;

/**
 * @author meugen
 */
public interface EntityMapping<T> {

    T cursorToEntity(Cursor cursor);

    void entityToValues(T entity, ContentValues values);
}
