/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Minh Bui
 */
public class Customer {
    
//    CREATE TABLE Customer (
//  customer_id INT NOT NULL PRIMARY KEY IDENTITY(1,1),
//  username VARCHAR(255) NOT NULL UNIQUE,
//  [name] VARCHAR(255),
//  email VARCHAR(255) NOT NULL UNIQUE,
//  phone_number CHAR(10) NOT NULL,
//  [password] VARCHAR(255) NOT NULL,
//  created_at DATETIME DEFAULT GETDATE() NOT NULL,
//  is_driver BIT default(0)

    int customer_id;
    String username,name,email,password,phone_number,created_at;
    boolean is_driver;

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public boolean isIs_driver() {
        return is_driver;
    }

    public void setIs_driver(boolean is_driver) {
        this.is_driver = is_driver;
    }

    public Customer() {
    }

    public Customer(String username, String name, String email, String password, String phone_number, boolean is_driver) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone_number = phone_number;
        this.is_driver = is_driver;
    }
    
    public Customer(int customer_id, String username, String email, String password, String phone_number, String created_at) {
        this.customer_id = customer_id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone_number = phone_number;
        this.created_at = created_at;
    }
    public Customer( String username, String email, String password, String phone_number) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone_number = phone_number;
    }
    
    public Customer( String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Customer(int customer_id, String username, String name, String email, String password, String phone_number, String created_at, boolean is_driver) {
        this.customer_id = customer_id;
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone_number = phone_number;
        this.created_at = created_at;
        this.is_driver = is_driver;
    }
    
    public Customer(int customer_id, String username, String email, String password, String phone_number, String created_at, boolean is_driver) {
        this.customer_id = customer_id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone_number = phone_number;
        this.created_at = created_at;
        this.is_driver = is_driver;
    }

}
