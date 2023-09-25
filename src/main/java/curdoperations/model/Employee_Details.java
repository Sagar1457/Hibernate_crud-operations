package curdoperations.model;
//BVIDHYASAGAR..AF0320724
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee_Details 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Employee_Id;
	private String Employee_Name;
	private String Employee_Dept;
	private String Employee_Role;
	public Employee_Details() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee_Details(int employee_Id, String employee_Name, String employee_Dept, String employee_Role) {
		super();
		Employee_Id = employee_Id;
		Employee_Name = employee_Name;
		Employee_Dept = employee_Dept;
		Employee_Role = employee_Role;
	}
	public int getEmployee_Id() {
		return Employee_Id;
	}
	public void setEmployee_Id(int employee_Id) {
		Employee_Id = employee_Id;
	}
	public String getEmployee_Name() {
		return Employee_Name;
	}
	public void setEmployee_Name(String employee_Name) {
		Employee_Name = employee_Name;
	}
	public String getEmployee_Dept() {
		return Employee_Dept;
	}
	public void setEmployee_Dept(String employee_Dept) {
		Employee_Dept = employee_Dept;
	}
	public String getEmployee_Role() {
		return Employee_Role;
	}
	public void setEmployee_Role(String employee_Role) {
		Employee_Role = employee_Role;
	}
}
