package activities;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import auxiliares.AuxiliarHistorial;

import com.example.myfitnessapplication.Deporte;
import com.example.myfitnessapplication.ListViewAdapter;
import com.example.myfitnessapplication.R;

public class Historial extends Activity {
	private EditText etBusca;
	private ListView lvLista;
	private ListViewAdapter miAdaptador;

	private Button buBuscar;
	private Button buRegresar;
	private Button buAvanzar;

	private AuxiliarHistorial auxiliar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_historial);

		init();

		initListeners();
	}

	/**
	 * Metodo utilizado para inicializar variables de la actividad
	 */
	private void init() {
		lvLista = (ListView) findViewById(R.id.listView1);

		buBuscar = (Button) findViewById(R.id.button1);
		etBusca = (EditText) findViewById(R.id.editText1);

		auxiliar = new AuxiliarHistorial(this);

		auxiliar.getDefaultView();

		setContent(auxiliar.getContent());
		
		buAvanzar = (Button) findViewById(R.id.buHistorialAvanzar);
		buRegresar = (Button) findViewById(R.id.buHistorialRegresar);
	}

	/**
	 * Metodo usado para inicializar listeners de la actividad
	 */
	private void initListeners() {
		buBuscar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String deporteName = etBusca.getText().toString();

				if (deporteName.matches("")) {
					auxiliar.getDefaultView();
					setContent(auxiliar.getContent());
				} else {
					auxiliar.cargaDeporte(deporteName);
					List<Deporte> temporal = auxiliar.getContent();
					if (temporal != null) {
						setContent(temporal);
					}
				}
			}
		});

		buAvanzar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (auxiliar.puedeAvanzar()) {
					auxiliar.avanzar();
					setContent(auxiliar.getContent());
				}
			}
		});

		buRegresar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (auxiliar.puedeRegresar()) {
					auxiliar.regresar();
					setContent(auxiliar.getContent());
				}
			}
		});

	}

	/**
	 * Metodo utilizado para definir el contenido que tendrá la ListView
	 * 
	 * @param myList
	 *            es el contenido que tendrá la ListView
	 */
	private void setContent(List<Deporte> myList) {
		miAdaptador = new ListViewAdapter(this.getBaseContext(), R.layout.row,
				myList);
		lvLista.setAdapter(miAdaptador);
	}

}
