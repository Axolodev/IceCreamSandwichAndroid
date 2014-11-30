package com.example.myfitnessapplication;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DeporteOperations {
	private SQLiteDatabase db;
	private DeporteHelper dbHelper;
	public static final String TABLE_DEPORTES = "deportes";
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_DEPORTE = "deporte";
	public static final String COLUMN_TIEMPO = "tiempo";
	public static final String COLUMN_FECHA = "fecha";
	public static final String COLUMN_CALORIAS = "calorias";
	public final String TAG = "DeporteOperations";

	public DeporteOperations(Context context) {
		dbHelper = new DeporteHelper(context);
	}

	public void open() throws SQLException {
		db = dbHelper.getWritableDatabase();
	}

	public void addDeporte(Deporte deporte) {
		ContentValues values = new ContentValues();
		values.put(COLUMN_DEPORTE, deporte.getDeporte());
		values.put(COLUMN_FECHA, deporte.getFecha());
		values.put(COLUMN_CALORIAS, deporte.getCalorias());
		values.put(COLUMN_TIEMPO, deporte.getTiempo());
		db.insert(TABLE_DEPORTES, null, values);

	}

	@SuppressLint("SimpleDateFormat")
	public Deporte[] findDeporte(String nombreDeporte) {
		String query = "Select * FROM " + TABLE_DEPORTES + " WHERE "
				+ COLUMN_DEPORTE + " = \"" + nombreDeporte + "\"";
		Cursor cursor = db.rawQuery(query, null);
		int numberOfRows = cursor.getCount();
		Deporte[] deporte = new Deporte[numberOfRows];
		if (cursor.moveToFirst()) {
			int counter = 0;
			
			deporte[counter] = new Deporte();
			deporte[counter].setID(Integer.parseInt(cursor.getString(0)));
			
			deporte[counter].setDeporte(cursor.getString(1));
			deporte[counter].setFecha(cursor.getString(2));
			deporte[counter].setCalorias(Double.parseDouble(cursor
					.getString(3)));
			deporte[counter].setTiempo(Double.parseDouble(cursor
					.getString(4)));
			counter++;
			
			while (cursor.moveToNext()) {
				deporte[counter] = new Deporte();
				deporte[counter].setID(Integer.parseInt(cursor.getString(0)));
				
				deporte[counter].setDeporte(cursor.getString(1));
				deporte[counter].setFecha(cursor.getString(2));
				deporte[counter].setCalorias(Double.parseDouble(cursor
						.getString(3)));
				deporte[counter].setTiempo(Double.parseDouble(cursor
						.getString(4)));
				counter++;
			}
			cursor.close();
			return deporte;
		}
		return null;
	}

	public Deporte findEquipo(int id) {
		String query = "Select * FROM " + TABLE_DEPORTES + " WHERE "
				+ COLUMN_ID + " = \"" + id + "\"";
		Cursor cursor = db.rawQuery(query, null);
		Deporte equipo = new Deporte();
		if (cursor.moveToFirst()) {
			cursor.moveToFirst();
			equipo.setID(Integer.parseInt(cursor.getString(0)));
			equipo.setDeporte(cursor.getString(1));
			equipo.setFecha(cursor.getString(2));
			equipo.setCalorias(Double.parseDouble(cursor.getString(3)));
			equipo.setTiempo(Double.parseDouble(cursor.getString(4)));
			cursor.close();
		} else {
			equipo = null;
		}
		return equipo;
	}

	public int numRows() {
		String query = "SELECT Count(*) FROM " + TABLE_DEPORTES;
		Cursor cursor = db.rawQuery(query, null);
		cursor.moveToFirst();
		return Integer.parseInt(cursor.getString(0));
	}

}
/*
 * public class PeliculaOperations { private SQLiteDatabase db; private
 * PeliculaHelper dbHelper; public static final String
 * TABLE_PELICULAS="peliculas"; public static final String COLUMN_ID="_id";
 * public static final String COLUMN_NAME="name"; public static final String
 * COLUMN_RANKING="ranking";
 * 
 * public PeliculaOperations(Context context){ dbHelper=new
 * PeliculaHelper(context); } public void open()throws SQLException{
 * db=dbHelper.getWritableDatabase(); } public void close(){ db.close();
 * 
 * } public void addPelicula(Pelicula pelicula){ ContentValues values=new
 * ContentValues(); values.put(COLUMN_NAME, pelicula.getName());
 * values.put(COLUMN_RANKING, pelicula.getRanking()); db.insert(TABLE_PELICULAS,
 * null, values);
 * 
 * } public Pelicula findPelicula(String nombrePelicula){ String query=
 * "Select * FROM "
 * +TABLE_PELICULAS+" WHERE "+COLUMN_NAME+" = \""+nombrePelicula+"\"" ; Cursor
 * cursor=db.rawQuery(query, null); Pelicula pelicula=new Pelicula(); if
 * (cursor.moveToFirst()){ cursor.moveToFirst();
 * pelicula.setID(Integer.parseInt(cursor.getString(0)));
 * pelicula.setName(cursor.getString(1));
 * pelicula.setRanking(Integer.parseInt(cursor.getString(2))); cursor.close(); }
 * else{ pelicula=null; }
 * 
 * return pelicula; } public boolean deletePelicula(String nombrePelicula){
 * boolean result=false; String query="Select * FROM " + TABLE_PELICULAS +
 * " WHERE "+ COLUMN_NAME+ " = \""+nombrePelicula+ "\""; Cursor
 * cursor=db.rawQuery(query, null); Pelicula pelicula=new Pelicula(); if
 * (cursor.moveToFirst()){
 * pelicula.setID(Integer.parseInt(cursor.getString(0)));
 * db.delete(TABLE_PELICULAS, COLUMN_ID+" = ?", new
 * String[]{String.valueOf(pelicula.getID())}); cursor.close(); result=true; }
 * return result; }
 * 
 * 
 * }
 */
