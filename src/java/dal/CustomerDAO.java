/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Customer;

/**
 *
 * @author Minh Bui
 */
public class CustomerDAO extends DBContext {

    /*
    Done
     */
    public List<Customer> getAll() {
        List<Customer> list = new ArrayList<>();
        String sql = "SELECT [customer_id]\n"
                + "      ,[username]\n"
                + "      ,[name]\n"
                + "      ,[email]\n"
                + "      ,[phone_number]\n"
                + "      ,[password]\n"
                + "      ,[created_at]\n"
                + "      ,[is_driver]\n"
                + "  FROM [dbo].[Customer]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Customer u = new Customer();
                u.setCustomer_id(rs.getInt("customer_id"));
                u.setUsername(rs.getString("username"));
                u.setName(rs.getString("name"));
                u.setEmail(rs.getString("email"));
                u.setPhone_number(rs.getString("phone_number"));
                u.setPassword(rs.getString("password"));
                u.setCreated_at(rs.getString("created_at"));
                u.setIs_driver(rs.getBoolean("is_driver"));
                list.add(u);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    /*
    Done
     */
    public Customer getDataByLoginInfo(Customer c, List<Customer> list) {
        Customer c_info = new Customer();
        for (int i = 0; i < list.size(); i++) {
            if (c.getUsername().equals(list.get(i).getUsername()) && c.getPassword().equals(list.get(i).getPassword())) {
                c_info = list.get(i);
                return c_info;
            }
        }
        return null;
    }

    /*
    Done
     */
    public String getPhoneNumberByID(int id) {
        String phone_number = "";
        String sql = "Select phone_number\n"
                + "From Customer\n"
                + "Where customer_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                phone_number = rs.getString("phone_number");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return phone_number;
    }

    /*
    Done
     */
    public int login(Customer c, List<Customer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (c.getUsername().equals(list.get(i).getUsername()) && c.getPassword().equals(list.get(i).getPassword())) {
                if (list.get(i).isIs_driver()) {
                    return 1;
                } else {
                    return 2;
                }
            }
        }
        return 3;
    }

    /*
    Done
     */
    public void signUp(Customer c) {
        String sql = "INSERT INTO [dbo].[Customer]\n"
                + "           ([username]\n"
                + "           ,[name]\n"
                + "           ,[email]\n"
                + "           ,[phone_number]\n"
                + "           ,[password]\n"
                + "           ,[is_driver])"
                + "     VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getUsername());
            st.setString(2, c.getName());
            st.setString(3, c.getEmail());
            st.setString(4, c.getPhone_number());
            st.setString(5, c.getPassword());
            st.setBoolean(6, c.isIs_driver());
            st.executeUpdate();
        } catch (SQLException e) {
        }
    }

    /*
    Done
     */
    public String checkUsername(List<Customer> list, String username) {
        String msg = "Tên tài khoản đã tồn tại.";
        for (int i = 0; i < list.size(); i++) {
            if (username.equals(list.get(i).getUsername())) {
                return msg;
            }
        }
        return null;
    }

    /*
    Done
     */
    public String checkEmail(List<Customer> list, String email) {
        String msg = "Email đã được sử dụng.";
        for (int i = 0; i < list.size(); i++) {
            if (email.equals(list.get(i).getEmail())) {
                return msg;
            }
        }
        return null;
    }

    /*
    Done
     */
    public String checkPass(String psw, String cpsw) {
        String msg = "Mật khẩu không trùng khớp.";
        if (!psw.equals(cpsw)) {
            return msg;
        } else {
            return null;
        }
    }

    /*
    Done
     */
    public void becomeDriver(int customer_id, String name, String phone_number) {
        String sql = "UPDATE Customer\n"
                + "SET [name] = ?, phone_number = ?, is_Driver = 1\n"
                + "WHERE customer_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, phone_number);
            st.setInt(3, customer_id);
            st.executeUpdate();
        } catch (SQLException e) {
        }
    }

    /*
    Done
     */
    public void changeInfo(int customer_id, String name, String phone_number) {
        String sql = "UPDATE Customer\n"
                + "SET [name] = ?, phone_number = ?\n"
                + "WHERE customer_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, phone_number);
            st.setInt(3, customer_id);
            st.executeUpdate();
        } catch (SQLException e) {
        }
    }

    /*
    Done
     */
    public void changePass(int customer_id, String pass) {
        String sql = "UPDATE Customer\n"
                + "SET [password] = ?\n"
                + "WHERE customer_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, pass);
            st.setInt(2, customer_id);
            st.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public int summary(int id) {
        int sum = 0;
        String sql = "Select sum(price) as summary\n"
                + "From Book , History h , Customer, car\n"
                + "Where book.book_id = h.book_id \n"
                + "and Customer.customer_id = Car.customer_id \n"
                + "and book.car_id = car.car_id\n"
                + "and Customer.customer_id= ? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                sum = rs.getInt("summary");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return sum;
    }
    
 
}
