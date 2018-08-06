package com.pharogrammer.fedora.damanhour.homiversity.root;

import com.pharogrammer.fedora.damanhour.homiversity.http.module.LecturesServiceModule;
import com.pharogrammer.fedora.damanhour.homiversity.mvp.module.AbcFragModule;
import com.pharogrammer.fedora.damanhour.homiversity.mvp.module.ContainerModule;
import com.pharogrammer.fedora.damanhour.homiversity.mvp.module.MainModule;
import com.pharogrammer.fedora.damanhour.homiversity.mvp.module.MatRecFragModule;
import com.pharogrammer.fedora.damanhour.homiversity.mvp.module.OthersFragModule;
import com.pharogrammer.fedora.damanhour.homiversity.mvp.module.PharmaFragModule;
import com.pharogrammer.fedora.damanhour.homiversity.mvp.view.activity.ContainerActivity;
import com.pharogrammer.fedora.damanhour.homiversity.mvp.view.activity.MainActivity;
import com.pharogrammer.fedora.damanhour.homiversity.mvp.view.fragment.AbcFragment;
import com.pharogrammer.fedora.damanhour.homiversity.mvp.view.fragment.MatRecFragment;
import com.pharogrammer.fedora.damanhour.homiversity.mvp.view.fragment.OthersFragment;
import com.pharogrammer.fedora.damanhour.homiversity.mvp.view.fragment.PharmaFragment;

import dagger.Component;

/**
 * Created by fedora on 13/02/18.
 */

@Component(modules = {ApplicationModule.class, MainModule.class, ContainerModule.class,
        PharmaFragModule.class, LecturesServiceModule.class, AbcFragModule.class,
        OthersFragModule.class, MatRecFragModule.class
})
public interface ApplicationComponent {

    void inject(MainActivity target);
    void inject(ContainerActivity target);

    void inject(PharmaFragment target);
    void inject(AbcFragment target);
    void inject(OthersFragment target);
    void inject(MatRecFragment target);

}
