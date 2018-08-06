package com.pharogrammer.fedora.damanhour.homiversity.utils;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;

/**
 * Created by fedora on 16/02/18.
 */

public class FilesDownloader  {

    private String fileName;
    private String url;
    private Context context;
    private String ext;

    public FilesDownloader(Context context, String url, String fileName, String ext) {

        this.context = context;
        this.url = url;
        this.fileName = fileName;
        this.ext = ext;
    }

    public void startDownloading(){

        DownloadManager.Request r = new DownloadManager.Request(Uri.parse(url));

        // This put the download in the same Download dir the browser uses
        r.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, getFullFileName());

        // When downloading music and videos they will be listed in the player
        // (Seems to be available since Honeycomb only)
        r.allowScanningByMediaScanner();

        // Notify user when download is completed
        // (Seems to be available since Honeycomb only)
        r.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

        // Start download
        DownloadManager dm = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        dm.enqueue(r);
    }

    private String getFullFileName(){
        if (ext != null && ext.length() > 0 && !ext.equals("")){
            return this.fileName +"." + this.ext.trim();
        }else{
            return this.fileName;
        }

    }
}
