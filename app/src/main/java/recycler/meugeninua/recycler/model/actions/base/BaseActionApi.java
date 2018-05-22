package recycler.meugeninua.recycler.model.actions.base;

import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.CallSuper;

import recycler.meugeninua.recycler.model.actions.AppActionApi;
import recycler.meugeninua.recycler.model.resources.Resource;

/**
 * @author meugen
 */
public class BaseActionApi<Req, Resp> implements AppActionApi<Req, Resp> {

    @CallSuper
    @Override
    public void onAction(
            final Req req,
            final MutableLiveData<Resource<Resp>> liveData) {
        final Resource<Resp> resource = liveData.getValue();
        liveData.postValue(Resource.loading(resource == null
                ? null : resource.result));
    }
}
