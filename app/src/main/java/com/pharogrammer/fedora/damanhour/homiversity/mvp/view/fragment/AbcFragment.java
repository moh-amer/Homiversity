package com.pharogrammer.fedora.damanhour.homiversity.mvp.view.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pharogrammer.fedora.damanhour.homiversity.R;
import com.pharogrammer.fedora.damanhour.homiversity.http.model.Lecture;
import com.pharogrammer.fedora.damanhour.homiversity.mvp.mvp.FragmentMVP;
import com.pharogrammer.fedora.damanhour.homiversity.root.App;
import com.pharogrammer.fedora.damanhour.homiversity.utils.adapter.AllTeamsRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class AbcFragment extends Fragment implements FragmentMVP.AbcView {

    @Inject
    FragmentMVP.AbcPresenter presenter;

    RecyclerView recyclerView;
    AllTeamsRecyclerAdapter adapter;
    List<Lecture> lectures;

    public AbcFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_abc, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        int key = getArguments().getInt("KEY");

        recyclerView = getView().findViewById(R.id.rv_abc);

        lectures = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        adapter = new AllTeamsRecyclerAdapter(getContext(), lectures);
        recyclerView.setAdapter(adapter);
        presenter.loadLectures(key);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ((App) context.getApplicationContext()).getComponent().inject(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.setView(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.unSubscribeRx();
    }

    @Override
    public void setLectureToAdapter(Lecture lecture) {
        if (lecture != null){
            lectures.add(lecture);
            adapter.notifyItemInserted(lectures.size() - 1);
        }
    }
}
