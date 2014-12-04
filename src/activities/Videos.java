package activities;

import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.myfitnessapplication.R;
import com.example.myfitnessapplication.Video;
import com.example.myfitnessapplication.VideoOperations;

public class Videos extends Activity {

	private final String DEPORTES[] = { "Correr", "Caminar", "Spinning",
			"Baloncesto", "Futbol", "Natacion", "Atletismo" };

	private Spinner spDeportes;
	private Button ibBuscar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_videos);
		VideoOperations dao;
		dao = new VideoOperations(this);
		dao.open();
		Video video = new Video(1, "2", "3", "4");
		dao.addVideo(video);

		init();

		initListeners();
	}

	private void init() {

		List<String> myList = Arrays.asList(DEPORTES);

		spDeportes = (Spinner) findViewById(R.id.spiSeleccionDeporte);
		ibBuscar = (Button) findViewById(R.id.buBuscarVideos);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_dropdown_item, myList);
		// Apply the adapter to the spinner
		spDeportes.setAdapter(adapter);
	}

	private void initListeners() {
		ibBuscar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (isOnline()) {
					Intent intent = new Intent(Videos.this,
							ListaVideosActivity.class);
					intent.putExtra("Deporte",
							(String) spDeportes.getSelectedItem());
					startActivity(intent);
				} else {
					Toast.makeText(getApplicationContext(),
							"No Tienes Conexion a Internet", Toast.LENGTH_LONG)
							.show();
				}
			}

		});

	}

	public boolean isOnline() {
		ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo netInfo = cm.getActiveNetworkInfo();
		if (netInfo != null && netInfo.isConnectedOrConnecting()) {
			return true;
		}
		return false;
	}
}
