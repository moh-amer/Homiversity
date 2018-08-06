package com.pharogrammer.fedora.damanhour.homiversity.mvp.module;

import com.pharogrammer.fedora.damanhour.homiversity.mvp.mvp.ContainerMVP;
import com.pharogrammer.fedora.damanhour.homiversity.mvp.presenter.ContainerPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by fedora on 14/02/18.
 */

@Module
@Singleton
public class ContainerModule {

    @Provides
    public ContainerMVP.Presenter providePresenter(){
        return new ContainerPresenter();
    }
}
