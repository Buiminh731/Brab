/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.BookDAO;
import dal.CarDAO;
import dal.CustomerDAO;
import dal.EmailDAO;
import dal.HistoryDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Book;
import model.Car;
import model.Customer;

/**
 *
 * @author Minh Bui
 */
@WebServlet(name = "DriverControl", urlPatterns = {"/drivercontrol"})
public class DriverControl extends HttpServlet {

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
            out.println("<title>Servlet DriverControl</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DriverControl at " + request.getContextPath() + "</h1>");
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
        //getSessionData
        Customer c = (Customer) request.getSession().getAttribute("customer");
        BookDAO bd = new BookDAO();
        CarDAO cd = new CarDAO();
        CustomerDAO cusd = new CustomerDAO();
        //list all data for display
        List<Book> listB = bd.getAllInfoForDriver(c.getCustomer_id());
        List<Car> listC = cd.getDisplayInfo();
        List<Customer> listCus = cusd.getAll();
        request.setAttribute("current", c);
        request.setAttribute("listB", listB);
        request.setAttribute("listC", listC);
        request.setAttribute("listCus", listCus);
        request.getRequestDispatcher("book_driver.jsp").forward(request, response);
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
        Customer c = (Customer) request.getSession().getAttribute("customer");
        BookDAO bd = new BookDAO();
        EmailDAO ed = new EmailDAO();
        CarDAO cd = new CarDAO();
        CustomerDAO cusd = new CustomerDAO();
        HistoryDAO hd = new HistoryDAO();
        //get parameter
        int id = Integer.parseInt(request.getParameter("id"));
        int cid = Integer.parseInt(request.getParameter("cid"));
        String changeValue = request.getParameter("but");
        String phone_number = cusd.getPhoneNumberByID(cid);
        boolean prevent = hd.detectExistance(hd.getAll(), id);
        //update staus and send notification to customer

        if (!prevent) {
            try{
            if (changeValue.equalsIgnoreCase("confirm")) {
                bd.updateStatus(1, id);
                ed.sendSMS(phone_number, "Your order have been confirm!");
            } else {
                bd.updateStatus(0, id);
                ed.sendSMS(phone_number, "Your order have been decline!");
            }}catch(Exception e){
                response.sendRedirect(request.getContextPath() + "/drivercontrol");
            }
            response.sendRedirect(request.getContextPath() + "/drivercontrol");
        } else if (prevent) {
            request.setAttribute("prevent", "Timeout order, you can't change this.");
            List<Book> listB = bd.getAllInfoForDriver(c.getCustomer_id());
            List<Car> listC = cd.getDisplayInfo();
            List<Customer> listCus = cusd.getAll();
            request.setAttribute("current", c);
            request.setAttribute("listB", listB);
            request.setAttribute("listC", listC);
            request.setAttribute("listCus", listCus);
            request.getRequestDispatcher("book_driver.jsp").forward(request, response);
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
