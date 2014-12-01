package activities;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import auxiliares.AuxVideoURL;

import com.example.myfitnessapplication.R;

public class ListaVideosActivity extends Activity {

	private ListView lvVideos;
	private List<String> miLista;
	private String nombreDeporte;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista_videos);

		Bundle bundle = getIntent().getExtras();

		nombreDeporte = bundle.getString("Deporte");

		miLista = new ArrayList<String>();
		lvVideos = (ListView) findViewById(R.id.lvVerVideos);

		AuxVideoURL aux = new AuxVideoURL();

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				getApplicationContext(), android.R.layout.simple_list_item_1,
				aux.getLista(nombreDeporte));

		lvVideos.setAdapter(adapter);
		
		lvVideos.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {

			}
		});
	}

}
