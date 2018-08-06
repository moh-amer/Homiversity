package com.pharogrammer.fedora.damanhour.homiversity.mvp.presenter;

import com.pharogrammer.fedora.damanhour.homiversity.http.model.Lecture;
import com.pharogrammer.fedora.damanhour.homiversity.mvp.mvp.FragmentMVP;
import com.pharogrammer.fedora.damanhour.homiversity.utils.Constants;

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

public class PharmaFragPresenter implements FragmentMVP.PharmaPresenter {

    FragmentMVP.PharmaView view;
    FragmentMVP.PharmaModel model;
    Subscription subscription;

    public PharmaFragPresenter(FragmentMVP.PharmaModel model) {
        this.model = model;
    }

    @Override
    public void setView(FragmentMVP.PharmaView view) {
        this.view = view;
    }

    @Override
    public void loadLectures(int key) {

        if (view != null)
            view.showProgressDialogue();

        subscription = getModelDataByCategory(key).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Lecture>() {
                    @Override
                    public void onCompleted() {
                        view.hideProgressDialogue();
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.hideProgressDialogue();
                        view.showConnectionErrorMsg();
                    }

                    @Override
                    public void onNext(Lecture lecture) {
                        if (view != null){
                            view.hideProgressDialogue();
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
