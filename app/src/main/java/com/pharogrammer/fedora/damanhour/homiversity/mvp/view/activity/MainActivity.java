package com.pharogrammer.fedora.damanhour.homiversity.mvp.view.activity;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.pharogrammer.fedora.damanhour.homiversity.R;
import com.pharogrammer.fedora.damanhour.homiversity.mvp.mvp.MainMVP;
import com.pharogrammer.fedora.damanhour.homiversity.root.App;
import com.pharogrammer.fedora.damanhour.homiversity.utils.Constants;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,MainMVP.View {


    //inject the main presenter
    @Inject
    MainMVP.Presenter presenter;

    //Define and bind ImageButtons Which are resposible for the main Action of all buttons
    @BindViews({R.id.btn_ceutical_theoritcal , R.id.btn_ceutical_theo_practical,
                R.id.btn_ceutical_material, R.id.btn_ceutical_record,
                R.id.btn_bio_theoritcal, R.id.btn_bio_theo_practical,
                R.id.btn_bio_material, R.id.btn_bio_record,
                R.id.btn_instro_theoritcal, R.id.btn_instro_theo_practical,
                R.id.btn_instro_material, R.id.btn_instro_record,
                R.id.btn_pharma_theoritcal, R.id.btn_pharma_theo_practical,
                R.id.btn_pharma_material, R.id.btn_pharma_record,
                R.id.btn_kinetics_theoritcal, R.id.btn_kinetics_theo_practical,
                R.id.btn_kinetics_material, R.id.btn_kinetics_record,
                R.id.btn_immu_theoritcal,
                R.id.btn_immu_material , R.id.btn_immu_record,
                R.id.btn_practice_theoritcal,
                R.id.btn_practice_material, R.id.btn_practice_record
    })
    List<AppCompatImageButton> imageButtons;

    //Define and bind main screen Buttons which are responsible for showing and hiding ImageButtons
    @BindViews({R.id.btn_main_ceutical, R.id.btn_main_bio,
                R.id.btn_main_instro, R.id.btn_main_pharma,
                R.id.btn_main_kinetics, R.id.btn_main_immu,
                R.id.btn_main_practice})
    List<AppCompatButton> buttonList;

    //Define and bind the layout(container) of imageButtons
    @BindViews({R.id.layout_sub_ceutical, R.id.layout_sub_bio,
                R.id.layout_sub_instro, R.id.layout_sub_pharma,
                R.id.layout_sub_kinetics, R.id.layout_sub_immu,
                R.id.layout_sub_practice})
    List<LinearLayout> imageButtonLayoutList;

    @BindView(R.id.toolbar_main)
    Toolbar toolbar;

    AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //bind dagger to the Activity
        ((App) getApplication()).getComponent().inject(this);
        //bind butter knife liberary to the activity
        ButterKnife.bind(this);

        //Set up actionbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Tell the main buttons from where they should take their action
        ButterKnife.apply(buttonList, new ButterKnife.Action<AppCompatButton>() {
            @Override
            public void apply(@NonNull AppCompatButton view, int index) {
                view.setOnClickListener(MainActivity.this);
            }
        });

        //Tell the image buttons from where they should take their aciton
        ButterKnife.apply(imageButtons, new ButterKnife.Action<AppCompatImageButton>() {
            @Override
            public void apply(@NonNull AppCompatImageButton view, int index) {
                view.setOnClickListener(MainActivity.this);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.mainbar_menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.item_about){
            dialog = new AlertDialog.Builder(this).create();
            dialog.setMessage("All rights reserved \u00a9 Pharogrammer 2018");
            dialog.setCancelable(true);
            dialog.show();
        }else if (item.getItemId() == android.R.id.home){
            finish();
        }

        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        //set the view to the presenter
        presenter.setView(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            //Switch over the main buttons to display or hide
            case R.id.btn_main_ceutical:
                presenter.setVisibility(0);
                break;
            case R.id.btn_main_bio:
                presenter.setVisibility(1);
                break;
            case R.id.btn_main_instro:
                presenter.setVisibility(2);
                break;
            case R.id.btn_main_pharma:
                presenter.setVisibility(3);
                break;
            case R.id.btn_main_kinetics:
                presenter.setVisibility(4);
                break;
            case R.id.btn_main_immu:
                presenter.setVisibility(5);
                break;
            case R.id.btn_main_practice:
                presenter.setVisibility(6);
                break;

            //Switch over the imageButtons to Open the new Activity with key , so that the container activity knows from where the request has been sent
            case R.id.btn_ceutical_theoritcal:
                startActivity(presenter.getIntent(Constants.CEUTICAL_THEO));
                break;
            case R.id.btn_ceutical_theo_practical:
                startActivity(presenter.getIntent(Constants.CEUTICAL_THEO_PRACTICAL));
                break;
            case R.id.btn_ceutical_material:
                startActivity(presenter.getIntent(Constants.CEUTICAL_MATERIAL));
                break;
            case R.id.btn_ceutical_record:
                startActivity(presenter.getIntent(Constants.CEUTICAL_RECORD));
                break;
            case R.id.btn_bio_theoritcal:
                startActivity(presenter.getIntent(Constants.BIO_THEO));
                break;
            case R.id.btn_bio_theo_practical:
                startActivity(presenter.getIntent(Constants.BIO_THEO_PRACTICAL));
                break;
            case R.id.btn_bio_material:
                startActivity(presenter.getIntent(Constants.BIO_MATERIAL));
                break;
            case R.id.btn_bio_record:
                startActivity(presenter.getIntent(Constants.BIO_RECORD));
                break;
            case R.id.btn_instro_theoritcal:
                startActivity(presenter.getIntent(Constants.INSTRO_THEO));
                break;
            case R.id.btn_instro_theo_practical:
                startActivity(presenter.getIntent(Constants.INSTRO_THEO_PRACTICAL));
                break;
            case R.id.btn_instro_material:
                startActivity(presenter.getIntent(Constants.INSTRO_MATERIAL));
                break;
            case R.id.btn_instro_record:
                startActivity(presenter.getIntent(Constants.INSTRO_RECORD));
                break;
            case R.id.btn_pharma_theoritcal:
                startActivity(presenter.getIntent(Constants.PHARMA_THEO));
                break;
            case R.id.btn_pharma_theo_practical:
                startActivity(presenter.getIntent(Constants.PHARMA_THEO_PRACTICAL));
                break;
            case R.id.btn_pharma_material:
                startActivity(presenter.getIntent(Constants.PHARMA_MATERIAL));
                break;
            case R.id.btn_pharma_record:
                startActivity(presenter.getIntent(Constants.PHARMA_RECORD));
                break;
            case R.id.btn_kinetics_theoritcal:
                startActivity(presenter.getIntent(Constants.KINETICS_THEO));
                break;
            case R.id.btn_kinetics_theo_practical:
                startActivity(presenter.getIntent(Constants.KINETICS_THEO_PRACTICAL));
                break;
            case R.id.btn_kinetics_material:
                startActivity(presenter.getIntent(Constants.KINETICS_MATERIAL));
                break;
            case R.id.btn_kinetics_record:
                startActivity(presenter.getIntent(Constants.KINETICS_RECORD));
                break;
            case R.id.btn_immu_theoritcal:
                startActivity(presenter.getIntent(Constants.IMMU_THEO));
                break;
            case R.id.btn_immu_material:
                startActivity(presenter.getIntent(Constants.IMMU_MATERIAL));
                break;
            case R.id.btn_immu_record:
                startActivity(presenter.getIntent(Constants.IMMU_RECORD));
                break;
            case R.id.btn_practice_theoritcal:
                startActivity(presenter.getIntent(Constants.PRACTICE_THEO));
                break;
            case R.id.btn_practice_material:
                startActivity(presenter.getIntent(Constants.PRACTICE_MATERIAL));
                break;
            case R.id.btn_practice_record:
                startActivity(presenter.getIntent(Constants.PRACTICE_RECORD));
                break;

        }
    }



    @Override
    public void controlVisibility(int index) {
        ButterKnife.apply(imageButtonLayoutList, new ButterKnife.Action<LinearLayout>() {
            @Override
            public void apply(@NonNull LinearLayout view, int index) {
                view.setVisibility(View.GONE);
            }
        });

        imageButtonLayoutList.get(index).setVisibility(View.VISIBLE);
    }
}
