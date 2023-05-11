/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.CustomerDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Customer;

/**
 *
 * @author Minh Bui
 */
@WebServlet(name="SignUpControl", urlPatterns={"/signup"})
public class SignUpControl extends HttpServlet {
   
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
            out.println("<title>Servlet SignUpControl</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SignUpControl at " + request.getContextPath () + "</h1>");
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
        request.getRequestDispatcher("signup.jsp").forward(request, response);
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
        CustomerDAO u = new CustomerDAO();
        List<Customer> list = u.getAll();
        //Get all parameter
        String username = request.getParameter("uname");
        String fullname = request.getParameter("fname");
        String psw  = request.getParameter("psw");
        String cpsw = request.getParameter("cpsw");
        String email = request.getParameter("email");
        String phone_number = request.getParameter("phone_number");
        String rawIs_Driver = request.getParameter("driver");
        //Validation though database
        String msg1 = u.checkEmail(list, email);
        String msg = u.checkUsername(list, username);
        //Check password similarity
        String msg2 = u.checkPass(cpsw,psw);
        //Return to sign up page if there is a error
        if(msg != null || msg1 != null || msg2 != null){
            request.setAttribute("msg2", msg2);
            request.setAttribute("msg", msg);
            request.setAttribute("msg1", msg1);
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        }
        try{
            boolean is_driver = Boolean.parseBoolean(rawIs_Driver);
            Customer c = new Customer(username, fullname, email, psw, phone_number, is_driver);
            u.signUp(c);
            response.sendRedirect("login");
        }catch(IllegalArgumentException | NullPointerException | IOException e){
        }
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
