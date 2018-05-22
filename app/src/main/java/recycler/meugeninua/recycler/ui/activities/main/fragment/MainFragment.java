package recycler.meugeninua.recycler.ui.activities.main.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

import recycler.meugeninua.recycler.R;
import recycler.meugeninua.recycler.model.entities.MccMncEntity;
import recycler.meugeninua.recycler.model.resources.Resource;
import recycler.meugeninua.recycler.ui.activities.base.fragment.BaseFragment;
import recycler.meugeninua.recycler.ui.activities.main.fragment.binding.MainBinding;
import recycler.meugeninua.recycler.ui.activities.main.fragment.vm.MainViewModel;

/**
 * @author meugen
 */
public class MainFragment extends BaseFragment<MainBinding> {

    private static final String TAG = MainFragment.class.getSimpleName();

    @Inject MainViewModel viewModel;

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
        viewModel.mccMncLiveData.observe(this, this::onMccMncResource);
        if (savedInstanceState == null) {
            viewModel.loadMccMnc();
        }
        binding.setup();
    }

    private void onMccMncResource(final Resource<List<MccMncEntity>> resource) {
        if (resource.status == Resource.LOADING) {
            binding.showProgressBar();
        } else if (resource.status == Resource.SUCCESS) {
            binding.showEntities(resource.result);
        } else if (resource.status == Resource.ERROR) {
            binding.showError(resource.error);
        }
    }
}
