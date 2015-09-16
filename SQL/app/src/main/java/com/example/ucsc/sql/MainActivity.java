package com.example.ucsc.sql;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    EditText ishkInput;
    TextView ishkText;
    MyDBHandler dbHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ishkInput = (EditText)findViewById(R.id.ishkInput);
        ishkText = (TextView)findViewById(R.id.ishkText);
        dbHandler = new MyDBHandler(this, null, null , 1);
        printDatabase();
    }

    //add a product to d db
    public void addButtonClicked(View view){
        Products product = new Products(ishkInput.getText().toString());
        dbHandler.addProduct(product);
        printDatabase();
    }

    //Delete items
    public void deleteButtonClicked(View view){
        String inputText = ishkText.getText().toString();
        dbHandler.deleteProduct(inputText);
        printDatabase();
    }


    public void printDatabase(){
        String dbString = dbHandler.databaseToString();
        ishkText.setText(dbString);
        ishkInput.setText("");
    }



}
