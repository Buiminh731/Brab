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
import java.util.ArrayList;
import java.util.List;
import model.Car;
import model.Customer;

/**
 *
 * @author Minh Bui
 */
@WebServlet(name="SearchEngine", urlPatterns={"/search"})
public class SearchEngine extends HttpServlet {
   
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
            out.println("<title>Servlet SearchEngine</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchEngine at " + request.getContextPath () + "</h1>");
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
        String searchInput = request.getParameter("search-input");
        //get data list
        List<Car> list = cd.getSearchResult(searchInput);
        
        int numPs=list.size();
        int numperPage=3;
        int numpage=numPs/numperPage+(numPs%numperPage==0?0:1);
        int start,end;
        String tpage=request.getParameter("page");
        int page;
        try{
            page=Integer.parseInt(tpage);
        }catch(NumberFormatException e){
            page=1;
        }
        start=(page-1)*numperPage;
        if(page*numperPage>numPs){
            end=numPs;
        }else
            end=page*numperPage;
        
        List<Car> arr = cd.getCarByPage(list, start, end);
        //so phan tu cua 1 trang
        request.setAttribute("data", arr);
        //so trang
        request.setAttribute("num", numpage);
        
        request.setAttribute("list", list);
        request.setAttribute("current", (Customer) request.getSession().getAttribute("customer"));
        request.setAttribute("searchInput", searchInput);
        request.getRequestDispatcher("search.jsp").forward(request, response); 
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
        String searchInput = request.getParameter("search-input");
        //get data list
        List<Car> list = cd.getSearchResult(searchInput);
        
        int numPs=list.size();
        int numperPage=3;
        int numpage=numPs/numperPage+(numPs%numperPage==0?0:1);
        int start,end;
        String tpage=request.getParameter("page");
        int page;
        try{
            page=Integer.parseInt(tpage);
        }catch(NumberFormatException e){
            page=1;
        }
        start=(page-1)*numperPage;
        if(page*numperPage>numPs){
            end=numPs;
        }else
            end=page*numperPage;
        List<Car> arr = cd.getCarByPage(list, start, end);
        //so phan tu cua 1 trang
        request.setAttribute("data", arr);
        //so trang
        request.setAttribute("num", numpage);
        
        request.setAttribute("list", list);
        request.setAttribute("current", (Customer) request.getSession().getAttribute("customer"));
        request.setAttribute("searchInput", searchInput);
        request.getRequestDispatcher("search.jsp").forward(request, response);                                                                                                                                                                                                                                                                                                                                                                        
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
