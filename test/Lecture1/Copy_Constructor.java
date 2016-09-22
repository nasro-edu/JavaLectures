
/**
 * 
 */

/**
 * @author nasro
 *
 */
public class Copy_Constructor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Example ex1 = new Example(10, "obj1");
		System.out.println(ex1);
		Example  ex3 = ex1;
		ex3.setX(11);
		//what happen to ex1
		System.out.println(ex1);
		
		System.out.println("\n ----- testing  ex2 and ex4 ");		
		Example ex2 = new Example(20, "obj2");
		Example ex4 = new Example(ex2);
		System.out.println(ex2);System.out.println(ex4);
		ex4.setX(21);
		System.out.println(ex2);System.out.println(ex4);
		
		Example [] myList = new Example[4];
		myList[0]=ex1;myList[1]=ex2;myList[2]=ex3;myList[3]=ex4;
		
		//for( Example elem : myList)
		//		System.out.println(elem);
	}

}
//------------------
class Example
{  private int x;
	private String name;

	public Example() {}
	public Example(int x, String name) {
		this.x = x;
		this.name = name;
	}
	public Example(Example obj) {
	      this (obj.x, obj.name);
	      // or this.xA = obj.xA;  this.aText = obj.aText;
	}
	public String getName () {return name;}
	public void setX(int x) {this.x = x;}
	public String toString() {return "/n name="+name+" // x="+x;}
}
