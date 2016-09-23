package Lecture1;
import java.sql.Date;

import Lecture1.*;

/**
 * 
 */

/**
 * @author nasro
 *
 */
public class Immuatble {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) {
	
		Location loc = new Location(52.2, 32.5);
		ImmutableCountry canada = new ImmutableCountry("Canada", loc, 213000);
		System.out.println(canada);
		loc.setLatitude(22.4, 11.4);
		System.out.println(canada);
		
	}

}
