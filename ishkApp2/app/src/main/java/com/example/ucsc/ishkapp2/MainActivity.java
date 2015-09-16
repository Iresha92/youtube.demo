package com.example.ucsc.ishkapp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.Button;
import android.graphics.Color;
import android.widget.EditText;
import android. content.res.Resources;
import android.util.TypedValue;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Layout
        RelativeLayout ishkLayout = new RelativeLayout(this);
        ishkLayout.setBackgroundColor(Color.GREEN);

        //Button
        Button redButton = new Button(this);
        redButton.setText("LOG IN");
        redButton.setBackgroundColor(Color.RED);

        //user name input
        EditText username = new EditText(this);
        redButton.setId(1);
        username.setId(2);

        RelativeLayout.LayoutParams buttonDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        RelativeLayout.LayoutParams usernameDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        //give rules to possition widgets
        usernameDetails.addRule(RelativeLayout.ABOVE,redButton.getId());
        usernameDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        usernameDetails.setMargins(0, 0, 0, 50);

        buttonDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonDetails.addRule(RelativeLayout.CENTER_VERTICAL);

        Resources r = getResources();
        int px= (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,200,
            r.getDisplayMetrics()
        );

        username.setWidth(px);

        //now need to add the redButton to the ishkLayout
        //addWidget nathuwa addView daanne cz widget serama view eken ena ewa nisa
        ishkLayout.addView(redButton, buttonDetails);
        ishkLayout.addView(username,usernameDetails);

        //now make dz The main screen (SET this activities display to d view)
        setContentView(ishkLayout);

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
