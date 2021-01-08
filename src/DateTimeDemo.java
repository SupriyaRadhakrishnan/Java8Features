import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;

public class DateTimeDemo {

	/*
	 * Old Datetime API
	 * Date is 2 packages.
	 * java.text was used for date formatting
	 * Date classes are not thread safe.
	 * 
	 * New DateTime API
	 * Immutable. creates a new Object.
	 * 
	 */
	public static void main(String[] args) {
		/**************Date**************/
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate);//gives only date in yyyy-MM-dd format
		LocalDate localDate1 = LocalDate.of(1989,12,9); //Year,Month,Date 
		         //or
		          localDate1 = LocalDate.of(1989,Month.DECEMBER,9);//1989-12-9
		          /*We can use the enum in Month.If we give LocalDate.of(1989,Month.FEBRUARY,30); - checks even if the year was leap year
		           * Exception in thread "main" java.time.DateTimeException: Invalid date 'FEBRUARY 30'
	at java.time.LocalDate.create(Unknown Source)
	at java.time.LocalDate.of(Unknown Source)
	at DateTimeDemo.main(DateTimeDemo.java:23*/
		           
		System.out.println(localDate1);
		
		/**************Time**************/
		LocalTime t = LocalTime.now();  // this gives value based on the system time zone.
		LocalTime t1 = LocalTime.of(12,35,10,999); // 
		System.out.println(t);//13:52:57.661
		System.out.println(t1);//12:35:10.000000999 hh:mm:ss ms
		
		//Getting Zone Ids - this returns a set of the zoneids.
		for(String s :ZoneId.getAvailableZoneIds())
		{
		//System.out.println(s);
		}
		
		LocalTime t2 = LocalTime.now(ZoneId.of("Africa/Cairo")); //21:01:03.427
		System.out.println(t2);
		/**************Instant Class**************/
		//Instant class - used for machine readable
		Instant i = Instant.now();
	System.out.println(i);//2021-01-08T19:02:45.561Z in GMT 
		
	/**************Instant Class**************/
	
	LocalDateTime ldt = LocalDateTime.now();
	
	System.out.println(ldt); //2021-01-08T14:03:57.791
	
	}

}
