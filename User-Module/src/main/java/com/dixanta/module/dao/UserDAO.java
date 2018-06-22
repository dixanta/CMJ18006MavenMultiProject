/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dixanta.module.dao;

import com.dixanta.app.core.dao.GenericDAO;
import com.dixanta.module.entity.User;
import java.sql.SQLException;

/**
 *
 * @author USER
 */
public interface UserDAO extends GenericDAO<User>{
    User login(String userName,String password)
            throws ClassNotFoundException,SQLException;
    User getByUserName(String userName)throws ClassNotFoundException,SQLException;;
    User getByEmail(String email)throws ClassNotFoundException,SQLException;;
}
