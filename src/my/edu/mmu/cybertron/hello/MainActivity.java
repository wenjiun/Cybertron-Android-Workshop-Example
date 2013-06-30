package my.edu.mmu.cybertron.hello;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	// super refers to the super class 
    	// which in this case is the Activity
    	// onCreate() callback in the Activity class will be called
        super.onCreate(savedInstanceState);
        
        // set the first screen to display the design in 
        // res/layout/activity_main.xml
        setContentView(R.layout.activity_main);
        
        // identify the 3 UI widgets in the screen
        // an EditText (Text Field), TextView (Label) and a Button
        final EditText editTextInput = (EditText)findViewById(R.id.editTextInput);
        final TextView textViewGreeting = (TextView)findViewById(R.id.textViewGreeting);   					
        Button buttonSubmit = (Button)findViewById(R.id.buttonSubmit);
        
        // register an anonymous OnClickListener to the button
    	buttonSubmit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// get the text the user enter into the EditText
				String name = editTextInput.getText().toString();
				// check the text the user enter 
				if(name.equals("Yap")) {
					textViewGreeting.setText("Hello " + name);
					// The intent to start the SecondActivity
					Intent i = new Intent(MainActivity.this, SecondActivity.class);
					// put a String into the intent with a specific key					
					i.putExtra("name", name);
					// put an integer into the intent with a specific key
					i.putExtra("year", 2013);
					// will start the Second Activity
					startActivity(i);
				} else {
					textViewGreeting.setText("Wrong user");
				}
			}
		});
    }
    


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu from /res/menu/main.xml 
    	// this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    // onOptionsItemSelected will be called whenever the user
    // click on an action in the ActionBar (the top bar)
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// check the ID of the ActionBar item the user click
		if(item.getItemId()==R.id.action_exit) {
			// pop up an dialog box with title, message
			// and two buttons
			new AlertDialog.Builder(MainActivity.this)
			.setTitle(R.string.app_name)
			.setMessage(R.string.are_you_sure_you_want_to_quit_)
			.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// finish is to kill this current activity
					finish();						
				}
			})
			// null in the 
			.setNegativeButton(R.string.cancel, null)
			.show();
			
		}		
		return super.onOptionsItemSelected(item);
	}
    
    
}











