import java.util.*;
import java.util.Date;
import java.util.TimeZone;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.io.*;
import java.lang.Object;
import java.text.ParseException;

// entry point(main class)
class DelayPsychic
{
	private Airport airport;
	private Calendar departDate = Calendar.getInstance();
	private String Acronym;
	private String Name;
	private Calendar date;
	private int id;
	private Journey journey;
	private String flightNo;

	public static void main(String[] args)
	{
		new DelayPsychic();
	}
	
	public DelayPsychic()
	{
		journey = new Journey();
		flightNo = "BA007";
		
		journey.newJourney(flightNo);

		System.out.println("");
		System.out.println("                          Your Journey:"); //Title	
		System.out.println("                            Outbound:");
		System.out.println("");
		System.out.println("Flight Number: " + journey.flightNo()); // prints the flight number		
		System.out.println("");
		System.out.println("Departing From: " + journey.sourceAirportCode() + " " + journey.sourceAirportName() ); // prints the source airport code
		System.out.println("Terminal: " + journey.getSourceTerminal());
		System.out.println("Scheduled Departure Time: " + journey.schedDepTime()); // prints the scheduled departure time 	
		System.out.println("Estimated Departure Time: " + journey.estDepTime());

		try
		{
			System.out.println("Reported Delay: " + journey.officialDelay() + " hours"); //prints reported delay, based on scheduled and estimated departure times	
		}
		catch(ParseException p)
		{
			System.out.println("ParseException Occured");
		}

		System.out.println(" ");
		System.out.println("Destination: " + journey.sourceAirportCode() + " " + journey.sourceAirportName() );
		System.out.println("Scheduled Arrival Time: " + journey.schedArrTime() ); // prints the scheduled departure time 	
		System.out.println("Estimated Arrival Time: " + journey.estArrTime() );
	}

	
	
	
	//test code for airport class
/* 	public void airports()
	{
		SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
		airport = new Airport();
		airport.newAirport("MAN", "Manchester", departDate);
		id = airport.getid();
		Acronym = airport.getAcronym();
		date = airport.getlocalTime();
		
		System.out.println("Airport: " + Acronym);
		System.out.println("Airport ID: " + id);
		System.out.println("Local Time: " + time.format(date.getTime()) );
	} */
}