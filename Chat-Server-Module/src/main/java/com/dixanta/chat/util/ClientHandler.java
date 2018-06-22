/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dixanta.chat.util;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class ClientHandler {
    private List<Client> clients
            =new ArrayList<>();
    
    public List<Client> getClients(){
        return clients;
    }
    
    public void addClient(Client client){
        clients.add(client);
    }
    
    public Client getByUserName(String userName){
        for(Client c: clients){
            if(c.getUser().getUserName().
                    equals(userName)){
                return c;
            }
        }
        return null;
    }
    
    public boolean removeClient(Client client){
        return clients.remove(client);
    }
}
