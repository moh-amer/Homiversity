package com.pharogrammer.fedora.damanhour.homiversity.utils.adapter;

import android.support.v4.app.Fragment;

/**
 * Created by fedora on 14/02/18.
 */

public class FragModel {

    private Fragment fragment;
    private String title;

    public FragModel(Fragment fragment, String title) {
        this.fragment = fragment;
        this.title = title;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
