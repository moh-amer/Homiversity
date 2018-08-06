package com.pharogrammer.fedora.damanhour.homiversity.mvp.view.fragment;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

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
public class PharmaFragment extends Fragment implements FragmentMVP.PharmaView {


    @Inject
    FragmentMVP.PharmaPresenter presenter;


    RecyclerView recyclerView;

    AllTeamsRecyclerAdapter adapter;
    List<Lecture> lectures;

    ProgressDialog dialogue;

    public PharmaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pharma, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final int key = getArguments().getInt("KEY");

        recyclerView = getView().findViewById(R.id.rv_pharma);


//        reloadButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                presenter.loadLectures(key);
//            }
//        });

        lectures = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        adapter = new AllTeamsRecyclerAdapter(getContext(),lectures);
        recyclerView.setAdapter(adapter);
        presenter.loadLectures(key);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        ((App)context.getApplicationContext()).getComponent().inject(this);
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
            adapter.notifyItemInserted(lectures.size() - 1 );
        }
    }

    @Override
    public void showProgressDialogue() {
        if (dialogue == null){
            dialogue = new ProgressDialog(getActivity());
            dialogue.setMessage("loading...");
            dialogue.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            dialogue.setCancelable(false);
            dialogue.show();
        }else{
            if ( ! dialogue.isShowing()){
                dialogue.show();
            }
        }
    }

    @Override
    public void hideProgressDialogue() {
        if (dialogue != null && dialogue.isShowing()){
            dialogue.hide();
            dialogue.dismiss();
        }
    }

    @Override
    public void showConnectionErrorMsg() {
        Snackbar.make(getView(),"Please check your connection",Snackbar.LENGTH_INDEFINITE).show();
    }

}
