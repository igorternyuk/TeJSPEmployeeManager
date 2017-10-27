/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
import model.UserDAO;
import model.dto.UserDTO;

/**
 *
 * @author igor
 */
@WebServlet(name = "UserManagmentServlet", urlPatterns = {"/users.do"})
public class UserManagmentServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            List<UserDTO> data = new ArrayList<>();
            UserDTO user = new UserDTO();
            UserDAO dao = new UserDAO();
            String result;
            
            try{
                if(request.getParameter("btnInsert") != null){
                    int id = Integer.parseInt(request.getParameter("inputID"));
                    String name = request.getParameter("inputName");
                    String email = request.getParameter("inputEmail");
                    String password = request.getParameter("inputPassword");
                    user.setId(id);
                    user.setName(name);
                    user.setEmail(email);
                    user.setPassword(password);
                    if(dao.insert(user)){
                        result = "New user was successfully inserted to the database";
                    }
                    else{
                        result = "User insertion failed";
                    }
                    request.setAttribute("result", result);
                        
                }
                else if(request.getParameter("btnUpdate") != null){
                    int id = Integer.parseInt(request.getParameter("inputID"));
                    String name = request.getParameter("inputName");
                    String email = request.getParameter("inputEmail");
                    String password = request.getParameter("inputPassword");
                    user.setId(id);
                    user.setName(name);
                    user.setEmail(email);
                    user.setPassword(password);
                    if(dao.update(user)){
                        result = "Users's information was successfully updated";
                    }
                    else{
                        result = "User info update failed";
                    }
                    request.setAttribute("result", result);
                }
                else if(request.getParameter("btnDelete") != null){
                    int id = Integer.parseInt(request.getParameter("inputID"));
                    if(dao.remove(id)){
                        result = "User register with id = " + String.valueOf(id) + 
                                 " was successfully deleted";
                    }
                    else{
                        result = "Could not delete register";
                    }
                    request.setAttribute("result", result);
                }
                else if(request.getParameter("btnSearch") != null){
                    String filter = request.getParameter("comboSearch");
                    String rexExp = request.getParameter("txtRegExp");
                    List<UserDTO> searchResult;
                    searchResult = dao.search(filter, rexExp); 
                    if(searchResult.isEmpty()){
                        result = "Cound not find users with such parameters";
                    }
                    else {
                        if(searchResult.size() == 1)
                            result = "One user was found";
                        else
                            result = searchResult.size() + " users were found";
                    }
                    request.setAttribute("result", result);
                    request.setAttribute("searchResult", searchResult);
                } 
                else if(request.getParameter("btnReadAll") != null){
                    List<UserDTO> searchResult = dao.readAll();                    
                    result = "Listado completo";
                    request.setAttribute("result", result);
                    request.setAttribute("searchResult", searchResult);
                }
                request.getRequestDispatcher("UsersView.jsp").forward(request, response);
            }
            catch(NumberFormatException ex){
                Logger.getLogger(EmployeeManagmentServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
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
