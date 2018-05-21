package recycler.meugeninua.recycler.model.db.mappings.impls;

import android.content.ContentValues;
import android.database.Cursor;

import javax.inject.Inject;

import recycler.meugeninua.recycler.model.db.mappings.EntityMapping;
import recycler.meugeninua.recycler.model.entities.MccMncEntity;

/**
 * @author meugen
 */
public class MccMncMapping extends BaseMapping implements EntityMapping<MccMncEntity> {

    private static final String FLD_TYPE = "type";
    private static final String FLD_COUNTRY_NAME = "country_name";
    private static final String FLD_COUNTRY_CODE = "country_code";
    private static final String FLD_MCC = "mcc";
    private static final String FLD_MNC = "mnc";
    private static final String FLD_BRAND = "brand";
    private static final String FLD_OPERATOR = "operator";
    private static final String FLD_STATUS = "status";
    private static final String FLD_BANDS = "bands";
    private static final String FLD_NOTES = "notes";

    @Inject
    MccMncMapping() {}

    @Override
    public MccMncEntity cursorToEntity(final Cursor cursor) {
        final MccMncEntity entity = new MccMncEntity();
        entity.type = getStringOrNull(cursor, FLD_TYPE);
        entity.countryName = getStringOrNull(cursor, FLD_COUNTRY_NAME);
        entity.countryCode = getStringOrNull(cursor, FLD_COUNTRY_CODE);
        entity.mcc = getStringOrNull(cursor, FLD_MCC);
        entity.mnc = getStringOrNull(cursor, FLD_MNC);
        entity.brand = getStringOrNull(cursor, FLD_BRAND);
        entity.operator = getStringOrNull(cursor, FLD_OPERATOR);
        entity.status = getStringOrNull(cursor, FLD_STATUS);
        entity.bands = getStringOrNull(cursor, FLD_BANDS);
        entity.notes = getStringOrNull(cursor, FLD_NOTES);
        return entity;
    }

    @Override
    public void entityToValues(final MccMncEntity entity, final ContentValues values) {
        putStringOrNull(FLD_TYPE, entity.type, values);
        putStringOrNull(FLD_COUNTRY_NAME, entity.countryName, values);
        putStringOrNull(FLD_COUNTRY_CODE, entity.countryCode, values);
        putStringOrNull(FLD_MCC, entity.mcc, values);
        putStringOrNull(FLD_MNC, entity.mnc, values);
        putStringOrNull(FLD_BRAND, entity.brand, values);
        putStringOrNull(FLD_OPERATOR, entity.operator, values);
        putStringOrNull(FLD_STATUS, entity.status, values);
        putStringOrNull(FLD_BANDS, entity.bands, values);
        putStringOrNull(FLD_NOTES, entity.notes, values);
    }
}
