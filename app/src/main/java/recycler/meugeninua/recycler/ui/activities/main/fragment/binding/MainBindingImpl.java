package recycler.meugeninua.recycler.ui.activities.main.fragment.binding;

import android.widget.TextView;

import javax.inject.Inject;

import recycler.meugeninua.recycler.R;
import recycler.meugeninua.recycler.ui.activities.base.binding.BaseBinding;

/**
 * @author meugen
 */
public class MainBindingImpl extends BaseBinding implements MainBinding {

    @Inject
    MainBindingImpl() {}

    @Override
    public void setMessage(final CharSequence message) {
        final TextView messageView = get(R.id.message);
        messageView.setText(message);
    }
}
