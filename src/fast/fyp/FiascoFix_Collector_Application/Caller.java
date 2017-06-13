package fast.fyp.FiascoFix_Collector_Application;

import android.app.AlertDialog;


public class Caller extends Thread {
	public CallSoap cs;
	// old 
	//public int a, b;
	// ==============
	
	// new 
	public String a;
	public String b;
	// ======================
	protected AlertDialog ad;

	public void run() {
		try {
			cs = new CallSoap();
			String resp = cs.Call(a, b);
			MySOAPCallActivity.rslt = resp;
		} catch (Exception ex) {
			MySOAPCallActivity.rslt = ex.toString();
		}
	}

}
