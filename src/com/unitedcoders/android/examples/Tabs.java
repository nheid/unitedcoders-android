package com.unitedcoders.android.examples;

import android.app.TabActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class Tabs extends TabActivity implements OnClickListener {

    Button doSomething;
    TabHost tabHost;
    ViewFlipper flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tablayout_1);

        doSomething = (Button) findViewById(R.id.btn_do_something);
        doSomething.setOnClickListener(this);

        flipper = (ViewFlipper) findViewById(R.id.layout_tab_one);
        flipper.setOnClickListener(this);

        String tabname1 = getString(R.string.tabexample_tab1);
        String tabname2 = getString(R.string.tabexample_tab2);
        
        tabHost = getTabHost();
        tabHost.addTab(tabHost.newTabSpec("tab1").setContent(R.id.layout_tab_one).setIndicator(tabname1));
        tabHost.addTab(tabHost.newTabSpec("tab2").setContent(R.id.layout_tab_two).setIndicator(tabname2));

        tabHost.setCurrentTab(0);

    }

    @Override
    public void onClick(View v) {

        // show a toast in second tab
        if (v == doSomething) {
            Toast.makeText(getApplicationContext(), "doing something", Toast.LENGTH_SHORT).show();
        }

        // toggle TextView in first tab
        if (v == flipper) {
            flipper.showNext();
        }

    }

}
