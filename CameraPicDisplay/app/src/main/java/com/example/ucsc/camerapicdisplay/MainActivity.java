package com.example.ucsc.camerapicdisplay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.content.pm.PackageInfo;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE =1;
    ImageView ishkImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button ishkButton =(Button)findViewById(R.id.ishkButton);
        ishkImageView=(ImageView)findViewById(R.id.ishkImageView);

        //disable d button if d user has no camera
        if (!hasCamera())
            ishkButton.setEnabled(false);
    }

    //check if user has a camera
    private boolean hasCamera(){
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);
    }


    //LAUNCHING D CAMERA
    public void launchCamera(View view){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //take a pic n passs results along to onActivityResult
        startActivityForResult(intent,REQUEST_IMAGE_CAPTURE);

    }

    //IF u wanna return d image taken
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==REQUEST_IMAGE_CAPTURE && resultCode==RESULT_OK){
            //GET d photo
            Bundle extras=data.getExtras();
            Bitmap photo=(Bitmap)extras.get("data");
            ishkImageView.setImageBitmap(photo);
        }
    }
}
