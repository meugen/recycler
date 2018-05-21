package recycler.meugeninua.recycler.app.di.modules;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import recycler.meugeninua.recycler.app.di.scopes.PerActivity;
import recycler.meugeninua.recycler.ui.activities.main.MainActivity;
import recycler.meugeninua.recycler.ui.activities.main.MainActivityModule;

/**
 * @author meugen
 */
@Module
public abstract class ContributorsModule {

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    @PerActivity
    abstract MainActivity contributeMainActivity();
}
