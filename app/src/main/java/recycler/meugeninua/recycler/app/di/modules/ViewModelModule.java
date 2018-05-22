package recycler.meugeninua.recycler.app.di.modules;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import recycler.meugeninua.recycler.app.di.factories.ViewModelFactory;
import recycler.meugeninua.recycler.app.di.keys.ViewModelKey;
import recycler.meugeninua.recycler.app.di.scopes.PerApplication;
import recycler.meugeninua.recycler.ui.activities.main.fragment.vm.MainViewModel;

/**
 * @author meugen
 */
@Module
public abstract class ViewModelModule {

    @Binds @PerApplication
    abstract ViewModelProvider.Factory bindProviderFactory(final ViewModelFactory factory);

    @Binds @IntoMap @ViewModelKey(MainViewModel.class)
    abstract ViewModel bindMainViewModel(final MainViewModel viewModel);
}
