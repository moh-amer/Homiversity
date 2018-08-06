package com.pharogrammer.fedora.damanhour.homiversity.utils.adapter;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;

import com.pharogrammer.fedora.damanhour.homiversity.R;
import com.pharogrammer.fedora.damanhour.homiversity.http.model.Lecture;
import com.pharogrammer.fedora.damanhour.homiversity.utils.FilesDownloader;

import java.io.IOException;
import java.util.List;

/**
 * Created by fedora on 16/02/18.
 */

public class RecordsRecyclerAdapter extends RecyclerView.Adapter<RecordsRecyclerAdapter.RecordHolder>
        implements MediaPlayer.OnPreparedListener , MediaController.MediaPlayerControl {

    private List<Lecture> lectureList;
    private Context context;
    MediaPlayer player;
    MediaController controller;
    Handler handler;
    View rootView;

    public RecordsRecyclerAdapter(Context context , List<Lecture> lectureList) {
        this.lectureList = lectureList;
        this.context = context;
        handler = new Handler();
        controller = new MediaController(context);

        //view of the Activity used mainly to anchor the media controller
        rootView = ((Activity)context).getWindow().getDecorView().findViewById(android.R.id.content);

        prepareMediaPlayer();


    }

    @Override
    public RecordHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.record_row, parent , false);
        return new RecordHolder(view);
    }

    @Override
    public void onBindViewHolder(RecordHolder holder, int position) {

        final Lecture currentLec = lectureList.get(position);
        holder.tvTitle.setText(currentLec.getTitle());
        holder.tvDescription.setText(currentLec.getLecturer());
       // final String uri = lectureList.get(position).getUrls().get(0);

        //doesn't make sense till now
        holder.itemView.getRootView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    controller.show();

            }
        });

        holder.btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //This action for play Button

                if ( currentLec.getFileUrl() != null && ! currentLec.getFileUrl().isEmpty()){

                    if (player.isPlaying()) {
                        controller.hide();
                        player.stop();
                        player.release();
                    }
                    prepareMediaPlayer();

                    try {
                        player.setDataSource(context, Uri.parse(currentLec.getFileUrl()));
                        player.prepare();


                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else {
                    Toast.makeText(context, "There's no Record to play", Toast.LENGTH_SHORT).show();
                }

            }
        });


        holder.btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentLec.getFileUrl() != null && !currentLec.getFileUrl().isEmpty()) {

                    FilesDownloader downloader = new FilesDownloader(context,
                            currentLec.getFileUrl(),
                            currentLec.getTitle(),
                            currentLec.getExt());
                    downloader.startDownloading();

                    Toast.makeText(context, "Downloading", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(context, "Failed to get Downloading link", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }


    @Override
    public int getItemCount() {
        return lectureList.size();
    }





    private void prepareMediaPlayer(){

        player = new MediaPlayer();
        player.setOnPreparedListener(this);


    }



    @Override
    public void onPrepared(MediaPlayer mp) {
        controller.setMediaPlayer(this);
        controller.setAnchorView(rootView.findViewById(R.id.root_id_container));
        handler.post(new Runnable() {
            @Override
            public void run() {
                controller.setEnabled(true);
                controller.show();
                player.start();
            }
        });

    }


    @Override
    public void start() {
        player.start();
    }

    @Override
    public void pause() {
        player.pause();
    }

    @Override
    public int getDuration() {
        return player.getDuration();
    }

    @Override
    public int getCurrentPosition() {
        return player.getCurrentPosition();
    }

    @Override
    public void seekTo(int pos) {
        player.seekTo(pos);
    }

    @Override
    public boolean isPlaying() {
        return player.isPlaying();
    }

    @Override
    public int getBufferPercentage() {
        return 0;
    }

    @Override
    public boolean canPause() {
        return true;
    }

    @Override
    public boolean canSeekBackward() {
        return true;
    }

    @Override
    public boolean canSeekForward() {
        return true;
    }

    @Override
    public int getAudioSessionId() {
        return 0;
    }






    //this method called from fragment onDestroy method
    public void onFinishRecycler(){
        controller.hide();
        player.stop();
        player.release();
    }

    public static class RecordHolder  extends RecyclerView.ViewHolder{
        TextView tvTitle,tvDescription;
        AppCompatImageButton btnPlay, btnDownload;

        public RecordHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_record_title);
            tvDescription = itemView.findViewById(R.id.tv_record_description);
            btnPlay = itemView.findViewById(R.id.btn_record_play);
            btnDownload = itemView.findViewById(R.id.btn_record_download);
        }
    }
}
