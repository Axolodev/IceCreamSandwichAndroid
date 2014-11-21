package com.example.myfitnessapplication;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class Historial extends Activity {
	EditText busca;
	ListView lista;
	ListViewAdapter miAdaptador;
	DeporteOperations dao;
	Button buscar;
	List<Deporte> deportes;
	ArrayList<String> results = new ArrayList<String>();
	private String tableName = DeporteHelper.TABLE_DEPORTES;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_historial);
		lista=(ListView)findViewById(R.id.listView1);
		dao=new DeporteOperations(this);
		dao.open();
		deportes=new ArrayList<Deporte>();
		buscar=(Button)findViewById(R.id.button1);
		busca=(EditText)findViewById(R.id.editText1);
		
		for(int i = 1; i<dao.numRows()+1;i++){
			Deporte equipo = dao.findEquipo(i);
			if (equipo!=null)deportes.add(equipo);
			
			}
		miAdaptador = new ListViewAdapter(this.getBaseContext(),R.layout.row,deportes);
		lista.setAdapter(miAdaptador);
		
		OnClickListener registro= new OnClickListener(){
			public void onClick(View v){
				searchDeporte(v);
			}};
	}
	public void searchDeporte(View view){
		String name=busca.getText().toString();
		Deporte deporte= dao.findDeporte(name);
		/*
		 * 			peliculaID.setText(String.valueOf(pelicula.getID()));
			quantityBox.setText(String.valueOf(pelicula.getRanking()));
		 * 
		 * */
	}
}
