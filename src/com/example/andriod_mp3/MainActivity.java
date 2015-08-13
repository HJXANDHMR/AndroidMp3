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
		// textView = (TextView) findViewById(R.id.textView3);
		mediaPlayer = MediaPlayer.create(this, R.raw.love);
		bt_start.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				if (!mediaPlayer.isPlaying()) {
					mediaPlayer.start(); // 开始播放
					int time = mediaPlayer.getDuration();
					// textView.setText(" " + time);
				}

			}

		});

		bt_pause.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (mediaPlayer.isPlaying()) {
					mediaPlayer.pause(); // 暂停播放
				}
			}
		});

		bt_again.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (mediaPlayer.isPlaying()) {
					mediaPlayer.reset(); // 停止播放
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
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
