package activities;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.myfitnessapplication.Medicion;
import com.example.myfitnessapplication.R;

public class MainActivity extends Activity {

	Button medicion;
	Button historial;
	Button resumen;
	Button videos;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		medicion=(Button)findViewById(R.id.button1);
		historial=(Button)findViewById(R.id.button3);
		resumen=(Button)findViewById(R.id.button4);
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
		
		resumen.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent res=new Intent(MainActivity.this, ResumenActivity.class);
				startActivity(res);
			}
		});
		
		videos.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent vi=new Intent(MainActivity.this, Videos.class);
				startActivity(vi);
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.conf:
			Intent confi=new Intent(MainActivity.this, Configuracion.class);
			startActivity(confi);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	
	
/*
	@Override
	protected void onResume() {
	  super.onResume();

	  // Logs 'install' and 'app activate' App Events.
	  AppEventsLogger.activateApp(this);
	}
	
	@Override
	protected void onPause() {
	  super.onPause();

	  // Logs 'app deactivate' App Event.
	  AppEventsLogger.deactivateApp(this);
	}
	*/
}
