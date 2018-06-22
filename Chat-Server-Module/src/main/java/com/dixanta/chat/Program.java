/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dixanta.chat;

import com.dixanta.chat.util.ClientHandler;
import com.dixanta.chat.util.ClientListener;
import com.dixanta.module.dao.UserDAO;
import com.dixanta.module.dao.impl.UserDAOImpl;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author USER
 */
public class Program {

    public static void main(String[] args) {
        int port = 9090;
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server is running at "+ port);
            UserDAO userDAO=new UserDAOImpl();
            ClientHandler handler=new ClientHandler();
            while (true) {
                Socket socket=server.accept();
                System.out.println("Connection Request from " +
                        socket.getInetAddress().getHostAddress());
                
                ClientListener listener
                        =new ClientListener(socket);
                        listener.setUserDAO(userDAO);
                        listener.setHandler(handler);
                listener.start();
            }
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
}
