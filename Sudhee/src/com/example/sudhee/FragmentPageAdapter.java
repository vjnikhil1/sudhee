package com.example.sudhee;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class FragmentPageAdapter extends FragmentPagerAdapter {

	public FragmentPageAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		 switch (arg0) {  
         case 0:  
                return new ITFragment();  
         case 1:  
                return new CSEFragment();
         case 2:  
             return new ECEfragment();
         case 3:  
             return new MECHANICALFragment();
         case 4:  
             return new CIVILFragment();
       
         case 5:
        	 return new ABOUTFragment();
         
         default:  
              break;  
         }  
         return null;  
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 6;
	}

}

