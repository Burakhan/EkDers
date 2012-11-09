package com.burakhan.ekders;


import java.text.DecimalFormat;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class formuYonet extends Activity{

	public float damga;
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
					float sonuc = gunduz*(float)(0.071589)*140;
					sonuc += gunduz*(float)(0.071589)*150;
					damga = (float) 0.00066*sonuc;
					sonuc = sonuc-damga;
					Spinner spinner = (Spinner) findViewById(R.id.vergisec);
					int pos = spinner.getSelectedItemPosition();
					int[] vergidegerleri = getResources().getIntArray(R.array.vergi_degeri);
					final float vergidegeri = vergidegerleri[pos];
					sonuc = (float)(vergidegeri*sonuc)/100;
					sonuc = vergidegeri;
					DecimalFormat df = new DecimalFormat(".##");
					TextView sonucTxt = (TextView) findViewById(R.id.sonuc);
					sonucTxt.setText(String.valueOf(df.format(sonuc)));
					    
					
				}
			});
	
	}
}