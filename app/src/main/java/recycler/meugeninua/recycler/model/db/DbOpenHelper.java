package recycler.meugeninua.recycler.model.db;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import recycler.meugeninua.recycler.app.di.qualifiers.AppContext;

/**
 * @author meugen
 */
public class DbOpenHelper extends SQLiteOpenHelper {

    private static final String TAG = DbOpenHelper.class.getSimpleName();

    private static final String NAME = "recycler";
    private static final int VERSION = 1;

    private static final int BUF_SIZE = 128;

    private final AssetManager assetManager;

    private Pattern pattern;

    @Inject
    DbOpenHelper(@AppContext final Context context) {
        super(context, NAME, null, VERSION);
        this.assetManager = context.getAssets();
    }

    @Override
    public void onCreate(final SQLiteDatabase db) {
        onUpgrade(db, 0, VERSION);
    }

    @Override
    public void onUpgrade(
            final SQLiteDatabase db,
            final int oldVersion,
            final int newVersion) {
        pattern = Pattern.compile("([^;]+);");
        for (int version = oldVersion + 1; version <= newVersion; version++) {
            upgrade(db, version);
        }
    }

    private void upgrade(final SQLiteDatabase db, final int version) {
        final Matcher matcher = pattern.matcher(
                readPatchForVersion(version));
        while (matcher.find()) {
            db.execSQL(matcher.group(1));
        }
    }

    private CharSequence readPatchForVersion(final int version) {
        try {
            Reader reader = null;
            try {
                reader = new InputStreamReader(assetManager.open(
                        "db/" + NAME + "/" + version + ".sql"));
                final StringBuilder builder = new StringBuilder();

                final char[] buf = new char[BUF_SIZE];
                while (true) {
                    final int count = reader.read(buf);
                    if (count < 0) {
                        break;
                    }
                    builder.append(buf, 0, count);
                }
                return builder;
            } finally {
                if (reader != null) {
                    reader.close();
                }
            }
        } catch (IOException e) {
            Log.e(TAG, e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }
}
