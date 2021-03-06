package org.teamwe.carrent.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

public class User implements Serializable {

    public static int COMMEN_USER = 0;
    public static int ENGENEER = 1;
    public static int ADMINISTRATOR = 2;



    private  String  email;
    @JsonIgnore
    private  String  password;
    private  String  name;

    private  String  licence;
    private  String  head;
    private  String  phone;

    private  int    type;
    private  int   credit;
    private  int  isvalidated;

    private  int   status;
    private  int   points;

    private  int   isauthorized;
    private  long   balance;


    public static void setCommenUser(int commenUser) {
        COMMEN_USER = commenUser;
    }

    public static void setENGENEER(int ENGENEER) {
        User.ENGENEER = ENGENEER;
    }

    public static void setADMINISTRATOR(int ADMINISTRATOR) {
        User.ADMINISTRATOR = ADMINISTRATOR;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public void setIsvalidated(int isvalidated) {
        this.isvalidated = isvalidated;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setIsauthorized(int isauthorized) {
        this.isauthorized = isauthorized;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public static int getCommenUser() {
        return COMMEN_USER;
    }

    public static int getENGENEER() {
        return ENGENEER;
    }

    public static int getADMINISTRATOR() {
        return ADMINISTRATOR;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getLicence() {
        return licence;
    }

    public String getHead() {
        return head;
    }

    public String getPhone() {
        return phone;
    }

    public int getType() {
        return type;
    }

    public int getCredit() {
        return credit;
    }

    public int getIsvalidated() {
        return isvalidated;
    }

    public int getStatus() {
        return status;
    }

    public int getPoints() {
        return points;
    }

    public int getIsauthorized() {
        return isauthorized;
    }

    public long getBalance() {
        return balance;
    }

    public User(String email, String password, String name, String licence, String head, String phone, int type, int credit, int isvalidated, int status, int points, int isauthorized, long balance) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.licence = licence;
        this.head = head;
        this.phone = phone;
        this.type = type;
        this.credit = credit;
        this.isvalidated = isvalidated;
        this.status = status;
        this.points = points;
        this.isauthorized = isauthorized;
        this.balance = balance;
    }

    public User(String email, String password, int type, int isvalidated, int status) {
        this.email = email;
        this.password = password;
        this.type = type;
        this.isvalidated = isvalidated;
        this.status = status;
    }




    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", licence='" + licence + '\'' +
                ", head='" + head + '\'' +
                ", phone='" + phone + '\'' +
                ", type=" + type +
                ", credit=" + credit +
                ", isvalidated=" + isvalidated +
                ", status=" + status +
                ", points=" + points +
                ", isauthorized=" + isauthorized +
                ", balance=" + balance +
                '}';
    }
}
