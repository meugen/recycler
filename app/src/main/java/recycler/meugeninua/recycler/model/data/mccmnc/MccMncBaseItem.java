package recycler.meugeninua.recycler.model.data.mccmnc;

import android.support.annotation.IntDef;

public class MccMncBaseItem {

    @IntDef({HEADER,ENTITY})
    public @interface Type {}
    public static final int HEADER = 1;
    public static final int ENTITY = 2;

    public final int type;

    public MccMncBaseItem(@Type final int type) {
        this.type = type;
    }
}
