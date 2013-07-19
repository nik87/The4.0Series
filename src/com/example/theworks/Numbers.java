package com.example.theworks;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Numbers extends Activity implements OnClickListener {

	EditText number;
	Button sendInfo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.numbers);
		number = (EditText) findViewById(R.id.editText1);
		sendInfo = (Button) findViewById(R.id.button1);
		sendInfo.setOnClickListener(this);
	}


	@Override
	public void onClick(View v) {
		String s = number.getText().toString();
		Intent i = getIntent(); //findet die Klasse heraus die sie gestartet hat
		
		/**Wertet den gesendeten Intent aus mit dem Namen numbers und weißt diesen
		dem String msg zu, der im Weiteren dann aus gewertet wird und dann wieder
		zurück gesendet wird, mithilfe von widthInfo und heightInfo**/
		
		String msg = i.getStringExtra("numbers");
		if(msg.contentEquals("width")){
			i.putExtra("widthInfo", s);
			setResult(RESULT_OK,i);
			finish();
		}
		if(msg.contentEquals("height")){
			i.putExtra("heightInfo", s);
			setResult(RESULT_OK,i);
			finish();
		}
	}

}
