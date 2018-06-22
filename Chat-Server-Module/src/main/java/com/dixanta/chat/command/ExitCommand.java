/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dixanta.chat.command;

import com.dixanta.chat.util.Broadcaster;

/**
 *
 * @author USER
 */
public class ExitCommand extends ChatCommand {

    @Override
    public void execute(String[] tokens) throws Exception {
        client.getSocket().close();
        handler.removeClient(client);
        Broadcaster
                        .broadcastMessage(handler.getClients(),
                                client, 
                                client.getUser().getUserName() 
                                        + " has logged out !!!");
    }
    
}
