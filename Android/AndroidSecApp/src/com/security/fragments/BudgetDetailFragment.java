package com.security.fragments;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.httpclient.HttpClient;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.security.R;
import com.security.activities.FragmentChangeActivity;
import com.security.classes.Presupuesto;

public class BudgetDetailFragment extends Fragment{
	private View filterFragmentView;
	public FragmentChangeActivity activity;
	public Object id;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		filterFragmentView = inflater.inflate(R.layout.fragment_budget_details, null);
		final Presupuesto p = (Presupuesto)id;
		((TextView)filterFragmentView.findViewById(R.id.storeName)).setText(p.getTitulo());
		((TextView)filterFragmentView.findViewById(R.id.budgetDetails)).setText(p.getPresupuesto());
		((TextView)filterFragmentView.findViewById(R.id.budgetTotal)).setText(p.getMonto().toString());
		filterFragmentView.findViewById(R.id.budgetComprar).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				//PaymentRequest pr = new PaymentRequest();
				//pr.setPayerEmail("hernanfsantiago@hotmail.com");
//				pr.setClientId("3658591962082015");
//				pr.setClientSecret("932HWR9vN2mDyV9UpYzQjdX7p34uU0h7");
				//Payment pay = new Payment(pr);
				//Item item = new Item(p.getTitulo(),p.getMonto().toString());
				//String ulString = pay.performPayment(item);
				
//				com.mpago.domain.PaymentRequest pr = new com.mpago.domain.PaymentRequest();
//				pr.setPayerEmail("hernanfsantiago@hotmail.com");
//				com.mpago.checkout.Payment pay = new com.mpago.checkout.Payment(pr);
//				com.mpago.domain.Item item = new com.mpago.domain.Item(p.getTitulo(),p.getMonto().toString());
//				String ulString = pay.performPayment(item);
				
				
				
				final Uri uri = Uri.parse("https://sandbox.mercadopago.com/mla/checkout/pay?pref_id=39149184-fbdebfc3-5d80-4c28-8d58-a48c609892cf");
				Intent browserIntent = new Intent(Intent.ACTION_VIEW, uri);
				browserIntent.addCategory(Intent.CATEGORY_BROWSABLE);
				startActivity(browserIntent);
			}
		});
		
		
		return filterFragmentView;
	}
	
	protected String getASCIIContentFromEntity(HttpEntity entity) throws IllegalStateException, IOException {
		InputStream in = entity.getContent();


		StringBuffer out = new StringBuffer();
		int n = 1;
		while (n>0) {
		byte[] b = new byte[4096];
		n =  in.read(b);


		if (n>0) out.append(new String(b, 0, n));
		}


		return out.toString();
		}
	
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}
}
