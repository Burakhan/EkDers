package com.burakhan.ekders;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;

public class EkDers extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
    	//ilk view oluşturma
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ek_ders);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_ek_ders, menu);
        return true;
    }

    
}
