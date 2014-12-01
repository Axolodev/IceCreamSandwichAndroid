package com.example.myfitnessapplication;

import socialnetwork.FacebookFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Configuracion extends FragmentActivity {

	private FacebookFragment facebookFrag;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_configuracion);
		final EditText altura =(EditText) findViewById(R.id.altura_val1);
		final EditText peso =(EditText) findViewById(R.id.peso_val2);
		Button save = (Button) findViewById(R.id.guardar_conf_button1);
		altura.setText(Integer.toString(Prefereces.getAltura(this)));
		peso.setText(Integer.toString(Prefereces.getPeso(this)));
		
		final OnClickListener registro = new OnClickListener(){
        	@Override
        	public void onClick(View v){
        		if(altura.getText()!=null && peso.getText()!=null){
        			Prefereces.setPeso(getApplicationContext(),Integer.parseInt((peso.getText().toString())));
        			Prefereces.setAltura(getApplicationContext(),Integer.parseInt((altura.getText().toString())));
        			Toast.makeText(Configuracion.this, "peso: " + Integer.toString(Prefereces.getPeso(Configuracion.this)) + "alt: " + Integer.toString(Prefereces.getAltura(Configuracion.this)), Toast.LENGTH_LONG).show();
        		}
        		else Toast.makeText(Configuracion.this, "No dejes campos vacios", Toast.LENGTH_LONG).show();
        		
       
        	}
        };
		save.setOnClickListener(registro);
		
		/*
		 * CON ESTO NO PODIA HACER NADA CON LA VISTA, CHECAR QUE HACE
		 * 
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
	    */
	}
}
