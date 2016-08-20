package by.boiko.crm.service.impl;


import by.boiko.crm.dao.StudentDao;
import by.boiko.crm.model.Student;
import by.boiko.crm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Transactional
    public List<Student> getAll() {
        return studentDao.loadAll();
    }

    @Transactional
    public Student get(int id) {
        return studentDao.load(id);
    }


    @Transactional
    public List<Student> getStudentByName(String name) {
        return studentDao.loadStudentsByName(name);
    }

    @Transactional
    public void delete(int id) {
        studentDao.delete(id);
    }

    @Transactional
    public void saveOrUpdate(Student student) {
        studentDao.saveOrUpdate(student);
    }




}