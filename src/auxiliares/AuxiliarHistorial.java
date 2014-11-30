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

	private final String TAG = "AuxiliarHistorial";
	
	public AuxiliarHistorial(Activity activity) {
		deporteOp = new DeporteOperations(activity);
		deporteOp.open();
	}

	public List<Deporte> cargaDeporte(String name) {
		
		
		Deporte[] deporte = deporteOp.findDeporte(name);
		
		if(deporte == null){
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
		misDeportes = new ArrayList<Deporte>();

		for (int i = 1; i < deporteOp.numRows() + 1; i++) {
			Deporte equipo = deporteOp.findEquipo(i);
			if (equipo != null)
				misDeportes.add(equipo);
		}
		return misDeportes;
	}
}
