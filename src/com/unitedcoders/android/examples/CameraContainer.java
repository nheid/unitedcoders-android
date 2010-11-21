package com.unitedcoders.android.examples;

import android.app.Activity;
import android.content.Intent;
import android.provider.MediaStore;
import android.view.View;

public class CameraContainer extends Activity {
	
	
	
	 public void startCamera(View v){
	    	Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
	    	startActivityForResult(intent, 1234);

	    }

}
