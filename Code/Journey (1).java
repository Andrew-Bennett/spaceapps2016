import java.util.*;
import java.util.Date;
import java.util.TimeZone;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.io.*;
import java.lang.Object;

// for multiple flights
class Journey
{
	private List<Flight> flights = new ArrayList<Flight>();
	private Flight flight;
	private String source;
	private String destination;
	private String terminal;
	private String flightNumber;
	private Calendar schedDepartTime;
	private Calendar estDepartTime;
	private Calendar schedArriveTime;
	private Calendar estArriveTime;
	
	// sets journey class fields to null
	public Journey()
	{
		// flights to null
		for(int i = 0; i < flights.size(); i++)
		{
			flights.set(i, null);
		}
	}
	
	public void newJourney(String flightNo)
	{	
		//gets the data from the input flight number
		DataGrabber flightInfo = new DataGrabber(flightNo);

		source = flightInfo.getDepartureAirport();
		destination = flightInfo.getArrivalAirport();
		terminal = "Terminal 3"; //test code, for real thing use: flightInfo.getTerminal()
		flightNumber = flightNo;
		
		schedDepartTime = flightInfo.getDepartureTime();
		try
		{
			estDepartTime = flightInfo.getDepEstimate();
		}
		catch(NullPointerException n)
		{
			estDepartTime = schedDepartTime;
		}
		
		schedArriveTime = flightInfo.getArrivalTime();
		try
		{
			estArriveTime = flightInfo.getArrEstimate();		
		}
		catch(NullPointerException n)
		{
			estDepartTime = schedDepartTime;
		}		
		
		flight = new Flight(source, destination, terminal, schedDepartTime, estDepartTime, schedArriveTime, estArriveTime);
	}
	
	// calculates the delay based on the scheduled and estimated departure times
	public String officialDelay()
	{
//		SimpleDateFormat schedTime = new SimpleDateFormat("HH:mm:ss");
//		SimpleDateFormat estTime = new SimpleDateFormat("HH:mm:ss");
		
		Date time1 = schedDepartTime.getTime();
		Date time2 = estDepartTime.getTime();
		
		long sum = time2.getTime() - time1.getTime();
		
		String delay = String.valueOf(sum);
		
		return delay;
	}
	
	//gets scheduled departure time
	public String schedDepTime()
	{
		return flight.getDepartTime();
	}

	//gets estimated departure time
	public String estDepTime()
	{
		return flight.estDepartTime();
	}	
	
	//get flight number
	public String flightNo()
	{
			return flightNumber;		
	}
	
	public String airportCode()
	{
//		int arraysize = flights.size();
		
		return flight.sourceCode();		
	}
	
	public String airportName()
	{
//		int arraysize = flights.size();
		
		return flight.sourceAirportName();
	}
	
	public String getSourceTerminal()
	{
		return flight.getTerminal();
	}
}