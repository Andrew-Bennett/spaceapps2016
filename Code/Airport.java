import java.util.*;
import java.util.Date;
import java.util.TimeZone;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.io.*;
import java.lang.Object;

class Airport
{
	private List<Calendar> localTimes = new ArrayList<Calendar>(); //probably not needed here
	private List<String> acronyms = new ArrayList<String>();
	private List<String> airportNames = new ArrayList<String>();
	private BufferedReader bufferedReader;
	private String acronym;
	private String name;
	private String timeZone;
	private TimeZone zone;

	// all structures to null	
	public Airport()
	{
		//localtimes to null
		for(int i = 0; i < localTimes.size(); i++)
		{
			localTimes.set(i, null);
		}
		
		//acronyms to null
		for(int i = 0; i < acronyms.size(); i++)
		{
			acronyms.set(i, null);
		}
		
		//airportNames to null
		for(int i = 0; i < airportNames.size(); i++)
		{
			airportNames.set(i, null);
		}
	}
	
	public void newAirport(String airports, String airportCode) throws FileNotFoundException //argument is text file containing airport lists
	{	
		airportCode = "DXB"; //test airport code
		setAcronym(airportCode);
		// code to read airport list text file.
		FileReader airportList = new FileReader(airports);
		bufferedReader = new BufferedReader(airportList);
		
		
		// read airport list
		try
		{
			readList();
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("File Not Found: " + airports + ". Terminating");
			System.exit(0);
		}
		
		catch(IOException iO)
		{
			System.out.println("IOException occurred. Terminating.");
			System.exit(0);
		}
	}
	
	//reads the airport list 
	public void readList() throws IOException
	{
		String line;
		String airportID;
		
		line = bufferedReader.readLine();

		// scans list for acronym
		if(line != null)
		{
			line = bufferedReader.readLine();				
			airportID = readAirportID(line);
			
			do
			{				
				readAirport(line);					
			}
			while(airportID.equals(acronym));
		} 
	}
	
	// reads airport code/acronym from airport list file
	private String readAirportID(String airport)
	{
		String[] airportName = airport.split(":");
		
		String airportID = airportName[0];
		
		return airportID;
	}
	
	private void readAirport(String airport) //argument is the current line being read
	{
		// split up the lines in the text file
		String[] airportName = airport.split(":");
		
		String code = airportName[0];
		String fullName = airportName[1];
		String timeZoneID = airportName[2];
				
		// add new element to each array (might not be neccessary)
//		acronyms.add(code);
//		airportNames.add(fullName);
//		zone.setID(timeZoneID);
//		localTimes.add(date); //probably not needed
		setAirportName(fullName);
	}
	
 	public void setAcronym(String code)
	{
		acronym = code;
	} 
	
	public String getAcronym()
	{
		//returns the acronym of the airport
		return acronym;
	}	
	
 	public void setAirportName(String fullName)
	{
		name = fullName;
	} 
	
	public String getAirportName()
	{
		//returns the full name of the airport
		return name;
	}
	
	public TimeZone getlocalTimeZone()
	{
		//returns the localTime of the airport with that name
		return zone;
	}					
}