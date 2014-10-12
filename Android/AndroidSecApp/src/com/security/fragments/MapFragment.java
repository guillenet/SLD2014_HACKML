package com.security.fragments;

import java.util.ArrayList;
import java.util.HashMap;

import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.security.R;
import com.security.activities.FragmentChangeActivity;
import com.security.classes.Local;
import com.security.util.SecAppUtil;

public class MapFragment extends Fragment {
	public GoogleMap map;
	public static LocationManager lm;
	private LayoutInflater mpaInflater = null;
	public static LatLng basePosition = null;
	public FragmentChangeActivity activity;
	private static View thisView;
	private static HashMap<Marker, Local> markerHash = new HashMap<Marker, Local>();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup view, Bundle savedInstance) {
		if (thisView != null) {
			ViewGroup parent = (ViewGroup) thisView.getParent();
			if (parent != null)
				parent.removeView(thisView);
			if (mpaInflater == null) {
				mpaInflater = inflater;
			}
			if (map == null) {
				map = ((SupportMapFragment) getFragmentManager().findFragmentById(R.id.main_map)).getMap();
				if (map == null) {
					try {
						thisView = inflater.inflate(R.layout.fragment_map, null);
					} catch (InflateException e) {
					}
					map = ((SupportMapFragment) getFragmentManager().findFragmentById(R.id.main_map)).getMap();
				}
			}
		} else {
			SecAppUtil.showProgressBar(activity);
			try {
				thisView = inflater.inflate(R.layout.fragment_map, null);
			} catch (InflateException e) {
			}
			mpaInflater = inflater;
			if (map == null) {
				map = ((SupportMapFragment) getFragmentManager().findFragmentById(R.id.main_map)).getMap();
			}

		}
		initMap();

		map.setMyLocationEnabled(true);
		map.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {
			private int i = 0;

			@Override
			public void onMyLocationChange(Location arg0) {
				if (i == 0) {
					CameraUpdate center = CameraUpdateFactory
							.newLatLng(new LatLng(FragmentChangeActivity.actualLat, FragmentChangeActivity.actualLng));
					CameraUpdate zoom = CameraUpdateFactory.zoomTo(16);
					map.moveCamera(center);
					map.animateCamera(zoom);
					i = 1;
				}
			}
		});
		return thisView;
	}

	private void initMap() {
		ArrayList<Local> locales = new ArrayList<Local>();
		locales = new Local().retrieveLocales();
		for (Local l : locales) {
			MarkerOptions cm = new MarkerOptions();
			String[] vpos = l.getLocation().split(",");
			Double d1 = Double.parseDouble(vpos[0]);
			Double d2 = Double.parseDouble(vpos[1]);
			cm.position(new LatLng(d1, d2)).title(l.getNombre()).snippet(l.getDescripcion());
			Marker marker = map.addMarker(cm);
			markerHash.put(marker, l);
		}
		map.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {
			@Override
			public void onInfoWindowClick(Marker marker) {
				Local d = markerHash.get(marker);
				if (d != null) {// 18.492675007769037--69.98389653861523
					activity.switchContent(FragmentContants.FRAGMENT_STORE, false, false, d);
				}
			}
		});
	}
}
