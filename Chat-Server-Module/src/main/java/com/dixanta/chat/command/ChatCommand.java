/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dixanta.chat.command;

import com.dixanta.chat.util.Client;
import com.dixanta.chat.util.ClientHandler;
import java.io.PrintStream;

/**
 *
 * @author USER
 */
public abstract class ChatCommand {
    protected Client client;
    protected ClientHandler handler;
    protected PrintStream out;

    public void setClient(Client client) {
        this.client = client;
    }

    public void setHandler(ClientHandler handler) {
        this.handler = handler;
    }

    public void setWriter(PrintStream out) {
        this.out = out;
    }
    
    public abstract  void execute(String[] tokens)
            throws Exception;
}
