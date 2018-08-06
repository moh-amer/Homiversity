package com.pharogrammer.fedora.damanhour.homiversity.mvp.presenter;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.pharogrammer.fedora.damanhour.homiversity.mvp.mvp.ContainerMVP;
import com.pharogrammer.fedora.damanhour.homiversity.mvp.view.fragment.AbcFragment;
import com.pharogrammer.fedora.damanhour.homiversity.mvp.view.fragment.MatRecFragment;
import com.pharogrammer.fedora.damanhour.homiversity.mvp.view.fragment.OthersFragment;
import com.pharogrammer.fedora.damanhour.homiversity.mvp.view.fragment.PharmaFragment;
import com.pharogrammer.fedora.damanhour.homiversity.utils.adapter.FragModel;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by fedora on 14/02/18.
 */

public class ContainerPresenter implements ContainerMVP.Presenter {
    private ContainerMVP.View view;
    private Subscription subscription;

    @Override
    public void setView(ContainerMVP.View view) {
        this.view = view;
    }

    @Override
    public void provideTeamsPagerFragments(int key) {

        Bundle bundle = new Bundle();
        bundle.putInt("KEY",key);

        PharmaFragment pharmaFragment = new PharmaFragment();
        pharmaFragment.setArguments(bundle);

        AbcFragment abcFragment = new AbcFragment();
        pharmaFragment.setArguments(bundle);

        OthersFragment othersFragment = new OthersFragment();
        othersFragment.setArguments(bundle);

        //add Fragments to a the list of fragments
        List<FragModel> fragments = new ArrayList<>();
        fragments.add(new FragModel(pharmaFragment, "Pharma"));
        fragments.add(new FragModel(abcFragment,"ABC"));
        fragments.add(new FragModel(othersFragment,"Others"));

        subscription = Observable.from(fragments).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FragModel>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(FragModel fragModel) {
                        if (view != null)
                            view.addPages(fragModel);
                    }
                });
    }

    @Override
    public Fragment getMatRecFragment(int key) {

        Bundle bundle = new Bundle();
        bundle.putInt("KEY", key);

        MatRecFragment matRecFragment = new MatRecFragment();
        matRecFragment.setArguments(bundle);

        return matRecFragment;
    }

    @Override
    public void unSubscribeRx() {
        if (subscription != null && ! subscription.isUnsubscribed()){
            subscription.unsubscribe();
        }
    }
}
