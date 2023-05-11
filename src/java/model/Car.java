/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Minh Bui
 */
public class Car {
//      car_id INT PRIMARY KEY IDENTITY(1,1),
//	customer_id INT NOT NULL,
//	model VARCHAR(255),
//	plate VARCHAR(255)


    int car_id, customer_id;
    String model, plate, owner;
    byte[] img;
    String encodedImg;

    public String getEncodedImg() {
        return encodedImg;
    }

    public void setEncodedImg(String encodedImg) {
        this.encodedImg = encodedImg;
    }

    public Car(int car_id, int customer_id, String model, String plate, String owner, byte[] img, String encodedImg) {
        this.car_id = car_id;
        this.customer_id = customer_id;
        this.model = model;
        this.plate = plate;
        this.owner = owner;
        this.img = img;
        this.encodedImg = encodedImg;
    }
    
    public Car() {
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Car(int car_id, int customer_id, String model, String plate, String owner, byte[] img) {
        this.car_id = car_id;
        this.customer_id = customer_id;
        this.model = model;
        this.plate = plate;
        this.owner = owner;
        this.img = img;
    }

    public Car(int customer_id, String model, String plate, String owner, byte[] img) {
        this.customer_id = customer_id;
        this.model = model;
        this.plate = plate;
        this.owner = owner;
        this.img = img;
    }
    
    public Car(int customer_id, String model, String plate, byte[] img) {
        this.customer_id = customer_id;
        this.model = model;
        this.plate = plate;
        this.img = img;
    }
    
    public Car(int car_id, int customer_id, String model, String plate, byte[] img) {
        this.car_id = car_id;
        this.customer_id = customer_id;
        this.model = model;
        this.plate = plate;
        this.img = img;
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }
  
}
