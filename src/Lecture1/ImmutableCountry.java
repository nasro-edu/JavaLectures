/**
 * 
 */
package Lecture1;

import java.util.Date;

/**
 * @author nasro
 *
 */
// final class can be either abstract or final , not both
////all methods in a final class are automatically final 
public final class ImmutableCountry
{  final private String name;
   final private Location loc;
   private int population;
   
  // public Country(){}
   public ImmutableCountry(String name, Location loc, int population) {
	this.name = name;
	//this.loc= loc;// this is not good since loc can be modified from outside this code
	// this is defensive copy 
	Location aLoc = new Location(loc);
	this.loc= aLoc;
	
   }
   public String toString() {return "\n name="+name+" ; indep date="+loc.toString()+" ; pop="+population;}

   // caanot assign a value to a final name  - data member
   //public void setName(String name){ this.name= name;}
   // caanot assign a value to a final loc - data member
   //public void setLocation(Location loc){ this.loc= loc;}
}

//subclass cannot inherit from final classes
//class ChildClass extends ImmutableCountry
//{}