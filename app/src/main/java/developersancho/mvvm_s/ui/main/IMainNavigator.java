package developersancho.mvvm_s.ui.main;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

import developersancho.mvvm_s.data.remote.api.model.ParkResponse;

public interface IMainNavigator {

    MutableLiveData<List<ParkResponse>> getAllParks();

    void clearCompositeDisposable();
}
