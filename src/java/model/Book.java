/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Timestamp;

/**
 *
 * @author Minh Bui
 */
public class Book {
//    wishlist_id INT PRIMARY KEY IDENTITY(1,1),
//    [customer_id] INT NOT NULL,
//    car_id INT NOT NULL,
//    pick_location VARCHAR(255) NOT NULL,
//    drop_location varchar(255) NOT NULL,
//    pick_time DATE NOT NULL,
//    price DECIMAL(9,2),
//    created_at DATETIME DEFAULT GETDATE() NOT NULL,
//    FOREIGN KEY ([customer_id]) REFERENCES Customer(customer_id),
//    FOREIGN KEY (car_id) REFERENCES [Car](car_id)
    
    int book_id,customer_id,car_id;
    String pick_location,drop_location;
    Timestamp pick_time, created_at;
    int price; 
    boolean is_confirm;

    public boolean isIs_confirm() {
        return is_confirm;
    }

    public void setIs_confirm(boolean is_confirm) {
        this.is_confirm = is_confirm;
    }

    public Book(int book_id, int customer_id, int car_id, String pick_location, String drop_location, Timestamp pick_time, Timestamp created_at, int price) {
        this.book_id = book_id;
        this.customer_id = customer_id;
        this.car_id = car_id;
        this.pick_location = pick_location;
        this.drop_location = drop_location;
        this.pick_time = pick_time;
        this.created_at = created_at;
        this.price = price;
    }

    public Book(int book_id, int customer_id, int car_id, String pick_location, String drop_location, Timestamp pick_time, Timestamp created_at, int price, boolean is_confirm) {
        this.book_id = book_id;
        this.customer_id = customer_id;
        this.car_id = car_id;
        this.pick_location = pick_location;
        this.drop_location = drop_location;
        this.pick_time = pick_time;
        this.created_at = created_at;
        this.price = price;
        this.is_confirm = is_confirm;
    }
 
    
    
    public Book() {
    }
    
    public Book( int customer_id, int car_id, String pick_location, String drop_location, Timestamp pick_time, int price) {
        this.customer_id = customer_id;
        this.car_id = car_id;
        this.pick_location = pick_location;
        this.drop_location = drop_location;
        this.pick_time = pick_time;
        this.price = price;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public String getPick_location() {
        return pick_location;
    }

    public void setPick_location(String pick_location) {
        this.pick_location = pick_location;
    }

    public String getDrop_location() {
        return drop_location;
    }

    public void setDrop_location(String drop_location) {
        this.drop_location = drop_location;
    }

    public Timestamp getPick_time() {
        return pick_time;
    }

    public void setPick_time(Timestamp pick_time) {
        this.pick_time = pick_time;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
      
}
