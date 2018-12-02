package developersancho.mvvm_s.data.remote.api;

import developersancho.mvvm_s.data.remote.api.retrofit.IParkService;
import developersancho.mvvm_s.data.remote.api.retrofit.ParkClient;
import developersancho.mvvm_s.utils.AppConstant;

public class ApiHelper implements IApiHelper {


    @Override
    public IParkService getParkService() {
        return ParkClient.getClient(AppConstant.BASEURL).create(IParkService.class);
    }
}
