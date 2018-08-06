package com.pharogrammer.fedora.damanhour.homiversity.mvp.mvp;

import com.pharogrammer.fedora.damanhour.homiversity.http.model.Lecture;

import rx.Observable;

/**
 * Created by fedora on 14/02/18.
 */

public interface FragmentMVP {


    //Interfaces of Pharma Fragment
    interface PharmaView{
        void setLectureToAdapter(Lecture lecture);
        void showProgressDialogue();
        void hideProgressDialogue();
        void showConnectionErrorMsg();

    }

    interface PharmaPresenter{
        void setView(FragmentMVP.PharmaView view);
        void loadLectures(int key);
        void unSubscribeRx();


    }

    interface PharmaModel{
        Observable<Lecture> getCeuticalTheoLectures();
        Observable<Lecture> getCeuticalTheoPractLectures();

        Observable<Lecture> getBioTheoLectures();
        Observable<Lecture> getBioTheoPractLectures();

        Observable<Lecture> getInstroTheoLectures();
        Observable<Lecture> getInstroTheoPractLectures();

        Observable<Lecture> getPharmaTheoLectures();
        Observable<Lecture> getPharmaTheoPractLectures();

        Observable<Lecture> getKineticsTheoLectures();
        Observable<Lecture> getKineticsTheoPractLectures();

        Observable<Lecture> getImmuTheoLectures();

        Observable<Lecture> getPracticeTheoLectures();


    }


    //Interfaces of ABC fragment
    interface AbcView{
        void setLectureToAdapter(Lecture lecture);

    }

    interface AbcPresenter{
        void setView(FragmentMVP.AbcView view);
        void loadLectures(int key);
        void unSubscribeRx();

    }

    interface AbcModel{

        Observable<Lecture> getCeuticalTheoLectures();
        Observable<Lecture> getCeuticalTheoPractLectures();

        Observable<Lecture> getBioTheoLectures();
        Observable<Lecture> getBioTheoPractLectures();

        Observable<Lecture> getInstroTheoLectures();
        Observable<Lecture> getInstroTheoPractLectures();

        Observable<Lecture> getPharmaTheoLectures();
        Observable<Lecture> getPharmaTheoPractLectures();

        Observable<Lecture> getKineticsTheoLectures();
        Observable<Lecture> getKineticsTheoPractLectures();

        Observable<Lecture> getImmuTheoLectures();

        Observable<Lecture> getPracticeTheoLectures();

    }


    //Interfaces of Others Fragment
    interface OthersView{
        void setLectureToAdapter(Lecture lecture);


    }

    interface OthersPresenter{
        void setView(FragmentMVP.OthersView view);
        void loadLectures(int key);
        void unSubscribeRx();
    }

    interface OthersModel{

        Observable<Lecture> getCeuticalTheoLectures();
        Observable<Lecture> getCeuticalTheoPractLectures();

        Observable<Lecture> getBioTheoLectures();
        Observable<Lecture> getBioTheoPractLectures();

        Observable<Lecture> getInstroTheoLectures();
        Observable<Lecture> getInstroTheoPractLectures();

        Observable<Lecture> getPharmaTheoLectures();
        Observable<Lecture> getPharmaTheoPractLectures();

        Observable<Lecture> getKineticsTheoLectures();
        Observable<Lecture> getKineticsTheoPractLectures();

        Observable<Lecture> getImmuTheoLectures();

        Observable<Lecture> getPracticeTheoLectures();

    }


    //Interfaces of MatRec Fragment
    interface MatRecView{
        void setLectureToAdapter(Lecture lecture);
        void showProgressDialogue();
        void hideProgressDialogue();
        void showConnectionErrorMsg();

    }

    interface MatRecPresenter{
        void setView(FragmentMVP.MatRecView view);
        void loadLectures(int key);
        void unSubscribeRx();
    }

    interface MatRecModel{

        Observable<Lecture> getCeuticalMaterial();
        Observable<Lecture> getBioMaterial();
        Observable<Lecture> getInstroMaterial();
        Observable<Lecture> getPharmaMaterial();
        Observable<Lecture> getKineticsMaterial();
        Observable<Lecture> getImmuMaterial();
        Observable<Lecture> getPracticeMaterial();

        Observable<Lecture> getCeuticalRecords();
        Observable<Lecture> getBioRecords();
        Observable<Lecture> getInstroRecords();
        Observable<Lecture> getPharmaRecords();
        Observable<Lecture> getKineticsRecords();
        Observable<Lecture> getImmuRecords();
        Observable<Lecture> getPracticeRecords();
    }
}
