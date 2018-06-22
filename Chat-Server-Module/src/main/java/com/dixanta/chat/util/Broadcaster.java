/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dixanta.chat.util;

import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

/**
 *
 * @author USER
 */
public class Broadcaster {
    public static void broadcastMessage(List<Client> clients,
            Client client,
            String message)throws IOException{
        for(Client c:clients){
            if(!c.equals(client)){
                PrintStream out=
                        new PrintStream(c.getSocket().getOutputStream());
                out.println(message);
            }
        }
    }
}
