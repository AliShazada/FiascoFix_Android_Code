package fast.fyp.FiascoFix_Collector_Application;

import android.app.AlertDialog;


public class Caller_s extends Thread {
	public CallSoap_s cs;
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
			cs = new CallSoap_s();
			String resp = cs.Call_s(a, b);
			MySOAPCallActivity_second.rslt = resp;
		} catch (Exception ex) {
			MySOAPCallActivity_second.rslt = ex.toString();
		}
	}

}
