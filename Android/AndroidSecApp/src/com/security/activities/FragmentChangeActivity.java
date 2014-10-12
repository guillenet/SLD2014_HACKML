package com.security.activities;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.actionbarsherlock.app.ActionBar;
import com.facebook.Session;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.security.R;
import com.security.classes.Cache;
import com.security.classes.Local;
import com.security.fragments.BudgetDetailFragment;
import com.security.fragments.BudgetListFragment;
import com.security.fragments.FilterFragment;
import com.security.fragments.FragmentContants;
import com.security.fragments.MapFragment;
import com.security.fragments.OrderDetailFragment;
import com.security.fragments.OrdersListFragment;
import com.security.fragments.SlidingMenuFragment;
import com.security.fragments.StoreFragment;

public class FragmentChangeActivity extends SlidingFragmentActivity {
	private Fragment fragmentSlidingMenu;
	private Fragment mContent;

	private Fragment fragmentGeneric;
	private Fragment fragmentMap;
	private Fragment fragmentStore;
	private Fragment framentFilter;
	private Fragment framentBudget;
	private Fragment fragmentBudgetDetail;
	private Fragment framentPedido;
	private Fragment fragmentOrderDetail;
	private FragmentContants prevFragment = FragmentContants.FRAGMENT_MAP;
	private FragmentContants actFragment = FragmentContants.FRAGMENT_MAP;

	public static double actualLat = -33.301761d;
	public static double actualLng = -66.337694d;

	private Button buttonLoginLogout;

	private Bundle savedInstanceStateBak;
	
	public FragmentChangeActivity() {
		super();
	}

	private void initActionBar() {
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setIcon(R.drawable.icon_menu);
		getSupportActionBar().setBackgroundDrawable(
				new ColorDrawable(Color.parseColor("#33B5E5")));
		getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		getSupportActionBar().setCustomView(R.layout.action_bar_main);

		ImageView imgSlide = (ImageView) findViewById(R.id.lnkSlider);
		imgSlide.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				getSlidingMenu().toggle();
			}
		});

//		TextView lnkMap = (TextView) findViewById(R.id.lnkMap);
//		TextView lnkList = (TextView) findViewById(R.id.lnkList);
//		lnkMap.setOnClickListener(new LinkButtonBarListener(lnkList));
//		lnkList.setOnClickListener(new LinkButtonBarListener(lnkMap));

