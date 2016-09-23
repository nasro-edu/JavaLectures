/**
 * 
 */
package Lecture1;

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

   // cannot assign a value to a final name  - data member
   //public void setName(String name){ this.name= name;}
   // cannot assign a value to a final loc - data member
   //public void setLocation(Location loc){ this.loc= loc;}
}

//subclass cannot inherit from final classes
//class ChildClass extends ImmutableCountry
//{}

//testing final methods
// a final method can be inherited?  yes/no
//uncomment line 54 to see if a final method can be overriden?  yes/no
class A
{ int a;
  final public void  methodofA1(int a){ this.a= a;}
  final private void  methodofA2(int a){ this.a= 2*a;}
  public void inherit(){System.out.println("methid in A class");}
}

class B extends A 
{  // whatever data members of B
	public void inherit() 
		{ 	methodofA1(30); // final method inherited
			//methodofA2(10); // why this final method is NOT inherited
		System.out.println("B overriding the inherited methods=");}

	//public void  methodofA(int a){ this.a= a+10;}


}