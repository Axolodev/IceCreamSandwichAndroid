package com.example.myfitnessapplication;

import socialnetwork.FacebookFragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class Configuracion extends FragmentActivity {

	private FacebookFragment facebookFrag;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if(savedInstanceState == null) {
			// Add the fragment on initial activity setup
	        facebookFrag = new FacebookFragment();
	        getSupportFragmentManager()
	        .beginTransaction()
	        .add(android.R.id.content, facebookFrag)
	        .commit();
		} else {
	        // Or set the fragment from restored state info
	        facebookFrag = (FacebookFragment) getSupportFragmentManager()
	        .findFragmentById(android.R.id.content);
	    }
	}
}
