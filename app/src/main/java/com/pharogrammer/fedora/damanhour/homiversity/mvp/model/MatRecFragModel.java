package com.pharogrammer.fedora.damanhour.homiversity.mvp.model;

import com.pharogrammer.fedora.damanhour.homiversity.http.model.Lecture;
import com.pharogrammer.fedora.damanhour.homiversity.mvp.mvp.FragmentMVP;
import com.pharogrammer.fedora.damanhour.homiversity.mvp.repository.Repository;
import com.pharogrammer.fedora.damanhour.homiversity.utils.Constants;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by fedora on 16/02/18.
 */

public class MatRecFragModel implements FragmentMVP.MatRecModel {

    Repository repository;

    public MatRecFragModel(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<Lecture> getCeuticalMaterial(){

       return repository.getAvailableCeuticalLectures().filter(new Func1<Lecture, Boolean>() {
            @Override
            public Boolean call(Lecture lecture) {
                return lecture.getType().equals(Constants.TYPE_MATERIAL);
            }
        });
    }

    @Override
    public Observable<Lecture> getBioMaterial(){

        return repository.getAvailableBioLectures().filter(new Func1<Lecture, Boolean>() {
            @Override
            public Boolean call(Lecture lecture) {
                return lecture.getType().equals(Constants.TYPE_MATERIAL);
            }
        });
    }

    @Override
    public Observable<Lecture> getInstroMaterial(){

        return repository.getAvailableInstroLectures().filter(new Func1<Lecture, Boolean>() {
            @Override
            public Boolean call(Lecture lecture) {
                return lecture.getType().equals(Constants.TYPE_MATERIAL);
            }
        });
    }


    @Override
    public Observable<Lecture> getPharmaMaterial(){

        return repository.getAvailablePharmaLectures().filter(new Func1<Lecture, Boolean>() {
            @Override
            public Boolean call(Lecture lecture) {
                return lecture.getType().equals(Constants.TYPE_MATERIAL);
            }
        });
    }


    @Override
    public Observable<Lecture> getKineticsMaterial(){

        return repository.getAvailableKineticsLectures().filter(new Func1<Lecture, Boolean>() {
            @Override
            public Boolean call(Lecture lecture) {
                return lecture.getType().equals(Constants.TYPE_MATERIAL);
            }
        });
    }


    @Override
    public Observable<Lecture> getImmuMaterial(){

        return repository.getAvailableImmuLectures().filter(new Func1<Lecture, Boolean>() {
            @Override
            public Boolean call(Lecture lecture) {
                return lecture.getType().equals(Constants.TYPE_MATERIAL);
            }
        });
    }


    public Observable<Lecture> getPracticeMaterial(){

        return repository.getAvailablePracticeLectures().filter(new Func1<Lecture, Boolean>() {
            @Override
            public Boolean call(Lecture lecture) {
                return lecture.getType().equals(Constants.TYPE_MATERIAL);
            }
        });
    }


    @Override
    public Observable<Lecture> getCeuticalRecords(){

        return repository.getAvailableCeuticalLectures().filter(new Func1<Lecture, Boolean>() {
            @Override
            public Boolean call(Lecture lecture) {
                return lecture.getType().equals(Constants.TYPE_RECORD);
            }
        });
    }


    @Override
    public Observable<Lecture> getBioRecords(){

        return repository.getAvailableBioLectures().filter(new Func1<Lecture, Boolean>() {
            @Override
            public Boolean call(Lecture lecture) {
                return lecture.getType().equals(Constants.TYPE_RECORD);
            }
        });
    }


    @Override
    public Observable<Lecture> getInstroRecords(){

        return repository.getAvailableInstroLectures().filter(new Func1<Lecture, Boolean>() {
            @Override
            public Boolean call(Lecture lecture) {
                return lecture.getType().equals(Constants.TYPE_RECORD);
            }
        });
    }


    @Override
    public Observable<Lecture> getPharmaRecords(){

        return repository.getAvailablePharmaLectures().filter(new Func1<Lecture, Boolean>() {
            @Override
            public Boolean call(Lecture lecture) {
                return lecture.getType().equals(Constants.TYPE_RECORD);
            }
        });
    }


    @Override
    public Observable<Lecture> getKineticsRecords(){

        return repository.getAvailableKineticsLectures().filter(new Func1<Lecture, Boolean>() {
            @Override
            public Boolean call(Lecture lecture) {
                return lecture.getType().equals(Constants.TYPE_RECORD);
            }
        });
    }


    @Override
    public Observable<Lecture> getImmuRecords(){

        return repository.getAvailableImmuLectures().filter(new Func1<Lecture, Boolean>() {
            @Override
            public Boolean call(Lecture lecture) {
                return lecture.getType().equals(Constants.TYPE_RECORD);
            }
        });
    }

    @Override
    public Observable<Lecture> getPracticeRecords(){

        return repository.getAvailablePracticeLectures().filter(new Func1<Lecture, Boolean>() {
            @Override
            public Boolean call(Lecture lecture) {
                return lecture.getType().equals(Constants.TYPE_RECORD);
            }
        });
    }
}
