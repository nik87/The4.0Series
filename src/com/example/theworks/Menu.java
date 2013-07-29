package com.example.theworks;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;


public class Menu extends Activity implements OnClickListener {

	String activities[] = { "ST", "SETTINGS", "INTERNALSTORE", "READING", "SAVETOSD" };;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id = v.getId();
		for (int i = 0; i < activities.length; i++) {
			if (id == getResources().getIdentifier("b" + i, "id",
					"com.example.theworks")) {
				Intent intent = new Intent("com.example.theworks."
						+ activities[i]);
				startActivity(intent);
			}
		}

	}
}

