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

	public static String Open_Form = "kadrolu";	

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ek_ders);
        Spinner spinner;
        spinner = (Spinner) findViewById(R.id.tur);
       
        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
            	final String[] yuzdedegerleri = getResources().getStringArray(R.array.tur_degeri);
     	        Open_Form = yuzdedegerleri[position];
            }

            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

			

        });
        Button btnFormaGit = (Button)findViewById(R.id.button1);
        btnFormaGit.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				final Intent intent = new Intent();
				
				intent.setClass(EkDers.this,formuYonet.class);
				intent.putExtra(Open_Form, Open_Form);
				startActivity(intent);
				    
				
			}
		});
    }
}
