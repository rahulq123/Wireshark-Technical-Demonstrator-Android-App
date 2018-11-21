package com.rahul.Wireshark;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

/**
 * Created by rahul on 24/04/2017.
 */


public class Advanced2 extends YouTubeBaseActivity {

    ImageButton b;
    ImageButton sharebutton;
    ImageButton advanced2download;
    DownloadManager downloadManager;
    private YouTubePlayerView youTubePlayerView;
    private YouTubePlayer.OnInitializedListener onInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.advanced2);

        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.advanced2player);
        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("qsUaB36CVDw");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };


        b = (ImageButton) findViewById(R.id.playadvanced2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                youTubePlayerView.initialize("AIzaSyBPtateu5TEC1IFHTAudFyFvDZCDF38o4M", onInitializedListener);

            }
        });


        sharebutton = (ImageButton) findViewById(R.id.Sbutton);
        sharebutton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String shareBody = "https://www.youtube.com/watch?v=qsUaB36CVDw";
                //String shareSub = "";
                //  myIntent.putExtra(Intent.EXTRA_SUBJECT,shareSub);
                myIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(myIntent, "Share using"));
            }

        });



        advanced2download = (ImageButton)findViewById(R.id.ADVANCED2download);
        advanced2download.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                Uri uri = Uri.parse("https://drive.google.com/uc?export=download&id=0BzjV_rigHRHQZy1ibGNVQkxVczQ");
                DownloadManager.Request request = new DownloadManager.Request(uri);
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                Long reference = downloadManager.enqueue(request);


            }
        });



    }
}
