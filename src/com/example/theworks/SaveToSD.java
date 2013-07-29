package com.example.theworks;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

/***
 * 
 * @author niklas.knauer
 * Dies Funktioniert nur auf einem SmartPhone nicht im Emulator
 */

public class SaveToSD extends Activity implements OnClickListener{
	
	Button savePic;
	Button saveSound;
	EditText filename;
	boolean isSDAvail=false, isSDWriteable =false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.savetosd);
		savePic = (Button) findViewById(R.id.savePicture);
		saveSound =(Button)findViewById(R.id.saveSound);
		filename =(EditText)findViewById(R.id.filename);
		savePic.setOnClickListener(this);
		saveSound.setOnClickListener(this);
		checkSDStuff();
	}

	private void checkSDStuff() {
		// TODO Auto-generated method stub
		String state = Environment.getExternalStorageState();
		if(Environment.MEDIA_MOUNTED.equals(state)){
			//write
			isSDAvail = true;
			isSDWriteable =true;
		}else if(Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)){
			//read only
			isSDAvail = true;
			isSDWriteable =false;
		}else{
			//uh-oh
			isSDAvail = false;
			isSDWriteable =false;
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.savePicture:
			File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
			String name = filename.getText().toString();
			File file = new File(path, name + ".png");
			saveData(path, file, R.drawable.ic_launcher);
			break;
		case R.id.saveSound:
			File path2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
			String name2 = filename.getText().toString();
			File file2 = new File(path2, name2 + ".mp3");
			saveData(path2, file2,R.raw.gamemusic);
			break;
		}
	}

	private void saveData(File path, File file, int info) {
		Log.d("pic", "pic");
		if(isSDAvail && isSDWriteable){
			try {
				path.mkdirs();
				InputStream is = getResources().openRawResource(info);
				OutputStream os;
				os = new FileOutputStream(file);
				byte[] data = new byte[is.available()];
				is.read(data);
				os.write(data);
				is.close();
				os.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	}

}