package fast.fyp.FiascoFix_Collector_Application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;

public class MySOAPCallActivity2 extends Activity {

	public static String rslt = "";
	/** Called when the activity is first created. */
	SimpleAdapter simpleAdpt;
	String addres_record;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cities_xml);

		final AlertDialog ad = new AlertDialog.Builder(this).create();

		initList();
		ListView lv = (ListView) findViewById(R.id.listView);
		// registerForContextMenu(lv);

		// simpleAdpt = new SimpleAdapter(this, planetsList,
		// android.R.layout.simple_list_item_1, new String[] { "planet" },
		// new int[] { android.R.id.text1 });

		simpleAdpt = new SimpleAdapter(this, planetsList, R.layout.mm,
				new String[] { "planet" }, new int[] { R.id.textView1 });

		lv.setAdapter(simpleAdpt);
		
		lv.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parentAdapter, View view,
					int position,

					long id) {
				//888888888888888888888//
				
				 try
				 {
				 TextView clickedView = (TextView) view;
				 String a=clickedView.getText().toString();
				
				 
				 rslt="START";
				 Caller c=new Caller(); c.a=a;
				  c.ad=ad;
				 c.join(); c.start();
				 while(rslt=="START") {
				 try {
				 Thread.sleep(10);
				 }catch(Exception ex) {
				 }
				 }				
				
				 ad.setTitle("Login Succeed");
				 ad.setMessage("Hello "+rslt);
				
//				 String addresses="House No 12, Street 100, F11/1.|House No 16, Street 101, F11/1.|House No 41, Street 102, F11/1.";
//				
//				 Intent i = new Intent(MySOAPCallActivity2.this, Cities.class);
//				 String keyIdentifer = null;
//				 i.putExtra("STRING_I_NEED",addresses);
//				 startActivity(i);
				 
				
				 }catch(Exception ex) {
				 ad.setTitle("Error!"); ad.setMessage(ex.toString());
				 }
				 ad.show();
				
				//888888888888888888888//

				
				//
				// Toast.makeText(
				// Cities.this,
				// "Item with id [" + id + "] - Position [" + position
				// + "] - Planet [" + clickedView.getText() + "]",
				// Toast.LENGTH_SHORT).show();

			}

		});

		registerForContextMenu(lv);

		

	}

	List<Map<String, String>> planetsList = new ArrayList<Map<String, String>>();

	private void initList() {

		// We populate the planets

		// Bundle extras = getIntent().getExtras();
		// addres_record = extras.getString("addresses");

		addres_record = "House No 12, Street 100, F11/1.@House No 16, Street 101, F11/1.@House No 41, Street 102, F11/1.";

		String words[] = addres_record.split("@");

		for (int i = 0; i < words.length; i++) {
			planetsList.add(createPlanet("planet", words[i]));
		}

	}

	private HashMap<String, String> createPlanet(String key, String name) {

		HashMap<String, String> planet = new HashMap<String, String>();

		planet.put(key, name);

		return planet;

	}

	// We want to create a context Menu when the user long click on an item
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {

		super.onCreateContextMenu(menu, v, menuInfo);
		AdapterContextMenuInfo aInfo = (AdapterContextMenuInfo) menuInfo;

		// We know that each row in the adapter is a Map
		@SuppressWarnings("rawtypes")
		HashMap map = (HashMap) simpleAdpt.getItem(aInfo.position);

		menu.setHeaderTitle("Options for " + map.get("planet"));
		menu.add(1, 1, 1, "Details");
		menu.add(1, 2, 2, "Delete");

	}

	// This method is called when user selects an Item in the Context menu
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		int itemId = item.getItemId();
		// Implements our logic
		Toast.makeText(this, "Item id [" + itemId + "]", Toast.LENGTH_SHORT)
				.show();
		return true;
	}
}
