/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp;

import com.socket.Massanger;
import com.socket.Message;
import com.socket.MessageTypeEnum;


/**
 *
 * @author MHatem
 */
public class ChatApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Massanger msgApp = new Massanger();
         Message helloMsg = new Message();
            helloMsg.setSender("MHatem");
            helloMsg.setReciver("Server");
            helloMsg.setContent("hatem 123");
            helloMsg.setType(MessageTypeEnum.LOGIN.getCode());
            msgApp.send(helloMsg);
            msgApp.setReciverString("ALL");
            msgApp.run();
    }
    
}
