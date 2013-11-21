package com.example.ej_menu_amonamarth_completo;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void abrirPaginaWeb(View v){
		Intent intent = new Intent(android.content.Intent.ACTION_VIEW,Uri.parse("http://amonamarth.com/"));
		startActivity(intent);
	}
	
	public void llamarGrupo(View v){
		Intent intent = new Intent(android.content.Intent.ACTION_DIAL, Uri.parse("tel:112"));
		startActivity(intent);
	}
	
	public void abrirGaleria(View v){
		Intent intent = new Intent(this, GaleriaImagenes.class);
		startActivity(intent);
	}
	
	public void abrirMapa(View v){
		Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("geo:62.00,15.00"));
		startActivityForResult(intent,0);
	}

}