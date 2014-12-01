package activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.myfitnessapplication.Deporte;
import com.example.myfitnessapplication.DeporteOperations;
import com.example.myfitnessapplication.R;

public class ResumenActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_resumen);
		TextView calorias = (TextView) findViewById(R.id.calorias_id2);
		TextView duracion = (TextView) findViewById(R.id.tiempo_id2);
		TextView fecha = (TextView) findViewById(R.id.fecha_tag_id2);
		DeporteOperations dao;
		dao = new DeporteOperations(this);
		dao.open();
		Deporte equipo = dao.findEquipo(1);
		double caloriasSum = equipo.getCalorias();
		double duracionSum = equipo.getTiempo();
		fecha.setText("Inicio: " + equipo.getFecha());
		for (int i = 2; i < dao.numRows() + 1; i++) {
			equipo = dao.findEquipo(i);
			if (equipo != null) {
				caloriasSum += equipo.getCalorias();
				duracionSum += equipo.getTiempo();
			}

		}
		duracion.setText(String.valueOf(duracionSum));
		calorias.setText(String.valueOf(caloriasSum));
	}
}
