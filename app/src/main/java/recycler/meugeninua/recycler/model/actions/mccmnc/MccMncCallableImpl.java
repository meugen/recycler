package recycler.meugeninua.recycler.model.actions.mccmnc;

import java.util.List;
import java.util.concurrent.Callable;

import recycler.meugeninua.recycler.model.db.dao.MccMncDao;
import recycler.meugeninua.recycler.model.entities.MccMncEntity;

/**
 * @author meugen
 */
class MccMncCallableImpl implements Callable<List<MccMncEntity>> {

    private final MccMncDao dao;

    MccMncCallableImpl(final MccMncDao dao) {
        this.dao = dao;
    }

    @Override
    public List<MccMncEntity> call() throws Exception {
        return dao.all();
    }
}
