package com.security.fragments;

import com.security.R;
import com.security.activities.FragmentChangeActivity;
import com.security.classes.Local;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class StoreFragment  extends Fragment{
	private View filterFragmentView;
	public FragmentChangeActivity activity;
	public Local loc;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		filterFragmentView = inflater.inflate(R.layout.fragment_store_details, null);

		TextView txt1 = (TextView) filterFragmentView.findViewById(R.id.storeName1);
		txt1.setText(loc.getNombre());
		
		TextView txt2 = (TextView) filterFragmentView.findViewById(R.id.storeDescription1);
		txt2.setText(loc.getDescripcion());
		
		RatingBar rtb1 = (RatingBar) filterFragmentView.findViewById(R.id.ratingBar1);
		rtb1.setRating(45f);
		
		TextView txt3 = (TextView) filterFragmentView.findViewById(R.id.storeResponseTime);
		txt3.setText("1 hora");

		TextView txt4 = (TextView) filterFragmentView.findViewById(R.id.storeSellsTotal1);
		txt4.setText("150 ventas");

//		TextView txt5 = (TextView) filterFragmentView.findViewById(R.id.storeComments1);
//		txt5.setText("Buen vendedor");
		
		Button but = (Button) filterFragmentView.findViewById(R.id.buttonSendOrders1);
		but.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				activity.switchContent(FragmentContants.FRAGMENT_MAP, false, false, null);
			}
		});
		
		return filterFragmentView;
	}
	
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}
}
