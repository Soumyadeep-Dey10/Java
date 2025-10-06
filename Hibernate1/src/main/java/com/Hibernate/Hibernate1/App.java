package com.Hibernate.Hibernate1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args )
    {
        Student ob1 = new Student();
//        ob1.setId(18);
//        ob1.setName("Rup");
//        ob1.setMarks(82);
        
        //when using StudentName object
        StudentName s = new StudentName();
        s.setFname("AB");
        s.setMname("De");
        s.setMname("Villiers");
        
        ob1.setId(17);
        ob1.setName(s);
        ob1.setMarks(99);
/*        
save method belongs to interface called session and this interface belongs 
to hibernate framework.

Session session //Session is a interface, so we cannot create object of 
this interface, so we need a class which implements session interface,
but we do not have a class that implements session interface.
        
so we need object of Session Factory, but sessionFactory also is an 
interface, for that we need Configuration class
*/        
        Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
        SessionFactory sf = con.buildSessionFactory(); //this done the job of ServiceRegistry also
        Session session = sf.openSession(); //openSession is a method which will give the object of session interface
        
        //whenever we are saving the data into DB we are making some changes, so we need to follow the ACID property
        
        Transaction tx = session.beginTransaction();
        
        session.persist(ob1);
        
        //fetching data from the DB, also need to typecast 
//        ob1 = (Student)session.get(Student.class, 18);
//        System.out.println(ob1);
        
        tx.commit();
        session.close();
        sf.close();
    }
}
