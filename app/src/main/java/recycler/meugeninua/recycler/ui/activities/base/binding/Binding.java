package recycler.meugeninua.recycler.ui.activities.base.binding;

import android.view.View;

/**
 * @author meugen
 */
public interface Binding {

    <V extends View> V get(int id);

    void attachView(View view);

    void detachView();
}
