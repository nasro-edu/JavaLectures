/**
 * 
 */
package Lecture2.Inheritance;

import Lecture2.Inheritance.Employee.Qualification;
import dw317.lib.Name;

/**
 * @author nasro
 *
 */
public class Main_TestCasting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Main_TestCasting aa= new Main_TestCasting();
		Class_B bb ; int b=10;
		bb = aa.new Class_B(5,6,7);
		Class_A a ; b=10;
		a = aa.new Class_A(b);
		//1. Instantiating abstract classes
		// can we instantiate an abstract class?
		//Employee emp1 = new Employee();

		//2.1  upcasting 
		Name nameEmp1 = new Name("Julien", "peter");
		PartTimeEmployee emp1Parttime = new PartTimeEmployee(nameEmp1, 31,"e1234", (short) 10, Qualification.BSC, 20.5, 10);
		Person p1 = emp1Parttime;  // correct (up-casting)
		
		//2.2 down-casting (explicit)
		System.out.println(emp1Parttime.getName()+" income per 10hrs:"+ emp1Parttime.getIncome());
		System.out.println(emp1Parttime.getName()+" rate:"+ emp1Parttime.getRate());
		System.out.println("p1 employee assigned parttime employee -"+p1.getIncome());
		//System.out.println(p1.getRate());  //wrong
		System.out.println(p1.getName()+" erans:"+((PartTimeEmployee)p1).getRate()); // needs explicit casting

		
		//2.2 more on   down-casting 
		Name nameEmp2 = new Name("Connors", "sara");
		Person emp2FullTime =  new FullTimeEmployee(nameEmp2, 42,"e4567", (short) 25, Qualification.MSC, 4900.0); 
		
		
		Employee emp2 = new FullTimeEmployee(nameEmp2, 42,"e4567", (short) 25, Qualification.MSC, 4900.0);
		
		Employee employeeListArr [] = new Employee[4];
		employeeListArr[0] = new PartTimeEmployee(emp1Parttime);
		employeeListArr[1] = new FullTimeEmployee( (FullTimeEmployee) emp2FullTime);  // why i used (FullTimeEmployee)
		employeeListArr[2] = new FullTimeEmployee(new Name("Leo", "Messi"),29,"e1247",(short)10,Qualification.TBC,950000.0);  // why i used (FullTimeEmployee)
		employeeListArr[3] = new PartTimeEmployee(new Name("Cris", "Ronaldo"),31,"e2347",(short)12,Qualification.TBC,6350.0,40);  // why i used (FullTimeEmployee)
		
		// can I access getRate of part timers?
		System.out.println(employeeListArr[3].getName()+" earns per week:"+((PartTimeEmployee)employeeListArr[3]).getRate());
		// can I access getBasicSalary for Full timers?
		System.out.println(employeeListArr[1].getName()+" earns per week:"+((FullTimeEmployee)employeeListArr[1]).getBasicSalary());
		
		//what if i use a for loop
		for (Employee anEmp : employeeListArr)
		{	System.out.print(anEmp.getName()+" earns: ");
			//System.out.println(anEmp.getRate());
			if (anEmp instanceof PartTimeEmployee) System.out.println(((PartTimeEmployee)anEmp).getRate());
			//compilation correct but will throw Class casting exception
			//else if (anEmp instanceof FullTimeEmployee) System.out.println(((PartTimeEmployee)anEmp).getRate());
			else if (anEmp instanceof FullTimeEmployee) System.out.println(((FullTimeEmployee)anEmp).getBasicSalary());
		}
	
	}

protected class Class_A{  private int data1;
				protected int data2;
  				private Class_A(int data1) {this.data1=data1;;}
  				private Class_A(int data1, int data2) {this.data2=data2;}
 				}
class Class_B extends Class_A{  int data3;
				public Class_B(int data1, int data2, int data3) 
					{super(data1, data2); this.data3=data3;}
				//public int getData1() {return this.data1;}
				}
}
