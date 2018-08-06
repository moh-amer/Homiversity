package com.pharogrammer.fedora.damanhour.homiversity.mvp.mvp;


import android.content.Intent;

/**
 * Created by fedora on 13/02/18.
 */

public interface MainMVP {

    interface View{

        void controlVisibility(int index);
    }

    interface Presenter{

        void setView(MainMVP.View view);
        void setVisibility(int index);
        Intent getIntent(int key);
        void determineFragment();

    }


    interface Model{

    }
}
