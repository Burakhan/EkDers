package com.burakhan.ekders;

import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class sonuc extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		TextView textEdt;
		Bundle extras = getIntent().getExtras();
        DecimalFormat df = new DecimalFormat("#.##");
		super.onCreate(savedInstanceState);
        setContentView(R.layout.sonuc);
        /*
         * Gündüz Brüt Ücreti
         */
        textEdt = (TextView) findViewById(R.id.gunduzText);
        textEdt.setText(String.valueOf(df.format(extras.getFloat("gunduz")) + " TL"));
        /*
         * Gece Brüt Ücreti
         */
        textEdt = (TextView) findViewById(R.id.geceText);
        textEdt.setText(String.valueOf(df.format(extras.getFloat("gece")) + " TL"));
        /*
         * Kesinti Toplamý
         */
        textEdt = (TextView) findViewById(R.id.vergiText);
        textEdt.setText(String.valueOf(df.format(extras.getFloat("vergi")) + " TL"));
        /*
         * Net ele geçen
         */
        textEdt = (TextView) findViewById(R.id.netText);
        textEdt.setText(String.valueOf(df.format(extras.getFloat("sonuc")) + " TL"));
	}

}
