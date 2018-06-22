/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dixanta.chat.util;

import com.dixanta.chat.command.ChatCommand;
import com.dixanta.chat.command.ChatCommandFactory;
import com.dixanta.module.dao.UserDAO;
import com.dixanta.module.dao.impl.UserDAOImpl;
import com.dixanta.module.entity.User;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author USER
 */
public class ClientListener extends Thread {

    private Client client;
    private ClientHandler handler;
    private BufferedReader reader;
    private PrintStream out;
    private Socket socket;
    private UserDAO userDAO;

    public ClientListener(Socket socket) throws IOException {
        this.socket = socket;
        reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        out = new PrintStream(socket.getOutputStream());
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void setHandler(ClientHandler handler) {
        this.handler = handler;
    }
    
    @Override
    public void run() {
        try {
            while(!login()){
                out.println("Invalid User Name & Password");
                out.println("Please Try Again");
            }
            while(!isInterrupted()){
                out.println("(me)>");
                String line=reader.readLine();
                String[] tokens=line.split(";;");
                ChatCommand cmd=ChatCommandFactory.get(tokens[0]);
                if(cmd!=null){
                    cmd.setClient(client);
                    cmd.setHandler(handler);
                    cmd.setWriter(out);
                    cmd.execute(tokens);
                }else{
                    String msg=client.getUser().getUserName() + " says >"
                            +line;
                    Broadcaster
                            .broadcastMessage(
                                    handler.getClients(), client,msg);
                }
            }
        } catch (Exception ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    private boolean login() throws IOException {
        out.println("Enter User Name:");
        String userName = reader.readLine();
        out.println("Enter Password:");
        String password = reader.readLine();
        try {
            User user = userDAO.login(userName, password);
            if(user!=null){
                client=new Client(user, socket);
                handler.addClient(client);
                Broadcaster
                        .broadcastMessage(handler.getClients(),
                                client, userName + " has joined !!!");
                return true;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

}
