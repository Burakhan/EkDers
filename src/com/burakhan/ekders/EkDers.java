package com.burakhan.ekders;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.app.Activity;

import android.widget.AdapterView.OnItemSelectedListener;

public class EkDers extends Activity {

	public Integer FormOpenView = 1;	

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ek_ders);
        Spinner spinner;
        spinner = (Spinner) findViewById(R.id.tur);
       
        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
            	final int[] yuzdedegerleri = getResources().getIntArray(R.array.tur_degeri);
            	FormOpenView = yuzdedegerleri[position];
            }

            public void onNothingSelected(AdapterView<?> parentView) {
                //buraya bir şeyler yaz
            }

			

        });
        Button btnFormaGit = (Button)findViewById(R.id.button1);
        btnFormaGit.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				final Intent intent = new Intent();
				switch (FormOpenView) {
				case 1:
					intent.setClass(EkDers.this,kadrolu.class);
					break;
				case 2:
					intent.setClass(EkDers.this,ucretli.class);
					break;
				default:
					break;
				}
				
				//intent.putExtra(Open_Form, Open_Form);
				startActivity(intent);
				    
				
			}
		});
    }
}
