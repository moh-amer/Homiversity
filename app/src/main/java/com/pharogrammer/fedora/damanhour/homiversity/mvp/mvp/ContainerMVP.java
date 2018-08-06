package com.pharogrammer.fedora.damanhour.homiversity.mvp.mvp;

import android.support.v4.app.Fragment;

import com.pharogrammer.fedora.damanhour.homiversity.utils.adapter.FragModel;

import java.util.List;

/**
 * Created by fedora on 14/02/18.
 */

public interface ContainerMVP {

    interface View{
        void addPages(FragModel fragment);
    }

    interface Presenter{
        void setView(ContainerMVP.View view);
        void provideTeamsPagerFragments(int key);
        Fragment getMatRecFragment(int key);
        void unSubscribeRx();
    }

    interface Model{

    }
}
