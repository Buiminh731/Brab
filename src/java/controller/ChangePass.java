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
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Car;
import model.Customer;

/**
 *
 * @author Minh Bui
 */
@WebServlet(name = "ChangePass", urlPatterns = {"/changepass"})
public class ChangePass extends HttpServlet {

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
            out.println("<title>Servlet ChangePass</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ChangePass at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        //getSessionData
        Customer c = (Customer) request.getSession().getAttribute("customer");
        //get parameter
        String psw = request.getParameter("psw");
        String npsw = request.getParameter("npsw");
        String cnpsw = request.getParameter("cnpsw");
        CustomerDAO cusd = new CustomerDAO();
        CarDAO cd = new CarDAO();
        BookDAO bd = new BookDAO();
        //check psw condition
        String checkSimlarity = cusd.checkPass(npsw, cnpsw);
        if (!c.getPassword().equals(psw)) {
            String checkPass = "Sai mật khẩu";
            request.setAttribute("checkPass", checkPass);
        }
        request.setAttribute("checkSimlarity", checkSimlarity);
        //send back data for report purpose
        List<Car> list = cd.getDisplayInfo();
        request.setAttribute("summary", cusd.summary(c.getCustomer_id()));
        request.setAttribute("bookList", bd.listOrderDone(c.getCustomer_id()));
        request.setAttribute("listC", list);
        request.setAttribute("current", c);
        if (c.getPassword().equals(psw) && checkSimlarity == null) {
            cusd.changePass(c.getCustomer_id(), npsw);
            response.sendRedirect(request.getContextPath()+"/");
        }else{
        request.getRequestDispatcher("yourInfo.jsp").forward(request, response);
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
