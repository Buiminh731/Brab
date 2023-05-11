/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.CarDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.InputStream;
import model.Car;
import model.Customer;
import org.apache.tomcat.jakartaee.commons.compress.utils.IOUtils;

/**
 *
 * @author Minh Bui
 */
@WebServlet(name="AddCar", urlPatterns={"/addcar"})
public class AddCar extends HttpServlet {
   
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
            out.println("<title>Servlet AddCar</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddCar at " + request.getContextPath () + "</h1>");
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
        //getSessionData
        request.setAttribute("current", (Customer)request.getSession().getAttribute("customer"));
        request.getRequestDispatcher("addCar.jsp").forward(request, response);
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
        CarDAO cd = new CarDAO();
        Customer c = (Customer)request.getSession().getAttribute("customer");
        int customer_id = c.getCustomer_id();
        //getParameter
        String model = request.getParameter("model");
        String plate = request.getParameter("plate");
        Part filePart = request.getPart("image");

        // Get the input stream from the file part
        InputStream inputStream = filePart.getInputStream();

        // Read the input stream into a byte array
        byte[] image = IOUtils.toByteArray(inputStream);
        Car car = new Car(customer_id, model, plate, image);
        //add obj in database
        cd.addCar(car);
        response.sendRedirect(request.getContextPath()+"/homepage");
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
