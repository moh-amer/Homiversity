package com.pharogrammer.fedora.damanhour.homiversity.utils.adapter;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.pharogrammer.fedora.damanhour.homiversity.R;
import com.pharogrammer.fedora.damanhour.homiversity.http.model.Lecture;
import com.pharogrammer.fedora.damanhour.homiversity.utils.FilesDownloader;

import java.util.List;

/**
 * Created by fedora on 16/02/18.
 */

public class MaterialRecyclerAdapter extends RecyclerView.Adapter<MaterialRecyclerAdapter.MaterialHolder> {

    private List<Lecture> lectureList;
    private Context context;

    public MaterialRecyclerAdapter(Context context , List<Lecture> lectureList) {
        this.lectureList = lectureList;
        this.context = context;
    }

    @Override
    public MaterialRecyclerAdapter.MaterialHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.material_row, parent , false);
        return new MaterialHolder(view);
    }

    @Override
    public void onBindViewHolder(MaterialHolder holder, int position) {

        final Lecture currentLec = lectureList.get(position);
        holder.tvTitle.setText(currentLec.getTitle());
        holder.tvOwner.setText(currentLec.getLecturer());
        holder.btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FilesDownloader downloader = new FilesDownloader(context,
                        currentLec.getFileUrl(),
                        currentLec.getTitle(),
                        currentLec.getExt() );

                downloader.startDownloading();

                Toast.makeText(context, "Downloading...", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return lectureList.size();
    }

    public static class MaterialHolder  extends RecyclerView.ViewHolder{
        TextView tvTitle,tvOwner;
        AppCompatImageButton btnDownload;
        public MaterialHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_material_title);
            tvOwner = itemView.findViewById(R.id.tv_material_owner);
            btnDownload = itemView.findViewById(R.id.btn_material_download);
        }
    }
}
