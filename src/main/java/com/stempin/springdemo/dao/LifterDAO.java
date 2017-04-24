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

    @Transactional
    public List<Lifter> getLifters() {

        //get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        //create a query
        Query<Lifter> theQuery = currentSession.createQuery("from Lifter", Lifter.class);

        //execute query amd get the list of customers
        List<Lifter> lifters = theQuery.getResultList();

        //return the results
        return lifters;
    }
}
