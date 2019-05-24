package pl.kowalski.bookweb.activities;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import pl.kowalski.bookweb.R;

public class PlayActivity extends AppCompatActivity {


    private MediaPlayer mp;

    private Button start;
    private Button stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        start = findViewById(R.id.playButton);
        stop = findViewById(R.id.stopButton);

        try {
            mp = new MediaPlayer();
            mp.setDataSource("http://www.bajki-zasypianki.pl/pliki/amelka-i-jej-zaczarowana-noc.mp3");
            mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    start.setEnabled(true);
                    stop.setEnabled(true);
                }
            });
            mp.prepareAsync();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void onStartClick(View view) {
        mp.start();
    }

    public void onStopClick(View view) {
        if (mp.isPlaying()) {
            mp.stop();
        }
    }

}
