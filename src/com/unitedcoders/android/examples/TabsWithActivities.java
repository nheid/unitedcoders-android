package com.unitedcoders.android.examples;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.TabHost;

public class TabsWithActivities extends TabActivity {
	
	
	  /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.camera);

        TabHost tabHost = getTabHost();

        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("Camera Container").setContent(
                new Intent(this, CameraContainer.class)));

        tabHost.setCurrentTab(0);

    }

    
    public void startCamera(View v){
    	Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    	startActivityForResult(intent, 4711);

    }
}
