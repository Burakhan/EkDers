package com.burakhan.ekders;


import java.text.DecimalFormat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class kadrolu extends Activity{

	public float damga,kat_sayi,sonuc = 0,gece=0,gunduz=0,vergi=0;
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		 super.onCreate(savedInstanceState);
	     setContentView(R.layout.kadrolu);
	     Button btnFormaGit = (Button)findViewById(R.id.button1);
	        btnFormaGit.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					damga = Float.parseFloat(getResources().getString(R.string.damga));
					kat_sayi = Float.parseFloat(getResources().getString(R.string.kat_sayi));
					/**
					 * Gunduz Ek Ders Ücreti Hesabı
					 */
					final EditText gunduzTxt = (EditText) findViewById(R.id.gunduz);       
					String gunduzDeger = gunduzTxt.getText().toString();
					if(gunduzDeger.length()>0) 
						gunduz = Float.parseFloat(gunduzDeger)*140*kat_sayi;
					/**
					 * Gece Ek Ders Ücreti Hesabı
					 */
					final EditText geceTxt = (EditText) findViewById(R.id.gece);       
					String geceDeger = geceTxt.getText().toString();
					if(geceDeger.length()>0) 
						gece = Float.parseFloat(geceDeger)*150*kat_sayi;
					/*
					 * Gündüz ve Gece Ücret Toplamı
					 */
					sonuc = gunduz + gece;
					/**
					 * Özel Egitim && Normal Eğitim
					 */
					Spinner spinner = (Spinner) findViewById(R.id.ogrenim);
					int position = spinner.getSelectedItemPosition();
					final int[] ogrenimdegerleri = getResources().getIntArray(R.array.ogrenim_degeri);
					final int ogrenim = ogrenimdegerleri[position];
					sonuc += (float)(ogrenim*sonuc)/100;
					/*
					 * Lisans Derecesi
					 * $Lisans
					 * $Yüksek L.
					 * $Doktora
					 */
					spinner = (Spinner) findViewById(R.id.lisans);
					position = spinner.getSelectedItemPosition();
					final int[] lisansdegerleri = getResources().getIntArray(R.array.lisans_degeri);
					final int lisans = lisansdegerleri[position];
					sonuc += (float)(lisans*sonuc)/100;
					/*
					 * Damga && gelir vergisi Hesabı
					 */
					spinner = (Spinner) findViewById(R.id.vergisec);
					position = spinner.getSelectedItemPosition();
					final int[] vergidegerleri = getResources().getIntArray(R.array.vergi_degeri);
					final int vergidegeri = vergidegerleri[position];
					vergi += (float)(vergidegeri*sonuc)/100;
					vergi +=(float)damga*sonuc;
					sonuc = sonuc-vergi;
					
					DecimalFormat df = new DecimalFormat("#.##");
					TextView sonucTxt = (TextView) findViewById(R.id.sonuc);
					sonucTxt.setText(String.valueOf(df.format(sonuc)+" TL"));
					//sonuc = 0;    
					
					Intent intent = new Intent();
					intent.putExtra("vergi", vergi);
					intent.putExtra("gece", gece);
					intent.putExtra("gunduz", gunduz);
					intent.putExtra("sonuc", sonuc);
					intent.setClass(kadrolu.this,sonuc.class);
					startActivity(intent);
					
				}
			});
	
	}
}