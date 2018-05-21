package recycler.meugeninua.recycler.ui.activities.base;

import android.content.Context;

import dagger.Binds;
import dagger.Module;
import recycler.meugeninua.recycler.app.di.qualifiers.ActivityContext;
import recycler.meugeninua.recycler.app.di.scopes.PerActivity;

/**
 * @author meugen
 */
@Module
public abstract class BaseActivityModule {

    @Binds @ActivityContext @PerActivity
    abstract Context bindActivityContext(final BaseActivity activity);
}
