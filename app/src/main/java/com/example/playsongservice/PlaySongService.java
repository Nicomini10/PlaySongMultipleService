package com.example.playsongservice;

        import android.app.Service;
        import android.content.Intent;
        import android.media.MediaPlayer;
        import android.os.IBinder;

public class PlaySongService extends Service {

    private MediaPlayer mediaPlayer;
    int array_song = 0;


    public PlaySongService() {
    }

    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }


    @Override
    public void onCreate() {
        super.onCreate();

        final int[] songs = new int[4];

        songs[0] = R.raw.mysong4;
        songs[1] = R.raw.mysong2;
        songs[2] = R.raw.golf;
        songs[3] = R.raw.mysong;


        mediaPlayer = MediaPlayer.create(getApplicationContext(), songs[array_song]);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {

                array_song++;

                mediaPlayer.release();
                mediaPlayer = MediaPlayer.create(getApplicationContext(), songs[array_song]);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(this);


            }
        });

    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        mediaPlayer.start();

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        mediaPlayer.release();
        super.onDestroy();
    }
}
