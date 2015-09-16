package com.example.ucsc.threads;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import org.w3c.dom.Text;
import android.os.Handler;
import android.os.Message;


public class MainActivity extends AppCompatActivity {

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            //mk sure this part is NOT inside any runnable object / any thread
            TextView ishkText = (TextView)findViewById(R.id.ishkText);
            ishkText.setText("Nice job :P");
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickIshkButton(View view){

        Runnable r=new Runnable() {
            @Override
            public void run() {
                long futureTime = System.currentTimeMillis()+10000;
                while (System.currentTimeMillis()<futureTime){
                    synchronized (this){
                        try{
                            wait(futureTime- System.currentTimeMillis());
                        }catch (Exception e){
                        }
                    }
                }


                //calls d handler
                handler.sendEmptyMessage(0);
            }
        };


        Thread ishkThread = new Thread(r);
        ishkThread.start();



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
