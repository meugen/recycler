package recycler.meugeninua.recycler.app.di;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import recycler.meugeninua.recycler.app.RecyclerApp;
import recycler.meugeninua.recycler.app.di.modules.AppModule;
import recycler.meugeninua.recycler.app.di.modules.ContributorsModule;
import recycler.meugeninua.recycler.app.di.scopes.PerApplication;

/**
 * @author meugen
 */
@Component(modules = {AppModule.class, AndroidInjectionModule.class,
        ContributorsModule.class})
@PerApplication
public interface AppComponent extends AndroidInjector<RecyclerApp> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<RecyclerApp> {}
}
