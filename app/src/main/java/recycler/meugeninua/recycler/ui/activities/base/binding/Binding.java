package recycler.meugeninua.recycler.ui.activities.base.binding;

import android.support.annotation.NonNull;
import android.view.View;

/**
 * @author meugen
 */
public interface Binding {

    @NonNull
    <V extends View> V get(int id);

    void attachView(View view);

    void detachView();
}
