package com.pharogrammer.fedora.damanhour.homiversity.mvp.module;

import android.content.Context;

import com.pharogrammer.fedora.damanhour.homiversity.mvp.mvp.MainMVP;
import com.pharogrammer.fedora.damanhour.homiversity.mvp.presenter.MainPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by fedora on 13/02/18.
 */

@Module
@Singleton
public class MainModule {

    private Context context;

    public MainModule(Context context) {
        this.context = context;
    }

    @Provides
    public MainMVP.Presenter providePresenter(){
        return new MainPresenter(context);
    }

}
