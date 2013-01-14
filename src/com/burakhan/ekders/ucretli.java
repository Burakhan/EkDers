package com.burakhan.ekders;


import java.text.DecimalFormat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class ucretli extends Activity{

	public float damga,kat_sayi,brut,sskPrim,isciPayi,sonuc = 0,gece=0,gunduz=0,vergi=0;
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		 super.onCreate(savedInstanceState);
	     setContentView(R.layout.ucretli);
	     Button btnFormaGit = (Button)findViewById(R.id.button1);
	        btnFormaGit.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					damga = Float.parseFloat(getResources().getString(R.string.damga));
					kat_sayi = Float.parseFloat(getResources().getString(R.string.kat_sayi));
					/**
					 * Gunduz Ek Ders Ücreti Hesabý
					 */
					final EditText gunduzTxt = (EditText) findViewById(R.id.gunduz);       
					String gunduzDeger = gunduzTxt.getText().toString();
					if(gunduzDeger.length()>0) 
						gunduz = Float.parseFloat(gunduzDeger)*140*kat_sayi;
					/**
					 * Gece Ek Ders Ücreti Hesabý
					 */
					final EditText geceTxt = (EditText) findViewById(R.id.gece);       
					String geceDeger = geceTxt.getText().toString();
					if(geceDeger.length()>0) 
						gece = Float.parseFloat(geceDeger)*150*kat_sayi;
					/**
					 * Gündüz ve Gece Ücret Toplamý 
					 * Brüt
					 */
					brut= gunduz + gece;
					
					/**
					 * gelir vergisi matrahý
					 */
					Spinner spinner = (Spinner) findViewById(R.id.ssk);
					int position = spinner.getSelectedItemPosition();
					final String[] statudegerleri = getResources().getStringArray(R.array.statu_deger);
					final int ssk = Integer.valueOf(statudegerleri[position]);
					float gvm = brut-ssk*brut/100;
					Log.d("gvm",String.valueOf(gvm));
					
					/**
					 * medeni durum
					 */
					spinner = (Spinner) findViewById(R.id.mdurum);
					position = spinner.getSelectedItemPosition();
					final String[] agidegerleri = getResources().getStringArray(R.array.agi_deger);
					final int agi = Integer.valueOf(agidegerleri[position]);
					
					/**
					 * Damga && gelir vergisi Hesabý
					 */
					spinner = (Spinner) findViewById(R.id.vergisec);
					position = spinner.getSelectedItemPosition();
					final int[] vergidegerleri = getResources().getIntArray(R.array.vergi_degeri);
					final int vergidegeri = vergidegerleri[position];
					damga =(float)damga*brut;
					/*
					 * Gelir Vergisi
					 */
					vergi = (float)(gvm*vergidegeri)/100;
					/**
					 * Ssk Primi
					 */
					sskPrim = (float)(0.195*brut);
					/**
					 * Kesinti Toplamý
					 */
					vergi = vergi+damga+(ssk*brut/100)+sskPrim;
					sonuc = brut+sskPrim-vergi;
					/**
					 * Sonuc + AGÝ
					 */
					sonuc += (float)(agi*brut/100)*15/100;
					
					DecimalFormat df = new DecimalFormat("#.##");
					TextView sonucTxt = (TextView) findViewById(R.id.sonuc);
					sonucTxt.setText(String.valueOf(df.format(sonuc)+" TL"));					
					Intent intent = new Intent();
					intent.putExtra("vergi", vergi);
					intent.putExtra("gece", gece);
					intent.putExtra("gunduz", gunduz);
					intent.putExtra("sonuc", sonuc);
					intent.setClass(ucretli.this,sonuc.class);
					startActivity(intent);
					
				}
			});
	
	}
}