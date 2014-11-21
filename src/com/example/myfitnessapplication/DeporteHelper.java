package com.example.myfitnessapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DeporteHelper extends SQLiteOpenHelper{
	private static final int DATABASE_VERSION=1;
	private static final String DATABASE_NAME="deporteDB.db";
	public static final String TABLE_DEPORTES="deportes";
	public static final String COLUMN_ID="_id";
	public static final String COLUMN_DEPORTE="deporte";
	public static final String COLUMN_TIEMPO="tiempo";
	public static final String COLUMN_FECHA="fecha";
	public static final String COLUMN_CALORIAS="calorias";
	public static final String COLUMN_HORA="hora";
	public DeporteHelper(Context context) {
		super(context,DATABASE_NAME,null,DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String CREATE_DEPORTES_TABLE
		="CREATE TABLE " + TABLE_DEPORTES+
				"("+ COLUMN_ID+ " INTEGER PRIMARY KEY,"+
						COLUMN_DEPORTE +" TEXT,"+
						COLUMN_FECHA +" DATETIME,"+
						COLUMN_CALORIAS +" DOUBLE,"+
				COLUMN_TIEMPO +" DOUBLE"+");";
				db.execSQL(CREATE_DEPORTES_TABLE);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		Log.w(DeporteHelper.class.getName(),"Upgrading database from version "+ oldVersion+"to"+newVersion+", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS" + TABLE_DEPORTES);
		onCreate(db);
		
	}

}

 