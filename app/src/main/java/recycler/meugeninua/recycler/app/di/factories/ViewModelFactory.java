package recycler.meugeninua.recycler.app.di.factories;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

/**
 * @author meugen
 */
public class ViewModelFactory implements ViewModelProvider.Factory {

    @Inject Map<Class<? extends ViewModel>, Provider<ViewModel>> providersMap;

    @Inject
    ViewModelFactory() {}

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull final Class<T> modelClass) {
        final Provider<ViewModel> provider = providersMap.get(modelClass);
        if (provider == null) {
            throw new IllegalArgumentException("ViewModel " + modelClass + " is not found");
        }
        return (T) provider.get();
    }
}
