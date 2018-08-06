package com.pharogrammer.fedora.damanhour.homiversity.mvp.model;

import com.pharogrammer.fedora.damanhour.homiversity.http.model.Lecture;
import com.pharogrammer.fedora.damanhour.homiversity.mvp.mvp.FragmentMVP;
import com.pharogrammer.fedora.damanhour.homiversity.mvp.repository.Repository;
import com.pharogrammer.fedora.damanhour.homiversity.utils.Constants;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by fedora on 15/02/18.
 */

public class OthersFragModel implements FragmentMVP.OthersModel {

    
    private Repository third2Repo;

    public OthersFragModel(Repository third2Repo) {
        this.third2Repo = third2Repo;
    }

    @Override
    public Observable<Lecture> getCeuticalTheoLectures() {
        return third2Repo.getAvailableCeuticalLectures().filter(new Func1<Lecture, Boolean>() {
            @Override
            public Boolean call(Lecture lecture) {
                return  lecture.getTeam().equals(Constants.TEAM_OTHERS)
                        &&lecture.getType().equals(Constants.THEO);
            }
        });
    }

    @Override
    public Observable<Lecture> getCeuticalTheoPractLectures() {
        return third2Repo.getAvailableCeuticalLectures().filter(new Func1<Lecture, Boolean>() {
            @Override
            public Boolean call(Lecture lecture) {
                return lecture.getTeam().equals(Constants.TEAM_OTHERS)
                        && lecture.getType().equals(Constants.THEO_PRACT);
            }
        });
    }

    @Override
    public Observable<Lecture> getBioTheoLectures() {
        return third2Repo.getAvailableBioLectures().filter(new Func1<Lecture, Boolean>() {
            @Override
            public Boolean call(Lecture lecture) {
                return lecture.getTeam().equals(Constants.TEAM_OTHERS)
                        &&lecture.getType().equals(Constants.THEO);
            }
        });
    }

    @Override
    public Observable<Lecture> getBioTheoPractLectures() {
        return third2Repo.getAvailableBioLectures().filter(new Func1<Lecture, Boolean>() {
            @Override
            public Boolean call(Lecture lecture) {
                return lecture.getTeam().equals(Constants.TEAM_OTHERS)
                        && lecture.getType().equals(Constants.THEO_PRACT);
            }
        });
    }

    @Override
    public Observable<Lecture> getInstroTheoLectures() {
        return third2Repo.getAvailableInstroLectures().filter(new Func1<Lecture, Boolean>() {
            @Override
            public Boolean call(Lecture lecture) {
                return lecture.getTeam().equals(Constants.TEAM_OTHERS)
                        &&lecture.getType().equals(Constants.THEO);
            }
        });
    }

    @Override
    public Observable<Lecture> getInstroTheoPractLectures() {
        return third2Repo.getAvailableInstroLectures().filter(new Func1<Lecture, Boolean>() {
            @Override
            public Boolean call(Lecture lecture) {
                return lecture.getTeam().equals(Constants.TEAM_OTHERS)
                        && lecture.getType().equals(Constants.THEO_PRACT);
            }
        });
    }

    @Override
    public Observable<Lecture> getPharmaTheoLectures() {
        return third2Repo.getAvailablePharmaLectures().filter(new Func1<Lecture, Boolean>() {
            @Override
            public Boolean call(Lecture lecture) {
                return lecture.getTeam().equals(Constants.TEAM_OTHERS)
                        &&lecture.getType().equals(Constants.THEO);
            }
        });
    }

    @Override
    public Observable<Lecture> getPharmaTheoPractLectures() {
        return third2Repo.getAvailablePharmaLectures().filter(new Func1<Lecture, Boolean>() {
            @Override
            public Boolean call(Lecture lecture) {
                return lecture.getTeam().equals(Constants.TEAM_OTHERS)
                        && lecture.getType().equals(Constants.THEO_PRACT);
            }
        });
    }

    @Override
    public Observable<Lecture> getKineticsTheoLectures() {
        return third2Repo.getAvailableKineticsLectures().filter(new Func1<Lecture, Boolean>() {
            @Override
            public Boolean call(Lecture lecture) {
                return lecture.getTeam().equals(Constants.TEAM_OTHERS)
                        &&lecture.getType().equals(Constants.THEO);
            }
        });
    }

    @Override
    public Observable<Lecture> getKineticsTheoPractLectures() {
        return third2Repo.getAvailableKineticsLectures().filter(new Func1<Lecture, Boolean>() {
            @Override
            public Boolean call(Lecture lecture) {
                return lecture.getTeam().equals(Constants.TEAM_OTHERS)
                        && lecture.getType().equals(Constants.THEO_PRACT);
            }
        });
    }

    @Override
    public Observable<Lecture> getImmuTheoLectures() {
        return third2Repo.getAvailableImmuLectures().filter(new Func1<Lecture, Boolean>() {
            @Override
            public Boolean call(Lecture lecture) {
                return lecture.getTeam().equals(Constants.TEAM_OTHERS)
                        &&lecture.getType().equals(Constants.THEO);
            }
        });
    }

    @Override
    public Observable<Lecture> getPracticeTheoLectures() {
        return third2Repo.getAvailablePracticeLectures().filter(new Func1<Lecture, Boolean>() {
            @Override
            public Boolean call(Lecture lecture) {
                return lecture.getTeam().equals(Constants.TEAM_OTHERS)
                        &&lecture.getType().equals(Constants.THEO);
            }
        });
    }
}
