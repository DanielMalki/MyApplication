package com.dmalki.myfirstapplication;

import android.content.Context;
import android.media.MediaPlayer;

public class MusicManager {
    private static MediaPlayer mediaPlayer;

    public static void playMusic(Context context, int songResId) {
        stopMusic(); // נוודא שלא מתנגנת כבר מוזיקה קודמת

        mediaPlayer = MediaPlayer.create(context, songResId);
        mediaPlayer.setLooping(true); // שהשיר יתנגן בלופ
        mediaPlayer.start();
    }

    public static void nextSong(Context context, int songResId) {
        playMusic(context, songResId);
    }

    public static void stopMusic() {
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    public static boolean isPlaying() {
        return mediaPlayer != null && mediaPlayer.isPlaying();
    }
}
