package recycler.meugeninua.recycler.model.db.dao;

import java.util.Collection;
import java.util.List;

import recycler.meugeninua.recycler.model.entities.MccMncEntity;

/**
 * @author meugen
 */
public interface MccMncDao {

    void insert(Collection<MccMncEntity> entities);

    int count();

    List<MccMncEntity> all();
}
