import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DataGrabber {

	public static void main(String[] cheese) {
<<<<<<< HEAD
<<<<<<< HEAD
		Document doc;
		try {
			doc = Jsoup.connect("http://en.wikipedia.org/").get();
			Elements newsHeadlines = doc.select("#mp-itn b a");
			System.out.println(newsHeadlines);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

=======
=======
>>>>>>> master
		
>>>>>>> master
		Document doc2;
		String airline = "BA";
		String number = "0105";
		try {
			doc2 = Jsoup.connect(String.format("http://www.flightstats.com/go/FlightStatus/flightStatusByFlight.do?airline=%s&flightNumber=%s", airline, number)).userAgent("Mozilla").data("name", "jsoup").get();
			Elements route = doc2.select(".route");
<<<<<<< HEAD
<<<<<<< HEAD
			Elements flight = doc2.select("#mainAreaLeftColumn flightName");
			Element info = doc2.select("table").get(4);
			System.out.println(route);
			System.out.println(flight);
			System.out.println(info);

=======
=======
>>>>>>> master
			Elements flight = doc2.select("td.statusValue");
			Element dep = flight.select("td").get(0);
			Element arr = flight.select("td").get(1);
			System.out.println("Flight route: " + route.text());
			System.out.println("Scheduled departure time: " + dep.text());
			System.out.println("Scheduled arrival time: " + arr.text());
		
>>>>>>> master
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}



}
