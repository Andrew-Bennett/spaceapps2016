import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DataGrabber {

	public static void main(String[] cheese) {
		Document doc;
		try {
			doc = Jsoup.connect("http://en.wikipedia.org/").get();
			Elements newsHeadlines = doc.select("#mp-itn b a");
			System.out.println(newsHeadlines);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Document doc2;
		String airline = "BA";
		String number = "0105";
		try {
			doc2 = Jsoup.connect(String.format("http://www.flightstats.com/go/Airport/weather.do?airport=%s", airport)).userAgent("Take-off").data("name", "jsoup").get();
			Elements flight = doc2.select("td.statusValue");
			Element dep = flight.select("td").get(0);
			Element arr = flight.select("td").get(1);
			System.out.println(dep)

			// System.out.println("Flight route: " + route.text());
			// System.out.println("Scheduled departure time: " + dep.text());
			// System.out.println("Scheduled arrival time: " + arr.text());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}



}
