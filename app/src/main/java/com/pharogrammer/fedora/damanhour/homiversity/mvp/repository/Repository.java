package com.pharogrammer.fedora.damanhour.homiversity.mvp.repository;

import com.pharogrammer.fedora.damanhour.homiversity.http.model.Lecture;

import java.util.List;

import rx.Observable;

/**
 * Created by fedora on 14/02/18.
 */

public interface Repository {

    Observable<Lecture> getCeuticalLecturesFromMemory();
    Observable<Lecture> getCeuticalLecturesFromNetwork();
    Observable<Lecture> getAvailableCeuticalLectures();

    Observable<Lecture> getBioLecturesFromMemory();
    Observable<Lecture> getBioLecturesFromNetwork();
    Observable<Lecture> getAvailableBioLectures();


    Observable<Lecture> getInstroLecturesFromMemory();
    Observable<Lecture> getInstroLecturesFromNetwork();
    Observable<Lecture> getAvailableInstroLectures();


    Observable<Lecture> getPharmaLecturesFromMemory();
    Observable<Lecture> getPharmaLecturesFromNetwork();
    Observable<Lecture> getAvailablePharmaLectures();

    Observable<Lecture> getKineticsLecturesFromMemory();
    Observable<Lecture> getKineticsLecturesFromNetwork();
    Observable<Lecture> getAvailableKineticsLectures();


    Observable<Lecture> getImmuLecturesFromMemory();
    Observable<Lecture> getImmuLecturesFromNetwork();
    Observable<Lecture> getAvailableImmuLectures();

    Observable<Lecture> getPracticeLecturesFromMemory();
    Observable<Lecture> getPracticeLecturesFromNetwork();
    Observable<Lecture> getAvailablePracticeLectures();
}
