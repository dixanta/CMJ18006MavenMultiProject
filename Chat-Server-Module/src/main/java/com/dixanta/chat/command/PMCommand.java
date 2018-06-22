/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dixanta.chat.command;

import com.dixanta.chat.util.Broadcaster;
import com.dixanta.chat.util.Client;
import java.io.PrintStream;

/**
 *
 * @author USER
 */
public class PMCommand extends ChatCommand {

    @Override
    public void execute(String[] tokens) throws Exception {
        if(tokens.length>2){
            Client buddy=handler.getByUserName(tokens[1]);
            if(buddy!=null){
                PrintStream ps=
                        new PrintStream(buddy.getSocket()
                        .getOutputStream());
                ps.println("[PM from " + 
                        client.getUser().getUserName()+"] says>"
                + tokens[2]);
            }else{
                out.println(tokens[1] + " username not found");
            }
            
        }else{
            out.println("Invalid PM command");
        }
    }
    
}
