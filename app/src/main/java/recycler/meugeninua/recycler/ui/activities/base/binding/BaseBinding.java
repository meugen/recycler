package recycler.meugeninua.recycler.ui.activities.base.binding;

import android.support.v4.util.SparseArrayCompat;
import android.view.View;

import java.lang.ref.WeakReference;

import javax.inject.Inject;

/**
 * @author meugen
 */
public class BaseBinding implements Binding {

    private final SparseArrayCompat<WeakReference<View>> array
            = new SparseArrayCompat<>();
    private WeakReference<View> rootViewRef;

    @Inject
    protected BaseBinding() {}

    public final <V extends View> V get(final int id) {
        final WeakReference<View> viewRef = array.get(id);
        View view = viewRef == null ? null : viewRef.get();
        if (view == null) {
            final View rootView = rootViewRef == null ? null : rootViewRef.get();
            if (rootView == null) {
                return null;
            }
            view = rootView.findViewById(id);
            if (view != null) {
                array.put(id, new WeakReference<>(view));
            }
        }
        return (V) view;
    }

    @Override
    public final void attachView(final View view) {
        detachView();
        rootViewRef = new WeakReference<>(view);
    }

    @Override
    public final void detachView() {
        if (rootViewRef != null) {
            rootViewRef.clear();
            rootViewRef = null;
        }
        array.clear();
    }
}
