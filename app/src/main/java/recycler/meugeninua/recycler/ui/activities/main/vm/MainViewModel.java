package recycler.meugeninua.recycler.ui.activities.main.vm;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import recycler.meugeninua.recycler.app.managers.events.AppEventsManager;
import recycler.meugeninua.recycler.app.managers.events.EventMccMncUpdated;
import recycler.meugeninua.recycler.model.actions.AppActionApi;
import recycler.meugeninua.recycler.model.data.mccmnc.MccMncBaseItem;
import recycler.meugeninua.recycler.model.entities.MccMncEntity;
import recycler.meugeninua.recycler.model.resources.Resource;

/**
 * @author meugen
 */
public class MainViewModel extends ViewModel {

    public final MutableLiveData<Resource<List<MccMncBaseItem>>> mccMncLiveData;

    @Inject AppEventsManager eventsManager;
    @Inject AppActionApi<Void, List<MccMncBaseItem>> actionApi;

    private UUID key;

    @Inject
    MainViewModel() {
        this.mccMncLiveData = new MutableLiveData<>();
    }

    public void loadMccMnc() {
        if (key == null) {
            key = eventsManager.subscribeToEvent(
                    EventMccMncUpdated.class, event -> loadMccMnc());
        }
        actionApi.onAction(null, mccMncLiveData);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        eventsManager.unsubscribe(key);
    }
}
