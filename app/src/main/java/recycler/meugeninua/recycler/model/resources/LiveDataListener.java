package recycler.meugeninua.recycler.model.resources;

import android.arch.lifecycle.MutableLiveData;

import java.lang.ref.WeakReference;

import recycler.meugeninua.recycler.app.managers.AppAsyncManager;

/**
 * @author meugen
 */
public class LiveDataListener<T> implements AppAsyncManager.ResultListener<T> {

    private final Object liveDataOrRef;

    public LiveDataListener(final MutableLiveData<Resource<T>> liveData) {
        this(liveData, true);
    }

    public LiveDataListener(
            final MutableLiveData<Resource<T>> liveData,
            final boolean weak) {
        this.liveDataOrRef = weak ? new WeakReference<>(liveData) : liveData;
    }

    private MutableLiveData<Resource<T>> getLiveData() {
        if (liveDataOrRef instanceof WeakReference) {
            final WeakReference<MutableLiveData<Resource<T>>> ref
                    = (WeakReference<MutableLiveData<Resource<T>>>) liveDataOrRef;
            return ref.get();
        }
        return (MutableLiveData<Resource<T>>) liveDataOrRef;
    }

    @Override
    public void onSuccess(final T result) {
        final MutableLiveData<Resource<T>> liveData = getLiveData();
        if (liveData != null) {
            liveData.postValue(Resource.success(result));
        }
    }

    @Override
    public void onError(final Throwable t) {
        final MutableLiveData<Resource<T>> liveData = getLiveData();
        if (liveData != null) {
            liveData.postValue(Resource.error(t));
        }
    }
}
