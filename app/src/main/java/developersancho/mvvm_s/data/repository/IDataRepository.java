package developersancho.mvvm_s.data.repository;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

import developersancho.mvvm_s.data.remote.api.model.ParkResponse;

public interface IDataRepository {

    MutableLiveData<List<ParkResponse>> getAllParks();
    void clearCompositeDisposable();
}
