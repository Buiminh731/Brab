/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.BookDAO;
import dal.CarDAO;

import dal.CustomerDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Car;

import model.Customer;

/**
 *
 * @author Minh Bui
 */
@WebServlet(name="YourInfo", urlPatterns={"/yourinfo"})
public class YourInfo extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet YourInfo</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet YourInfo at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        CarDAO cd = new CarDAO();
        CustomerDAO cusd = new CustomerDAO();
        BookDAO bd = new BookDAO();
        //get all list of personal account data
        Customer c = (Customer)request.getSession().getAttribute("customer");
        request.setAttribute("bookList", bd.listOrderDone(c.getCustomer_id()));
        List<Car> list = cd.getDisplayInfo();
        request.setAttribute("summary", cusd.summary(c.getCustomer_id()));
        request.setAttribute("listC", list);
        request.setAttribute("current", c);
        request.setAttribute("listChart", bd.getChart(c.getCustomer_id()));
        request.getRequestDispatcher("yourInfo.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        //change by using parameter and re direct
        String name = request.getParameter("name");
        String phone_number = request.getParameter("phonenumber");
        int customer_id = Integer.parseInt(request.getParameter("customer_id"));
        CustomerDAO cd = new CustomerDAO();
        cd.changeInfo(customer_id, name, phone_number);
        response.sendRedirect(request.getContextPath()+"/");
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
