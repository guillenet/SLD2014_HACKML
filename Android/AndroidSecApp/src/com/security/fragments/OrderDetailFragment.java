package com.security.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.security.R;
import com.security.activities.FragmentChangeActivity;
import com.security.classes.Pedido;

public class OrderDetailFragment extends Fragment{
	private View orderFragmentView;
	public FragmentChangeActivity activity;
	public Object id;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		orderFragmentView = inflater.inflate(R.layout.fragment_order_details, null);
		Pedido p = (Pedido)id;
		((TextView)orderFragmentView.findViewById(R.id.orderTitle)).setText(p.getTitulo());
		((TextView)orderFragmentView.findViewById(R.id.orderDetails)).setText(p.getDescripcion());
		return orderFragmentView;
	}
	
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}
}
