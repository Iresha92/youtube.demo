package com.example.ucsc.boundservices;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.os.IBinder;
import android.content.Context;
import android.content.Intent;
import android.content.ComponentName;
import android.content.ServiceConnection;
import com.example.ucsc.boundservices.MyService.MyLocalBinder;

import java.security.PublicKey;

public class MainActivity extends AppCompatActivity {


    MyService ishkService;
    boolean isBound=false;

    public void showTime(View view){
        String currentTime=ishkService.getCurrentTime();
        TextView ishkText =(TextView)findViewById(R.id.ishkText);
        ishkText.setText(currentTime);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i = new Intent(this, MyService.class);
        bindService(i,ishkConnection,Context.BIND_AUTO_CREATE);
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private ServiceConnection ishkConnection = new ServiceConnection() {
        @Override
        //wt u wanna hapn wen u try to connect
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyLocalBinder binder = (MyLocalBinder)service;
            ishkService = binder.getService();
            isBound=true;
        }

        @Override
        //wt u wanna hapn wen u try to DISconnect
        public void onServiceDisconnected(ComponentName name) {
            isBound=false;
        }
    };

}
