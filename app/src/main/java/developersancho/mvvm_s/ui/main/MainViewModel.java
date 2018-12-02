package developersancho.mvvm_s.ui.main;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import androidx.lifecycle.ViewModel;
import developersancho.mvvm_s.data.remote.api.model.ParkResponse;
import developersancho.mvvm_s.data.repository.DataRepository;
import developersancho.mvvm_s.data.repository.IDataRepository;

@Singleton
public class MainViewModel extends ViewModel implements IMainNavigator {

    private IDataRepository mDataRepository;

    @Inject
    public MainViewModel(IDataRepository mDataRepository) {
        this.mDataRepository = mDataRepository;
    }

    @Override
    public MutableLiveData<List<ParkResponse>> getAllParks() {
        return mDataRepository.getAllParks();
    }

    @Override
    public void clearCompositeDisposable() {
        mDataRepository.clearCompositeDisposable();
    }


}
