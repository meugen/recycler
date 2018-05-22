package recycler.meugeninua.recycler.app.di.keys;

import android.arch.lifecycle.ViewModel;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import dagger.MapKey;

/**
 * @author meugen
 */
@MapKey
@Retention(RetentionPolicy.SOURCE)
public @interface ViewModelKey {

    Class<? extends ViewModel> value();
}
