package recycler.meugeninua.recycler.ui.activities.main;

import android.os.Bundle;

import recycler.meugeninua.recycler.R;
import recycler.meugeninua.recycler.app.services.mccmncstore.MccMncStoreService;
import recycler.meugeninua.recycler.ui.activities.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MccMncStoreService.enqueueWork(this);
    }
}
