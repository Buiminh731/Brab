/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import model.Car;


/**
 *
 * @author Minh Bui
 */
public class CarDAO extends DBContext {
    /*
    Done
    */
    public List<Car> getAll() {
        List<Car> list = new ArrayList<>();
        String sql = "SELECT [car_id]\n"
                + "      ,[customer_id]\n"
                + "      ,[model]\n"
                + "      ,[plate]\n"
                + "      ,[img]\n"
                + "  FROM [dbo].[Car]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Car c = new Car();
                c.setCustomer_id(rs.getInt("customer_id"));
                c.setCar_id(rs.getInt("car_id"));
                c.setModel(rs.getString("model"));
                c.setPlate(rs.getString("plate"));
                c.setImg(rs.getBytes("img"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    /*
    Done
    */
    public List<Car> getDisplayInfo() {
        List<Car> list = new ArrayList<>();
        String sql = "SELECT [car_id],Car.[customer_id],[model],[plate],[img],[name]\n"
                + "FROM [dbo].[Car] , [dbo].[Customer]\n"
                + "Where Car.customer_id = Customer.customer_id";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Car c = new Car();
                c.setCustomer_id(rs.getInt("customer_id"));
                c.setCar_id(rs.getInt("car_id"));
                c.setModel(rs.getString("model"));
                c.setPlate(rs.getString("plate"));
                c.setImg(rs.getBytes("img"));
                c.setOwner(rs.getString("name"));
                byte[] imageBytes = rs.getBytes("img");
                if (imageBytes != null) {
                    String encodedImage = Base64.getEncoder().encodeToString(imageBytes);
                    c.setEncodedImg(encodedImage);
                } else {
                    // handle the case where imageBytes is null
                }

                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    /*
    Done
    */
    public List<Car> getTopInfo() {
        List<Car> list = new ArrayList<>();
        String sql = "Select top 4 a.car_id, a.customer_id,a.model,a.plate, a.img, a.[name]\n"
                + "from\n"
                + "(Select [car_id],Car.[customer_id],[model],[plate],[img],[name]\n"
                + "FROM [dbo].[Car] , [dbo].[Customer]\n"
                + "Where Car.customer_id = Customer.customer_id) as a\n"
                + "inner join\n"
                + "(SELECT Book.car_id, COUNT(book.car_id) as amount\n"
                + "FROM  [dbo].Book\n"
                + "Group by Book.car_id)as b\n"
                + "on a.car_id=b.car_id\n"
                + "order by b.amount desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Car c = new Car();
                c.setCustomer_id(rs.getInt("customer_id"));
                c.setCar_id(rs.getInt("car_id"));
                c.setModel(rs.getString("model"));
                c.setPlate(rs.getString("plate"));
                c.setImg(rs.getBytes("img"));
                c.setOwner(rs.getString("name"));
                byte[] imageBytes = rs.getBytes("img");
                if (imageBytes != null) {
                    String encodedImage = Base64.getEncoder().encodeToString(imageBytes);
                    c.setEncodedImg(encodedImage);
                } else {
                    // handle the case where imageBytes is null
                }
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    /*
    Done
    */
    public Car getCarByID(int car_id) {
        Car c = new Car();
        String sql = "SELECT [car_id],Car.[customer_id],[model],[plate],[img],[name]\n"
                + "FROM [dbo].[Car] , [dbo].[Customer]\n"
                + "Where Car.customer_id = Customer.customer_id and car.car_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, car_id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                c.setCustomer_id(rs.getInt("customer_id"));
                c.setCar_id(rs.getInt("car_id"));
                c.setModel(rs.getString("model"));
                c.setPlate(rs.getString("plate"));
                c.setImg(rs.getBytes("img"));
                c.setOwner(rs.getString("name"));
            }
        } catch (SQLException e) {
        }
        return c;
    }
    /*
    Done
    */
    public void addCar(Car c) {
        String sql = "INSERT INTO [dbo].[Car]\n"
                + "           ([customer_id]\n"
                + "           ,[model]\n"
                + "           ,[plate]\n"
                + "           ,[img])\n"
                + "     VALUES(?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, c.getCustomer_id());
            st.setString(2, c.getModel());
            st.setString(3, c.getPlate());
            st.setBytes(4, c.getImg());
            st.executeUpdate();
        } catch (SQLException e) {
        }
    }
    /*
    Done
    */
    public List<Car> getChartData() {
        List<Car> list = new ArrayList<>();
        String sql = "Select top 4 a.[name], a.customer_id,b.amount\n"
                + "from\n"
                + "(Select [car_id],Car.[customer_id],[model],[plate],[img],[name]\n"
                + "FROM [dbo].[Car] , [dbo].[Customer]\n"
                + "Where Car.customer_id = Customer.customer_id) as a\n"
                + "inner join\n"
                + "(SELECT Book.car_id, COUNT(book.car_id) as amount\n"
                + "FROM  [dbo].Book\n"
                + "Group by Book.car_id)as b\n"
                + "on a.car_id=b.car_id\n"
                + "order by b.amount desc";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Car c = new Car();
                c.setCar_id(rs.getInt("amount"));;
                c.setOwner(rs.getString("name"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    /*
    Done
    */
    public List<Car> getSearchResult(String searchInput) {
        List<Car> list = new ArrayList<>();
        String sql = "SELECT [car_id],Car.[customer_id],[model],[plate],[img],[name]\n"
                + "FROM [dbo].[Car] , [dbo].[Customer]\n"
                + "Where Car.customer_id = Customer.customer_id and model like '%" + searchInput + "%'";

        try {
            PreparedStatement st = connection.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Car c = new Car();
                c.setCustomer_id(rs.getInt("customer_id"));
                c.setCar_id(rs.getInt("car_id"));
                c.setModel(rs.getString("model"));
                c.setPlate(rs.getString("plate"));
                c.setImg(rs.getBytes("img"));
                c.setOwner(rs.getString("name"));
                byte[] imageBytes = rs.getBytes("img");
                if (imageBytes != null) {
                    String encodedImage = Base64.getEncoder().encodeToString(imageBytes);
                    c.setEncodedImg(encodedImage);
                } else {
                    // handle the case where imageBytes is null
                }

                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    /*
    Done
    */
    public String deleteCarByID(int id) {
        String msg = "*You can only delete if there weren't any book schedual.";
        String sql = "Delete\n"
                + "FROM Car\n"
                + "WHERE car_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            return msg;
        }
        return null;
    }
    
    public List<Car> getCarByPage(List<Car> list,int start,int end){
        List<Car> arr=new ArrayList<>();
        for(int i = start; i < end ; i++){
            arr.add(list.get(i));
        }
        return arr;
    }

}
