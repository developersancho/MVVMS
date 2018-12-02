package developersancho.mvvm_s.data.repository;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

import javax.inject.Inject;

import developersancho.mvvm_s.data.remote.api.ApiHelper;
import developersancho.mvvm_s.data.remote.api.IApiHelper;
import developersancho.mvvm_s.data.remote.api.model.ParkResponse;
import developersancho.mvvm_s.data.remote.api.model.ParkResult;
import developersancho.mvvm_s.utils.AppConstant;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class DataRepository implements IDataRepository {
    private CompositeDisposable mCompositeDisposable;
    private IApiHelper mApiHelper;
    private MutableLiveData<List<ParkResponse>> allParks;

    /*public DataRepository() {
        mApiHelper = new ApiHelper();
        mCompositeDisposable = new CompositeDisposable();
        allParks = new MutableLiveData<>();
    }*/

    @Inject
    public DataRepository(CompositeDisposable mCompositeDisposable, IApiHelper mApiHelper) {
        this.mCompositeDisposable = mCompositeDisposable;
        this.mApiHelper = mApiHelper;
        allParks = new MutableLiveData<>();
    }

    /*private CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }

    private ApiHelper getApiHelper() {
        return mApiHelper;
    }*/

    @Override
    public MutableLiveData<List<ParkResponse>> getAllParks() {
        String distance = "1000";
        String apikey = AppConstant.APIKEY;
        String lat = "41.094352";
        String lng = "29.094222";

        mCompositeDisposable.add(
                mApiHelper.getParkService().getParkList(distance, lat, lng, apikey)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<List<ParkResult>>() {
                            @Override
                            public void accept(List<ParkResult> parkResults) throws Exception {
                                if (parkResults.size() > 0) {
                                    if (parkResults.get(0).getStatus().equals("OK")) {
                                        allParks.setValue(parkResults.get(0).getResults());
                                    }
                                }
                            }
                        })
        );

        return allParks;
    }

    @Override
    public void clearCompositeDisposable() {
        mCompositeDisposable.clear();
    }


}
