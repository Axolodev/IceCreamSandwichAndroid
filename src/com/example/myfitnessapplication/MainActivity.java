package com.example.myfitnessapplication;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	Button medicion;
	Button historial;
	Button configuracion;
	Button videos;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		medicion=(Button)findViewById(R.id.button1);
		historial=(Button)findViewById(R.id.button3);
		configuracion=(Button)findViewById(R.id.button4);
		videos=(Button)findViewById(R.id.button5);
		
		medicion.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent medi=new Intent(MainActivity.this, Medicion.class);
				startActivity(medi);
			}
		});
		
		historial.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent hist=new Intent(MainActivity.this, Historial.class);
				startActivity(hist);
			}
		});
		
		configuracion.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent confi=new Intent(MainActivity.this, Configuracion.class);
				startActivity(confi);
			}
		});
		
		videos.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent vi=new Intent(MainActivity.this, Videos.class);
				startActivity(vi);
			}
		});
	}

}
