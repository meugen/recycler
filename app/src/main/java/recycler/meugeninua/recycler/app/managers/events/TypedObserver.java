package recycler.meugeninua.recycler.app.managers.events;

import android.support.annotation.MainThread;

/**
 * @author meugen
 */
public interface TypedObserver<T> {

    @MainThread
    void onUpdate(T event);
}
