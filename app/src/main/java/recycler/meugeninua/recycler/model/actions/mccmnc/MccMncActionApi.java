package recycler.meugeninua.recycler.model.actions.mccmnc;

import android.arch.lifecycle.MutableLiveData;

import java.util.List;

import javax.inject.Inject;

import recycler.meugeninua.recycler.app.managers.AppAsyncManager;
import recycler.meugeninua.recycler.model.actions.base.BaseActionApi;
import recycler.meugeninua.recycler.model.db.dao.MccMncDao;
import recycler.meugeninua.recycler.model.entities.MccMncEntity;
import recycler.meugeninua.recycler.model.resources.LiveDataListener;
import recycler.meugeninua.recycler.model.resources.Resource;

/**
 * @author meugen
 */
public class MccMncActionApi extends BaseActionApi<Void, List<MccMncEntity>> {

    @Inject AppAsyncManager asyncManager;
    @Inject MccMncDao mccMncDao;

    @Inject
    MccMncActionApi() {}

    @Override
    public void onAction(
            final Void aVoid,
            final MutableLiveData<Resource<List<MccMncEntity>>> liveData) {
        super.onAction(aVoid, liveData);
        asyncManager.execute(
                mccMncDao::all,
                new LiveDataListener<>(liveData));
    }
}
