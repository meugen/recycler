package recycler.meugeninua.recycler.model.actions;

import android.arch.lifecycle.MutableLiveData;

import recycler.meugeninua.recycler.model.resources.Resource;

/**
 * @author meugen
 */
public interface AppActionApi<Req, Resp> {

    void onAction(Req req, MutableLiveData<Resource<Resp>> liveData);
}
