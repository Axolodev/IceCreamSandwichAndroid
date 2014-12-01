package auxiliares;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.util.Log;

import com.example.myfitnessapplication.Deporte;
import com.example.myfitnessapplication.DeporteOperations;

public class AuxiliarHistorial {
	private DeporteOperations deporteOp;
	private List<Deporte> misDeportes;

	private int currPos;

	private final String TAG = "AuxiliarHistorial";

	public AuxiliarHistorial(Activity activity) {
		deporteOp = new DeporteOperations(activity);
		deporteOp.open();
	}

	public List<Deporte> cargaDeporte(String name) {
		currPos = 0;

		Deporte[] deporte = deporteOp.findDeporte(name);

		if (deporte == null) {
			return null;
		}
		misDeportes = new ArrayList<Deporte>();

		for (int i = 0; i < deporte.length; i++) {
			misDeportes.add(deporte[i]);
			Log.d(TAG, deporte.length + "");
		}

		return misDeportes;
	}

	public List<Deporte> getDefaultView() {
		currPos = 0;
		misDeportes = new ArrayList<Deporte>();

		for (int i = 1; i < deporteOp.numRows() + 1; i++) {
			Deporte equipo = deporteOp.findEquipo(i);
			if (equipo != null)
				misDeportes.add(equipo);
		}
		return misDeportes;
	}

	public boolean puedeRegresar() {
		Log.d(TAG, currPos - 10 + "");
		return currPos - 10 >= 0;
	}

	public boolean puedeAvanzar() {
		Log.d(TAG, currPos + 10 + "");
		return currPos + 10 < misDeportes.size();
	}

	public void avanzar() {
		currPos += 10;
		Log.v(TAG, currPos + " Avanza");
	}

	public void regresar() {
		currPos -= 10;
		Log.v(TAG, currPos + " Regresa");
	}

	public List<Deporte> getContent() {
		List<Deporte> temporal = new ArrayList<Deporte>();
		for (int i = currPos; i < misDeportes.size() && i < currPos + 10; i++) {
			temporal.add(misDeportes.get(i));
		}
		return temporal;
	}

}
