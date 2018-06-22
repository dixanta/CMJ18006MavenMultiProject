/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dixanta.chat.command;

import com.dixanta.chat.util.Broadcaster;
import com.dixanta.chat.util.Client;

/**
 *
 * @author USER
 */
public class ListCommand extends ChatCommand {

    @Override
    public void execute(String[] tokens) throws Exception {
        StringBuilder content = new StringBuilder();
        content.append("Listing Clients")
                .append("\n=================\n");
        for (Client c : handler.getClients()) {
            if (!c.hasBlocked(client)) {
                content.append(c.getUser().getUserName());
            }
            if (c.equals(client)) {
                content.append("(me)");
            }
            content.append("\r\n");
        }
        out.println(content.toString());
        out.println("%%END%%");
    }

}
