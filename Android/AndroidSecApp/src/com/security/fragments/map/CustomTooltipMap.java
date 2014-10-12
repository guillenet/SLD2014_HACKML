package com.security.fragments.map;

import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter;
import com.google.android.gms.maps.model.Marker;
import com.security.R;

public class CustomTooltipMap implements InfoWindowAdapter {

	private final View myContentsView;

	public CustomTooltipMap(View v) {
		myContentsView = v;
	}

	@Override
	public View getInfoContents(Marker marker) {

		TextView tvTitle = ((TextView) myContentsView.findViewById(R.id.mapTooltipTitle));
		tvTitle.setText(marker.getTitle());
		TextView tvSnippet = ((TextView) myContentsView
				.findViewById(R.id.mapTooltipDescripction));
		tvSnippet.setText(marker.getSnippet());

		return myContentsView;
	}

	@Override
	public View getInfoWindow(Marker marker) {
		// TODO Auto-generated method stub
		return null;
	}
}