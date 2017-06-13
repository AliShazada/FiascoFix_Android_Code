package fast.fyp.FiascoFix_Collector_Application;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MySOAPCallActivity extends Activity {

public static String rslt="";    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_collector);
        Button b1=(Button)findViewById(R.id.button1);
        final  AlertDialog ad=new AlertDialog.Builder(this).create();

        b1.setOnClickListener(new View.OnClickListener() {
  
            @Override public void onClick(View arg0) {
            // TODO Auto-generated method stub 

            try
            { 
                EditText ed1=(EditText)findViewById(R.id.user_name);
                EditText ed2=(EditText)findViewById(R.id.password_edit); 
                
                String a=ed1.getText().toString();
                
                String b=ed2.getText().toString();
                rslt="START"; 
                Caller c=new Caller(); c.a=a;
                c.b=b; c.ad=ad;
                c.join(); c.start();
                while(rslt=="START") {
                    try {
                        Thread.sleep(10); 
                    }catch(Exception ex) {
                    }
                }
                
//                if(rslt=="NO")
//                {
//                	ad.setTitle("Username/Password Not Found");
//                    ad.setMessage("Enter Again"); 
//                }
//                else if(rslt=="YES")
             //   {
                	ad.setTitle("Login Succeed");
                    ad.setMessage("Hello "+rslt); 
                    
                    String temp1=rslt.toString();
                    
                    Toast.makeText(getApplicationContext(), temp1, 
                    		   Toast.LENGTH_LONG).show();
                    //Log.d("TCP", rslt);
                    
                   String addresses="House No 12, Street 100, F11/1.|House No 16, Street 101, F11/1.|House No 41, Street 102, F11/1.";
                   String login="shahzada";
                   Intent i = new Intent(MySOAPCallActivity.this, MySOAPCallActivity_second.class);   
                    String keyIdentifer  = null;
                   i.putExtra("STRING_I_NEED",rslt);
                   startActivity(i);
              //  }
                
            }catch(Exception ex) {
                ad.setTitle("Error!"); ad.setMessage(ex.toString());
            }
            ad.show(); 
        } });
    }
}
