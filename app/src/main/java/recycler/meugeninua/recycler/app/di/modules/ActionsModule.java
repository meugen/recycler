package recycler.meugeninua.recycler.app.di.modules;

import java.util.List;

import dagger.Binds;
import dagger.Module;
import recycler.meugeninua.recycler.app.di.scopes.PerApplication;
import recycler.meugeninua.recycler.model.actions.AppActionApi;
import recycler.meugeninua.recycler.model.actions.mccmnc.MccMncActionApi;
import recycler.meugeninua.recycler.model.entities.MccMncEntity;

/**
 * @author meugen
 */
@Module
public abstract class ActionsModule {

    @Binds @PerApplication
    abstract AppActionApi<Void, List<MccMncEntity>> bindMccMncActionApi(
            final MccMncActionApi api);
}