//		lnkMap.setBackgroundResource(R.drawable.s_buttonbar_map_in);
//		lnkList.setBackgroundResource(R.drawable.s_buttonbar_list_out);
//		lnkMap.setTextColor(Color.parseColor("#33B5E5"));
//		lnkList.setTextColor(Color.WHITE);

		TextView lnkFilters = (TextView) findViewById(R.id.lnkFilter);
		lnkFilters.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				switchContent(FragmentContants.FRAGMENT_FILTER);
				getSupportActionBar().setCustomView(R.layout.action_bar_filter);
				TextView lnkBack = (TextView) findViewById(R.id.lnkBack);
				lnkBack.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						switchContent(FragmentContants.FRAGMENT_MAP);
						initActionBar();
					}
				});
			}
		});

	}

	private void initSlidingMenu() {
		// customize the SlidingMenu
		SlidingMenu sm = getSlidingMenu();
		sm.setShadowWidthRes(R.dimen.shadow_width);
		sm.setShadowDrawable(R.drawable.shadow);
		sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		sm.setFadeDegree(0.35f);
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		savedInstanceStateBak = savedInstanceState;

		Cache.appActivity = this;
		
		initSlidingMenu();
		initActionBar();
		// set the Above View
		if (savedInstanceState != null)
			fragmentGeneric = getSupportFragmentManager().getFragment(
					savedInstanceState, "fragmentGeneric");
		if (fragmentGeneric == null) {
			fragmentMap = new MapFragment();
			((MapFragment) fragmentMap).lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
			((MapFragment) fragmentMap).activity = this;
			fragmentGeneric = fragmentMap;
		}

		// set the Above View
		setContentView(R.layout.sliding_fragment_behind);
		getSlidingMenu().showContent();

		getSupportFragmentManager().beginTransaction()
				.replace(R.id.sliding_fragment_behind_id, fragmentGeneric).commit();

		// set the Behind View
		if (fragmentSlidingMenu == null) {
			fragmentSlidingMenu = new SlidingMenuFragment();
			((SlidingMenuFragment) fragmentSlidingMenu).activity = this;
		}
		setBehindContentView(R.layout.sliding_fragment_above);
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.sliding_fragment_above_id, fragmentSlidingMenu).commit();

		// customize the SlidingMenu
		getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		Session session = Session.getActiveSession();
		Session.saveSession(session, outState);
	}

	public void switchContent(FragmentContants fragmentConstant) {
		switchContent(fragmentConstant, false, false);
	}

	public void switchContent(FragmentContants fragmentConstant,
			boolean toggleBar, boolean fromSlider, Object ...params) {
		Fragment f = null;
		boolean applyFade = false;
		
		switch (fragmentConstant) {
		case FRAGMENT_MAP:
			if (fragmentMap == null) {
				fragmentMap = new MapFragment();
				((MapFragment) fragmentMap).lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
				((MapFragment) fragmentMap).activity = this;
			}
			applyFade = true;
			f = fragmentMap;
			break;
		case FRAGMENT_FILTER:
			if (framentFilter == null) {
				framentFilter = new FilterFragment();
			}
			((FilterFragment) framentFilter).activity = this;
			f = framentFilter;
			break;
		case FRAGMENT_STORE:
			if (fragmentStore == null) {
				fragmentStore = new StoreFragment();
			}
			((StoreFragment) fragmentStore).activity = this;
			((StoreFragment) fragmentStore).loc = (Local)params[0];
			f = fragmentStore;
			break;
		case FRAGMENT_BUDGET_DETAIL:
			if (fragmentBudgetDetail == null) {
				fragmentBudgetDetail = new BudgetDetailFragment();
			}
			((BudgetDetailFragment) fragmentBudgetDetail).activity = this;
			((BudgetDetailFragment) fragmentBudgetDetail).id = params[0];
			f = fragmentBudgetDetail;
			break;
		case FRAGMENT_BUDGET:
			if (framentBudget == null) {
				framentBudget = new BudgetListFragment();
			}
			((BudgetListFragment) framentBudget).activity = this;
			f = framentBudget;
			break;
		case FRAGMENT_ORDERS:
			if (framentPedido == null) {
				framentPedido = new OrdersListFragment();
			}
			((OrdersListFragment) framentPedido).activity = this;
			f = framentPedido;
			break;		
		case FRAGMENT_ORDER_DETAIL:
			if (fragmentOrderDetail == null) {
				fragmentOrderDetail = new OrderDetailFragment();
			}
			((OrderDetailFragment) fragmentOrderDetail).activity = this;
			((OrderDetailFragment) fragmentOrderDetail).id = params[0];
			f = fragmentOrderDetail;
			break;	
		}
		
		prevFragment = actFragment;
		actFragment = fragmentConstant;

		if ((actFragment != null)
				&& (actFragment == FragmentContants.FRAGMENT_FILTER)
				&& (fragmentConstant != FragmentContants.FRAGMENT_FILTER)
				&& !fromSlider) {
			initActionBar();


		}else if(fragmentConstant == FragmentContants.FRAGMENT_MAP){
			initActionBar();
		}
		FragmentTransaction transaction = getSupportFragmentManager()
				.beginTransaction();
//		if(applyFade){
//			transaction.setCustomAnimations(R.anim.e_fade_in, R.anim.e_fade_out,
//					R.anim.e_fade_in, R.anim.e_fade_out);
//		}else{
//			transaction.setCustomAnimations(R.anim.enter, R.anim.exit,
//					R.anim.pop_enter, R.anim.pop_exit);
//		}
		transaction.replace(R.id.sliding_fragment_behind_id, f);
		transaction.addToBackStack(null);
		transaction.commit();
		//getSupportFragmentManager().executePendingTransactions();
		if (toggleBar) {
			getSlidingMenu().toggle();
		}
	}
}
