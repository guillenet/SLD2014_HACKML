package com.security.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.security.R;
import com.security.activities.FragmentChangeActivity;

public class FilterFragment extends Fragment{
	private View filterFragmentView;
	public FragmentChangeActivity activity;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		filterFragmentView = inflater.inflate(R.layout.fragment_filters, null);

		return filterFragmentView;
	}
	
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}
}
