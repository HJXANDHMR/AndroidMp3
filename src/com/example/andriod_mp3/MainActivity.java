package com.example.andriod_mp3;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	private Button bt_start;
	private Button bt_pause;
	private Button bt_again;
        private Button bt_gittest
	private MediaPlayer mediaPlayer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		bt_start = (Button) findViewById(R.id.start);
		bt_pause = (Button) findViewById(R.id.pause);
		bt_again = (Button) findViewById(R.id.again);
		mediaPlayer = MediaPlayer.create(this, R.raw.love);
		bt_start.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (!mediaPlayer.isPlaying()) {
					mediaPlayer.start();
					int time = mediaPlayer.getDuration();
				}
			}

		});

		bt_pause.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (mediaPlayer.isPlaying()) {
					mediaPlayer.pause(); 
				}
			}
		});

		bt_again.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (mediaPlayer.isPlaying()) {
					mediaPlayer.reset(); 
					mediaPlayer = MediaPlayer.create(MainActivity.this,
							R.raw.love);
				}
			}
		});
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (mediaPlayer != null) {
			mediaPlayer.stop();
			mediaPlayer.release();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
