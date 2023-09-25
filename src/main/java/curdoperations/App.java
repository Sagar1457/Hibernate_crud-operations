package curdoperations;
////BVIDHYASAGAR..AF0320724
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import curdoperations.model.Employee_Details;

public class App 
{
    public static void main( String[] args )
    {
    	SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        try
        {
        	//To enter the details
       	    for(int i=1;i<=5;i++) 
        	{
        	Employee_Details user=new Employee_Details();
        	user.setEmployee_Name("user "+i);
        	user.setEmployee_Dept("tester");
        	user.setEmployee_Role("fresher");
        	session.save(user);
        	}
        	
       	    //Reading or retrieving the data
       	    {
        	Employee_Details user=session.get(Employee_Details.class, 3);
        	System.out.println("Employee Dept:"+user.getEmployee_Dept());
       	    }
        	
			
			//Update the user details
       	    {
			Employee_Details user=session.get(Employee_Details.class, 3);
			System.out.println("Employee Dept:"+user.getEmployee_Dept());
			user.setEmployee_Dept("Devloper");
			System.out.println("Employee Dept:"+user.getEmployee_Dept());
			session.update(user);
			session.getTransaction().commit();
			session.save(user);
       	    }
			//Delete the user Details
       	    {
			Employee_Details user=session.get(Employee_Details.class, 5);
			session.delete(user);
			session.getTransaction().commit();}
        }
        finally
        {
        	session.close();
        	sessionFactory.close();
        }
    }
}
/*
output:-
---------
showing database;
mysql> use  hcurdoperations;
Database changed
mysql> show tables;
+---------------------------+
| Tables_in_hcurdoperations |
+---------------------------+
| userdetails               |
+---------------------------+
1 row in set (0.00 sec)
---------------------------------
Runing program to Add employees:-

mysql> show tables;
+---------------------------+
| Tables_in_hcurdoperations |
+---------------------------+
| employee_details          |
| userdetails               |
+---------------------------+
2 rows in set (0.00 sec)

mysql> select * from employee_details;
+-------------+---------------+---------------+---------------+
| Employee_Id | Employee_Dept | Employee_Name | Employee_Role |
+-------------+---------------+---------------+---------------+
|           1 | tester        | user 1        | fresher       |
|           2 | tester        | user 2        | fresher       |
|           3 | tester        | user 3        | fresher       |
|           4 | tester        | user 4        | fresher       |
|           5 | tester        | user 5        | fresher       |
+-------------+---------------+---------------+---------------+
5 rows in set (0.01 sec)
================================================
2.Display
Hibernate: select employee_d0_.Employee_Id as 
employee1_0_0_, employee_d0_.Employee_Dept as 
employee2_0_0_, employee_d0_.Employee_Name as 
employee3_0_0_, employee_d0_.Employee_Role as 
employee4_0_0_ from Employee_Details employee_d0_ 
where employee_d0_.Employee_Id=?

Employee Dept:tester
===================================================
mysql> select * from employee_details;
+-------------+---------------+---------------+---------------+
| Employee_Id | Employee_Dept | Employee_Name | Employee_Role |
+-------------+---------------+---------------+---------------+
|           1 | tester        | user 1        | fresher       |
|           2 | tester        | user 2        | fresher       |
|           3 | tester        | user 3        | fresher       |
|           4 | tester        | user 4        | fresher       |
|           5 | tester        | user 5        | fresher       |
+-------------+---------------+---------------+---------------+
5 rows in set (0.00 sec)

mysql> select * from employee_details;
+-------------+---------------+---------------+---------------+
| Employee_Id | Employee_Dept | Employee_Name | Employee_Role |
+-------------+---------------+---------------+---------------+
|           1 | tester        | user 1        | fresher       |
|           2 | tester        | user 2        | fresher       |
|           3 | Devloper      | user 3        | fresher       |
|           4 | tester        | user 4        | fresher       |
|           5 | tester        | user 5        | fresher       |
+-------------+---------------+---------------+---------------+
5 rows in set (0.00 sec)
mysql> select * from employee_details;
+-------------+---------------+---------------+---------------+
| Employee_Id | Employee_Dept | Employee_Name | Employee_Role |
+-------------+---------------+---------------+---------------+
|           1 | tester        | user 1        | fresher       |
|           2 | tester        | user 2        | fresher       |
|           3 | Devloper      | user 3        | fresher       |
|           4 | tester        | user 4        | fresher       |
|           5 | tester        | user 5        | fresher       |
+-------------+---------------+---------------+---------------+
5 rows in set (0.00 sec)

mysql> select * from employee_details;
+-------------+---------------+---------------+---------------+
| Employee_Id | Employee_Dept | Employee_Name | Employee_Role |
+-------------+---------------+---------------+---------------+
|           1 | tester        | user 1        | fresher       |
|           2 | tester        | user 2        | fresher       |
|           3 | Devloper      | user 3        | fresher       |
|           4 | tester        | user 4        | fresher       |
+-------------+---------------+---------------+---------------+
4 rows in set (0.00 sec)
*/
