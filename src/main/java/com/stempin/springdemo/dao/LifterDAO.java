package com.stempin.springdemo.dao;

import com.stempin.springdemo.entity.Lifter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class LifterDAO implements ILifterDAO{

    //need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    public List<Lifter> getLifters() {

        //get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        //create a query ... sort by last name
        Query<Lifter> theQuery = currentSession.createQuery("from Lifter order by lastName", Lifter.class);

        //execute query amd get the list of customers
        List<Lifter> lifters = theQuery.getResultList();

        //return the results
        return lifters;
    }

    public void saveLifter(Lifter theLifter) {
        //get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        //save the customer ... finally
        currentSession.saveOrUpdate(theLifter);
    }

    public Lifter getLifter(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Lifter lifter = currentSession.get(Lifter.class, theId);

        return lifter;
    }

    public void deleteLifter(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query theQuery = currentSession.createQuery("delete from Lifter where id=:lifterId");
        theQuery.setParameter("lifterId", theId);

        theQuery.executeUpdate();
    }

    public List<Lifter> searchCustomer(String theSearchName) {
       Session currentSession = sessionFactory.getCurrentSession();
       Query theQuery = null;
       if (theSearchName != null && theSearchName.trim().length() > 0) {
           theQuery = currentSession.createQuery("from Lifter where lower(firstName) like :theName or lower" +
                   "(lastName) like :theName", Lifter.class);
           theQuery.setParameter("theName","%" + theSearchName.toLowerCase()+"%");
       }
       else {
           theQuery = currentSession.createQuery("from Lifter", Lifter.class);
       }

       List<Lifter> lifters = theQuery.getResultList();

       return lifters;
    }
}
