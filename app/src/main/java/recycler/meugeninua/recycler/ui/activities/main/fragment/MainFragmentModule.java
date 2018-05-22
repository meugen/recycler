package recycler.meugeninua.recycler.ui.activities.main.fragment;

import android.support.v4.app.Fragment;

import dagger.Binds;
import dagger.Module;
import recycler.meugeninua.recycler.app.di.scopes.PerFragment;
import recycler.meugeninua.recycler.ui.activities.base.fragment.BaseFragmentModule;
import recycler.meugeninua.recycler.ui.activities.main.fragment.binding.MainBinding;
import recycler.meugeninua.recycler.ui.activities.main.fragment.binding.MainBindingImpl;

/**
 * @author meugen
 */
@Module(includes = BaseFragmentModule.class)
public abstract class MainFragmentModule {

    @Binds @PerFragment
    abstract Fragment bindFragment(final MainFragment fragment);

    @Binds @PerFragment
    abstract MainBinding bindBinding(final MainBindingImpl impl);
}
