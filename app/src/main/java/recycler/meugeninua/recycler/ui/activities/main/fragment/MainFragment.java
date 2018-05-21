package recycler.meugeninua.recycler.ui.activities.main.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.math.BigInteger;
import java.util.Random;

import recycler.meugeninua.recycler.R;
import recycler.meugeninua.recycler.ui.activities.base.fragment.BaseFragment;
import recycler.meugeninua.recycler.ui.activities.main.fragment.binding.MainBinding;

/**
 * @author meugen
 */
public class MainFragment extends BaseFragment<MainBinding> {

    private static final Random RANDOM = new Random();

    @Nullable
    @Override
    public View onCreateView(
            @NonNull final LayoutInflater inflater,
            @Nullable final ViewGroup container,
            @Nullable final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main,
                container, false);
    }

    @Override
    public void onActivityCreated(@Nullable final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        binding.setMessage(new BigInteger(200, RANDOM).toString(26));
    }
}
