package fast.fyp.FiascoFix_Collector_Application;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Select_provinces extends Activity{
	
	RadioButton b1,b2,b3,b4,b5;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.select_provinces_layout);
		
		b1=(RadioButton)findViewById(R.id.radio_islamabad);
		
		b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent i = new Intent();

				i.setClass(Select_provinces.this, donation_status_activity.class);
				startActivity(i);
				
			}
		});
		
		b2=(RadioButton)findViewById(R.id.radio_PUN);
		
		b2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent i = new Intent();

				i.setClass(Select_provinces.this, Cities.class);
				startActivity(i);
				
			}
		});
		
		
		b3=(RadioButton)findViewById(R.id.radio_sindth);
		
		b3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent();

				i.setClass(Select_provinces.this, City_Sindth.class);
				startActivity(i);
			}
		});
		
		b4=(RadioButton)findViewById(R.id.radio_KPK);
		
		b4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent();

				i.setClass(Select_provinces.this, City_KPK.class);
				startActivity(i);
			}
		});
		
		b5=(RadioButton)findViewById(R.id.radio_balochistan);
		
		b5.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent();
				i.setClass(Select_provinces.this, City_Bal.class);
				startActivity(i);
			}
		});
				
	}

}
