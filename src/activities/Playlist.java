package activities;

import java.io.IOException;

import android.app.Activity;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myfitnessapplication.R;

public class Playlist extends Activity {
	private String[] mAudioPath;
	private MediaPlayer mMediaPlayer;
	private String[] mMusicList;


	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_playlist);

	    mMediaPlayer = new MediaPlayer();

	    ListView mListView = (ListView) findViewById(R.id.listView1);

	    mMusicList = getAudioList();

	    ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(this,
	    android.R.layout.simple_list_item_1, mMusicList);
	    mListView.setAdapter(mAdapter);

	    mListView.setOnItemClickListener(new OnItemClickListener() {

	    @Override
	    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
	    long arg3) {
	    try {
	        playSong(mAudioPath[arg2]);
	    } catch (IllegalArgumentException e) {
	        e.printStackTrace();
	    } catch (IllegalStateException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    }
	   });
	}

	private String[] getAudioList() {
	    final Cursor mCursor = getContentResolver().query(
	            MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
	            new String[] { MediaStore.Audio.Media.DISPLAY_NAME, MediaStore.Audio.Media.DATA }, null, null,
	            "LOWER(" + MediaStore.Audio.Media.TITLE + ") ASC");

	    int count = mCursor.getCount();

	    String[] songs = new String[count];
	    String[] mAudioPath = new String[count];
	    int i = 0;
	    if (mCursor.moveToFirst()) {
	        do {
	            songs[i] = mCursor.getString(mCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DISPLAY_NAME));
	            mAudioPath[i] = mCursor.getString(mCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA));
	            i++;
	        } while (mCursor.moveToNext());
	    }   

	    mCursor.close();

	    return songs;
	}
private void playSong(String path) throws IllegalArgumentException,
IllegalStateException, IOException {

Log.d("ringtone", "playSong :: " + path);

mMediaPlayer.reset();
mMediaPlayer.setDataSource(path);       
//mMediaPlayer.setLooping(true);
mMediaPlayer.prepare();
mMediaPlayer.start();
}}