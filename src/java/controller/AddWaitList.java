/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.CarDAO;
import dal.BookDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.text.ParseException;
import model.Car;
import model.Customer;
import model.Book;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Minh Bui
 */
@WebServlet(name = "AddWaitList", urlPatterns = {"/addwaitlist"})
public class AddWaitList extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddWaitList</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddWaitList at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String car_id = request.getParameter("car_id");
        CarDAO cd = new CarDAO();
        try {
            Car c = cd.getCarByID(Integer.parseInt(car_id));
            //set all attribute to display needed information
            request.setAttribute("car", c);
            request.setAttribute("current", (Customer) request.getSession().getAttribute("customer"));
        } catch (NumberFormatException e) {
        }
        request.getRequestDispatcher("confirm.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //create a format
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        //getSessionData
        Customer c = (Customer) request.getSession().getAttribute("customer");
        BookDAO wd = new BookDAO();
        try {
            //set all data for book entity
            int customer_id = c.getCustomer_id();
            int car_id = Integer.parseInt(request.getParameter("car_id"));
            String pick_location = request.getParameter("pickLocation");
            String drop_location = request.getParameter("dropLocation");
            String raw = request.getParameter("pickTime");
            Date date = dateFormat.parse(raw);//parsethe data set it to time stamp
            Timestamp pick_time = new Timestamp(date.getTime());
            int price = Integer.parseInt(request.getParameter("desiredPrice"));
            Book w = new Book(customer_id, car_id, pick_location, drop_location, pick_time, price);
            String msg = wd.queueUp(w);//add data
            System.out.println(msg);
            response.sendRedirect(request.getContextPath() + "/homepage");
        } catch (ParseException e) {
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
