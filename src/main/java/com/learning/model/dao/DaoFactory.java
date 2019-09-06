package com.learning.model.dao;

import com.learning.model.dao.impl.JDBCDaoFactory;

public abstract class DaoFactory  {
    private static DaoFactory daoFactory;
    public abstract EnrolleeDao createEnrolleeDao();

    public static DaoFactory getInstance(){
        if( daoFactory == null ){
            synchronized (DaoFactory.class){
                if(daoFactory==null){
                    DaoFactory temp = new JDBCDaoFactory();
                    daoFactory = temp;
                }
            }
        }
        return daoFactory;
    }
}

