package com.pharogrammer.fedora.damanhour.homiversity.mvp.repository;

import com.pharogrammer.fedora.damanhour.homiversity.http.api.LecturesApiService;
import com.pharogrammer.fedora.damanhour.homiversity.http.model.Lecture;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by fedora on 14/02/18.
 */

public class Third2Repository implements Repository {

    private List<Lecture> ceuticalList;
    private List<Lecture> bioList;
    private List<Lecture> instroList;
    private List<Lecture> pharmaList;
    private List<Lecture> kineticsList;
    private List<Lecture> immuList;
    private List<Lecture> practiceList;

    private LecturesApiService lecturesApiService;

    private long timeStamp;

    private final static long STALE_MS = 1000 * 1000;


    public Third2Repository(LecturesApiService lecturesApiService) {

        this.lecturesApiService = lecturesApiService;

        ceuticalList = new ArrayList<>();
        bioList = new ArrayList<>();
        instroList = new ArrayList<>();
        pharmaList = new ArrayList<>();
        kineticsList = new ArrayList<>();
        immuList = new ArrayList<>();
        practiceList = new ArrayList<>();

        timeStamp = System.currentTimeMillis();

    }


    private boolean isUpToDate(){
        return System.currentTimeMillis() - timeStamp  < STALE_MS;
    }


    @Override
    public Observable<Lecture> getCeuticalLecturesFromMemory() {

        if (isUpToDate()){
            return Observable.from(ceuticalList);
        }else {
            timeStamp = System.currentTimeMillis();
            ceuticalList.clear();
            return Observable.empty();
        }
    }

    @Override
    public Observable<Lecture> getCeuticalLecturesFromNetwork() {

        return lecturesApiService.getCeuticalLectures().flatMap(new Func1<List<Lecture>, Observable<Lecture>>() {
            @Override
            public Observable<Lecture> call(List<Lecture> lectures) {
                return Observable.from(lectures);
            }
        }).doOnNext(new Action1<Lecture>() {
            @Override
            public void call(Lecture lecture) {
                ceuticalList.add(lecture);
            }
        });
    }

    @Override
    public Observable<Lecture> getAvailableCeuticalLectures() {
        return getCeuticalLecturesFromMemory().switchIfEmpty(getCeuticalLecturesFromNetwork());
    }

    @Override
    public Observable<Lecture> getBioLecturesFromMemory() {

        if (isUpToDate()){
            return Observable.from(bioList);
        }else {
            timeStamp = System.currentTimeMillis();
            bioList.clear();
            return Observable.empty();
        }
    }

    @Override
    public Observable<Lecture> getBioLecturesFromNetwork() {

        return lecturesApiService.getBioLectures().flatMap(new Func1<List<Lecture>, Observable<Lecture>>() {
            @Override
            public Observable<Lecture> call(List<Lecture> lectures) {
                return Observable.from(lectures);
            }
        }).doOnNext(new Action1<Lecture>() {
            @Override
            public void call(Lecture lecture) {
                bioList.add(lecture);
            }
        });

    }

    @Override
    public Observable<Lecture> getAvailableBioLectures() {
        return getBioLecturesFromMemory().switchIfEmpty(getBioLecturesFromNetwork());
    }

    @Override
    public Observable<Lecture> getInstroLecturesFromMemory() {

        if (isUpToDate()){
            return Observable.from(instroList);
        }else {
            timeStamp = System.currentTimeMillis();
            instroList.clear();
            return Observable.empty();
        }
    }

    @Override
    public Observable<Lecture> getInstroLecturesFromNetwork() {

        return lecturesApiService.getInstroLectures().flatMap(new Func1<List<Lecture>, Observable<Lecture>>() {
            @Override
            public Observable<Lecture> call(List<Lecture> lectures) {
                return Observable.from(lectures);
            }
        }).doOnNext(new Action1<Lecture>() {
            @Override
            public void call(Lecture lecture) {
                instroList.add(lecture);
            }
        });

    }

