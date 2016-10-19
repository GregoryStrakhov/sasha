package by.boiko.crm.service.impl;

import by.boiko.crm.dao.WorkerDao;
import by.boiko.crm.model.Worker;
import by.boiko.crm.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService {

    @Autowired
    private WorkerDao workerDao;

    @Override
    public Worker findById(Integer id) {
        return null;
    }

    @Override
    public List<Worker> findAll() {
        return null;
    }

    @Override
    public void saveOrUpdate(Worker worker) {

    }

    @Override
    public void delete(int id) {

    }

    @Transactional
    public Worker findByLogin(String login) {
        return workerDao.findByLogin(login);
    }
}
