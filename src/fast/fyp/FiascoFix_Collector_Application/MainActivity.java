package fast.fyp.FiascoFix_Collector_Application;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MainActivity extends FragmentActivity {

	GoogleMap map;
	ArrayList<LatLng> markerPoints;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Initializing
		markerPoints = new ArrayList<LatLng>();

		// Getting reference to SupportMapFragment of the activity_main
		SupportMapFragment fm = (SupportMapFragment) getSupportFragmentManager()
				.findFragmentById(R.id.map);

		// Getting Map for the SupportMapFragment
		map = fm.getMap();

		// map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);

		if (map != null) {

			// Enable MyLocation Button in the Map
			map.setMyLocationEnabled(true);

			// ////------------------------------------------------

			CameraUpdate center = CameraUpdateFactory.newLatLng(new LatLng(
					33.67857, 72.99140));
			CameraUpdate zoom = CameraUpdateFactory.zoomTo(15);

			map.moveCamera(center);
			map.animateCamera(zoom);

			String url = getDirectionsUrl();

			DownloadTask downloadTask = new DownloadTask();

			// Start downloading json data from Google Directions
			// API
			downloadTask.execute(url);

			url = getDirectionsUrl1();

			DownloadTask downloadTask1 = new DownloadTask();

			// Start downloading json data from Google Directions
			// API
			downloadTask1.execute(url);

			url = getDirectionsUrl11();

			DownloadTask downloadTask11 = new DownloadTask();

			// Start downloading json data from Google Directions
			// API
			downloadTask11.execute(url);

			// ////-=----------------------------------------------

			// // Setting onclick event listener for the map
			// map.setOnMapClickListener(new OnMapClickListener() {
			//
			// @Override
			// public void onMapClick(LatLng point) {
			//
			// // CameraUpdate center = CameraUpdateFactory
			// // .newLatLng(new LatLng(33.67857, 72.99140));
			// // CameraUpdate zoom = CameraUpdateFactory.zoomTo(15);
			// //
			// // map.moveCamera(center);
			// // map.animateCamera(zoom);
			//
			// // Already two locations
			// if (markerPoints.size() > 1) {
			// markerPoints.clear();
			// map.clear();
			// }
			//
			// // Adding new item to the ArrayList
			// markerPoints.add(point);
			//
			// // Creating MarkerOptions
			// MarkerOptions options = new MarkerOptions();
			//
			// // Setting the position of the marker
			// options.position(point);
			//
			// /**
			// * For the start location, the color of marker is GREEN and
			// * for the end location, the color of marker is RED.
			// */
			// if (markerPoints.size() == 1) {
			// //
			// options.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
			// } else if (markerPoints.size() == 2) {
			// //
			// options.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
			// }
			//
			// // Add new marker to the Google Map Android API V2
			// map.addMarker(options);
			//
			// // Checks, whether start and end locations are captured
			// if (markerPoints.size() >= 2) {
			// LatLng origin = markerPoints.get(0);
			// LatLng dest = markerPoints.get(1);
			//
			// // Getting URL to the Google Directions API
			// String url = getDirectionsUrl(origin, dest);
			//
			// DownloadTask downloadTask = new DownloadTask();
			//
			// // Start downloading json data from Google Directions
			// // API
			// downloadTask.execute(url);
			// }
			//
			// }
			// });
		}
	}

	private String getDirectionsUrl() {

		// // Origin of route
		// String str_origin = "origin="+origin.latitude+","+origin.longitude;
		//
		// // Destination of route
		// String str_dest = "destination="+dest.latitude+","+dest.longitude;

		// /////////////////////////////////////////////////////////////
		// Origin of route
		String str_origin = "origin=33.67857,72.99140";

		// Destination of route
		String str_dest = "destination=33.69064,72.98973";

		MarkerOptions marker = new MarkerOptions().position(
				new LatLng(33.67857, 72.99140)).title("Source");

		// Changing marker icon
		marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.bus));
		// marker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));

		// adding marker
		map.addMarker(marker);

		MarkerOptions marker2 = new MarkerOptions().position(
				new LatLng(33.69064, 72.98973)).title(
				"House no. 1475 St no. 42,F-11/3");

		// Changing marker icon
		marker2.icon(BitmapDescriptorFactory
				.fromResource(R.drawable.drink_and_milk));
		// marker2.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
		// adding marker
		map.addMarker(marker2);

		// ////////////////////////////////////////////////

		// Sensor enabled
		String sensor = "sensor=false";

		// Building the parameters to the web service
		String parameters = str_origin + "&" + str_dest + "&" + sensor;

		// Output format
		String output = "json";

		// Building the url to the web service
		String url = "https://maps.googleapis.com/maps/api/directions/"
				+ output + "?" + parameters;

		map.setOnMarkerClickListener(new OnMarkerClickListener() {

			@Override
			public boolean onMarkerClick(Marker marker) {
				// TODO Auto-generated method stub
				if (marker.getTitle().equals("House no. 1475 St no. 42,F-11/3")) {
					Toast.makeText(MainActivity.this, "House no. 1475 St no. 42,F-11/3", 1000)
							.show();
					
					Intent i = new Intent();
					
					i.setClass(MainActivity.this, FormActivity.class);
					startActivity(i);
				}

				return true;
			}
		});
		return url;

	}

	// ////////////-------------------------

	private String getDirectionsUrl1() {

		// // Origin of route
		// String str_origin = "origin="+origin.latitude+","+origin.longitude;
		//
		// // Destination of route
		// String str_dest = "destination="+dest.latitude+","+dest.longitude;

		// /////////////////////////////////////////////////////////////
		// Origin of route
		String str_origin = "origin=33.67857,72.99140";

		// Destination of route
		String str_dest = "destination=33.68471,72.98359";

		// MarkerOptions marker = new MarkerOptions().position(
		// new LatLng(33.67857, 72.99140)).title("Source");
		//
		// // Changing marker icon
		// //
		// marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher));
		// marker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
		//
		// // adding marker
		// map.addMarker(marker);

		MarkerOptions marker2 = new MarkerOptions().position(
				new LatLng(33.68471, 72.98359)).title(
				"House no. 1455" + " St no. 39,F-11/3");

		// Changing marker icon
		marker2.icon(BitmapDescriptorFactory
				.fromResource(R.drawable.drink_and_milk));
		// marker2.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET));
		// adding marker
		map.addMarker(marker2);

		// ////////////////////////////////////////////////

		// Sensor enabled
		String sensor = "sensor=false";

		// Building the parameters to the web service
		String parameters = str_origin + "&" + str_dest + "&" + sensor;

		// Output format
		String output = "json";

		// Building the url to the web service
		String url = "https://maps.googleapis.com/maps/api/directions/"
				+ output + "?" + parameters;

		return url;
	}

	// //////////------------------

	private String getDirectionsUrl11() {

		// // Origin of route
		// String str_origin = "origin="+origin.latitude+","+origin.longitude;
		//
		// // Destination of route
		// String str_dest = "destination="+dest.latitude+","+dest.longitude;

		// /////////////////////////////////////////////////////////////
		// Origin of route
		String str_origin = "origin=33.67857,72.99140";

		// Destination of route
		String str_dest = "destination=33.68817,72.98831";

		// MarkerOptions marker = new MarkerOptions().position(
		// new LatLng(33.67857, 72.99140)).title("Source");
		//
		// // Changing marker icon
		// //
		// marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher));
		// marker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
		//
		// // adding marker
		// map.addMarker(marker);

		MarkerOptions marker2 = new MarkerOptions().position(
				new LatLng(33.68817, 72.98831)).title(
				"House no. 1525" + " St no. 20,F-11/2");

		// Changing marker icon
		marker2.icon(BitmapDescriptorFactory
				.fromResource(R.drawable.drink_and_milk));
		// marker2.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
		// adding marker
		map.addMarker(marker2);

		// ////////////////////////////////////////////////

		// Sensor enabled
		String sensor = "sensor=false";

		// Building the parameters to the web service
		String parameters = str_origin + "&" + str_dest + "&" + sensor;

		// Output format
		String output = "json";

		// Building the url to the web service
		String url = "https://maps.googleapis.com/maps/api/directions/"
				+ output + "?" + parameters;

		return url;
	}

	// /////////////////////------------------

	/** A method to download json data from url */
	private String downloadUrl(String strUrl) throws IOException {
		String data = "";
		InputStream iStream = null;
		HttpURLConnection urlConnection = null;
		try {
			URL url = new URL(strUrl);

			// Creating an http connection to communicate with url
			urlConnection = (HttpURLConnection) url.openConnection();

			// Connecting to url
			urlConnection.connect();

			// Reading data from url
			iStream = urlConnection.getInputStream();

			BufferedReader br = new BufferedReader(new InputStreamReader(
					iStream));

			StringBuffer sb = new StringBuffer();

			String line = "";
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}

			data = sb.toString();

			br.close();

		} catch (Exception e) {
			Log.d("Exception while downloading url", e.toString());
		} finally {
			iStream.close();
			urlConnection.disconnect();
		}
		return data;
	}

	// Fetches data from url passed
	private class DownloadTask extends AsyncTask<String, Void, String> {

		// Downloading data in non-ui thread
		@Override
		protected String doInBackground(String... url) {

			// For storing data from web service
			String data = "";

			try {
				// Fetching the data from web service
				data = downloadUrl(url[0]);
			} catch (Exception e) {
				Log.d("Background Task", e.toString());
			}
			return data;
		}

		// Executes in UI thread, after the execution of
		// doInBackground()
		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);

			ParserTask parserTask = new ParserTask();

			// Invokes the thread for parsing the JSON data
			parserTask.execute(result);

		}
	}

	/** A class to parse the Google Places in JSON format */
	private class ParserTask extends
			AsyncTask<String, Integer, List<List<HashMap<String, String>>>> {

		// Parsing the data in non-ui thread
		@Override
		protected List<List<HashMap<String, String>>> doInBackground(
				String... jsonData) {

			JSONObject jObject;
			List<List<HashMap<String, String>>> routes = null;

			try {
				jObject = new JSONObject(jsonData[0]);
				DirectionsJSONParser parser = new DirectionsJSONParser();

				// Starts parsing data
				routes = parser.parse(jObject);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return routes;
		}

		// Executes in UI thread, after the parsing process
		@Override
		protected void onPostExecute(List<List<HashMap<String, String>>> result) {
			ArrayList<LatLng> points = null;
			PolylineOptions lineOptions = null;
			MarkerOptions markerOptions = new MarkerOptions();

			// Traversing through all the routes
			for (int i = 0; i < result.size(); i++) {
				points = new ArrayList<LatLng>();
				lineOptions = new PolylineOptions();

				// Fetching i-th route
				List<HashMap<String, String>> path = result.get(i);

				// Fetching all the points in i-th route
				for (int j = 0; j < path.size(); j++) {
					HashMap<String, String> point = path.get(j);

					double lat = Double.parseDouble(point.get("lat"));
					double lng = Double.parseDouble(point.get("lng"));
					LatLng position = new LatLng(lat, lng);

					points.add(position);
				}

				// Adding all the points in the route to LineOptions
				lineOptions.addAll(points);
				lineOptions.width(2);
				lineOptions.color(Color.RED);

			}

			// Drawing polyline in the Google Map for the i-th route
			map.addPolyline(lineOptions);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}