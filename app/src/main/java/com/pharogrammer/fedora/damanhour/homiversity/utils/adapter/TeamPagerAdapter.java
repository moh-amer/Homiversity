package com.pharogrammer.fedora.damanhour.homiversity.utils.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by fedora on 14/02/18.
 */

public class TeamPagerAdapter extends FragmentPagerAdapter {

    List<FragModel> fragmentList;
    public TeamPagerAdapter(FragmentManager fm , List<FragModel> fragments) {
        super(fm);
        this.fragmentList = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentList.get(position).getTitle();
    }
}
