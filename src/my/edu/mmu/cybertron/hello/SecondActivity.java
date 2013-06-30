package my.edu.mmu.cybertron.hello;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		// obtain the intent that starts this Activity
		Intent i = getIntent();
		// obtain a String from the intent with a specific key
		String name = i.getStringExtra("name");
		// obtain an integer from the intent with a specific key
		int year = i.getIntExtra("year", 0);
		((TextView)findViewById(R.id.textViewSecond)).setText(name + " " + year);
	}

}
