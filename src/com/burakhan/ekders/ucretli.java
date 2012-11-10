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


public class ucretli extends Activity{

	public float damga;
	public float sonuc = 0;
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		 super.onCreate(savedInstanceState);
	     setContentView(R.layout.kadrolu);
	     Button btnFormaGit = (Button)findViewById(R.id.button1);
	        btnFormaGit.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					final EditText gunduzTxt = (EditText) findViewById(R.id.gunduz);       
					final float gunduz = Float.parseFloat(gunduzTxt.getText().toString());
					if(gunduz > 0) {
						sonuc += gunduz*(float)(0.071589)*140;
						Log.d("Soc",String.valueOf(sonuc));
					}
					final EditText geceTxt = (EditText) findViewById(R.id.gece);       
					final float gece = Float.parseFloat(geceTxt.getText().toString());
					if(gece > 0) {
						sonuc += gunduz*(float)(0.071589)*150;
					}
					
					damga = (float) (66*sonuc)/10000;
					sonuc = sonuc-damga;
					Spinner spinner = (Spinner) findViewById(R.id.vergisec);
					int position = spinner.getSelectedItemPosition();
					final int[] vergidegerleri = getResources().getIntArray(R.array.vergi_degeri);
					final int vergidegeri = vergidegerleri[position];
					
					
					sonuc = (float)(vergidegeri*sonuc)/100;
					
					spinner = (Spinner) findViewById(R.id.ogrenim);
					position = spinner.getSelectedItemPosition();
					final int[] ogrenimdegerleri = getResources().getIntArray(R.array.ogrenim_degeri);
					final int ogrenim = ogrenimdegerleri[position];
					sonuc = (float)(ogrenim*sonuc);
					
					DecimalFormat df = new DecimalFormat(".##");
					TextView sonucTxt = (TextView) findViewById(R.id.sonuc);
					sonucTxt.setText(String.valueOf(df.format(sonuc)+" TL"));
					    
					
				}
			});
	
	}
}