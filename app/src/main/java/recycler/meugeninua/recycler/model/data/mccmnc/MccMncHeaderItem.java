package recycler.meugeninua.recycler.model.data.mccmnc;

public class MccMncHeaderItem extends MccMncBaseItem {

    public final String country;

    public MccMncHeaderItem(final String country) {
        super(HEADER);
        this.country = country;
    }
}
