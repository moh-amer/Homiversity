package com.pharogrammer.fedora.damanhour.homiversity.mvp.presenter;

import android.content.Context;
import android.content.Intent;

import com.pharogrammer.fedora.damanhour.homiversity.mvp.mvp.MainMVP;
import com.pharogrammer.fedora.damanhour.homiversity.mvp.view.activity.ContainerActivity;
import com.pharogrammer.fedora.damanhour.homiversity.mvp.view.activity.MainActivity;
import com.pharogrammer.fedora.damanhour.homiversity.utils.Constants;

/**
 * Created by fedora on 13/02/18.
 */

public class MainPresenter implements MainMVP.Presenter {

    private MainMVP.View view;
    private Context context;

    public MainPresenter(Context context) {
        this.context = context;
    }

    @Override
    public void setView(MainMVP.View view) {
        this.view = view;
    }

    @Override
    public void setVisibility(int index) {
        if (view != null && index<7){
            view.controlVisibility(index);

        }
    }

    @Override
    public Intent getIntent(int key) {
        Intent intent = null;
        switch (key){
            case Constants.CEUTICAL_THEO:
                intent =  new Intent(context, ContainerActivity.class);
                intent.putExtra("KEY", Constants.CEUTICAL_THEO);
                break;

            case Constants.CEUTICAL_THEO_PRACTICAL:
                intent =  new Intent(context, ContainerActivity.class);
                intent.putExtra("KEY", Constants.CEUTICAL_THEO_PRACTICAL);
                break;
            case Constants.CEUTICAL_MATERIAL:
                intent =  new Intent(context, ContainerActivity.class);
                intent.putExtra("KEY", Constants.CEUTICAL_MATERIAL);
                break;

            case Constants.CEUTICAL_RECORD:
                intent =  new Intent(context, ContainerActivity.class);
                intent.putExtra("KEY", Constants.CEUTICAL_RECORD);
                break;

            case Constants.BIO_THEO:
                intent =  new Intent(context, ContainerActivity.class);
                intent.putExtra("KEY", Constants.BIO_THEO);
                break;

            case Constants.BIO_THEO_PRACTICAL:
                intent =  new Intent(context, ContainerActivity.class);
                intent.putExtra("KEY", Constants.BIO_THEO_PRACTICAL);
                break;

            case Constants.BIO_MATERIAL:
                intent =  new Intent(context, ContainerActivity.class);
                intent.putExtra("KEY", Constants.BIO_MATERIAL);
                break;

            case Constants.BIO_RECORD:
                intent =  new Intent(context, ContainerActivity.class);
                intent.putExtra("KEY", Constants.BIO_RECORD);
                break;

            case Constants.INSTRO_THEO:
                intent =  new Intent(context, ContainerActivity.class);
                intent.putExtra("KEY", Constants.INSTRO_THEO);
                break;

            case Constants.INSTRO_THEO_PRACTICAL:
                intent =  new Intent(context, ContainerActivity.class);
                intent.putExtra("KEY", Constants.INSTRO_THEO_PRACTICAL);
                break;

            case Constants.INSTRO_MATERIAL:
                intent =  new Intent(context, ContainerActivity.class);
                intent.putExtra("KEY", Constants.INSTRO_MATERIAL);
                break;

            case Constants.INSTRO_RECORD:
                intent =  new Intent(context, ContainerActivity.class);
                intent.putExtra("KEY", Constants.INSTRO_RECORD);
                break;

            case Constants.PHARMA_THEO:
                intent =  new Intent(context, ContainerActivity.class);
                intent.putExtra("KEY", Constants.PHARMA_THEO);
                break;

            case Constants.PHARMA_THEO_PRACTICAL:
                intent =  new Intent(context, ContainerActivity.class);
                intent.putExtra("KEY", Constants.PHARMA_THEO_PRACTICAL);
                break;

            case Constants.PHARMA_MATERIAL:
                intent =  new Intent(context, ContainerActivity.class);
                intent.putExtra("KEY", Constants.PHARMA_MATERIAL);
                break;

            case Constants.PHARMA_RECORD:
                intent =  new Intent(context, ContainerActivity.class);
                intent.putExtra("KEY", Constants.PHARMA_RECORD);
                break;

            case Constants.KINETICS_THEO:
                intent =  new Intent(context, ContainerActivity.class);
                intent.putExtra("KEY", Constants.KINETICS_THEO);
                break;

            case Constants.KINETICS_THEO_PRACTICAL:
                intent =  new Intent(context, ContainerActivity.class);
                intent.putExtra("KEY", Constants.KINETICS_THEO_PRACTICAL);
                break;

            case Constants.KINETICS_MATERIAL:
                intent =  new Intent(context, ContainerActivity.class);
                intent.putExtra("KEY", Constants.KINETICS_MATERIAL);
                break;

            case Constants.KINETICS_RECORD:
                intent =  new Intent(context, ContainerActivity.class);
                intent.putExtra("KEY", Constants.KINETICS_RECORD);
                break;

            case Constants.IMMU_THEO:
                intent =  new Intent(context, ContainerActivity.class);
                intent.putExtra("KEY", Constants.IMMU_THEO);
                break;

            case Constants.IMMU_MATERIAL:
                intent =  new Intent(context, ContainerActivity.class);
                intent.putExtra("KEY", Constants.IMMU_MATERIAL);
                break;

            case Constants.IMMU_RECORD:
                intent =  new Intent(context, ContainerActivity.class);
                intent.putExtra("KEY", Constants.IMMU_RECORD);
                break;

            case Constants.PRACTICE_THEO:
                intent =  new Intent(context, ContainerActivity.class);
                intent.putExtra("KEY", Constants.PRACTICE_THEO);
                break;

            case Constants.PRACTICE_MATERIAL:
                intent =  new Intent(context, ContainerActivity.class);
                intent.putExtra("KEY", Constants.PRACTICE_MATERIAL);
                break;

            case Constants.PRACTICE_RECORD:
                intent =  new Intent(context, ContainerActivity.class);
                intent.putExtra("KEY", Constants.PRACTICE_RECORD);
                break;

        }
        return intent;
    }

    @Override
    public void determineFragment() {

    }
}
