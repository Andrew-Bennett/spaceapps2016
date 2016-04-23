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
		try {
			doc2 = Jsoup.connect("http://www.flightstats.com/go/FlightStatus/flightStatusByFlight.do?airline=BA&flightNumber=0105").userAgent("Mozilla").data("name", "jsoup").get();
			Elements route = doc2.select(".route");
			Elements flight = doc2.select("#mainAreaLeftColumn");
			Element info = doc2.select("table").get(4);
			System.out.println(route);
			System.out.println(flight);
			System.out.println(info);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	

}
