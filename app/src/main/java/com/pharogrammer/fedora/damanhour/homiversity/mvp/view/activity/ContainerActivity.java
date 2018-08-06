package com.pharogrammer.fedora.damanhour.homiversity.mvp.view.activity;

import android.Manifest;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.pharogrammer.fedora.damanhour.homiversity.R;
import com.pharogrammer.fedora.damanhour.homiversity.mvp.mvp.ContainerMVP;
import com.pharogrammer.fedora.damanhour.homiversity.mvp.view.fragment.AbcFragment;
import com.pharogrammer.fedora.damanhour.homiversity.mvp.view.fragment.OthersFragment;
import com.pharogrammer.fedora.damanhour.homiversity.mvp.view.fragment.PharmaFragment;
import com.pharogrammer.fedora.damanhour.homiversity.root.App;
import com.pharogrammer.fedora.damanhour.homiversity.utils.Constants;
import com.pharogrammer.fedora.damanhour.homiversity.utils.adapter.FragModel;
import com.pharogrammer.fedora.damanhour.homiversity.utils.adapter.TeamPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContainerActivity extends AppCompatActivity implements ContainerMVP.View  {

    @BindView(R.id.tab_teams)
    TabLayout tabLayout;

    @BindView(R.id.vp_teams)
    ViewPager viewPager;

    @Inject
    ContainerMVP.Presenter presenter;

    private TeamPagerAdapter adapter;
    private List<FragModel> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //This is Used to prevent Activity From orientation
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);
        //bind dagger to this activity
        ((App)getApplication()).getComponent().inject(this);

        int key = getIntent().getExtras().getInt("KEY");


        //Check android version then ask for permission programatically

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1){
            if ( ! ( ActivityCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED ) ){
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
            }
        }




        if (getTeamsBelonging().contains(key)) {
            setContentView(R.layout.activity_container);

            //bind views via butterknife
            ButterKnife.bind(this);

            getSupportActionBar().hide();

            fragments = new ArrayList<>();

            Bundle bundle = new Bundle();
            bundle.putInt("KEY", key);


            //Add Tab Fragments to TabLayout and set Bundle to them
            PharmaFragment pharmaFragment = new PharmaFragment();
            pharmaFragment.setArguments(bundle);
            AbcFragment abcFragment = new AbcFragment();
            abcFragment.setArguments(bundle);
            OthersFragment othersFragment = new OthersFragment();
            othersFragment.setArguments(bundle);

            fragments.add(new FragModel(pharmaFragment , "Pharma"));
            fragments.add(new FragModel(abcFragment, "ABC"));
            fragments.add(new FragModel(othersFragment, "Others"));


            //presenter.provideTeamsPagerFragments(key);
            adapter = new TeamPagerAdapter(getSupportFragmentManager(), this.fragments);
            viewPager.setAdapter(adapter);
            tabLayout.setupWithViewPager(viewPager);
        }else{
            setContentView(R.layout.activity_container_basic);

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frag_container, presenter.getMatRecFragment(key))
                    .commit();

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.unSubscribeRx();
    }


    @Override
    public void addPages(FragModel fragment) {
        if (fragment != null){
            fragments.add(fragment);
            adapter.notifyDataSetChanged();
        }
    }

    private List<Integer> getTeamsBelonging(){
        List<Integer> teams = new ArrayList<>();
        teams.add(Constants.CEUTICAL_THEO);
        teams.add(Constants.CEUTICAL_THEO_PRACTICAL);
        teams.add(Constants.BIO_THEO);
        teams.add(Constants.BIO_THEO_PRACTICAL);
        teams.add(Constants.INSTRO_THEO);
        teams.add(Constants.INSTRO_THEO_PRACTICAL);
        teams.add(Constants.PHARMA_THEO);
        teams.add(Constants.PHARMA_THEO_PRACTICAL);
        teams.add(Constants.KINETICS_THEO);
        teams.add(Constants.KINETICS_THEO_PRACTICAL);
        teams.add(Constants.IMMU_THEO);
        teams.add(Constants.PRACTICE_THEO);

        return teams;
    }
}
