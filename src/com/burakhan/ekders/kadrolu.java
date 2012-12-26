package com.burakhan.ekders;


import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class kadrolu extends Activity{

	public float damga,sonuc = 0,gece=0,gunduz=0;
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		 super.onCreate(savedInstanceState);
	     setContentView(R.layout.kadrolu);
	     Button btnFormaGit = (Button)findViewById(R.id.button1);
	        btnFormaGit.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					final EditText gunduzTxt = (EditText) findViewById(R.id.gunduz);       
					String gunduzDeger = gunduzTxt.getText().toString();
					if(gunduzDeger.length()>0) 
						gunduz = Float.parseFloat(gunduzDeger);
					sonuc += gunduz*(float)(0.073737)*140;
					final EditText geceTxt = (EditText) findViewById(R.id.gece);       
					String geceDeger = geceTxt.getText().toString();
					
					if(geceDeger.length()>0) {
						gece = Float.parseFloat(geceDeger);
					}
					sonuc += gece*(float)(0.073737)*150;
					
					
					Spinner spinner = (Spinner) findViewById(R.id.ogrenim);
					int position = spinner.getSelectedItemPosition();
					final int[] ogrenimdegerleri = getResources().getIntArray(R.array.ogrenim_degeri);
					final int ogrenim = ogrenimdegerleri[position];
					sonuc += (float)(ogrenim*sonuc)/100;
					Log.d("geceDeger",String.valueOf(sonuc));
					
					spinner = (Spinner) findViewById(R.id.lisans);
					position = spinner.getSelectedItemPosition();
					final int[] lisansdegerleri = getResources().getIntArray(R.array.lisans_degeri);
					final int lisans = lisansdegerleri[position];
					sonuc += (float)(lisans*sonuc)/100;
					Log.d("geceDeger",String.valueOf(sonuc));
					
					damga = (float) (66*sonuc)/10000;
					sonuc = sonuc-damga;

					spinner = (Spinner) findViewById(R.id.vergisec);
					position = spinner.getSelectedItemPosition();
					final int[] vergidegerleri = getResources().getIntArray(R.array.vergi_degeri);
					final int vergidegeri = vergidegerleri[position];
					sonuc = (float)(vergidegeri*sonuc)/100;
					
					DecimalFormat df = new DecimalFormat(".##");
					TextView sonucTxt = (TextView) findViewById(R.id.sonuc);
					sonucTxt.setText(String.valueOf(df.format(sonuc)+" TL"));
					sonuc = 0;    
					
				}
			});
	
	}
}