package fast.fyp.FiascoFix_Collector_Application;


import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class FormActivity extends Activity {
	TextView t1,t2,t3,t4,t5,t6;
	EditText e1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.form);
		
		t1=(TextView)findViewById(R.id.textView2_name_donor);
		t2=(TextView)findViewById(R.id.textView2_address_donor_houseno);
		t3=(TextView)findViewById(R.id.textView2_address_donor_Street_sector);
		t4=(TextView)findViewById(R.id.textView2_address_donor_city);
		t5=(TextView)findViewById(R.id.TextView02_donor_phone);
		t6=(TextView)findViewById(R.id.TextView_donation_catregory);
		e1=(EditText)findViewById(R.id.editText_donation_quantity);
		
		Bundle extras = getIntent().getExtras();
		//addres_record = extras.getString("STRING_I_NEED");
		 
		String a = extras.getString("donor_data");
		
		
		String words[] = a.split("@");

		for (int i = 0; i < words.length; i++) {
			
			if(i==0)
			{
				t1.setText(words[i]);
			}
			else if (i==1)
			{
				t2.setText(words[i]);
			}
			else if (i==2)
			{
				t3.setText(words[i]);
			}
			else if (i==3)
			{
				t4.setText(words[i]);
			}
			else if (i==4)
			{
				t5.setText(words[i]);
			}
			else if (i==5)
			{
				t6.setText(words[i]);
			}
			else if (i==6)
			{
				e1.setText(words[i]);
			}
				
		}
		
		
		
		e1.setText("5");
		
		
		
		
	}

}
