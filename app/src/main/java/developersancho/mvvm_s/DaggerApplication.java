package developersancho.mvvm_s;

import android.app.Application;

import dagger.Module;
import developersancho.mvvm_s.di.component.DaggerComponent;
import developersancho.mvvm_s.di.component.DaggerDaggerComponent;
import developersancho.mvvm_s.di.module.DaggerModule;

@Module
public class DaggerApplication extends Application {
    private DaggerComponent daggerComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        daggerComponent = createDaggerComponent();
    }

    public DaggerComponent getDaggerComponent() {
        return daggerComponent == null ? createDaggerComponent() : daggerComponent;
    }


    private DaggerComponent createDaggerComponent() {
        return DaggerDaggerComponent.builder().daggerModule(new DaggerModule(this)).build();
    }

    public void clearComponent() {
        daggerComponent = null;
    }
}
