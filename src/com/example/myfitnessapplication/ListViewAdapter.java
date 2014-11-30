package com.example.myfitnessapplication;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ListViewAdapter extends ArrayAdapter<Deporte> {

	private Context context;
	int layoutResourceId;
	List<Deporte> listaEquipos;

	public ListViewAdapter(Context context, int resource,
			List<Deporte> listaEquipos) {
		super(context, resource, listaEquipos);
		this.context = context;
		this.listaEquipos = listaEquipos;
		this.layoutResourceId = resource;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;
		if (row == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = inflater.inflate(layoutResourceId, parent, false);
		}

		TextView calorias = (TextView) row.findViewById(R.id.calorias_val);
		TextView duracion = (TextView) row.findViewById(R.id.duracion_val);
		TextView fecha = (TextView) row.findViewById(R.id.fecha_val);
		TextView deporte = (TextView) row.findViewById(R.id.deporte_val);
		Deporte equipo = listaEquipos.get(position);

		calorias.setText(String.valueOf((equipo.getCalorias())));
		duracion.setText(String.valueOf((equipo.getTiempo())));
		fecha.setText(String.valueOf((equipo.getFecha())));
		deporte.setText(String.valueOf((equipo.getDeporte())));

		return row;

	}

}