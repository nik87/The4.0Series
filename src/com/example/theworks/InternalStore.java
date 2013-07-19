package com.example.theworks;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class InternalStore extends Activity implements OnClickListener {

	Button save;
	EditText filename, entry;
	String FILENAME, JOUR; 
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.internal_store);
		save = (Button) findViewById(R.id.button1);
		save.setOnClickListener(this);
		filename = (EditText) findViewById(R.id.editText1);
		entry = (EditText) findViewById(R.id.editText2);
	}


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		FILENAME = filename.getText().toString();
		if(FILENAME.contentEquals("")){
			FILENAME = "UNTILTLED";
		}
		JOUR = entry.getText().toString();
		try {
			FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
			fos.write(JOUR.getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
