/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dixanta.chat.util;

import com.dixanta.module.entity.User;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class Client {
    private User user;
    private Socket socket;
    private List<Client> blockList;

    public Client() {
    }

    public Client(User user, Socket socket) {
        this.user = user;
        this.socket = socket;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
    
    public void block(Client client){
        if(blockList==null){
            blockList=new ArrayList<>();
        }
        blockList.add(client);
    }
    public void unblock(Client client){
        if(blockList!=null){
            blockList.remove(client);
        }
    }
    
    public boolean hasBlocked(Client client){
        if(blockList==null){
            return false;
        }
        for(Client c:blockList){
            if(c.equals(client)){
                return true;
            }
        }
        return false;
    }
    
    
    
    
    
}
