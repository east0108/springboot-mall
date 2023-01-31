package com.east.springbootmall.rowmapper;


import com.east.springbootmall.model.User;
import org.springframework.jdbc.core.RowMapper;


import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int i) throws SQLException {

        User user = new User();

        user.setUserId(rs.getInt("user_id"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setCreated_date(rs.getDate("created_date"));
        user.setLast_modified_date(rs.getDate("last_modified_date"));


        return user;
    }
}
