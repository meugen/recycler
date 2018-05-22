package recycler.meugeninua.recycler.ui.activities.main.fragment;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.Fragment;

import java.util.List;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import recycler.meugeninua.recycler.app.di.scopes.PerFragment;
import recycler.meugeninua.recycler.model.actions.AppActionApi;
import recycler.meugeninua.recycler.model.actions.mccmnc.MccMncActionApi;
import recycler.meugeninua.recycler.model.entities.MccMncEntity;
import recycler.meugeninua.recycler.ui.activities.base.fragment.BaseFragmentModule;
import recycler.meugeninua.recycler.ui.activities.main.fragment.binding.MainBinding;
import recycler.meugeninua.recycler.ui.activities.main.fragment.binding.MainBindingImpl;
import recycler.meugeninua.recycler.ui.activities.main.fragment.vm.MainViewModel;

/**
 * @author meugen
 */
@Module(includes = BaseFragmentModule.class)
public abstract class MainFragmentModule {

    @Binds @PerFragment
    abstract Fragment bindFragment(final MainFragment fragment);

    @Binds @PerFragment
    abstract MainBinding bindBinding(final MainBindingImpl impl);

    @Provides @PerFragment
    static MainViewModel provideMainViewModel(
            final Fragment fragment,
            final ViewModelProvider.Factory factory) {
        return ViewModelProviders.of(fragment, factory)
                .get(MainViewModel.class);
    }
}
