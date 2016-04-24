import java.util.*;
import java.util.Date;
import java.util.TimeZone;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.io.*;
import java.lang.Object;
import java.text.ParseException;

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
	public String officialDelay() throws ParseException
	{
		String time1 = schedDepTime();
		String time2 = estDepTime();
		
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		
		Date t1 = format.parse(time1);
		Date t2 = format.parse(time2);
		
		long sum = t2.getTime() - t1.getTime();
		
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
	
	//gets scheduled departure time
	public String schedArrTime()
	{
		return flight.getArriveTime();
	}

	//gets estimated departure time
	public String estArrTime()
	{
		return flight.estArriveTime();
	}	
	
	//get flight number
	public String flightNo()
	{
			return flightNumber;		
	}
	
	public String sourceAirportCode()
	{
		return flight.sourceCode();		
	}
	
	public String sourceAirportName()
	{
		return flight.sourceAirportName();
	}
	
	public String targetAirportCode()
	{
		return flight.targetCode();		
	}
	
	public String targetAirportName()
	{
		return flight.targetAirportName();	
	}
	
	public String getSourceTerminal()
	{
		return flight.getTerminal();
	}
}