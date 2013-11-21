package com.example.ej_menu_amonamarth_completo;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;

public class GaleriaImagenes extends Activity implements ViewFactory {
	
	Integer[] imagenIDS = {
			R.drawable.aa_01,
			R.drawable.aa_02,
			R.drawable.aa_03,
			R.drawable.aa_04,
			R.drawable.aa_05,
			R.drawable.aa_06,
			R.drawable.aa_07,
			R.drawable.aa_08,
			R.drawable.aa_09
	};
	
	private ImageSwitcher imageSwitcher;
	
	public Context context;
	
	public int itemBackground;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_galeria_imagenes);
		
		imageSwitcher = (ImageSwitcher)findViewById(R.id.switcher1);
		imageSwitcher.setFactory(this);
		
		imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left));
		imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right));
		
		@SuppressWarnings("deprecation")
		Gallery gallery = (Gallery)findViewById(R.galeria1);
		gallery.setAdapter(new ImageAdapter(this));
		gallery.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Apéndice de método generado automáticamente
				imageSwitcher.setImageResource(imagenIDS[arg2]);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public View makeView() {
		// TODO Apéndice de método generado automáticamente
		ImageView imageView = new ImageView(this);
		imageView.setBackgroundColor(0xFFFF0000);
		imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
		imageView.setLayoutParams(new ImageSwitcher.LayoutParams(
									LayoutParams.MATCH_PARENT,
									LayoutParams.MATCH_PARENT
							)
				);
		return imageView;
	}
	
	public class ImageAdapter extends BaseAdapter{

		
		public ImageAdapter(Context c) {
			// TODO Apéndice de constructor generado automáticamente
			context = c;
			TypedArray array = obtainStyledAttributes(R.styleable.galeria1);
			itemBackground = array.getResourceId(R.styleable.galeria1_android_galleryItemBackground, 0);
			array.recycle();
		}

		@Override
		public int getCount() {
			// TODO Apéndice de método generado automáticamente
			return imagenIDS.length;
		}

		@Override
		public Object getItem(int position) {
			// TODO Apéndice de método generado automáticamente
			return position;
		}

		@Override
		public long getItemId(int position) {
			// TODO Apéndice de método generado automáticamente
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Apéndice de método generado automáticamente
			ImageView imageView = new ImageView(context);
			
			imageView.setImageResource(imagenIDS[position]);
			imageView.setScaleType(ImageView.ScaleType.FIT_XY);
			imageView.setLayoutParams(new Gallery.LayoutParams(100,100));
			
			imageView.setBackgroundResource(itemBackground);
			
			return imageView;
		}
		
	}
}