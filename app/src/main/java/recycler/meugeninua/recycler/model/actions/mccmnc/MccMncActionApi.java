package recycler.meugeninua.recycler.model.actions.mccmnc;

import android.arch.lifecycle.MutableLiveData;
import android.support.v4.util.ObjectsCompat;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import recycler.meugeninua.recycler.app.managers.AppAsyncManager;
import recycler.meugeninua.recycler.model.actions.base.BaseActionApi;
import recycler.meugeninua.recycler.model.data.mccmnc.MccMncBaseItem;
import recycler.meugeninua.recycler.model.data.mccmnc.MccMncEntityItem;
import recycler.meugeninua.recycler.model.data.mccmnc.MccMncHeaderItem;
import recycler.meugeninua.recycler.model.db.dao.MccMncDao;
import recycler.meugeninua.recycler.model.entities.MccMncEntity;
import recycler.meugeninua.recycler.model.resources.LiveDataListener;
import recycler.meugeninua.recycler.model.resources.Resource;

/**
 * @author meugen
 */
public class MccMncActionApi extends BaseActionApi<Void, List<MccMncBaseItem>> {

    @Inject AppAsyncManager asyncManager;
    @Inject MccMncDao mccMncDao;

    @Inject
    MccMncActionApi() {}

    @Override
    public void onAction(
            final Void aVoid,
            final MutableLiveData<Resource<List<MccMncBaseItem>>> liveData) {
        super.onAction(aVoid, liveData);
        asyncManager.execute(
                this::getItems,
                new LiveDataListener<>(liveData));
    }

    private List<MccMncBaseItem> getItems() {
        final List<MccMncEntity> entities = mccMncDao.all();
        String lastCountry = null;

        final List<MccMncBaseItem> items = new ArrayList<>();
        for (MccMncEntity entity : entities) {
            if (lastCountry == null || !lastCountry.equals(entity.countryName)) {
                items.add(new MccMncHeaderItem(entity.countryName));
                lastCountry = entity.countryName;
            }
            items.add(new MccMncEntityItem(entity));
        }
        return items;
    }
}
