package com.example.myfitnessapplication;

import java.util.ArrayList;

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
	DeporteOperations dao;
	Button buscar;
	private ArrayList<String> results = new ArrayList<String>();
	private String tableName = DeporteHelper.TABLE_DEPORTES;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_historial);
		dao=new DeporteOperations(this);
		dao.open();
		lista=(ListView)findViewById(R.id.listView1);
		buscar=(Button)findViewById(R.id.button1);
		busca=(EditText)findViewById(R.id.editText1);
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
