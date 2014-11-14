package com.example.myfitnessapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Resultado extends Activity {

	String deporteS;
	Long tiempoS;
	Button menu;
	Double calori;
	TextView calorias,deporte,tiempo;//3 tiempo,4 calorias,6 deporte

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_resultado);
		menu=(Button)findViewById(R.id.button1);
		calorias=(TextView)findViewById(R.id.textView4);
		deporte=(TextView)findViewById(R.id.textView6);
		tiempo=(TextView)findViewById(R.id.textView3);
		/*
		 * Bundle datos= getIntent().getExtras();
		if (datos!=null){
			String usernameString=datos.getString("username");
			String passwordString=datos.getString("password");
			usernameTV.setText(usernameString);
			username2TV.setText(usernameString);
			passwordTV.setText(passwordString);
			
		}
		 */
		
		Bundle datos=getIntent().getExtras();
		if (datos!=null){
			deporteS=datos.getString("deporte");
			tiempoS=datos.getLong("tiempo");
			deporte.setText(deporteS);
			String tiempos=String.valueOf(tiempoS);
			tiempo.setText(tiempos); 
		}
		
		menu.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent medi=new Intent(Resultado.this, MainActivity.class);
				medi.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				medi.putExtra("deporte", deporteS);
				medi.putExtra("calorias", calori);
				medi.putExtra("tiempo", tiempoS);
				
				startActivity(medi);
			}
		});
		
		
	}
}
