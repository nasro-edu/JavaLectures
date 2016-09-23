/**
 * 
 */
package Lecture1;

import java.util.Optional;

/**
 * @author nasro
 *
 */
public class Opt_Client {
private String name;
private int age;
private CreditCard card;  // there is no need to declare fata member optional (doesnt make sense)

public Opt_Client(String name, int age, Optional <CreditCard> card) {
	this.name = name;
	this.age = age;
	CreditCard defCard = new CreditCard("VVVV", "1111"); 
	//CreditCard defCard = null; 
	this.card = card.orElse(defCard);
	//or	this.card = card.orElse(null);
	}

	@Override
	public String toString() {
		return "Opt_Client [name=" + name + ", age=" + age + "*"+
				( (this.card==null)?"*":this.card.toString());
						//", card=" + card + "]";
	}
}
//------------
class CreditCard{
	private String type;
	private String number;
	public CreditCard(String type, String number) {
		this.type = type; this.number = number;
	}
	@Override
	public String toString() {
		//return "CreditCard [type=" + type + ", number=" + number + "]";
		return type + "*" + number ;
	}
		
}