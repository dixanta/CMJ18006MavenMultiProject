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
public class BlockCommand extends ChatCommand {

    @Override
    public void execute(String[] tokens) throws Exception {
        if (tokens.length > 1) {
            Client buddy = handler.getByUserName(tokens[1]);
            if (buddy != null) {
                if (!client.equals(buddy)) {
                    client.block(buddy);
                    out.println(tokens[1] + " has been blocked");
                    String msg = client.getUser().getUserName() + " has logged out !!!";
                    buddy.getSocket()
                            .getOutputStream()
                            .write(msg.getBytes());
                }else{
                    out.println("Are pagal aafaile lai block hanchhas ");
                }

            } else {
                out.println(tokens[1] + " username not found");
            }
        } else {
            out.println("not enough parameters");
        }

    }

}
