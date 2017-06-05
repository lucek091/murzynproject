package com.stempin.springdemo.service;

import com.stempin.springdemo.dao.LifterDAO;
        import com.stempin.springdemo.entity.Lifter;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
        import org.springframework.transaction.annotation.Transactional;

        import java.util.List;

@Service
public class LifterService implements ILifterService {

    @Autowired
    private LifterDAO lifterDAO;

    @Transactional
    public List<Lifter> getLifters() {
        return lifterDAO.getLifters();
    }

    @Transactional
    public void saveLifter(Lifter theLifter) {
        lifterDAO.saveLifter(theLifter);
    }

    @Transactional
    public Lifter getLifter(int theId) {
        return lifterDAO.getLifter(theId);
    }

    @Transactional
    public void deleteLifter(int theId) {
        lifterDAO.deleteLifter(theId);
    }

    @Transactional
    public List<Lifter> searchLifter(String theSearchName) {
        return lifterDAO.searchCustomer(theSearchName);
    }


}
