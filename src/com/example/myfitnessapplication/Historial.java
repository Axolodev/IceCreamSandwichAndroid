package com.example.myfitnessapplication;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import auxiliares.AuxiliarHistorial;

public class Historial extends Activity {
	private EditText etBusca;
	private ListView lvLista;
	private ListViewAdapter miAdaptador;

	private Button buBuscar;

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

		setContent(auxiliar.getDefaultView());
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
					setContent(auxiliar.getDefaultView());
				} else {
					List<Deporte> temporal = auxiliar.cargaDeporte(deporteName);
					if (temporal != null) {
						setContent(temporal);
					}
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
