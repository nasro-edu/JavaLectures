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
   final private Location loc; //by the way, class composition
   private int population;	//pop can change
   
  // public Country(){}
   public ImmutableCountry(String name, Location loc, int population) {
	this.name = name;
	this.loc= loc;// this is not good since loc can be modified from outside this code
	//uncomment the following for a defensive (robust) copy -  this is defensive copy 
	//Location aLoc = new Location(loc);
	//this.loc= aLoc;
	
   }
   public String toString() {return "\n name="+name+" ; indep date="+loc.toString()+" ; pop="+population;}

   // cannot assign a value to a final name  - data member
   //public void setName(String name){ this.name= name;}
   // cannot assign a value to a final loc - data member
   //public void setLocation(Location loc){ this.loc= loc;}
}

//subclass cannot inherit from final classes
//uncomment 36 to see what happens
//class ChildClass extends ImmutableCountry {}

//testing final methods
// a final method can be inherited?  yes/no
//uncomment line 64 to see if a final method can be overriden?  yes/no
class A
{ int a;
  //final 
  InnerObj insideObj;
  //public A (){ a=10; insideObj = new InnerObj(2, 3);}
  public void  setInnerObj (){	//insideObj = new InnerObj(4, 6);
  								insideObj.x=4; insideObj.y=6;}
  public InnerObj getInnerObj() {return insideObj;}
  public void setInnerObj(InnerObj insideObj) {this.insideObj= insideObj;}
  
  final public void  methodofA1(int a){ this.a= a;}
  final private void  methodofA2(int a){ this.a= 2*a;}
  final public void  methodofA3(int a){ this.a= 3*a;}
  public void inherit(){System.out.println("methid in A class");}
}

class B extends A 
{  // whatever data members of B
	public void inherit() 
		{ 	methodofA1(30); // final method inherited
			//methodofA2(10); // why this final method is NOT inherited
		System.out.println("B overriding the inherited methods=");}
		
	//public void  methodofA3(int a){ this.a= a+10;}
	public void  methodofA3(double a){ this.a= (int)a+10;}


}

class InnerObj 
{ 	int x, y;
	public InnerObj(int x, int y) {
		setInnerObj(x, y);
		}
	public void setInnerObj(int x, int y) {
		this.x = x;		this.y = y;
	}
	
}