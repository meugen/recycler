package recycler.meugeninua.recycler.model.db.mappings.impls;

import android.content.ContentValues;
import android.database.Cursor;

/**
 * @author meugen
 */
class BaseMapping {

    String getStringOrNull(final Cursor cursor, final String name) {
        final int index = cursor.getColumnIndex(name);
        if (index < 0 || cursor.isNull(index)) {
            return null;
        }
        return cursor.getString(index);
    }

    void putStringOrNull(
            final String name,
            final String value,
            final ContentValues values) {
        if (value == null) {
            values.putNull(name);
        } else {
            values.put(name, value);
        }
    }
}
