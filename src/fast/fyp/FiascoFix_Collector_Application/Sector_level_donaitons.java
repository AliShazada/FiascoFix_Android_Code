package fast.fyp.FiascoFix_Collector_Application;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;

public class Sector_level_donaitons extends Activity {

	Button b1;
	SimpleAdapter simpleAdpt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.donor_add_xml);
		initList();
		ListView lv = (ListView) findViewById(R.id.listView);
		// registerForContextMenu(lv);

		// simpleAdpt = new SimpleAdapter(this, planetsList,
		// android.R.layout.simple_list_item_1, new String[] { "planet" },
		// new int[] { android.R.id.text1 });

		simpleAdpt = new SimpleAdapter(this, planetsList, R.layout.mm2,
				new String[] { "planet" }, new int[] { R.id.textView1 });

		lv.setAdapter(simpleAdpt);

		lv.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parentAdapter, View view,
					int position,

					long id) {

				TextView clickedView = (TextView) view;

				if (clickedView.getText() == "Attock") {

					Toast.makeText(Sector_level_donaitons.this, "ali jljlj",
							Toast.LENGTH_SHORT).show();
					Intent i = new Intent();

					i.setClass(Sector_level_donaitons.this, Zone.class);
					startActivity(i);
				}
				//
				// Toast.makeText(
				// Cities.this,
				// "Item with id [" + id + "] - Position [" + position
				// + "] - Planet [" + clickedView.getText() + "]",
				// Toast.LENGTH_SHORT).show();

			}

		});

		registerForContextMenu(lv);
		
		b1=(Button)findViewById(R.id.view_route_pln_ad);
		
		b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent();

				i.setClass(Sector_level_donaitons.this, MainActivity.class);
				startActivity(i);
				
			}
		});

		
	}

	List<Map<String, String>> planetsList = new ArrayList<Map<String, String>>();

	private void initList() {

		// We populate the planets

		planetsList.add(createPlanet("planet", "House no. 1525 St no. 20,F-11/2"));
		planetsList.add(createPlanet("planet", "House no. 1455 St no. 39,F-11/3"));
		planetsList.add(createPlanet("planet", "House no. 1475 St no. 42,F-11/3"));


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
}
