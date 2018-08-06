package com.pharogrammer.fedora.damanhour.homiversity.utils.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.pharogrammer.fedora.damanhour.homiversity.R;
import com.pharogrammer.fedora.damanhour.homiversity.http.model.Lecture;
import com.pharogrammer.fedora.damanhour.homiversity.mvp.view.activity.ImageDisplayActivity;
import com.pharogrammer.fedora.damanhour.homiversity.utils.FilesDownloader;

import java.util.List;

/**
 * Created by fedora on 14/02/18.
 */

public class AllTeamsRecyclerAdapter extends RecyclerView.Adapter<AllTeamsRecyclerAdapter.LectureHolder> {


    private List<Lecture> lectures;
    private Context context;
    public AllTeamsRecyclerAdapter(Context context , List<Lecture> lectures) {

        this.context = context;
        this.lectures = lectures;
    }

    @Override
    public LectureHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lecture_row,parent, false);
        return new LectureHolder(view);
    }

    @Override
    public void onBindViewHolder(LectureHolder holder,int position) {

        final Lecture currentLec = lectures.get(position);
        holder.tvTitle.setText(lectures.get(position).getTitle());
        holder.tvLecturer.setText(lectures.get(position).getLecturer());
        holder.cvLecture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context , ImageDisplayActivity.class);
                Bundle bundle = new Bundle();
                ImageUrls urls = new ImageUrls();
                if (currentLec.getUrls().size() > 0){
                    urls.setImageList(currentLec.getUrls());
                    bundle.putParcelable("key",urls);
                    intent.putExtras(bundle);
                }
                context.startActivity(intent);
            }
        });

       holder.btnDownload.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               FilesDownloader downloader = new FilesDownloader(context,
                       currentLec.getFileUrl(),
                       currentLec.getTitle(),
                       currentLec.getExt());

               downloader.startDownloading();

               Toast.makeText(context, "Downloading...", Toast.LENGTH_LONG).show();
           }
       });

    }

    @Override
    public int getItemCount() {
        return lectures.size();
    }

    public static class LectureHolder extends RecyclerView.ViewHolder{

        TextView tvTitle,tvLecturer;
        AppCompatImageButton btnDownload;
        CardView cvLecture;
        public LectureHolder(View itemView) {
            super(itemView);

            cvLecture = itemView.findViewById(R.id.cv_lecture_teams);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvLecturer = itemView.findViewById(R.id.tv_lecturer);
            btnDownload = itemView.findViewById(R.id.btn_teams_pdf_download);
        }
    }
}
