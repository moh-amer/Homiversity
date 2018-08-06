package com.pharogrammer.fedora.damanhour.homiversity.root;

import android.app.Application;

import com.pharogrammer.fedora.damanhour.homiversity.http.module.LecturesServiceModule;
import com.pharogrammer.fedora.damanhour.homiversity.mvp.module.AbcFragModule;
import com.pharogrammer.fedora.damanhour.homiversity.mvp.module.ContainerModule;
import com.pharogrammer.fedora.damanhour.homiversity.mvp.module.MainModule;
import com.pharogrammer.fedora.damanhour.homiversity.mvp.module.MatRecFragModule;
import com.pharogrammer.fedora.damanhour.homiversity.mvp.module.OthersFragModule;
import com.pharogrammer.fedora.damanhour.homiversity.mvp.module.PharmaFragModule;

/**
 * Created by fedora on 13/02/18.
 */

public class App extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .mainModule(new MainModule(this))
                .containerModule(new ContainerModule())
                .lecturesServiceModule(new LecturesServiceModule())
                .pharmaFragModule(new PharmaFragModule())
                .abcFragModule(new AbcFragModule())
                .othersFragModule(new OthersFragModule())
                .matRecFragModule(new MatRecFragModule())
                .build();
    }

    public ApplicationComponent getComponent(){
        return component;
    }
}
