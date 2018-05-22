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
import recycler.meugeninua.recycler.model.entities.MccMncEntity;

/**
 * @author meugen
 */
@PerFragment
public class MccMncAdapter extends RecyclerView.Adapter<MccMncAdapter.MccMncHolder> {

    private final LayoutInflater inflater;

    private List<MccMncEntity> entities;

    @Inject
    MccMncAdapter(
            @ActivityContext final Context context) {
        this.inflater = LayoutInflater.from(context);
        this.entities = Collections.emptyList();
    }

    public void swapEntities(final List<MccMncEntity> entities) {
        this.entities = entities;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MccMncHolder onCreateViewHolder(
            @NonNull final ViewGroup parent,
            final int viewType) {
        final View view = inflater.inflate(
                R.layout.item_mccmnc, parent, false);
        return new MccMncHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MccMncHolder holder, final int position) {
        holder.bind(entities.get(position));
    }

    @Override
    public int getItemCount() {
        return entities.size();
    }

    class MccMncHolder extends RecyclerView.ViewHolder {

        private final TextView operator;
        private final TextView country;

        MccMncHolder(final View itemView) {
            super(itemView);
            this.operator = itemView.findViewById(R.id.operator);
            this.country = itemView.findViewById(R.id.country);
        }

        public void bind(final MccMncEntity entity) {
            operator.setText(entity.operator);
            country.setText(entity.countryName);
        }
    }
}
