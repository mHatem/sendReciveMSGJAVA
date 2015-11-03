/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.socket;

import java.io.Serializable;

/**
 *
 * @author MHatem
 */
public class Message implements Serializable{
    private static final long serialVersionUID = 1L;
    private String  sender, content, reciver ; 
    private int type;
    
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReciver() {
        return reciver;
    }

    public void setReciver(String reciver) {
        this.reciver = reciver;
    }
    
    @Override
    public String toString(){
        return this.sender + " : " + content + "\n" ;
    }
    
}
