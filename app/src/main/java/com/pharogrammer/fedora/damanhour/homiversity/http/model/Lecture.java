package com.pharogrammer.fedora.damanhour.homiversity.http.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Lecture {

    @SerializedName("lec_id")
    @Expose
    private String lecId;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("lecturer")
    @Expose
    private String lecturer;
    @SerializedName("team")
    @Expose
    private String team;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("file_url")
    @Expose
    private String fileUrl;
    @SerializedName("ext")
    @Expose
    private String ext;
    @SerializedName("urls")
    @Expose
    private List<String> urls = null;

    public String getLecId() {
        return lecId;
    }

    public void setLecId(String lecId) {
        this.lecId = lecId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

}
