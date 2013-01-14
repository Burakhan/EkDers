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
         * G�nd�z Br�t �creti
         */
        textEdt = (TextView) findViewById(R.id.gunduzText);
        textEdt.setText(String.valueOf(df.format(extras.getFloat("gunduz")) + " TL"));
        /*
         * Gece Br�t �creti
         */
        textEdt = (TextView) findViewById(R.id.geceText);
        textEdt.setText(String.valueOf(df.format(extras.getFloat("gece")) + " TL"));
        /*
         * Kesinti Toplam�
         */
        textEdt = (TextView) findViewById(R.id.vergiText);
        textEdt.setText(String.valueOf(df.format(extras.getFloat("vergi")) + " TL"));
        /*
         * Net ele ge�en
         */
        textEdt = (TextView) findViewById(R.id.netText);
        textEdt.setText(String.valueOf(df.format(extras.getFloat("sonuc")) + " TL"));
	}

}
