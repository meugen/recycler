package recycler.meugeninua.recycler.model.entities;

import android.text.TextUtils;

/**
 * @author meugen
 */
public class MccMncEntity {

    public String type;
    public String countryName;
    public String countryCode;
    public String mcc;
    public String mnc;
    public String brand;
    public String operator;
    public String status;
    public String bands;
    public String notes;

    public boolean isValid() {
        final boolean atLeastOneEmpty = TextUtils.isEmpty(type)
                || TextUtils.isEmpty(countryName) || TextUtils.isEmpty(countryCode)
                || TextUtils.isEmpty(mcc) || TextUtils.isEmpty(mnc)
                || TextUtils.isEmpty(brand) || TextUtils.isEmpty(operator)
                || TextUtils.isEmpty(status) || TextUtils.isEmpty(bands)
                || TextUtils.isEmpty(notes);
        return !atLeastOneEmpty;
    }
}
