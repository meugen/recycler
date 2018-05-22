package recycler.meugeninua.recycler.ui.activities.main;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;
import recycler.meugeninua.recycler.app.di.scopes.PerActivity;
import recycler.meugeninua.recycler.app.di.scopes.PerFragment;
import recycler.meugeninua.recycler.ui.activities.base.BaseActivity;
import recycler.meugeninua.recycler.ui.activities.base.BaseActivityModule;
import recycler.meugeninua.recycler.ui.activities.main.fragment.MainFragment;
import recycler.meugeninua.recycler.ui.activities.main.fragment.MainFragmentModule;
import recycler.meugeninua.recycler.ui.activities.main.vm.MainViewModel;

/**
 * @author meugen
 */
@Module(includes = BaseActivityModule.class)
public abstract class MainActivityModule {

    @Binds @PerActivity
    abstract BaseActivity bindBaseActivity(final MainActivity activity);

    @Provides @PerActivity
    static MainViewModel provideMainViewModel(
            final MainActivity activity,
            final ViewModelProvider.Factory factory) {
        return ViewModelProviders.of(activity, factory)
                .get(MainViewModel.class);
    }

    @ContributesAndroidInjector(modules = MainFragmentModule.class)
    @PerFragment
    abstract MainFragment contributeMainFragment();
}
