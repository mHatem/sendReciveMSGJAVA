/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.socket;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MHatem
 */
public class Massanger implements Runnable {
    
    private Socket serverConntSocket ;
     int serverPort = 2002;
     String reciverString ;
     String ip = "192.168.1.20";
     ObjectOutputStream output;
     ObjectInputStream input;
     BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
    public Massanger(){
        try {
           
            serverConntSocket = new Socket(ip, serverPort);
            output = new ObjectOutputStream(serverConntSocket.getOutputStream());
            output.flush();
            
            input = new ObjectInputStream(serverConntSocket.getInputStream());

        } catch (IOException ex) {
            Logger.getLogger(Massanger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void run() {
        boolean keepRunning = true;
        while(keepRunning){
            try {
                Message msg = (Message) input.readObject();
                System.out.println(msg.toString());
                
                if(msg.getType() == MessageTypeEnum.NOTIFICATION.getCode()){
                    if(!msg.getContent().equals("OK"))
                        keepRunning = false;
                    else
                        System.out.println("Recived OK");
                }
                Message msgSend = new Message();
                msgSend.setContent(bufferRead.readLine());
                msgSend.setReciver(reciverString);
                msgSend.setSender("MHatem");
                msg.setType(MessageTypeEnum.MESSAGE.getCode());
                send(msgSend);
            } catch (IOException | ClassNotFoundException ex) {
                keepRunning = false;
                Logger.getLogger(Massanger.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    public void send (Message msg){
        try {
            output.writeObject(msg);
            output.flush();
            System.out.println("App : "+msg.toString());
        } catch (IOException ex) {
            Logger.getLogger(Massanger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getReciverString() {
        return reciverString;
    }

    public void setReciverString(String reciverString) {
        this.reciverString = reciverString;
    }
    

}
