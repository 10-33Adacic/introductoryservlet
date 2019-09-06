package com.learning.model.service;

import com.learning.model.dao.DaoFactory;
import com.learning.model.dao.EnrolleeDao;
import com.learning.model.entity.Enrollee;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class EnrolleeService {
    private DaoFactory daoFactory = DaoFactory.getInstance();
    private EnrolleeDao enrolleeDao = daoFactory.createEnrolleeDao();

    public List<Enrollee> findAllUsers(){
        return enrolleeDao.findAll();
    }

    public void addUser(String name, String email, String password) throws SQLException {
        String role = "USER";
        Enrollee newEnrollee = Enrollee.builder()
                .name(name)
                .email(email)
                .password(password)
                .role(role)
                .active(true)
                .build();
        enrolleeDao.add(newEnrollee);
    }

    public Optional<Enrollee> findUser(String email, String password){
        Optional<Enrollee> enrollee = Optional.ofNullable((enrolleeDao.findByEmail(email)));
        if (enrollee.isPresent() && enrollee.get().getPassword().equals(password)) {
            return enrollee;
        }
        return Optional.empty();
    }
}