    @Override
    public Observable<Lecture> getAvailableInstroLectures() {
        return getInstroLecturesFromMemory().switchIfEmpty(getInstroLecturesFromNetwork());
    }

    @Override
    public Observable<Lecture> getPharmaLecturesFromMemory() {

        if (isUpToDate()){
            return Observable.from(pharmaList);
        }else {
            timeStamp = System.currentTimeMillis();
            pharmaList.clear();
            return Observable.empty();
        }

    }

    @Override
    public Observable<Lecture> getPharmaLecturesFromNetwork() {

        return lecturesApiService.getPharmaLectures().flatMap(new Func1<List<Lecture>, Observable<Lecture>>() {
            @Override
            public Observable<Lecture> call(List<Lecture> lectures) {
                return Observable.from(lectures);
            }
        }).doOnNext(new Action1<Lecture>() {
            @Override
            public void call(Lecture lecture) {
                pharmaList.add(lecture);
            }
        });

    }

    @Override
    public Observable<Lecture> getAvailablePharmaLectures() {
        return getPharmaLecturesFromMemory().switchIfEmpty(getPharmaLecturesFromNetwork());
    }

    @Override
    public Observable<Lecture> getKineticsLecturesFromMemory() {

        if (isUpToDate()){
            return Observable.from(kineticsList);
        }else {
            timeStamp = System.currentTimeMillis();
            kineticsList.clear();
            return Observable.empty();
        }

    }

    @Override
    public Observable<Lecture> getKineticsLecturesFromNetwork() {

        return lecturesApiService.getKineticsLectures().flatMap(new Func1<List<Lecture>, Observable<Lecture>>() {
            @Override
            public Observable<Lecture> call(List<Lecture> lectures) {
                return Observable.from(lectures);
            }
        }).doOnNext(new Action1<Lecture>() {
            @Override
            public void call(Lecture lecture) {
                kineticsList.add(lecture);
            }
        });

    }

    @Override
    public Observable<Lecture> getAvailableKineticsLectures() {
        return getKineticsLecturesFromMemory().switchIfEmpty(getKineticsLecturesFromNetwork());
    }

    @Override
    public Observable<Lecture> getImmuLecturesFromMemory() {

        if (isUpToDate()){
            return Observable.from(immuList);
        }else {
            timeStamp = System.currentTimeMillis();
            immuList.clear();
            return Observable.empty();
        }

    }

    @Override
    public Observable<Lecture> getImmuLecturesFromNetwork() {

        return lecturesApiService.getImmuLectures().flatMap(new Func1<List<Lecture>, Observable<Lecture>>() {
            @Override
            public Observable<Lecture> call(List<Lecture> lectures) {
                return Observable.from(lectures);
            }
        }).doOnNext(new Action1<Lecture>() {
            @Override
            public void call(Lecture lecture) {
                immuList.add(lecture);
            }
        });

    }

    @Override
    public Observable<Lecture> getAvailableImmuLectures() {
        return getImmuLecturesFromMemory().switchIfEmpty(getImmuLecturesFromNetwork());
    }

    @Override
    public Observable<Lecture> getPracticeLecturesFromMemory() {

        if (isUpToDate()){
            return Observable.from(practiceList);
        }else {
            timeStamp = System.currentTimeMillis();
            practiceList.clear();
            return Observable.empty();
        }

    }

    @Override
    public Observable<Lecture> getPracticeLecturesFromNetwork() {

        return lecturesApiService.getPracticeLectures().flatMap(new Func1<List<Lecture>, Observable<Lecture>>() {
            @Override
            public Observable<Lecture> call(List<Lecture> lectures) {
                return Observable.from(lectures);
            }
        }).doOnNext(new Action1<Lecture>() {
            @Override
            public void call(Lecture lecture) {
                practiceList.add(lecture);
            }
        });

    }

    @Override
    public Observable<Lecture> getAvailablePracticeLectures() {
        return getPracticeLecturesFromMemory().switchIfEmpty(getPracticeLecturesFromNetwork());
    }
}
