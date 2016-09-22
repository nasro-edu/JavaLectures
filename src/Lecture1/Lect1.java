/**
 * 
 */
package Lecture1;

/**
 * @author nasro
 *
Copy Construtor
easily implemented
extract the argument's data members, and assign to a regular constructor
are unnecessary for immutable objects */
public class Lect1 {

}

class Example
{  private int xA;
	private String aText;

	public Example(int xA, String aText) {
		this.xA = xA;
		this.aText = aText;
	}
	public Example(Example obj) {
	      this (obj.xA, obj.aText);
	      // or this.xA = obj.xA;  this.aText = obj.aText;
	}

}