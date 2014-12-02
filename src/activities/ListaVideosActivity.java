package activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import auxiliares.AuxVideoURL;

import com.example.myfitnessapplication.Player;
import com.example.myfitnessapplication.R;

public class ListaVideosActivity extends Activity {

	private ListView lvVideos;
	private String nombreDeporte;
	AuxVideoURL aux;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista_videos);

		Bundle bundle = getIntent().getExtras();

		nombreDeporte = bundle.getString("Deporte");

		lvVideos = (ListView) findViewById(R.id.lvVerVideos);

		aux = new AuxVideoURL();

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				getApplicationContext(), android.R.layout.simple_list_item_1,
				aux.getLista(nombreDeporte));

		lvVideos.setAdapter(adapter);
		
		lvVideos.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				String miURL = aux.getVideoURL(arg2, nombreDeporte);
				Intent intent = new Intent(ListaVideosActivity.this, Player.class);
				intent.putExtra("URL", miURL);
				startActivity(intent);

			}
		});
	}

}
