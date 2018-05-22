package recycler.meugeninua.recycler.ui.activities.main.fragment.binding;

import android.content.Context;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import javax.inject.Inject;

import recycler.meugeninua.recycler.R;
import recycler.meugeninua.recycler.app.di.qualifiers.ActivityContext;
import recycler.meugeninua.recycler.model.data.mccmnc.MccMncBaseItem;
import recycler.meugeninua.recycler.model.entities.MccMncEntity;
import recycler.meugeninua.recycler.ui.activities.base.binding.BaseBinding;
import recycler.meugeninua.recycler.ui.activities.main.fragment.adapters.MccMncAdapter;

/**
 * @author meugen
 */
public class MainBindingImpl extends BaseBinding implements MainBinding {

    @Inject @ActivityContext Context context;
    @Inject MccMncAdapter adapter;

    @Inject
    MainBindingImpl() {}

    @Override
    public void setup() {
        final RecyclerView recycler = get(R.id.recycler);
        if (recycler == null) {
            return;
        }
        final GridLayoutManager layoutManager = new GridLayoutManager(context,
                context.getResources().getInteger(R.integer.mccmnc_total_span_count));
        layoutManager.setSpanSizeLookup(new SpanSizeLookupImpl());
        recycler.setLayoutManager(layoutManager);
        recycler.addItemDecoration(new DividerItemDecoration(
                context, DividerItemDecoration.VERTICAL));
        recycler.setAdapter(adapter);
    }

    @Override
    public void showProgressBar() {
        final ContentLoadingProgressBar progressBar = get(R.id.progress_bar);
        if (progressBar == null) {
            return;
        }
        progressBar.show();
    }

    @Override
    public void showEntities(final List<MccMncBaseItem> entities) {
        final ContentLoadingProgressBar progressBar = get(R.id.progress_bar);
        if (progressBar == null) {
            return;
        }
        progressBar.hide();
        adapter.swapEntities(entities);
    }

    @Override
    public void showError(final Throwable t) {
        final ContentLoadingProgressBar progressBar = get(R.id.progress_bar);
        final TextView error = get(R.id.error);
        if (progressBar == null || error == null) {
            return;
        }
        error.setVisibility(View.VISIBLE);
        progressBar.hide();
        error.setText(t.getLocalizedMessage());
    }

    private class SpanSizeLookupImpl extends GridLayoutManager.SpanSizeLookup {

        @Override
        public int getSpanSize(final int position) {
            final int viewType = adapter.getItemViewType(position);
            if (viewType == MccMncBaseItem.HEADER) {
                return context.getResources().getInteger(R.integer.mccmnc_header_span_count);
            } else if (viewType == MccMncBaseItem.ENTITY) {
                return context.getResources().getInteger(R.integer.mccmnc_entity_span_count);
            }
            return 0;
        }
    }
}
