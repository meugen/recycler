package recycler.meugeninua.recycler.ui.activities.main.fragment.vm;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;

import recycler.meugeninua.recycler.app.managers.AppAsyncManager;
import recycler.meugeninua.recycler.model.actions.AppActionApi;
import recycler.meugeninua.recycler.model.entities.MccMncEntity;
import recycler.meugeninua.recycler.model.resources.Resource;

/**
 * @author meugen
 */
public class MainViewModel extends ViewModel {

    public final MutableLiveData<Resource<List<MccMncEntity>>> mccMncLiveData;

    @Inject AppActionApi<Void, List<MccMncEntity>> actionApi;

    @Inject
    MainViewModel() {
        this.mccMncLiveData = new MutableLiveData<>();
    }

    public void loadMccMnc() {
        final Resource<List<MccMncEntity>> resource = mccMncLiveData.getValue();
        mccMncLiveData.setValue(Resource.loading(resource == null
                ? null : resource.result));
        actionApi.onAction(null, mccMncLiveData);
    }
}
