package Lecture1;

import java.util.Optional;

public class Opt_Client_Test {

	public static void main(String[] args) {
		CreditCard card1 = null, card2 = new CreditCard("VISA", "123456");
		//Opt_Client cli1= new Opt_Client("lim", 21, card); 
		Opt_Client cli1= new Opt_Client("lim", 21, Optional.of(card2)); 
		Opt_Client cli2= new Opt_Client("peter", 31, Optional.ofNullable(card1)); 
	System.out.println(cli1);
	System.out.println(cli2);
	
	}

}
