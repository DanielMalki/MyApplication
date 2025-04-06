package com.dmalki.myfirstapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "MusicPrefs";
    private static final String MUSIC_ON_KEY = "musicOn";
    private static final String CURRENT_SONG_INDEX_KEY = "currentSongIndex";

    Switch musicSwitch;
    Button nextSongButton;

    int[] songs = {
            R.raw.brr_brr_patapim,
            R.raw.crocodildo,
            R.raw.bombardiro,
            R.raw.tung_tung_tung_sahur,
            R.raw.lirili_larila,
            R.raw.tralalero_tralala,
            R.raw.trippi_tropi
    };
    int currentSongIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        musicSwitch = findViewById(R.id.musicSwitch);
        nextSongButton = findViewById(R.id.nextSongButton);

        // נטען את SharedPreferences
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        boolean musicOn = prefs.getBoolean(MUSIC_ON_KEY, false);
        int savedIndex = prefs.getInt(CURRENT_SONG_INDEX_KEY, 0);

        // נוודא שהאינדקס בטווח תקין
        if (savedIndex >= 0 && savedIndex < songs.length) {
            currentSongIndex = savedIndex;
        } else {
            currentSongIndex = 0;
        }

        musicSwitch.setChecked(musicOn);

        if (musicOn) {
            MusicManager.playMusic(this, songs[currentSongIndex]);
        }

        musicSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean(MUSIC_ON_KEY, isChecked);
            editor.apply();

            if (isChecked) {
                MusicManager.playMusic(this, songs[currentSongIndex]);
            } else {
                MusicManager.stopMusic();
            }
        });

        nextSongButton.setOnClickListener(v -> {
            currentSongIndex = (currentSongIndex + 1) % songs.length;

            SharedPreferences.Editor editor = prefs.edit();
            editor.putInt(CURRENT_SONG_INDEX_KEY, currentSongIndex);
            editor.apply();

            if (musicSwitch.isChecked()) {
                MusicManager.nextSong(this, songs[currentSongIndex]);
            }
        });
    }
}