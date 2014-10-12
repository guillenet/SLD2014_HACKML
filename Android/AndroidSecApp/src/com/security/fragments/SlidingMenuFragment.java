package com.security.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.security.R;
import com.security.activities.FragmentChangeActivity;
import com.security.util.SecAppUtil;


public class SlidingMenuFragment extends Fragment {
	public FragmentChangeActivity activity = null;
	private static View myFragmentView;
	
	 @Override
	 public View onCreateView(LayoutInflater inflater, ViewGroup container,
	   Bundle savedInstanceState) {

	  myFragmentView = inflater.inflate(R.layout.sliding_fragment_menu, container, false);
	  SlidginMenuMenuClick s = new SlidginMenuMenuClick();

	  myFragmentView.findViewById(R.id.menuItemMap).setOnClickListener(s);
	  myFragmentView.findViewById(R.id.menuItemDenouncement).setOnClickListener(s);
	  myFragmentView.findViewById(R.id.menuItemFilter).setOnClickListener(s);
//	  myFragmentView.findViewById(R.id.menuItemConfiguration).setOnClickListener(s);
	  myFragmentView.findViewById(R.id.menuItemExit).setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			activity.finish();
            System.exit(0);
		}
	});
	  
	  
	  return myFragmentView;
	 }
	 
	 class SlidginMenuMenuClick implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(v.getId() == R.id.menuItemMap){
				activity.switchContent(FragmentContants.FRAGMENT_MAP,true, true);
			}else if(v.getId() == R.id.menuItemDenouncement){
				activity.switchContent(FragmentContants.FRAGMENT_BUDGET,true,true);
			}else if(v.getId() == R.id.menuItemFilter){
				activity.switchContent(FragmentContants.FRAGMENT_ORDERS,true,true);
			}
		}
		 
	 }

}