package com.pharogrammer.fedora.damanhour.homiversity.mvp.module;

import com.pharogrammer.fedora.damanhour.homiversity.http.api.LecturesApiService;
import com.pharogrammer.fedora.damanhour.homiversity.mvp.model.OthersFragModel;
import com.pharogrammer.fedora.damanhour.homiversity.mvp.mvp.FragmentMVP;
import com.pharogrammer.fedora.damanhour.homiversity.mvp.presenter.OthersFragPresenter;
import com.pharogrammer.fedora.damanhour.homiversity.mvp.repository.Repository;
import com.pharogrammer.fedora.damanhour.homiversity.mvp.repository.Third2Repository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by fedora on 15/02/18.
 */

@Module
public class OthersFragModule {

    @Provides
    public FragmentMVP.OthersPresenter providePharmaPresenter(FragmentMVP.OthersModel model){
        return new OthersFragPresenter(model);
    }

    @Provides
    public FragmentMVP.OthersModel providePharmaModel(Repository repository){
        return new OthersFragModel(repository);
    }

}
