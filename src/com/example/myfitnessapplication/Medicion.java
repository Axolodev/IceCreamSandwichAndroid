package com.example.myfitnessapplication;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import activities.Cronometro;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.content.Context;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Medicion extends Activity {

	RadioButton actividad;
	RadioGroup deporte;
	Button iniciar;
	String deporteSeleccionado;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_medicion);
		deporte=(RadioGroup)findViewById(R.id.radioDeporte);
		iniciar=(Button)findViewById(R.id.button2);
		iniciar.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int selectedId = deporte.getCheckedRadioButtonId();
				actividad = (RadioButton) findViewById(selectedId);
				//deporteSeleccionado= actividad.getText().toString();
if (actividad!=null){
				deporteSeleccionado= actividad.getText().toString();}
				else {
					deporteSeleccionado="Correr";
				}
				FileOutputStream fos;  
                try {  
                 fos = openFileOutput("deporteSel", Context.MODE_PRIVATE);  
                 //default mode is PRIVATE, can be APPEND etc.  
                 fos.write(deporteSeleccionado.getBytes());
                 fos.close();  
                }
                catch (FileNotFoundException e) {e.printStackTrace();}  
                catch (IOException e) {e.printStackTrace();}  
				Toast.makeText(getApplicationContext(), "deporte: " + deporteSeleccionado, Toast.LENGTH_LONG).show();
				Intent dep=new Intent(Medicion.this, Cronometro.class);
				dep.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				dep.putExtra("deporte", deporteSeleccionado);
				startActivity(dep);
				finish();
				
			}
			
		});
		
	}
}
