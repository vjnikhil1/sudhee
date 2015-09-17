package com.example.sudhee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.cbit.sudhee.R;

public class CSEFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
				 View rootView = inflater.inflate(R.layout.cse_layout, container,false);
				 Button itbutton=(Button) rootView.findViewById(R.id.cseb);
				 itbutton.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent intent = new Intent(getActivity(), CSE_detail.class);
						 startActivity(intent);
					}
				});
				 return rootView;
		
	}

}
