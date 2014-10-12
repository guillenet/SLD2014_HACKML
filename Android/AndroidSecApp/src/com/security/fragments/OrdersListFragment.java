package com.security.fragments;

import java.util.ArrayList;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.security.R;
import com.security.activities.FragmentChangeActivity;
import com.security.classes.Pedido;
import com.security.classes.Presupuesto;

public class OrdersListFragment extends ListFragment {

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
			layout = inflater.inflate(R.layout.fragment_order_list_category_item, null);
			thisView = layout;
		}
		return layout;
	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
//		ArrayList<PresupuestoItem> presupuestoItemListAdapter = new ArrayList<PresupuestoItem>();
		PedidoAdapter pedidoItemListAdapter = new PedidoAdapter(getActivity());
		ArrayList<Pedido> pedidoListAdapter = new ArrayList<Pedido>();
		//Pedido p = new Pedido();
		//p.setDescripcion("sdfsdfsdf");
		pedidoListAdapter = new Pedido().retrievePedidos();
		for (Pedido pre:pedidoListAdapter){
			pedidoItemListAdapter.add(new PedidoItem(pre));
		}
		setListAdapter(pedidoItemListAdapter);
	}

	/*
	 * Adapter Item
	 */
	private class PedidoItem {
		private Pedido d;
		
		public PedidoItem(Pedido d) {
			this.d = d; 
		}
	}

	/*
	 * Adapter
	 */
	private class PedidoAdapter extends ArrayAdapter<PedidoItem> {

		public PedidoAdapter(Context context) {
			super(context, 0);
		}

		public View getView(final int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_orders_list_item, null);
			}
			((TextView)convertView.findViewById(R.id.orderTitle)).setText(getItem(position).d.getTitulo());
			
			convertView.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					//v.findViewById(R.id.)
					activity.switchContent(FragmentContants.FRAGMENT_ORDER_DETAIL, false, false, getItem(position).d);
				}
			});
			
			return convertView;
		}

	}
}
