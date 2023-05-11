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
import model.History;

/**
 *
 * @author Minh Bui
 */
public class HistoryDAO extends DBContext {

    public List<History> getAll() {
        List<History> list = new ArrayList<>();
        String sql = "SELECT [history_id]\n"
                + "      ,[book_id]\n"
                + "  FROM [dbo].[History]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                History h = new History();
                h.setBook_id(rs.getInt("book_id"));
                h.setHistory_id(rs.getInt("history_id"));
                list.add(h);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public boolean detectExistance(List<History> list, int id){
        for (int i = 0 ; i < list.size();i++) {
            if(list.get(i).getBook_id() == id){
                return true;
            }
        }
        return false;
    }
}
