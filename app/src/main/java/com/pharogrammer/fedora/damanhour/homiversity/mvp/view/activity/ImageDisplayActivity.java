package com.pharogrammer.fedora.damanhour.homiversity.mvp.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.pharogrammer.fedora.damanhour.homiversity.R;
import com.pharogrammer.fedora.damanhour.homiversity.utils.HackyViewPager;
import com.pharogrammer.fedora.damanhour.homiversity.utils.adapter.ImageSliderAdapter;
import com.pharogrammer.fedora.damanhour.homiversity.utils.adapter.ImageUrls;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ImageDisplayActivity extends AppCompatActivity {

    @BindView(R.id.vp_images)
    HackyViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_display);
        ButterKnife.bind(this);


        if (getIntent().getExtras() != null){
            Bundle bundle = getIntent().getExtras();
            ImageUrls images = bundle.getParcelable("key");

            ImageSliderAdapter adapter = new ImageSliderAdapter(this,images.getImageList());
            viewPager.setAdapter(adapter);

        }

    }
}
