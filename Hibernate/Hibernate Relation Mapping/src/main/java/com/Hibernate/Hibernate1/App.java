package com.Hibernate.Hibernate1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args )
    {
        
        
        Laptop l = new Laptop();
        l.setLid(101);
        l.setLname("Dell");
        

        Student ob1 = new Student();
        ob1.setRollno(18);
        ob1.setName("Rup");
        ob1.setMarks(82);
        ob1.getLaptop().add(l);
        
        l.getStudent().add(ob1);
       
        Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        SessionFactory sf = con.buildSessionFactory(); //this done the job of ServiceRegistry also
        Session session = sf.openSession(); //openSession is a method which will give the object of session interface
        
       
        
        Transaction tx = session.beginTransaction();
        
        session.persist(ob1);
        session.persist(l);
        
        
        tx.commit();
        session.close();
        sf.close();
    }
}
