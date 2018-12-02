package developersancho.mvvm_s.di.component;

import javax.inject.Singleton;

import dagger.Component;
import developersancho.mvvm_s.di.module.DaggerModule;
import developersancho.mvvm_s.ui.main.MainActivity;

@Singleton
@Component(modules = {DaggerModule.class})
public interface DaggerComponent {
    void inject(MainActivity activity);
}
