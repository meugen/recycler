package recycler.meugeninua.recycler.ui.activities.main;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import recycler.meugeninua.recycler.app.di.scopes.PerActivity;
import recycler.meugeninua.recycler.app.di.scopes.PerFragment;
import recycler.meugeninua.recycler.ui.activities.base.BaseActivity;
import recycler.meugeninua.recycler.ui.activities.base.BaseActivityModule;
import recycler.meugeninua.recycler.ui.activities.main.fragment.MainFragment;
import recycler.meugeninua.recycler.ui.activities.main.fragment.MainFragmentModule;

/**
 * @author meugen
 */
@Module(includes = BaseActivityModule.class)
public abstract class MainActivityModule {

    @Binds @PerActivity
    abstract BaseActivity bindBaseActivity(final MainActivity activity);

    @ContributesAndroidInjector(modules = MainFragmentModule.class)
    @PerFragment
    abstract MainFragment contributeMainFragment();
}
