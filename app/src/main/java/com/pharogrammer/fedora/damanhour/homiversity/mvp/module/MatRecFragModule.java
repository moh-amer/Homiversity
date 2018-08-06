package com.pharogrammer.fedora.damanhour.homiversity.mvp.module;

import com.pharogrammer.fedora.damanhour.homiversity.mvp.model.MatRecFragModel;
import com.pharogrammer.fedora.damanhour.homiversity.mvp.mvp.FragmentMVP;
import com.pharogrammer.fedora.damanhour.homiversity.mvp.presenter.MatRecFragPresenter;
import com.pharogrammer.fedora.damanhour.homiversity.mvp.repository.Repository;

import dagger.Module;
import dagger.Provides;

/**
 * Created by fedora on 16/02/18.
 */

@Module
public class MatRecFragModule {

    @Provides
    public FragmentMVP.MatRecPresenter provideMatRecFragPresenter(MatRecFragModel model){
        return new MatRecFragPresenter(model);
    }

    @Provides
    public MatRecFragModel provideMatRecFragModel(Repository repository){
        return new MatRecFragModel(repository);
    }

}
