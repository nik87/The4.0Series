package com.example.theworks;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class Reading extends Activity implements OnClickListener{
	
	Spinner spinner;
	TextView title, entry;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.reading);
		spinner = (Spinner)findViewById(R.id.spinner1);
		title = (TextView)findViewById(R.id.textView1);
		entry = (TextView)findViewById(R.id.textView2);
		getFilenames();
	}
	

	private void getFilenames() {
		// TODO Auto-generated method stub
		String[] filenames = getApplicationContext().fileList();
		List<String> list = new ArrayList<String>();
		for(int i = 0; i<filenames.length; i++){
			//Log.d("Filename", filenames[i]);
			list.add(filenames[i]);
		}
		
		ArrayAdapter<String> filenameAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, list);
		spinner.setAdapter(filenameAdapter);
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String selectedFile = String.valueOf(spinner.getSelectedItem());
		openFile(selectedFile);
	}


	private void openFile(String selectedFile) {
		// TODO Auto-generated method stub
		String value = "";
		FileInputStream fis;
		
		try {
			fis = openFileInput(selectedFile);
			byte[] input = new byte[fis.available()];
		while (fis.read(input) != -1) {
			value += new String(input);
		}
		fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		entry.setText(value);
	}

}
