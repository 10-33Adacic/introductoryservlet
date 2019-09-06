package com.learning.model.dao.impl;

import com.learning.model.dao.EnrolleeDao;
import com.learning.model.dao.mapper.EnrolleeMapper;
import com.learning.model.entity.Enrollee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCEnrolleeDao implements EnrolleeDao{
    private Connection connection;
    private EnrolleeMapper enrolleeMapper;

    public JDBCEnrolleeDao(EnrolleeMapper enrolleeMapper) {
        this.enrolleeMapper = enrolleeMapper;
    }

    public JDBCEnrolleeDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void add(Enrollee entity) throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement("INSERT INTO enrollee (name, email , password , role , active) VALUES (? ,? ,? , ?, ?)")) {
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getEmail());
            ps.setString(3, entity.getPassword());
            ps.setString(4, entity.getRole().name());
            ps.setBoolean(5, entity.isActive());
            ps.executeUpdate();
        }
    }


    //TODO try with res
    @Override
    public Enrollee findByEmail(String email) {
        try (PreparedStatement ps = connection.prepareStatement
                ("SELECT * FROM enrollee WHERE email = ?")) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return enrolleeMapper.extractFromResultSet(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    //TODO try with res
    @Override
    public List<Enrollee> findAll() {
        List<Enrollee> resultList = new ArrayList<>();
        try (Statement ps = connection.createStatement()) {
            ResultSet rs = ps.executeQuery("SELECT * FROM enrollee");

            while (rs.next()) {
                Enrollee result = enrolleeMapper.extractFromResultSet(rs);
                resultList.add(result);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultList;
    }

    //TODO try with res
    @Override
    public void update(Enrollee entity) {
        try (PreparedStatement ps = connection.prepareStatement(
                "UPDATE enrollee SET name = ? , email = ? , password = ?, role = ?, active = ? WHERE id = ?")) {
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getEmail());
            ps.setString(3, entity.getPassword());
            ps.setString(4, entity.getRole().name());
            ps.setBoolean(5, entity.isActive());
            ps.setLong(6, entity.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //TODO try with res
    @Override
    public void delete(int id) {
        try (PreparedStatement ps = connection.prepareStatement(
                "DELETE FROM enrollee  WHERE id = ?")) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //TODO try with res
    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    private Enrollee extractFromResultSet(ResultSet rs)
//            throws SQLException {
//        return Enrollee.builder()
//                .id(rs.getLong("id"))
//                .name(rs.getString("name"))
//                .email(rs.getString("email"))
//                .password(rs.getString("password"))
//                .role(rs.getString("role"))
//                .active(rs.getBoolean("active"))
//                .build();
//    }
}

