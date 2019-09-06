package com.learning.model.dao.impl;

import com.learning.model.dao.DaoFactory;
import com.learning.model.dao.EnrolleeDao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCDaoFactory extends DaoFactory {
    private DataSource dataSource = ConnectionPoolHolder.getDataSource();


    @Override
    public EnrolleeDao createEnrolleeDao() {
        return new JDBCEnrolleeDao(getConnection());
    }

    private Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
