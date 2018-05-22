package recycler.meugeninua.recycler.ui.activities.main.fragment.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import recycler.meugeninua.recycler.R;
import recycler.meugeninua.recycler.app.di.qualifiers.ActivityContext;
import recycler.meugeninua.recycler.app.di.scopes.PerFragment;
import recycler.meugeninua.recycler.model.data.mccmnc.MccMncBaseItem;
import recycler.meugeninua.recycler.model.data.mccmnc.MccMncEntityItem;
import recycler.meugeninua.recycler.model.data.mccmnc.MccMncHeaderItem;
import recycler.meugeninua.recycler.model.entities.MccMncEntity;

/**
 * @author meugen
 */
@PerFragment
public class MccMncAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final LayoutInflater inflater;

    private List<MccMncBaseItem> items;

    @Inject
    MccMncAdapter(
            @ActivityContext final Context context) {
        this.inflater = LayoutInflater.from(context);
        this.items = Collections.emptyList();
    }

    @Override
    public int getItemViewType(final int position) {
        return items.get(position).type;
    }

    public void swapEntities(final List<MccMncBaseItem> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(
            @NonNull final ViewGroup parent,
            final int viewType) {
        if (viewType == MccMncBaseItem.ENTITY) {
            final View view = inflater.inflate(
                    R.layout.item_mccmnc_entity,
                    parent, false);
            return new MccMncEntityHolder(view);
        } else if (viewType == MccMncBaseItem.HEADER) {
            final View view = inflater.inflate(
                    R.layout.item_mccmnc_header,
                    parent, false);
            return new MccMncHeaderHolder(view);
        }
        throw new IllegalArgumentException("Unknown view type " + viewType);
    }

    @Override
    public void onBindViewHolder(
            @NonNull final RecyclerView.ViewHolder holder,
            final int position) {
        if (holder instanceof MccMncEntityHolder) {
            final MccMncEntity entity = ((MccMncEntityItem) items.get(position)).entity;
            ((MccMncEntityHolder) holder).bind(entity);
        } else if (holder instanceof MccMncHeaderHolder) {
            final String country = ((MccMncHeaderItem) items.get(position)).country;
            ((MccMncHeaderHolder) holder).country.setText(country);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class MccMncEntityHolder extends RecyclerView.ViewHolder {

        private final TextView operator;

        MccMncEntityHolder(final View itemView) {
            super(itemView);
            this.operator = itemView.findViewById(R.id.operator);
        }

        void bind(final MccMncEntity entity) {
            operator.setText(entity.operator);
        }
    }

    static class MccMncHeaderHolder extends RecyclerView.ViewHolder {

        public final TextView country;

        public MccMncHeaderHolder(final View itemView) {
            super(itemView);
            this.country = itemView.findViewById(R.id.country);
        }
    }
}
