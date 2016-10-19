package by.boiko.crm.dao;


import by.boiko.crm.model.Worker;

public interface WorkerDao {

    Worker findByLogin(String login);
}
