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
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.pharogrammer.fedora.damanhour.homiversity.R;
import com.pharogrammer.fedora.damanhour.homiversity.http.model.Lecture;
import com.pharogrammer.fedora.damanhour.homiversity.mvp.mvp.FragmentMVP;
import com.pharogrammer.fedora.damanhour.homiversity.root.App;
import com.pharogrammer.fedora.damanhour.homiversity.utils.adapter.MaterialRecyclerAdapter;
import com.pharogrammer.fedora.damanhour.homiversity.utils.adapter.RecordsRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class MatRecFragment extends Fragment implements FragmentMVP.MatRecView{


    @Inject
    FragmentMVP.MatRecPresenter presenter;

    private List<Lecture> lectures;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private ProgressDialog dialogue;


    public MatRecFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mat_rec, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final int key = getArguments().getInt("KEY");
        String keyStrning = String.valueOf(key);
        keyStrning = keyStrning.substring(1);
        int subKey = Integer.valueOf(keyStrning);

        recyclerView = getView().findViewById(R.id.rv_mat_rec);

        lectures = new ArrayList<>();

        if (subKey == 3){
            //define the correct Adapter here
            adapter = new MaterialRecyclerAdapter(getContext(),lectures);

        }else if (subKey == 4 ){
            adapter = new RecordsRecyclerAdapter(getContext(), lectures);

        }

        //


        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        presenter.loadLectures(key);

        //
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
    public void onDestroy() {
        super.onDestroy();
        //Call a method from records recycler adapter to finish all processes belonging to playing sounds
        if (adapter.getClass() == RecordsRecyclerAdapter.class){
            ((RecordsRecyclerAdapter) adapter).onFinishRecycler();
        }
    }

    @Override
    public void setLectureToAdapter(Lecture lecture) {
        if (lecture != null){
            lectures.add(lecture);
            adapter.notifyItemInserted(lectures.size() -1);
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
