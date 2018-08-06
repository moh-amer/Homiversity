package com.pharogrammer.fedora.damanhour.homiversity.mvp.module;

import com.pharogrammer.fedora.damanhour.homiversity.mvp.model.AbcFragModel;
import com.pharogrammer.fedora.damanhour.homiversity.mvp.mvp.FragmentMVP;
import com.pharogrammer.fedora.damanhour.homiversity.mvp.presenter.AbcFragPresenter;
import com.pharogrammer.fedora.damanhour.homiversity.mvp.repository.Repository;


import dagger.Module;
import dagger.Provides;

/**
 * Created by fedora on 15/02/18.
 */

@Module
public class AbcFragModule {

    @Provides
    FragmentMVP.AbcPresenter provideAbcFragPresenter(FragmentMVP.AbcModel model){
        return new AbcFragPresenter(model);
    }

    @Provides
    FragmentMVP.AbcModel provideAbcFragModel(Repository repository){
        return new AbcFragModel(repository);
    }


}
