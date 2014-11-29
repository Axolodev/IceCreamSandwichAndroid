package com.example.myfitnessapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Videos extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_videos);
		VideoOperations dao;
		dao=new VideoOperations(this);
		dao.open();
		Video video=new Video("1","2", "3");
		dao.addVideo(video);
	}
}
