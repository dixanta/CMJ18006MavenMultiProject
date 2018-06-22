/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dixanta.chat.command;

import java.util.HashMap;

/**
 *
 * @author USER
 */
public class ChatCommandFactory {
    private static HashMap<String,ChatCommand>
            commands=init();
    
    private static HashMap<String,ChatCommand> init(){
        HashMap<String,ChatCommand> cmds=new HashMap<>();
        cmds.put("block",new BlockCommand());
        cmds.put("list",new ListCommand());
        cmds.put("pm",new PMCommand());
        cmds.put("exit",new ExitCommand());
        return cmds;
    }
    
    public static ChatCommand get(String param){
        return (commands.containsKey(param))?
                commands.get(param):null;
    }
}
