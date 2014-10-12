package com.security.fragments;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.security.R;
import com.security.activities.FragmentChangeActivity;
import com.security.classes.Presupuesto;

public class BudgetListFragment extends ListFragment {

	public FragmentChangeActivity activity;
	private View thisView;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View layout;

		if(thisView != null){
			layout = thisView;
			ViewGroup parent = (ViewGroup) layout.getParent();
			if (parent != null)
				parent.removeView(layout);
		}else{
			layout = inflater.inflate(R.layout.fragment_list_category_item, null);
			thisView = layout;
		}
		return layout;
	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
//		ArrayList<PresupuestoItem> presupuestoItemListAdapter = new ArrayList<PresupuestoItem>();
		PresupuestoAdapter presupuestoItemListAdapter = new PresupuestoAdapter(getActivity());
		ArrayList<Presupuesto> presupuestoListAdapter = new ArrayList<Presupuesto>();
		presupuestoListAdapter = new Presupuesto().retrievePresupuestos();
//		Presupuesto p = new Presupuesto();
//		p.setMonto(1234d);
//		presupuestoListAdapter.add(p);
		for (Presupuesto pre:presupuestoListAdapter){
			presupuestoItemListAdapter.add(new PresupuestoItem(pre));
		}
		setListAdapter(presupuestoItemListAdapter);
	}

	/*
	 * Adapter Item
	 */
	private class PresupuestoItem {
		public Presupuesto d;
		
		public PresupuestoItem(Presupuesto d) {
			this.d = d; 
		}
	}

	/*
	 * Adapter
	 */
	private class PresupuestoAdapter extends ArrayAdapter<PresupuestoItem> {

		public PresupuestoAdapter(Context context) {
			super(context, 0);
		}

		public View getView(final int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_budgets_list_item, null);
			}
			
			((TextView)convertView.findViewById(R.id.storeName)).setText(getItem(position).d.getIdVendedor().getIdLocal().getNombre());
			((TextView)convertView.findViewById(R.id.budgetTitle)).setText(getItem(position).d.getTitulo());
			convertView.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					//v.findViewById(R.id.)
					activity.switchContent(FragmentContants.FRAGMENT_BUDGET_DETAIL, false, false, getItem(position).d);
				}
			});
			
			return convertView;
		}

	}
}
