package Lecture2.Inheritance;
import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;

import Lecture2.Inheritance.Employee.Qualification;
import dw317.lib.Name;

/**
 * @author hnasreddine
 *
 */

public class Main_TestInheritance {

		public static void main(String[] args) {
			//Employee [10] emp = new Employee[10];
			Name name = new Name("Dany", "Ali"); short  age= 21;
			String emp_Id="4455667788"; double baseSalary = 1000.0; short experience=6; 
			Employee.Qualification qualif = Qualification.MSC;
			
			FullTimeEmployee dany = new FullTimeEmployee(name, age, emp_Id, experience, qualif, baseSalary);
			System.out.println(dany.toString());
		//------------------------------
			name = new Name("Jerry", "Lewis");   age= 31;
			emp_Id="11227788"; double rate = 60.0, nberWorkingHours=15;  experience=22; 
			qualif = Qualification.TBC;
			
			PartTimeEmployee jerry = new PartTimeEmployee(name, age, emp_Id, experience, qualif, rate, nberWorkingHours);
			System.out.println(jerry.toString());
			//------------------------------
			name = new Name("Sara", "Hill");   age= 18;
			short year = 3; String program="Com Sce"; double baseScholarship = 1000.0, gpa=3.6; 
			
			Student sara = new Student(name, age, year, program, baseScholarship, gpa) ;
			System.out.println(sara.toString());
		//----
			Person obj1, obj2;
			obj1 =  dany;  obj2= sara;
			if (compareIncome(obj1, obj2)>0) System.out.println(obj1.getName()+" is getting motre than "+ obj2.getName());
			else	System.out.println(obj2.getName()+" is getting motre than "+ obj1.getName());

			//---- this will be useful if we damp all objects i ArrayList and sort them out according to a crierai (income for instance)	
			ArrayList <Person> personList = new ArrayList<Person>();
			personList.add(sara);personList.add(jerry);personList.add(dany);
			System.out.println("\n ----------- before sorting ----------- ");
			System.out.println(personList.toString());
			Collections.sort(personList);
			System.out.println("\n ----------- AFTER sorting ----------- ");
			System.out.println(personList.toString());
			personList.forEach(m-> {
				
									}
							);
		}

		//------ here we comapre incomes of differnt objects of person
		// --- genric coding,  dynamic binding, polymorphism, overriding
		public static short compareIncome(Person obj1, Person obj2)
		{
			if(obj1.getIncome()>obj2.getIncome()) return 1;
			if(obj1.getIncome()==obj2.getIncome()) return 0;
			return -1;
		}
		//---- disply objects 
		
}