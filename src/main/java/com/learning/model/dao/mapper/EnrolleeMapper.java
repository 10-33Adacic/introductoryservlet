package com.learning.model.dao.mapper;

import com.learning.model.entity.Enrollee;
import com.learning.model.entity.Role;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class EnrolleeMapper implements ObjectMapper<Enrollee> {


    @Override
    public Enrollee extractFromResultSet(ResultSet rs) throws SQLException {
        Enrollee enrollee = new Enrollee();
        enrollee.setId(rs.getLong("id"));
        enrollee.setName(rs.getString("name"));
        enrollee.setEmail(rs.getString("email"));
        enrollee.setPassword(rs.getString("password"));
        for (Role role : Role.values())
            if (role.name().equals(rs.getObject("role")))
                enrollee.setRole(role);
        enrollee.setActive(rs.getBoolean("true"));
        return enrollee;
    }

    @Override
    public Enrollee makeUnique(Map<Long, Enrollee> cache, Enrollee enrollee) {
        cache.putIfAbsent(enrollee.getId(), enrollee);
        return cache.get(enrollee.getId());
    }
}
