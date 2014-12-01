package activities;

import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.example.myfitnessapplication.R;
import com.example.myfitnessapplication.Video;
import com.example.myfitnessapplication.VideoOperations;


public class Videos extends Activity {

	private final String DEPORTES[] = { "Correr", "Caminar", "Spinning",
			"Baloncesto", "Futbol", "Natacion", "Atletismo" };

	private Spinner spDeportes;
	private ImageButton ibBuscar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_videos);
		VideoOperations dao;
		dao=new VideoOperations(this);
		dao.open();
		Video video=new Video(1,"2", "3", "4");
		dao.addVideo(video);


		init();

		initListeners();
	}

	private void init() {

		List<String> myList = Arrays.asList(DEPORTES);

		spDeportes = (Spinner) findViewById(R.id.spiSeleccionDeporte);
		ibBuscar = (ImageButton) findViewById(R.id.ibVideosBuscar);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_dropdown_item, myList);
		// Apply the adapter to the spinner
		spDeportes.setAdapter(adapter);
	}

	private void initListeners() {
		ibBuscar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(Videos.this, Historial.class);
				intent.putExtra("Deporte",
						(String) spDeportes.getSelectedItem());
				startActivity(intent);
			}
		});

	}
}
