package com.example.thomas.delaypsychic;

import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SendFlightNo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_flight_no);


        Intent intent = getIntent();
        String message = intent.getStringExtra(MyActivity.EXTRA_MESSAGE);

        //couldn't get data grabber to work in the app :-(
        //DataGrabber grabber = new DataGrabber(message);
        //String output = "Route: " + grabber.getDepartureAirport() + " to " + grabber.getArrivalAirport();

        String output = "Route: LHR to JFK, Departure time: 13:36, Arrival time: 18:53, Weather: Clear, Expected delay: 0m";

        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(output);

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.content);
        layout.addView(textView);
    }
}

