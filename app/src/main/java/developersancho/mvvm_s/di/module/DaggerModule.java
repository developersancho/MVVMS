package developersancho.mvvm_s.di.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import androidx.lifecycle.ViewModelProviders;
import dagger.Module;
import dagger.Provides;
import developersancho.mvvm_s.data.remote.api.ApiHelper;
import developersancho.mvvm_s.data.remote.api.IApiHelper;
import developersancho.mvvm_s.data.repository.DataRepository;
import developersancho.mvvm_s.data.repository.IDataRepository;
import developersancho.mvvm_s.ui.main.IMainNavigator;
import developersancho.mvvm_s.ui.main.MainViewModel;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class DaggerModule {

    private Context context;

    public DaggerModule(Application app) {
        this.context = app;
    }

    @Provides
    Context providesContext() {
        return context;
    }

    @Provides
    @Singleton
    IApiHelper provideApiHelper() {
        return new ApiHelper();
    }

    @Provides
    @Singleton
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    @Singleton
    IDataRepository provideDataRepository(CompositeDisposable compositeDisposable, IApiHelper apiHelper) {
        return new DataRepository(compositeDisposable, apiHelper);
    }

    /*@Provides
    @Singleton
    IMainNavigator provideMainViewModel(IDataRepository repository) {
        return new MainViewModel(repository);
    }*/

}
