package activities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myfitnessapplication.Deporte;
import com.example.myfitnessapplication.DeporteOperations;
mport com.example.myfitnessapplication.Preferences;
import com.example.myfitnessapplication.R;
import com.facebook.UiLifecycleHelper;
import com.facebook.widget.FacebookDialog;

public class Resultado extends Activity {

	String deporteS;
	Long tiempoS,tiempomin,tiempohr;
        Button buMenu;
	//private Double calori;
	//Button menu;
	Long calori=(long) 1;
	TextView calorias,deporte,tiempo;//3 tiempo,4 calorias,6 deporte
	DeporteOperations dao;
	int peso, altura;
	


	//TextView tvCalorias, tvDeporte, tvTiempo;// 3 tiempo,4 calorias,6
														// deporte
	private UiLifecycleHelper uiHelper; // Usado para compartir datos en
										// Facebook

	private ImageButton buCompartirFace;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_resultado);
		buMenu = (Button) findViewById(R.id.button1);
		dao = new DeporteOperations(this);
		dao.open();
		/*tvCalorias = (TextView) findViewById(R.id.textView4);
		tvDeporte = (TextView) findViewById(R.id.textView6);
		tvTiempo = (TextView) findViewById(R.id.textView3);
		buCompartirFace = (ImageButton) findViewById(R.id.buShareFacebook);
		peso = Preferences.getPeso(this);
		altura = Preferences.getAltura(this);

		Bundle datos = getIntent().getExtras();
		if (datos != null) {
			deporteS = datos.getString("deporte");
			tiempoS = datos.getLong("tiempo");
			double tempCalorias = datos.getDouble("calorias");

			tvCalorias.setText(String.valueOf(tempCalorias));

			tvDeporte.setText(deporteS);
			String tiempos = String.valueOf(tiempoS);
			tvTiempo.setText(tiempos);
		}*/
		buCompartirFace = (ImageButton) findViewById(R.id.buShareFacebook);
calorias=(TextView)findViewById(R.id.textView4);
		deporte=(TextView)findViewById(R.id.textView6);
		String deporteF;
		tiempo=(TextView)findViewById(R.id.textView3);
		StringBuffer stringBuffer = new StringBuffer();    
        try {  
            //Attaching BufferedReader to the FileInputStream by the help of InputStreamReader  
            BufferedReader inputReader = new BufferedReader(new InputStreamReader(  
                    openFileInput("deporteSel")));  
            String inputString;  
            //Reading data line by line and storing it into the stringbuffer                
            while ((inputString = inputReader.readLine()) != null) {  
                stringBuffer.append(inputString);  
            }  
              
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        deporteF=stringBuffer.toString();
		
		Bundle datos=getIntent().getExtras();
		if (datos!=null){
			deporteS=datos.getString("deporte");
			tiempoS=datos.getLong("segundos");
			tiempomin=datos.getLong("minutos");
			tiempohr=datos.getLong("horas");
			
			String tiempos=String.valueOf(tiempoS);
			String hrs=String.valueOf(tiempohr);
			String min=String.valueOf(tiempomin);
			tiempo.setText(hrs+":"+min+":"+tiempos); 
		}
		deporte.setText(deporteF);
		Toast.makeText(getApplicationContext(), "deporte:" + deporteF, Toast.LENGTH_LONG).show();
	
	if (deporteF.equals("Spinning")){
		
		calori=(long) ((peso * 2.2) * (tiempomin+(tiempohr*60)) * .053);
		Toast.makeText(getApplicationContext(), "tiempo:" + calori, Toast.LENGTH_LONG).show();
	}
	else if(deporteF.equals("Caminar")){
		Toast.makeText(getApplicationContext(), "tiempo1:" + calori, Toast.LENGTH_LONG).show();
		calori=(long) ((peso * 2.2) * (tiempomin+(tiempohr*60))* .062);
		Toast.makeText(getApplicationContext(), "tiempo:" + calori, Toast.LENGTH_LONG).show();
		
	}
	else if (deporteF.equals("Baloncesto")){
		calori=(long) ((peso * 2.2) * (tiempomin+(tiempohr*60)) * .045);
		Toast.makeText(getApplicationContext(), "tiempo:" + calori, Toast.LENGTH_LONG).show();
		
	}
	else if(deporteF.equals("Futbol")){
		calori=(long) ((peso * 2.2) * (tiempomin+(tiempohr*60))* .061);
		Toast.makeText(getApplicationContext(), "tiempo:" + calori, Toast.LENGTH_LONG).show();
		
	}
	
	else{
		calori=(long) ((peso * 2.2) * (tiempomin+(tiempohr*60))* .142);
	}
		String caloriasF=String.valueOf(calori);
		calorias.setText(caloriasF);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String date = sdf.format(new Date());

		Deporte deporte = new Deporte(deporteF, date, calori, tiempoS+tiempomin*60+tiempohr*3600);
		dao.addDeporte(deporte);
		/*menu.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent medi=new Intent(Resultado.this, MainActivity.class);
				medi.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				medi.putExtra("deporte", deporteS);
				medi.putExtra("calorias", calori);
				medi.putExtra("tiempo", tiempoS);
				
				startActivity(medi);
			}
		});*/



		uiHelper = new UiLifecycleHelper(this, null);
		uiHelper.onCreate(savedInstanceState);

		initListeners();

	}

	/**
	 * Metodo usado para inicializar los Listeners de la Activity
	 */
	private void initListeners() {

		buMenu.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {


				Intent medi=new Intent(Resultado.this, MainActivity.class);
				medi.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				medi.putExtra("deporte", deporteS);
				medi.putExtra("calorias", calori);
				medi.putExtra("tiempo", tiempoS);
				
				startActivity(medi);

				

				finish();
			}
		});

		buCompartirFace.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String time = String.valueOf(tiempoS);

				FacebookDialog shareDialog = new FacebookDialog.ShareDialogBuilder(
						Resultado.this)
						.setLink("https://developers.facebook.com/android")
						.setDescription(
								"¡Acabo de hacer " + time + " de ejercicio!")
						.build();
				uiHelper.trackPendingDialogCall(shareDialog.present());

			}
		});

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		uiHelper.onActivityResult(requestCode, resultCode, data,
				new FacebookDialog.Callback() {
					@Override
					public void onError(FacebookDialog.PendingCall pendingCall,
							Exception error, Bundle data) {
						Log.e("Activity",
								String.format("Error: %s", error.toString()));
					}

					@Override
					public void onComplete(
							FacebookDialog.PendingCall pendingCall, Bundle data) {
						Log.i("Activity", "Success!");
					}
				});
	}

	@Override
	protected void onResume() {
		super.onResume();
		uiHelper.onResume();
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		uiHelper.onSaveInstanceState(outState);
	}

	@Override
	public void onPause() {
		super.onPause();
		uiHelper.onPause();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		uiHelper.onDestroy();
	}
}
