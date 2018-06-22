/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dixanta.module.dao.impl;

import com.dixanta.db.core.JdbcTemplate;
import com.dixanta.module.dao.UserDAO;
import com.dixanta.module.entity.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author USER
 */
public class UserDAOImpl implements UserDAO {

    private JdbcTemplate<User> template
            =new JdbcTemplate<>();
    

    private User mapData(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setUserName(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setEmail(rs.getString("email"));
        user.setCreatedDate(rs.getDate("created_date"));
        user.setModifiedDate(rs.getDate("modified_date"));
        user.setStatus(rs.getBoolean("status"));
        return user;
    }

    @Override
    public List<User> getAll() throws ClassNotFoundException, SQLException {
        String sql="select * from users";
        return template.query(sql, 
                (ResultSet rs) -> mapData(rs));
    }

    @Override
    public User getById(int id) throws ClassNotFoundException, SQLException {
        String sql = "select * from users where id=?";
        return template.queryForObject(sql,
                new Object[]{id},
                (ResultSet rs) -> mapData(rs));
    }

    @Override
    public int insert(User user) throws ClassNotFoundException, SQLException {
        String sql="insert into users(username,password,"
                + "email,status) values(?,?,?,?)";
        return template.update(sql,new Object[]{
            user.getUserName(),user.getPassword(),
            user.getEmail(),
            user.isStatus()
        });
    }

    @Override
    public int update(User user) throws ClassNotFoundException, SQLException {
        String sql="update users set username=?,"
                + "password=?,"
                + "email=?,"
                + "modified_date=CURRENT_TIMESTAMP,"
                + "status=? "
                + " where id=?";
        return template.update(sql,new Object[]{
            user.getUserName(),user.getPassword(),
            user.getEmail(),
            user.isStatus(),user.getId()
        });
    }

    @Override
    public int delete(int id) throws ClassNotFoundException, SQLException {
        String sql="delete from users where id=?";
        return template.update(sql,new Object[]{id});
    }

    @Override
    public User login(String userName, String password) throws ClassNotFoundException, SQLException {
        String sql = "select * from users where username=?"
                + " and password=?";
        return template.queryForObject(sql,
                new Object[]{userName,password},
                (ResultSet rs) -> mapData(rs));
    }

    @Override
    public User getByUserName(String userName) throws ClassNotFoundException, SQLException {
        String sql = "select * from users where username=?";
        return template.queryForObject(sql,
                new Object[]{userName},
                (ResultSet rs) -> mapData(rs));
    }

    @Override
    public User getByEmail(String email) throws ClassNotFoundException, SQLException {
        String sql = "select * from users where email=?";
        return template.queryForObject(sql,
                new Object[]{email},
                (ResultSet rs) -> mapData(rs));
    }

}
