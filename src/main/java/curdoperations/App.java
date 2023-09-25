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

