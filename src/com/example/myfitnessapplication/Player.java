package com.example.myfitnessapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class Player extends Activity {

	private WebView wbMiDisplay;

	private String miURL;

	private final String TAG = "PLAYER";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_player);

		Bundle bundle = getIntent().getExtras();

		miURL = bundle.getString("URL");

		init();
	}

	/**
	 * Metodo utilizado para inicializar variables globales de la
	 * <code>Activity</code>
	 */
	@SuppressLint("SetJavaScriptEnabled")
	private void init() {
		wbMiDisplay = (WebView) findViewById(R.id.wbMisVideos);

		WebSettings webSettings = wbMiDisplay.getSettings();
		webSettings.setJavaScriptEnabled(true);

		wbMiDisplay.setWebChromeClient(new WebChromeClient() {
		});
		
		wbMiDisplay.loadUrl(miURL);
		finish();
		Log.i(TAG, "miURL");
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// Check if the key event was the Back button and if there's history

		// If it wasn't the Back key or there's no web page history, bubble up
		// to the default
		// system behavior (probably exit the activity)
		return super.onKeyDown(keyCode, event);
	}

}
