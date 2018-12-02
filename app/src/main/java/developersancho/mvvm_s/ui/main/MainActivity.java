package developersancho.mvvm_s.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import developersancho.mvvm_s.DaggerApplication;
import developersancho.mvvm_s.R;
import developersancho.mvvm_s.data.remote.api.model.ParkResponse;
import developersancho.mvvm_s.data.repository.IDataRepository;

public class MainActivity extends AppCompatActivity {

    @Inject
    IDataRepository dataRepository;
    private MainViewModel viewModel;
    private RecyclerView recyclerView;
    private MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((DaggerApplication) getApplication()).getDaggerComponent().inject(this);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        mainAdapter = new MainAdapter();
        recyclerView.setAdapter(mainAdapter);

        viewModel = new MainViewModel(dataRepository);
        viewModel.getAllParks().observe(this, new Observer<List<ParkResponse>>() {
            @Override
            public void onChanged(List<ParkResponse> parkResponses) {
                mainAdapter.setParks(parkResponses);
            }
        });

        mainAdapter.setOnItemClickListener(parkResponse ->
                Toast.makeText(getApplicationContext(), parkResponse.getVicinity(), Toast.LENGTH_LONG).show());


    }

    @Override
    protected void onStop() {
        // clear clearCompositeDisposable
        viewModel.clearCompositeDisposable();
        super.onStop();
    }
}
