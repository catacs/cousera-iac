package app.coursera.multiweb;


import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;

public class Jabberwocky extends Activity {

	private WebView myWebView;
	private MediaPlayer scarry;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jabberwocky);
		myWebView = (WebView) findViewById(R.id.webView1);
		myWebView.getSettings().setBuiltInZoomControls(true);
		// Open asset/jabberwocky.html
		myWebView.loadUrl("file:///android_asset/jabberwocky.html");
		//http://es.wikipedia.org/wiki/Jabberwocky

	}
	
	@Override 
	protected void onResume() { 
	  scarry = MediaPlayer.create(this, R.raw.scarry_sound);
	  scarry.setLooping(true);
	  scarry.start();
	  super.onResume(); 
	}
	
	@Override 
	protected void onPause() {
		scarry.stop(); 
		scarry.release(); 
	 	super.onPause(); 
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	// The onKeyDown code is from
	// http://developer.android.com/guide/webapps/webview.html
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// Check if the key event was the Back button and if there's history
		if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
			myWebView.goBack();
			return true;
		}
		// If it wasn't the Back key or there's no web page history, bubble up
		// to the default
		// system behavior (probably exit the activity)
		return super.onKeyDown(keyCode, event);
	}
	
	public void loadWikipedia(View view) 
	{
		myWebView.loadUrl("http://en.wikipedia.org/wiki/Jabberwocky");
	}
	
	public void loadBeastImage(View view) 
	{
		myWebView.loadUrl("file:///android_asset/jabberwocky_beast.html");
	}
}
