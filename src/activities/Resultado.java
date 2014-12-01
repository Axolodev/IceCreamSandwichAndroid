package activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.myfitnessapplication.R;
import com.facebook.UiLifecycleHelper;
import com.facebook.widget.FacebookDialog;

public class Resultado extends Activity {

	private String deporteS;
	private Long tiempoS;
	private Button buMenu;
	private Double calori;
	private TextView tvCalorias, tvDeporte, tvTiempo;// 3 tiempo,4 calorias,6
														// deporte
	private UiLifecycleHelper uiHelper; // Usado para compartir datos en
										// Facebook

	private ImageButton buCompartirFace;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_resultado);
		buMenu = (Button) findViewById(R.id.button1);
		tvCalorias = (TextView) findViewById(R.id.textView4);
		tvDeporte = (TextView) findViewById(R.id.textView6);
		tvTiempo = (TextView) findViewById(R.id.textView3);
		buCompartirFace = (ImageButton) findViewById(R.id.buShareFacebook);

		Bundle datos = getIntent().getExtras();
		if (datos != null) {
			deporteS = datos.getString("deporte");
			tiempoS = datos.getLong("tiempo");
			double tempCalorias = datos.getDouble("calorias");

			tvCalorias.setText(String.valueOf(tempCalorias));

			tvDeporte.setText(deporteS);
			String tiempos = String.valueOf(tiempoS);
			tvTiempo.setText(tiempos);
		}

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
				/**
				 * Intent medi = new Intent(Resultado.this, MainActivity.class);
				 * medi.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				 * medi.putExtra("deporte", deporteS); medi.putExtra("calorias",
				 * calori); medi.putExtra("tiempo", tiempoS);
				 * 
				 * startActivity(medi);
				 **/

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
