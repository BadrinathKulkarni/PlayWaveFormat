package com.format.wave;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class PlayWaveFormat extends Activity {

	private MediaPlayer mp = null;
	private Button play = null;
	private Button stop = null;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		// Find the Button from the xml-file.
		play = (Button) this.findViewById(R.id.cmd_play);
		stop = (Button) this.findViewById(R.id.stop);
		stop.setClickable(false);

		play.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				play.setClickable(false);
				stop.setClickable(true);
				try {
					Log.d("2", "2222");
					mp = MediaPlayer.create(PlayWaveFormat.this,
							R.raw.jaane_kyun);
					mp.setLooping(true);
					mp.start();
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		stop.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				play.setClickable(true);
				stop.setClickable(false);
				try {
					mp.stop();
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
	
	@Override
	protected void onDestroy() {
		mp.release();
		super.onDestroy();
	}
	
	
}