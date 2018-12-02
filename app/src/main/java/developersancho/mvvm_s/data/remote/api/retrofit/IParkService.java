package developersancho.mvvm_s.data.remote.api.retrofit;

import java.util.List;

import developersancho.mvvm_s.data.remote.api.model.ParkResult;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IParkService {

    @GET("place/dist?")
    Observable<List<ParkResult>> getParkList(@Query("distance") String distance,
                                                  @Query("lat") String lat,
                                                  @Query("lng") String lng,
                                                  @Query("api_key") String api_key);

}
