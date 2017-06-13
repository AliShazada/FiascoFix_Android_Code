package fast.fyp.FiascoFix_Collector_Application;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main_menu extends Activity {

	Button b1, b2,b3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_menu_layout);
		b2 = (Button) findViewById(R.id.view_collection_status);
		b1=(Button) findViewById(R.id.Distribution_Plan);
		b3=(Button)findViewById(R.id.distribution_Status);

		b2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent i = new Intent();

				i.setClass(Main_menu.this, Select_provinces.class);
				startActivity(i);

			}
		});
		
		
		b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent i = new Intent();

				i.setClass(Main_menu.this, MainActivity2.class);
				startActivity(i);
			
				
				
			}
		});
		
		b3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent i = new Intent();

				i.setClass(Main_menu.this,  FormActivity.class);
				startActivity(i);
			
				
			}
		});
	}

}
