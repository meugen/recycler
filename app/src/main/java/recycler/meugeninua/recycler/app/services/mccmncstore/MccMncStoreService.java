package recycler.meugeninua.recycler.app.services.mccmncstore;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.support.annotation.NonNull;
import android.support.v4.app.JobIntentService;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.Log;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import recycler.meugeninua.recycler.app.managers.AppTransactionManager;
import recycler.meugeninua.recycler.model.db.dao.MccMncDao;
import recycler.meugeninua.recycler.model.entities.MccMncEntity;

/**
 * @author meugen
 */
public class MccMncStoreService extends JobIntentService {

    private static final String TAG = MccMncStoreService.class.getSimpleName();

    public static void enqueueWork(final Context context) {
        final Intent intent = new Intent(context, MccMncStoreService.class);
        enqueueWork(context, MccMncStoreService.class, 1000, intent);
    }

    @Inject MccMncDao mccMncDao;

    @Override
    public void onCreate() {
        AndroidInjection.inject(this);
        super.onCreate();
    }

    @Override
    protected void onHandleWork(@NonNull final Intent intent) {
        final int count = mccMncDao.count();
        if (count > 0) {
            Log.d(TAG, "No need store mcc-mnc. There are already " + count + " entities");
            return;
        }

        try (JsonReader reader = openMccMncList()) {
            storeMccMncEntities(reader);
        } catch (IOException e) {
            Log.e(TAG, e.getMessage(), e);
        }
    }

    private JsonReader openMccMncList() throws IOException {
        final AssetManager manager = getAssets();
        return new JsonReader(new InputStreamReader(manager
                .open("mcc-mnc-list.json")));
    }

    private void storeMccMncEntities(final JsonReader reader) throws IOException {
        final List<MccMncEntity> entities = new ArrayList<>();

        reader.beginArray();
        while (reader.hasNext()) {
            final MccMncEntity entity = new MccMncEntity();

            reader.beginObject();
            while (reader.hasNext()) {
                final String name = reader.nextName();
                if ("type".equals(name)) {
                    entity.type = nextStringOrNull(reader);
                } else if ("countryName".equals(name)) {
                    entity.countryName = nextStringOrNull(reader);
                } else if ("countryCode".equals(name)) {
                    entity.countryCode = nextStringOrNull(reader);
                } else if ("mcc".equals(name)) {
                    entity.mcc = nextStringOrNull(reader);
                } else if ("mnc".equals(name)) {
                    entity.mnc = nextStringOrNull(reader);
                } else if ("brand".equals(name)) {
                    entity.brand = nextStringOrNull(reader);
                } else if ("operator".equals(name)) {
                    entity.operator = nextStringOrNull(reader);
                } else if ("status".equals(name)) {
                    entity.status = nextStringOrNull(reader);
                } else if ("bands".equals(name)) {
                    entity.bands = nextStringOrNull(reader);
                } else if ("notes".equals(name)) {
                    entity.notes = nextStringOrNull(reader);
                } else {
                    reader.skipValue();
                }
            }
            reader.endObject();

            if (!"Test".equals(entity.type) && entity.isValid()) {
                entities.add(entity);
            }
        }
        reader.endArray();

        mccMncDao.insert(entities);
        Log.d(TAG, "Entities are stored");
    }

    private String nextStringOrNull(
            final JsonReader reader) throws IOException {
        if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
            return null;
        }
        return reader.nextString();
    }
}
