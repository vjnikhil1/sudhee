package com.example.sudhee;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.cbit.sudhee.R;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;

public class MainActivity extends FragmentActivity implements ActionBar.TabListener {
	ActionBar actionbar;
	 ViewPager viewpager;  
     FragmentPageAdapter ft; 
     
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		viewpager=(ViewPager)findViewById(R.id.pager);
		ft = new FragmentPageAdapter(getSupportFragmentManager());
		actionbar=getActionBar();
		viewpager.setAdapter(ft);
		actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS); 
		actionbar.addTab(actionbar.newTab().setText("Kodemania").setTabListener(this));  
        actionbar.addTab(actionbar.newTab().setText("Cognos").setTabListener(this));  
        actionbar.addTab(actionbar.newTab().setText("Scintillate").setTabListener(this));
        actionbar.addTab(actionbar.newTab().setText("Code Jumble").setTabListener(this));
        actionbar.addTab(actionbar.newTab().setText("Tech Fun").setTabListener(this));
        //actionbar.addTab(actionbar.newTab().setText("Lan Gaming").setTabListener(this));
        actionbar.addTab(actionbar.newTab().setText("Gallery").setTabListener(this)); 
        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				actionbar.setSelectedNavigationItem(arg0);
				
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
        
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		viewpager.setCurrentItem(tab.getPosition());
		
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    // Inflate the menu items for use in the action bar
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.main, menu);
	    return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
	    switch (item.getItemId()) {
	        case R.id.action_settings:
	        	Intent intent=new Intent(this,About.class);
	        	startActivity(intent);
	        	return true;
	            

	        
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
}
