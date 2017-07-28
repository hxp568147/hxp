package com.example.diyviewutils;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	@ViewInjeck(R.id.tv1)
	private TextView tv1;
	
	@ViewInjeck(R.id.tv2)
	private TextView tv2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ViewUtils.injeck(this);
		
		Log.d("mainActivity", ""+tv1.getText());
		Log.d("mainActivity", ""+tv2.getText());
	}
	
	@onClick({R.id.bt1,R.id.bt2})
	public void button(View view){
		Toast.makeText(this, "hahahahahahah", Toast.LENGTH_SHORT).show();
		Toast.makeText(this, "hahahahahahah", Toast.LENGTH_SHORT).show();
		Toast.makeText(this, "hahahahahahah", Toast.LENGTH_SHORT).show();
	}
	
}
