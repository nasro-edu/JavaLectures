/**
 * 
 */
package Lecture2.Inheritance;

/**
 * @author nasro
 *
 */
public class Main_InheritanceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
// to test which members of a super class are passed down (inherited) to derived classes
		A objA = null; 
		objA = new A();
		B objB = new B();
		B objB1 = new B(11);
		C objC = new C();
		B objC1 = new C();
		
		System.out.println("objA"+objA);
		System.out.println("objB"+objB);
		System.out.println("objC"+objC);
		System.out.println("objC"+objC1);
		
		//--------------
		// a data member inherited in derived classes is not linked to the originila one
		System.out.println("elem c in A:"+objA.c);
		System.out.println("elem c in B:"+objB.c);
		System.out.println("elem c in A:"+objA.c);
		System.out.println("elem c in C:"+objC.c);
		
		//---------
		//a static membetr is NOT inherited
		System.out.println("static in A:"+A.staticElem);
		System.out.println("static in B: "+(++objB.staticElem));
		System.out.println("static in A:"+A.staticElem);
		System.out.println("static in C: "+objC1.staticElem);

	}

}
//------------------
class A
{ public static int staticElem=5;
	private int a;
  protected int b;
  public int c;
   int d;
//  public A() {this.c=3;a=1;b=2;}
 // public A(int c) {this.c=c;}
   public void methodA1() {a=5;System.out.println(" using methodA1 of A");}
   protected void methodA2 () {System.out.println(" using methodA2 of A");}
   private void methodA3 () {System.out.println(" using methodA3 of A");}
   public String toString() {
		return "A [a=" + a + ", b=" + b + ", c=" + c + ", d=" + d + "]";
	   }
 }
//---
class B extends A
{  int b1;
  	public B() {b1=10;c=20;this.staticElem=6;}
	public B(int b1) {
		this.b1 = b1;
	}
  
	public String toString() {
		return "B [b1=" + b1 + ", b=" + b + ", c=" + c + ", d=" + d + " , staticElem ="+this.staticElem+"]";
	}
 }

class C extends B 
{    private int c1;
     public C() {c1=33;}
	@Override
	public String toString() {
		return "C [c1=" + c1 + ", b1=" + b1 + ", b=" + b + ", c=" + c + ", d=" + d + ", staticElem ="+this.staticElem+"]";
	}

	}
