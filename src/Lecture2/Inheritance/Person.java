package Lecture2.Inheritance;

import dw317.lib.Name;

/**
 * @author hnasreddine
 *
 */
public abstract  class Person implements Comparable{
	protected Name name;  // composition ( consist of  relationship
	int age;
	protected  Person(Name name, int age) // notice protected ... why? 
	{	setName(name);//this.name = name; 
		setAge( age) ; //this.age=age;
		}
	public Name getName() {
		return name;
	}
	private void setName(Name name) {	this.name = name;}
	private void setAge(int age) {	this.age=age;}

	public String toString() {return super.toString()+"-----------------------------"+
			"\n Name ="+ this.name + ", Age="+this.age;}
	//--- abstract methods --> implementation later
	public abstract double getIncome();
	//public abstract String getSkills(){}  // why this is wrong?
	public abstract String getSkills();
	@Override
	public int compareTo(Object o) {
	
		//if (this.age>((Person) o).age) return 1;
		//else if (this.age<((Person) o).age) return -1;
		//return 0;
		
		if (this.getIncome()>((Person) o).getIncome()) return 1;
		else if (this.getIncome()<((Person) o).getIncome()) return -1;
		return 0;
	}
}
//--------------------------------
abstract class Employee extends Person{
	protected String emp_Id;
	protected short experience;
	protected Qualification  qualif;
	 enum Qualification {TBC,BSC,MSC,PHD} ;
	
	protected Employee(Name name, int age,  String emp_Id, short experience, Qualification qualif) {
		super(name, age);
		this.emp_Id= emp_Id;
		setExperience (experience); //this.experience=experience;
		this.qualif = qualif;
	}
	private void  setExperience (short experience)
	{ if (experience>60 || experience<0) throw new IllegalArgumentException("experinec doesnt make senese");
		this.experience=experience;
	}
	public String toString() {return super.toString()+"\n  Employee Id ="+ this.emp_Id+ ", Experience=="+this.experience+ ", Qualif = "+qualif;}
}
//-------------------- fullTimeEmployee --------------------
class FullTimeEmployee extends Employee
{
	private double baseSalary;
	protected FullTimeEmployee(Name name, int age, String emo_Id,  short experience, Qualification qualif, double baseSalary) {
		super(name, age, emo_Id, experience, qualif);
		this.baseSalary=baseSalary;
	}
	protected FullTimeEmployee(FullTimeEmployee emp) {
		super(emp.name, emp.age, emp.emp_Id, emp.experience, emp.qualif);
		this.baseSalary=emp.baseSalary;
	}
	@Override
	public double getIncome() {
        double factorExp=0.1;
		if(this.experience<5) factorExp=0.2;
		if(this.experience<10) factorExp=0.4;
		else factorExp=0.5;
		
		double factorQualif = 0.1;
		switch (this.qualif)
		{
		case TBC: factorQualif=0.2;break;case BSC: factorQualif=0.3;break;
		case MSC: factorQualif=0.5;break;case PHD: factorQualif=0.4;
		}
		return (baseSalary + (baseSalary*factorExp) + (baseSalary*factorQualif));
	}
	public String toString() {return super.toString()+"\n BaseSalary ="+ this.baseSalary + ", salary Readjusted="+this.getIncome();}
	@Override
	public String getSkills() {return this.qualif.toString();	}
	//proper method to FullTimers
	public double getBasicSalary() {return this.baseSalary;}
	
}
//-------------------- fullTimeEmployee --------------------
class PartTimeEmployee extends Employee
{
	private double rate;
	private double nberWorkingHours;
	
	
	public PartTimeEmployee(Name name, int age, String emp_Id, short experience, Qualification qualif, double rate,
			double nberWorkingHours) {
		super(name, age, emp_Id, experience, qualif);
		this.rate = rate; this.nberWorkingHours = nberWorkingHours;
	}
	public PartTimeEmployee(PartTimeEmployee emp) {
		super(emp.name, emp.age, emp.emp_Id, emp.experience, emp.qualif);
		this.rate = emp.rate;	this.nberWorkingHours = emp.nberWorkingHours;
	}
	
	@Override
	public double getIncome() {
      	return (this.rate*this.nberWorkingHours);
	}
	public String toString() {return super.toString()+"\n rate ="+ this.rate+ ", Nber Hours="+
											this.nberWorkingHours+" -->salary Readjusted="+this.getIncome();}
	@Override
	public String getSkills()  {return this.qualif.toString();	}
	//proper method to PartTimers
	public double getRate() {return this.rate;}
}
//---------------- Student ---------------------

class Student extends Person
{
	private short year;
	private String program;
	private double baseScholarship;
	private double gpa;
	
	
	public Student(Name name, int age, short year, String program, double baseScholarship, double gpa) {
		super(name, age);
		this.year = year;
		this.program = program;
		this.baseScholarship= baseScholarship;
		this.gpa = gpa;
	}
	@Override
	public double getIncome() {
		double factorPerfom= 0.0;
		if(this.gpa>3.9)	factorPerfom= 1;
		else if(this.gpa>3.5)	factorPerfom= 0.8;
		else if(this.gpa>3.0)	factorPerfom= 0.5;
		else if(this.gpa>2.5)	factorPerfom= 0.3;
		return  (baseScholarship+ (baseScholarship*factorPerfom) );
	}
	public String toString() {return super.toString()+"\n Year ="+ this.year+ ", program="+
											this.program+" -->schoklarship="+this.getIncome();}
	@Override
	public String getSkills()  {return this.program;	}
	
}