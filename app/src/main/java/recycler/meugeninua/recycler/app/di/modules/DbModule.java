package recycler.meugeninua.recycler.app.di.modules;

import android.database.sqlite.SQLiteOpenHelper;

import dagger.Binds;
import dagger.Module;
import recycler.meugeninua.recycler.app.di.scopes.PerApplication;
import recycler.meugeninua.recycler.model.db.DbOpenHelper;
import recycler.meugeninua.recycler.model.db.dao.MccMncDao;
import recycler.meugeninua.recycler.model.db.dao.impls.MccMncDaoImpl;
import recycler.meugeninua.recycler.model.db.mappings.EntityMapping;
import recycler.meugeninua.recycler.model.db.mappings.impls.MccMncMapping;
import recycler.meugeninua.recycler.model.entities.MccMncEntity;

/**
 * @author meugen
 */
@Module
public abstract class DbModule {

    @Binds @PerApplication
    abstract SQLiteOpenHelper bindOpenHelper(final DbOpenHelper helper);

    @Binds @PerApplication
    abstract EntityMapping<MccMncEntity> bindMccMncMapping(final MccMncMapping mapping);

    @Binds @PerApplication
    abstract MccMncDao bindMccMncDao(final MccMncDaoImpl impl);
}
