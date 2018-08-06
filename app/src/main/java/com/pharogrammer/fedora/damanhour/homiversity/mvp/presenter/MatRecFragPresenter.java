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
 * Created by fedora on 16/02/18.
 */

public class MatRecFragPresenter implements FragmentMVP.MatRecPresenter {
    
    FragmentMVP.MatRecView view;
    FragmentMVP.MatRecModel model;
    private Subscription subscription;

    public MatRecFragPresenter(FragmentMVP.MatRecModel model) {
        this.model = model;
    }

    @Override
    public void setView(FragmentMVP.MatRecView view) {
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
            case Constants.CEUTICAL_MATERIAL:
                requiredData = model.getCeuticalMaterial();
                break;
            case Constants.CEUTICAL_RECORD:
                requiredData =  model.getCeuticalRecords();
                break;
            case Constants.BIO_MATERIAL:
                requiredData = model.getBioMaterial();
                break;
            case Constants.BIO_RECORD:
                requiredData = model.getBioRecords();
                break;
            case Constants.INSTRO_MATERIAL:
                requiredData = model.getInstroMaterial();
                break;
            case Constants.INSTRO_RECORD:
                requiredData = model.getInstroRecords();
                break;
            case Constants.PHARMA_MATERIAL:
                requiredData = model.getPharmaMaterial();
                break;
            case Constants.PHARMA_RECORD:
                requiredData = model.getPharmaRecords();
                break;
            case Constants.KINETICS_MATERIAL:
                requiredData = model.getKineticsMaterial();
                break;
            case Constants.KINETICS_RECORD:
                requiredData = model.getKineticsRecords();
                break;
            case Constants.IMMU_MATERIAL:
                requiredData = model.getImmuMaterial();
                break;
            case Constants.IMMU_RECORD:
                requiredData = model.getImmuRecords();
                break;
            case Constants.PRACTICE_MATERIAL:
                requiredData = model.getPracticeMaterial();
                break;
            case Constants.PRACTICE_RECORD:
                requiredData = model.getPracticeRecords();
                break;
        }

        return requiredData;
    }
}
