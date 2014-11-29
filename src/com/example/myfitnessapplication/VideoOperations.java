package com.example.myfitnessapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;



public class VideoOperations {
	private SQLiteDatabase db;
	private VideoHelper dbHelper;
	public static final String TABLE_VIDEOS="videos";
	public static final String COLUMN_ID="_id";
	public static final String COLUMN_DEPORTE="deporte";
	public static final String COLUMN_NOMBRE="nombre";
	public static final String COLUMN_URL="url";
	public VideoOperations(Context context){
		dbHelper=new VideoHelper(context);
	}
	public void open()throws SQLException{
		db=dbHelper.getWritableDatabase();
	}
	
	public void addVideo(Video deporte){
		ContentValues values=new ContentValues();
		values.put(COLUMN_DEPORTE, deporte.getDeporte());
		values.put(COLUMN_URL, deporte.getURL());
		values.put(COLUMN_NOMBRE, deporte.getNombre());
		db.insert(TABLE_VIDEOS, null, values);
		
	}
	

	public Video findVideo(int id) {
		String query = "Select * FROM " + TABLE_VIDEOS + " WHERE "
				+ COLUMN_ID + " = \"" + id + "\"";
		Cursor cursor = db.rawQuery(query, null);
		Video equipo = new Video();
		if (cursor.moveToFirst()) {
			cursor.moveToFirst();
			equipo.setID(Integer.parseInt(cursor.getString(0)));
			equipo.setDeporte(cursor.getString(1));
			equipo.setNombre(cursor.getString(2));
			equipo.setURL(cursor.getString(3));
			cursor.close();
		} else {
			equipo = null;
		}
		return equipo;
	}
	
	public int numRows() {
		String query = "SELECT Count(*) FROM " + TABLE_VIDEOS;
		Cursor cursor = db.rawQuery(query, null);
		cursor.moveToFirst();
		return Integer.parseInt(cursor.getString(0));
		}



}
