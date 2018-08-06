package com.pharogrammer.fedora.damanhour.homiversity.utils.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;
import com.pharogrammer.fedora.damanhour.homiversity.R;

import java.util.List;

/**
 * Created by fedora on 15/02/18.
 */

public class ImageSliderAdapter extends PagerAdapter {

    private Context context;
    private List<String> images;
    private LayoutInflater inflater;

    public ImageSliderAdapter(Context context, List<String> images) {
        this.context = context;
        this.images = images;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.pager_layout, container, false);

        PhotoView photoView = view.findViewById(R.id.pv_images);

        Glide.with(context)
                .load(images.get(position))
                .into(photoView);

        container.addView(view);

        return view;
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view == object);
    }
}
