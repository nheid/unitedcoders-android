package com.unitedcoders.android.examples;

import com.unitedcoders.android.examples.download.DownloadProgress;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class UCdroid extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button button = (Button) findViewById(R.id.btn_download_example);
        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DownloadProgress.class);
                startActivity(intent);

            }
        });
        
        Button buttonTabs = (Button) findViewById(R.id.btn_tabs);
        buttonTabs.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                Intent tabs = new Intent(getApplicationContext(), Tabs.class);
                startActivity(tabs);
            }
        });
    }
}