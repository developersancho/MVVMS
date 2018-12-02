package developersancho.mvvm_s.data.remote.api;

import developersancho.mvvm_s.data.remote.api.retrofit.IParkService;

// Facade Pattern
public interface IApiHelper {
    IParkService getParkService();
}
