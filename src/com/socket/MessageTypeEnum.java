/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.socket;

/**
 *
 * @author MHatem
 */
public enum MessageTypeEnum {
 REGISTER(0),
 LOGIN(1),
 SIGNOUT(2),
 MESSAGE(3),
 NOTIFICATION(4),
 USERS_LIST(5);
 
 private int code;
 MessageTypeEnum(int code){
  this.code = code;
 }
 
 public int getCode(){
  return code;
 }

}
