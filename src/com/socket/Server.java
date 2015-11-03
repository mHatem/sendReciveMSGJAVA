/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.socket;

import java.io.*;
import java.net.*;
import java.util.logging.*;

/**
 *
 * @author MHatem
 */
public class Server implements Runnable {

    ServerSocket serverSocket;

    public Server() {
        try {
            serverSocket = new ServerSocket(6789);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        try {
            System.out.print("Server running");
            String clientSentence;
            String capitalizedSentence;
            while (true) {
                Socket connectionSocket = serverSocket.accept(); //Check if connection available
                BufferedReader inFromClients = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());             
                clientSentence = inFromClients.readLine();             
                System.out.println("Received: " + clientSentence);             
                capitalizedSentence = clientSentence.toUpperCase() + '\n';             
                outToClient.writeBytes(capitalizedSentence); 
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
