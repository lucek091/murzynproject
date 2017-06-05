package com.stempin.springdemo.service;

import com.stempin.springdemo.entity.Lifter;

import java.util.List;

public interface ILifterService {

    List<Lifter> getLifters();

    void saveLifter(Lifter theLifter);

    Lifter getLifter(int theId);

    void deleteLifter(int theId);

    List<Lifter> searchLifter(String theSearchName);
}
