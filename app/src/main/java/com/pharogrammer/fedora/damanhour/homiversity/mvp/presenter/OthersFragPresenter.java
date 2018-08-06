package com.pharogrammer.fedora.damanhour.homiversity.mvp.presenter;

import com.pharogrammer.fedora.damanhour.homiversity.http.model.Lecture;
import com.pharogrammer.fedora.damanhour.homiversity.mvp.mvp.FragmentMVP;
import com.pharogrammer.fedora.damanhour.homiversity.utils.Constants;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by fedora on 15/02/18.
 */

public class OthersFragPresenter implements FragmentMVP.OthersPresenter {

    private FragmentMVP.OthersView view;
    private FragmentMVP.OthersModel model;
    private Subscription subscription;

    public OthersFragPresenter(FragmentMVP.OthersModel model) {
        this.model = model;
    }

    @Override
    public void setView(FragmentMVP.OthersView view) {
        this.view = view;
    }

    @Override
    public void loadLectures(int key) {

        subscription = getModelDataByCategory(key).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Lecture>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Lecture lecture) {
                        if (view != null){
                            view.setLectureToAdapter(lecture);
                        }
                    }
                });
    }

    @Override
    public void unSubscribeRx() {
        if (subscription != null && !subscription.isUnsubscribed()){
            subscription.unsubscribe();
        }
    }

    private Observable<Lecture> getModelDataByCategory(int key){
        Observable<Lecture> requiredData = null;

        switch(key){
            case Constants.CEUTICAL_THEO:
                requiredData = model.getCeuticalTheoLectures();
                break;
            case Constants.CEUTICAL_THEO_PRACTICAL:
                requiredData =  model.getCeuticalTheoPractLectures();
                break;
            case Constants.BIO_THEO:
                requiredData = model.getBioTheoLectures();
                break;
            case Constants.BIO_THEO_PRACTICAL:
                requiredData = model.getBioTheoPractLectures();
                break;
            case Constants.INSTRO_THEO:
                requiredData = model.getInstroTheoLectures();
                break;
            case Constants.INSTRO_THEO_PRACTICAL:
                requiredData = model.getInstroTheoPractLectures();
                break;
            case Constants.PHARMA_THEO:
                requiredData = model.getPharmaTheoLectures();
                break;
            case Constants.PHARMA_THEO_PRACTICAL:
                requiredData = model.getPharmaTheoPractLectures();
                break;
            case Constants.KINETICS_THEO:
                requiredData = model.getKineticsTheoLectures();
                break;
            case Constants.KINETICS_THEO_PRACTICAL:
                requiredData = model.getKineticsTheoPractLectures();
                break;
            case Constants.IMMU_THEO:
                requiredData = model.getImmuTheoLectures();
                break;
            case Constants.PRACTICE_THEO:
                requiredData = model.getPracticeTheoLectures();
                break;
        }

        return requiredData;
    }
}
