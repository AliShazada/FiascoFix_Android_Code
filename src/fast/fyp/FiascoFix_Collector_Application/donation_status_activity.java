package fast.fyp.FiascoFix_Collector_Application;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class donation_status_activity extends Activity {

	RadioButton r1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_donation_status_xml);

		r1 = (RadioButton) findViewById(R.id.radio_sctr_F);

		r1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent i = new Intent();

				i.setClass(donation_status_activity.this,
						Sector_level_donaitons.class);
				startActivity(i);

			}
		});
	}

}
