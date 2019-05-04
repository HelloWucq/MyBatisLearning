package com.wucq.entity;

import java.io.Serializable;

/**
 * User
 */
public class User implements Serializable{

    private int id;
    private String username;
    private String birthday;
    private int sex;
    private String address;
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }
    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday=birthday;
    }

    public int getSex() {
        return sex;
    }
 
    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address=address;
    }
}

