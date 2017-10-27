/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.UserDAO;
import model.dto.UserDTO;

/**
 *
 * @author igor
 * Last edited 27-10-2017
 */
@WebServlet(name = "MenuServlet", urlPatterns = {"/menu.view"})
public class MenuServlet extends HttpServlet {

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
        HttpSession session = request.getSession();
        UserDTO u = (UserDTO)session.getAttribute("user");        
        if(u == null){
            try {
                //Si el objeto de usuario es vacio creamos el objeto de la clase
                //error con descripcíon correspondiente.
                List<model.Error> errors = new ArrayList();
                UserDAO dao = new UserDAO();
                errors.add(model.Error.SESSION_IS_NOT_STARTED);
                session.setAttribute("errors", errors);
                request.getRequestDispatcher("error.view").forward(request, response);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MenuServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Menu</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            out.println("<hr>"); 
            out.println("<h1>Menu</h1>"); 
            out.println("<hr"); 
            out.println("<br /><a href='EmployeeView.jsp' style=\"font-size: 20px\">Manage employees</a>");
            out.println("<br /><a href='UsersView.jsp' style=\"font-size: 20px\">Manage users</a>");
            out.println("<br /><a href='logout.do' style=\"font-size: 20px\">Close session</a>");
            out.println("<hr>"); 
            out.println("</center>");
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
        processRequest(request, response);
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
