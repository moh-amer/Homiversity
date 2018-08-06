package com.pharogrammer.fedora.damanhour.homiversity.utils.adapter;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fedora on 15/02/18.
 */

public class ImageUrls implements Parcelable {

    private List<String> imageList;

    public ImageUrls() {
    }

    protected ImageUrls(Parcel in) {
        imageList = new ArrayList<>();
        in.readList(imageList,String.class.getClassLoader());
    }

    public static final Creator<ImageUrls> CREATOR = new Creator<ImageUrls>() {
        @Override
        public ImageUrls createFromParcel(Parcel in) {
            return new ImageUrls(in);
        }

        @Override
        public ImageUrls[] newArray(int size) {
            return new ImageUrls[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(imageList);
    }

    public List<String> getImageList() {
        return imageList;
    }

    public void setImageList(List<String> imageList) {
        this.imageList = imageList;
    }
}
