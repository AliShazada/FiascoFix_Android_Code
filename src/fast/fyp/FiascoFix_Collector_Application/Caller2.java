package fast.fyp.FiascoFix_Collector_Application;

import android.app.AlertDialog;


public class Caller2 extends Thread {
	public CallSoap2 cs;
	// old 
	//public int a, b;
	// ==============
	
	// new 
	public String a;
	
	// ======================
	protected AlertDialog ad;

	public void run() {
		try {
			cs = new CallSoap2();
			String resp = cs.Call2(a);
			MySOAPCallActivity2.rslt = resp;
		} catch (Exception ex) {
			MySOAPCallActivity2.rslt = ex.toString();
		}
	}

}
