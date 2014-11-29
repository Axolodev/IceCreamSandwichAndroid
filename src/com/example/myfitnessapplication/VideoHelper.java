package com.example.myfitnessapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class VideoHelper extends SQLiteOpenHelper{
	private static final int DATABASE_VERSION=1;
	private static final String DATABASE_NAME="videosDB.db";
	public static final String TABLE_VIDEOS="videos";
	public static final String COLUMN_ID="_id";
	public static final String COLUMN_DEPORTE="deporte";
	public static final String COLUMN_URL="url";
	public static final String COLUMN_NOMBRE="nombre";
	public VideoHelper(Context context) {
		super(context,DATABASE_NAME,null,DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String CREATE_DEPORTES_TABLE
		="CREATE TABLE " + TABLE_VIDEOS+
				"("+ COLUMN_ID+ " INTEGER PRIMARY KEY,"+
						COLUMN_DEPORTE +" TEXT,"+
						COLUMN_NOMBRE +" TEXT,"+
				COLUMN_URL +" TEXT"+");";
				db.execSQL(CREATE_DEPORTES_TABLE);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		Log.w(VideoHelper.class.getName(),"Upgrading database from version "+ oldVersion+"to"+newVersion+", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS" + TABLE_VIDEOS);
		onCreate(db);
		
	}

}

 