import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DataGrabber {

	public static void main(String[] cheese) {
		
		Document doc2;
		String airline = "BA";
		String number = "0105";
		try {
			doc2 = Jsoup.connect(String.format("http://www.flightstats.com/go/FlightStatus/flightStatusByFlight.do?airline=%s&flightNumber=%s", airline, number)).userAgent("Mozilla").data("name", "jsoup").get();
			Elements route = doc2.select(".route");
			Elements flight = doc2.select("td.statusValue");
			Element dep = flight.select("td").get(0);
			Element arr = flight.select("td").get(1);
			System.out.println("Flight route: " + route.text());
			System.out.println("Scheduled departure time: " + dep.text());
			System.out.println("Scheduled arrival time: " + arr.text());
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	

}
