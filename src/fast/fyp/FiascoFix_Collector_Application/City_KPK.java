package fast.fyp.FiascoFix_Collector_Application;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class City_KPK extends Activity {
	SimpleAdapter simpleAdpt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cities_xml);

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

				TextView clickedView = (TextView) view;

				if (clickedView.getText() == "Attock") {

					Toast.makeText(City_KPK.this, "ali jljlj", Toast.LENGTH_SHORT)
							.show();
					Intent i = new Intent();

					i.setClass(City_KPK.this, Zone.class);
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

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	List<Map<String, String>> planetsList = new ArrayList<Map<String, String>>();

	private void initList() {

		// We populate the planets

		planetsList.add(createPlanet("planet", "Attock"));

		planetsList.add(createPlanet("planet", "Bahawalpur"));

		planetsList.add(createPlanet("planet", "Bhakkar"));

		planetsList.add(createPlanet("planet", "Burewala"));

		planetsList.add(createPlanet("planet", "Chakwal"));

		planetsList.add(createPlanet("planet", "Chiniot"));

		planetsList.add(createPlanet("planet", "Daska"));

		planetsList.add(createPlanet("planet", "Dera Ghazi Khan"));

		planetsList.add(createPlanet("planet", "Dina"));

		planetsList.add(createPlanet("planet", "Faisalabad"));

		planetsList.add(createPlanet("planet", "Gujranwala"));

		planetsList.add(createPlanet("planet", "Gujrat"));

		planetsList.add(createPlanet("planet", "Gujar Khan"));

		planetsList.add(createPlanet("planet", "Hafizabad"));

		planetsList.add(createPlanet("planet", "Jalalpur Jattan"));

		planetsList.add(createPlanet("planet", "Lahore"));

		planetsList.add(createPlanet("planet", "Lalamusa"));

		planetsList.add(createPlanet("planet", "Muree"));

		planetsList.add(createPlanet("planet", "Multan"));

		planetsList.add(createPlanet("planet", "Sargodha"));

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