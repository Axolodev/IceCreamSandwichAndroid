package com.example.myfitnessapplication;

import java.util.List;



import android.content.Context;
import android.widget.ArrayAdapter;

public class ListViewAdapter extends ArrayAdapter<Deporte> {
	private Context context;
	int layoutResourceId;
	public ListViewAdapter(Context context, int resource, List<Deporte> objects) {
		super(context, resource, objects);
		// TODO Auto-generated constructor stub
	}


}
