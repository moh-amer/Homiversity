package com.pharogrammer.fedora.damanhour.homiversity.http.api;

import com.pharogrammer.fedora.damanhour.homiversity.http.model.Lecture;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by fedora on 14/02/18.
 */

public interface LecturesApiService {

    @GET("/homiversity/ceutical.php")
    Observable<List<Lecture>> getCeuticalLectures();

    @GET("/homiversity/bio.php")
    Observable<List<Lecture>> getBioLectures();

    @GET("/homiversity/instro.php")
    Observable<List<Lecture>> getInstroLectures();

    @GET("/homiversity/pharma.php")
    Observable<List<Lecture>> getPharmaLectures();

    @GET("/homiversity/kinetics.php")
    Observable<List<Lecture>> getKineticsLectures();

    @GET("/homiversity/immu.php")
    Observable<List<Lecture>> getImmuLectures();

    @GET("/homiversity/practice.php")
    Observable<List<Lecture>> getPracticeLectures();
}
