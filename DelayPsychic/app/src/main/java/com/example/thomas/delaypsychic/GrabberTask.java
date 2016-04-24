package com.example.thomas.delaypsychic;

import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by Thomas on 24/04/16.
 */
public class GrabberTask extends AsyncTask<Void, Void, Document> {
    private DataGrabber grabber;

    public GrabberTask(DataGrabber grabber) {
        this.grabber = grabber;
    }

    @Override
    protected Document doInBackground(Void... x) {
        Document doc;
        try {
            doc = Jsoup.connect(String.format("http://www.flightstats.com/go/FlightStatus/flightStatusByFlight.do?airline=%s&flightNumber=%s", grabber.airline, grabber.number)).userAgent("Mozilla").data("name", "jsoup").get();
            return doc;
        }
        catch (IOException e) {
        }
        return null;

    }

    @Override
    protected void onPostExecute(Document result) {
        grabber.doc = result;
    }


}
