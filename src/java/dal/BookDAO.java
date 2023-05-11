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
import model.Book;

/**
 *
 * @author Minh Bui
 */
public class BookDAO extends DBContext {

    /*
    Function: queueUp
    Done
    Put parameter in Book entity
     */
    public String queueUp(Book w) {
        String msg = "Success";
        String sql = "INSERT INTO [dbo].[Book]\n"
                + "           ([customer_id]\n"
                + "           ,[car_id]\n"
                + "           ,[pick_location]\n"
                + "           ,[drop_location]\n"
                + "           ,[pick_time]\n"
                + "           ,[price])\n"
                + "     VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, w.getCustomer_id());
            st.setInt(2, w.getCar_id());
            st.setString(3, w.getPick_location());
            st.setString(4, w.getDrop_location());
            st.setTimestamp(5, w.getPick_time());
            st.setInt(6, w.getPrice());
            st.executeUpdate();
        } catch (SQLException e) {
        }
        return msg;
    }

    /*
    Done
     */
    public List<Book> getAllInfo(int id) {
        List<Book> list = new ArrayList<>();
        String sql = "Select * from book \n"
                + "where customer_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Book b = new Book();
                b.setBook_id(rs.getInt("book_id"));
                b.setCustomer_id(rs.getInt("customer_id"));
                b.setCar_id(rs.getInt("car_id"));
                b.setPick_location(rs.getString("pick_location"));
                b.setDrop_location(rs.getString("drop_location"));
                b.setPick_time(rs.getTimestamp("pick_time"));
                b.setPrice(rs.getInt("price"));
                b.setCreated_at(rs.getTimestamp("created_at"));
                b.setIs_confirm(rs.getBoolean("is_confirm"));
                list.add(b);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    /*
    Done
     */
    public List<Book> getAllInfoForDriver(int id) {
        List<Book> list = new ArrayList<>();
        String sql = "Select book_id, b.customer_id,b.car_id,b.pick_location,b.drop_location,b.pick_time,b.price,b.created_at,b.is_confirm\n"
                + "From Book b, Customer c, Car\n"
                + "Where car.customer_id = ? and car.car_id = b.car_id and car.customer_id = c.customer_id";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Book b = new Book();
                b.setBook_id(rs.getInt("book_id"));
                b.setCustomer_id(rs.getInt("customer_id"));
                b.setCar_id(rs.getInt("car_id"));
                b.setPick_location(rs.getString("pick_location"));
                b.setDrop_location(rs.getString("drop_location"));
                b.setPick_time(rs.getTimestamp("pick_time"));
                b.setPrice(rs.getInt("price"));
                b.setCreated_at(rs.getTimestamp("created_at"));
                b.setIs_confirm(rs.getBoolean("is_confirm"));
                list.add(b);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    /*
    Done
     */
    public void updateStatus(int stat, int id) {
        String sql = "UPDATE Book\n"
                + "SET is_confirm = ?\n"
                + "WHERE book_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, stat);
            st.setInt(2, id);
            st.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public List<Book> listOrderDone(int id) {
        List<Book> list = new ArrayList<>();
        String sql = "Select Book.car_id, pick_time, price\n"
                + "From Book , History h , Customer, car\n"
                + "Where book.book_id = h.book_id \n"
                + "and Customer.customer_id = Car.customer_id \n"
                + "and book.car_id = car.car_id\n"
                + "and Customer.customer_id= ? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Book b = new Book();
                b.setCar_id(rs.getInt("car_id"));
                b.setPick_time(rs.getTimestamp("pick_time"));
                b.setPrice(rs.getInt("price"));
                list.add(b);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public List<Book> getChart(int id) {
        List<Book> list = new ArrayList<>();
        String sql = "Select YEAR(pick_time) as [year],count(YEAR(pick_time)) as [count],sum(price) as price\n"
                + "From Book , History h , Customer, car\n"
                + "Where book.book_id = h.book_id \n"
                + "and Customer.customer_id = Car.customer_id \n"
                + "and book.car_id = car.car_id\n"
                + "and Customer.customer_id= ?\n"
                + "Group By Year(pick_time)\n"
                + "order by [year] asc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Book b = new Book();
                b.setCustomer_id(rs.getInt("year"));
                b.setCar_id(rs.getInt("count"));
                b.setPrice(rs.getInt("price"));
                list.add(b);
            }
        } catch (SQLException e) {
        }
        return list;
    }
}
