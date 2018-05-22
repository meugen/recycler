package recycler.meugeninua.recycler.model.data.mccmnc;

import recycler.meugeninua.recycler.model.entities.MccMncEntity;

public class MccMncEntityItem extends MccMncBaseItem {

    public final MccMncEntity entity;

    public MccMncEntityItem(final MccMncEntity entity) {
        super(ENTITY);
        this.entity = entity;
    }
}
