package selenium;

public class Employeeconstructor {
	
	int empid;
	String empname;
	int salary;
	
	public Employeeconstructor(int empid, String empname, int salary) {
		this.empid = empid;
		this.empname = empname;
		this.salary = salary;
	}
    public void display()
    {
    	System.out.println("id"+empid);
    	System.out.println("name"+empname);
    	System.out.println("salary"+salary);

    	
    }
	public static void main(String[] args) {
		Employeeconstructor emp=new Employeeconstructor(101, "dona", 300000);
		emp.display();
	}

}
