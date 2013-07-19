package com.example.theworks;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
//das ist ein test
public class The40SeriesActivity extends Activity implements OnClickListener{
	/********************Deklarieren der Objekte**********************/
	Button height;
	Button width;
	Button calc;
	TextView area;
	/********************************************************************/
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		width = (Button) findViewById(R.id.button1);
		height = (Button) findViewById(R.id.button2);
		calc = (Button) findViewById(R.id.button3);
		area = (TextView) findViewById(R.id.textView1);
		
		height.setOnClickListener(this);
		width.setOnClickListener(this);
		calc.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		//sendet einen Intent an die Klasse Numbers
		Intent intent = new Intent(this,Numbers.class);
		
		switch (v.getId()) {
		case R.id.button1:
			//width
			/**
			 * packt in den Intent (Korb den Wert width
			 */
			intent.putExtra("numbers", "width");
			startActivityForResult(intent, 1);
			break;
		case R.id.button2:
			//height
			/**
			 * packt in den Intent (Korb) den Wert height
			 */
			intent.putExtra("numbers", "height");
			startActivityForResult(intent, 1);
			break;
		case R.id.button3:
			//calc
			int a = Integer.valueOf(width.getText().toString());
			int b = Integer.valueOf(height.getText().toString());
			area.setText(a*b+"sq ft");
			break;
		default:
			break;
		}
		
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data){
		super.onActivityResult(requestCode, resultCode, data);
		
		/**
		 * Wertet den Intent aus, der aus der Activity Numbers kommt. 
		 * Je nachdem wechle Information gesendet wird die Zahl
		 * als Text auf dem Button dargestellt
		 */
		if(data.getExtras().containsKey("widthInfo")){
			width.setText(data.getStringExtra("widthInfo"));
		}
		if(data.getExtras().containsKey("heightInfo")){
			height.setText(data.getStringExtra("heightInfo"));
		}
	}


}
