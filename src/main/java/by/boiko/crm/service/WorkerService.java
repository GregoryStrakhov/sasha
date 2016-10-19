package by.boiko.crm.service;


import by.boiko.crm.model.Worker;

import java.util.List;

public interface WorkerService {

    Worker findById(Integer id);

    List<Worker> findAll();

    void saveOrUpdate(Worker worker);

    void delete(int id);

    Worker findByLogin(String login);
}
