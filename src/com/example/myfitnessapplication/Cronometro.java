package com.example.myfitnessapplication;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class Cronometro extends Activity {
	Chronometer focus;
	Button iniciar, detener, reiniciar, guardar, playlist;
	long timeWhenStopped = 0;
	DeporteOperations dao;
	double tiempo;
	String deporteselec;
	double calorias;
	
	Calendar c = Calendar.getInstance(); 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cronometro);
		dao=new DeporteOperations(this);
		dao.open();
		focus = (Chronometer) findViewById(R.id.chronometer1);
		iniciar=(Button) findViewById(R.id.button1);
		detener=(Button) findViewById(R.id.button2);
		reiniciar=(Button) findViewById(R.id.button4);
		guardar=(Button) findViewById(R.id.button3);
		playlist=(Button) findViewById(R.id.button5);
		/*
		 * Bundle datos= getIntent().getExtras();
		if (datos!=null){
			String usernameString=datos.getString("username");
			String passwordString=datos.getString("password");
			usernameTV.setText(usernameString);
			username2TV.setText(usernameString);
			passwordTV.setText(passwordString);
			
		}
		 * 
		 * */
		Bundle datos= getIntent().getExtras();
		if (datos!=null){
			deporteselec=datos.getString("deporte");
		}

		iniciar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				focus.setBase(SystemClock.elapsedRealtime() + timeWhenStopped); 
				focus.start();
			}
		});
		
		detener.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				timeWhenStopped= focus.getBase() - SystemClock.elapsedRealtime();
				focus.stop();
			}
		});
		reiniciar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				timeWhenStopped = 0;
				focus.setBase(SystemClock.elapsedRealtime());
				
			}
		});
		guardar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				timeWhenStopped= focus.getBase() - SystemClock.elapsedRealtime();
				focus.stop();
				tiempo=(double)timeWhenStopped;
				if (deporteselec.equals("Correr")){
					calorias=(70 * 2.2) * tiempo * .142;
					
				}
				else if (deporteselec.equals("Spinning")){
					calorias=(70 * 2.2) * tiempo * .053;
				}
				else if(deporteselec.equals("Caminar")){
					calorias=(70 * 2.2) * tiempo * .062;
					
				}
				else if (deporteselec.equals("Baloncesto")){
					calorias=(70 * 2.2) * tiempo * .045;
					
				}
				else if(deporteselec.equals("Futbol")){
					calorias=(70 * 2.2) * tiempo * .061;
					
				}
				else if (deporteselec.equals("Natacion")){
					calorias=(70 * 2.2) * tiempo * .142;
					
				}
				else if (deporteselec.equals("Atletismo")){
					calorias=(70 * 2.2) * tiempo * .142;
					
				}
				newDeporte(v);
				/*Intent guarda=new Intent(Cronometro.this,Resultado.class);
				guarda.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				guarda.putExtra("tiempo", timeWhenStopped);
				guarda.putExtra("deporte", deporteselec);
				startActivity(guarda);*/
				
				/*
				 * Intent dep=new Intent(Medicion.this, Cronometro.class);
				startActivity(dep);
				 * 
				 * */
			}
		});
		
		playlist.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent play=new Intent(Cronometro.this,Playlist.class);
				play.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				
				startActivity(play);
				
			}
		});
		
		
	}
	public void newDeporte(View view){
		//int quantity=Integer.parseInt(quantityBox.getText().toString());
		//String name=nameBox.getText().toString();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String date = sdf.format(new Date());
		
		Deporte deporte=new Deporte(deporteselec,date, calorias, tiempo);
		dao.addDeporte(deporte);
		//Toast.makeText(getApplicationContext(),	"Product added", Toast.LENGTH_SHORT).show();
		//nameBox.setText("");
		//quantityBox.setText("");
		}
}
