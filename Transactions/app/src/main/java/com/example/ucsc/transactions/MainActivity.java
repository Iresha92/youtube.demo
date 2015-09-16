package com.example.ucsc.transactions;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.transition.TransitionManager;

public class MainActivity extends AppCompatActivity {

    ViewGroup ishkLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ishkLayout = (ViewGroup) findViewById(R.id.ishkLayout);

        ishkLayout.setOnTouchListener(
                new RelativeLayout.OnTouchListener(){
                    public  boolean onTouch (View v, MotionEvent event){
                        moveButton();
                        return true;
                    }
                }
        );
    }

    public void moveButton(){
        View ishkButton = findViewById(R.id.ishkButton);

        TransitionManager.beginDelayedTransition(ishkLayout);

        //change d position of button
        RelativeLayout.LayoutParams positionRules = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM,RelativeLayout.TRUE);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,RelativeLayout.TRUE);
        ishkButton.setLayoutParams(positionRules);


        //change size of button
        ViewGroup.LayoutParams sizeRules = ishkButton.getLayoutParams();
        sizeRules.width=450;
        sizeRules.height=300;
        ishkButton.setLayoutParams(sizeRules);
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
