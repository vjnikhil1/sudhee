package com.example.sudhee;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;
import com.cbit.sudhee.R;

public class ABOUTFragment extends Fragment {

	Integer[] imageIDs = {
			R.drawable.pic1,
			R.drawable.pic2,
			R.drawable.pic3,
			R.drawable.pic4,
			R.drawable.pic5,
			R.drawable.pic6,
			R.drawable.pic7,
			R.drawable.pic8,
			R.drawable.pic9,
			R.drawable.pic10,
			R.drawable.pic11,
			R.drawable.pic12,
			R.drawable.pic13,
			R.drawable.pic14,
			R.drawable.pic15,
			R.drawable.pic16,
			R.drawable.pic17,
			R.drawable.pic18,
			R.drawable.pic19,
			R.drawable.pic20,
			R.drawable.pic21,
			R.drawable.pic22,
			};
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		 final View rootView = inflater.inflate(R.layout.about, container,false);
		 Gallery gallery = (Gallery) rootView.findViewById(R.id.gallery1);
			gallery.setAdapter(new ImageAdapter(getActivity()));
			gallery.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> parent, View v, int position,long id)
		{
					
					// display the images selected
					ImageView imageView = (ImageView) rootView.findViewById(R.id.image1);
					imageView.setImageResource(imageIDs[position]);
			}
		});
		 return rootView;
	}
	public class ImageAdapter extends BaseAdapter {
		private Context context;
		private int itemBackground;
		public ImageAdapter(Context c)
		{
			context = c;
		}
		// returns the number of images
		@Override
		public int getCount() {
			return imageIDs.length;
		}
		// returns the ID of an item
		@Override
		public Object getItem(int position) {
			return position;
		}
		// returns the ID of an item
		@Override
		public long getItemId(int position) {
			return position;
		}
		// returns an ImageView view
		@Override
		@SuppressWarnings("deprecation")
		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView imageView = new ImageView(context);
			imageView.setImageResource(imageIDs[position]);
			imageView.setLayoutParams(new Gallery.LayoutParams(200, 200));
			imageView.setBackgroundResource(itemBackground);
			return imageView;
		}
	}
}
