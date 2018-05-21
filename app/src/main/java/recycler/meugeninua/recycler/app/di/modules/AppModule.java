package recycler.meugeninua.recycler.app.di.modules;

import android.content.Context;

import dagger.Binds;
import dagger.Module;
import recycler.meugeninua.recycler.app.RecyclerApp;
import recycler.meugeninua.recycler.app.di.qualifiers.AppContext;
import recycler.meugeninua.recycler.app.di.scopes.PerApplication;

/**
 * @author meugen
 */
@Module
public abstract class AppModule {

    @Binds @AppContext @PerApplication
    abstract Context bindAppContext(final RecyclerApp app);
}
