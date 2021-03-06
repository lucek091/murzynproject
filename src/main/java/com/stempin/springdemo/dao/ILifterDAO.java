package com.stempin.springdemo.dao;

import com.stempin.springdemo.entity.Lifter;

import java.util.List;

public interface ILifterDAO {

    List<Lifter> getLifters();

    void saveLifter(Lifter theLifter);

    Lifter getLifter(int theId);

    void deleteLifter(int theId);

    List<Lifter> searchCustomer(String theSearchName);
}
