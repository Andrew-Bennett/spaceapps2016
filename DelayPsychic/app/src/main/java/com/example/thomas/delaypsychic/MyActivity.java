package com.example.thomas.delaypsychic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MyActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.thomas.delaypsychic.MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
    }

    /** Called when the user clicks the Send button */
    public void sendFlightNo(View view) {
        Intent intent = new Intent(this, SendFlightNo.class);
        EditText editText = (EditText) findViewById(R.id.edit_flight_no);
        String flightNo = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, flightNo);
        startActivity(intent);
    }
}
