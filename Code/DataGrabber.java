import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DataGrabber {
	private Elements route;
	private Element dep;
	private Element arr;
	private Element depEst;
	private Element arrEst;

	// datagrabber testing code
/* 	public static void main(String[] cheese) {
		DataGrabber grabber = new DataGrabber("AA0107");
		System.out.println(grabber.getDepartureAirport());
		System.out.println(grabber.getArrivalAirport());
		System.out.println(grabber.getDepartureTime());
		System.out.println(grabber.getArrivalTime());
		try {
			System.out.println(grabber.getDepEstimate());
			System.out.println(grabber.getArrEstimate());
		}
		catch (NullPointerException e) {

		}
	} */

	public DataGrabber(String flightNo) {
		String airline = flightNo.substring(0,2);
		String number = flightNo.substring(2);

		Document doc;
		//String airline = "BA";
		//String number = "0105";
		this.route = null;
		this.dep = null;
		this.arr =  null;
		this.depEst = null;
		this.arrEst = null;
		try {
			doc = Jsoup.connect(String.format("http://www.flightstats.com/go/FlightStatus/flightStatusByFlight.do?airline=%s&flightNumber=%s", airline, number)).userAgent("Mozilla").data("name", "jsoup").get();
			route = doc.select(".route");
			Elements flight = doc.select("td.statusValue");
			dep = flight.select("td").get(0);
			arr = flight.select("td").get(1);
			try {
				depEst = flight.select("td").get(2);
				arrEst = flight.select("td").get(3);
			}
			catch (IndexOutOfBoundsException e) {
				
			}
			//System.out.println("Flight route: " + route.text());
			//System.out.println("Scheduled departure time: " + dep.text());
			//System.out.println("Scheduled arrival time: " + arr.text());
        } catch (IOException e) {
		}

	}

	public String getDepartureAirport() {
		int firstBracket = route.text().indexOf("(");
		String depAirport = route.text().substring(firstBracket+1, firstBracket+4);
		return depAirport;

	}
	public String getArrivalAirport() {
		int secondBracket = route.text().indexOf("(", 3);
		String arrAirport = route.text().substring(secondBracket+1, secondBracket+4);
		return arrAirport;
	}

	public Calendar getDepartureTime() {
		return stringToCalendar(dep.text());
	}
	public Calendar getArrivalTime() {
		return stringToCalendar(arr.text());
	}
	public Calendar getDepEstimate() throws NullPointerException {
		if (depEst == null) {
			throw new NullPointerException();
		}
		return stringToCalendar(depEst.text());
	}
	public Calendar getArrEstimate() throws NullPointerException {
		if (arrEst == null) {
			throw new NullPointerException();
		}
		return stringToCalendar(arrEst.text());
	}


	private Calendar stringToCalendar(String time) {
		int colon = time.indexOf(":");
		int hour = Integer.parseInt(time.substring(0,colon));
		int minute = Integer.parseInt(time.substring(colon+1, colon+3));
		int space1 = time.indexOf(" ");
		if (time.substring(space1+1, space1+3) == "PM") {
			hour += 12;
		}
		int space2 = space1 + 9;
		int month;
		switch (time.substring(space2+1, space2+4)) {
			case "Jan": month = 0;
						break;
			case "Feb": month = 1;
						break;
			case "Mar": month = 2;
						break;
			case "Apr": month = 3;
						break;
			case "May": month = 4;
						break;
			case "Jun": month = 5;
						break;
			case "Jul": month = 6;
						break;
			case "Aug": month = 7;
						break;
			case "Sep": month = 8;
						break;
			case "Oct": month = 9;
						break;
			case "Nov": month = 10;
						break;
			case "Dec": month = 11;
						break;
			default: month = -1;
						break;
		}
		int dash1 = time.indexOf("-", space2);
		//System.out.println(dash1);
		int dash2 = time.indexOf("-", dash1+1);
		//System.out.println(dash2);
		int day = Integer.parseInt(time.substring(dash1+1, dash2));
		int year = Integer.parseInt(time.substring(dash2+1, dash2+5));
		return new GregorianCalendar(year, month, day, hour, minute);
	}



}
