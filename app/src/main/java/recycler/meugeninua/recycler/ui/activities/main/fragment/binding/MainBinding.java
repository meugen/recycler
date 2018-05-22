package recycler.meugeninua.recycler.ui.activities.main.fragment.binding;

import java.util.List;

import recycler.meugeninua.recycler.model.data.mccmnc.MccMncBaseItem;
import recycler.meugeninua.recycler.model.entities.MccMncEntity;
import recycler.meugeninua.recycler.ui.activities.base.binding.Binding;

/**
 * @author meugen
 */
public interface MainBinding extends Binding {

    void setup();

    void showProgressBar();

    void showEntities(List<MccMncBaseItem> entities);

    void showError(Throwable t);
}
