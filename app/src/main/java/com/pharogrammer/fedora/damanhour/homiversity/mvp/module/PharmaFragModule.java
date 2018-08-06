package com.pharogrammer.fedora.damanhour.homiversity.mvp.module;

import com.pharogrammer.fedora.damanhour.homiversity.http.api.LecturesApiService;
import com.pharogrammer.fedora.damanhour.homiversity.mvp.model.PharmaFragModel;
import com.pharogrammer.fedora.damanhour.homiversity.mvp.mvp.FragmentMVP;
import com.pharogrammer.fedora.damanhour.homiversity.mvp.presenter.PharmaFragPresenter;
import com.pharogrammer.fedora.damanhour.homiversity.mvp.repository.Repository;
import com.pharogrammer.fedora.damanhour.homiversity.mvp.repository.Third2Repository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by fedora on 14/02/18.
 */

@Module
public class PharmaFragModule {

    @Provides
    public FragmentMVP.PharmaPresenter providePharmaPresenter(FragmentMVP.PharmaModel model){
        return new PharmaFragPresenter(model);
    }

    @Provides
    public FragmentMVP.PharmaModel providePharmaModel(Repository repository){
        return new PharmaFragModel(repository);
    }

    @Provides
    public Repository provideRepository(LecturesApiService lecturesApiService){
        return new Third2Repository(lecturesApiService);
    }

}
