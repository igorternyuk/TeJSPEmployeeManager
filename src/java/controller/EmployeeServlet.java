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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAOEmployee;
import uml.Employee;

/**
 *
 * @author igor
 */
@WebServlet(name = "EmployeeServlet", urlPatterns = {"/employees"})
public class EmployeeServlet extends HttpServlet {

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
            
            List<Employee> data = new ArrayList<>();
            Employee employee = new Employee();
            DAOEmployee dao = new DAOEmployee();
            String result;
            
            try{
                if(request.getParameter("btnInsert") != null){
                    int id = Integer.parseInt(request.getParameter("inputID"));
                    String name = request.getParameter("inputName");
                    String surname = request.getParameter("inputSurname");
                    int age = Integer.parseInt(request.getParameter("inputAge"));
                    String address = request.getParameter("inputAddress");
                    String phone= request.getParameter("inputPhone");
                    String email = request.getParameter("inputEmail");
                    employee.setId(id);
                    employee.setName(name);
                    employee.setSurname(surname);
                    employee.setAge(age);
                    employee.setAddress(address);
                    employee.setPhone(phone);
                    employee.setEmail(email);
                    if(dao.insert(employee)){
                        result = "Employee was successfully inserted to the database";
                    }
                    else{
                        result = "Insertion failed";
                    }
                    request.setAttribute("result", result);
                        
                }
                else if(request.getParameter("btnUpdate") != null){
                    int id = Integer.parseInt(request.getParameter("inputID"));
                    String name = request.getParameter("inputName");
                    String surname = request.getParameter("inputSurname");
                    int age = Integer.parseInt(request.getParameter("inputAge"));
                    String address = request.getParameter("inputAddress");
                    String phone= request.getParameter("inputPhone");
                    String email = request.getParameter("inputEmail");
                    employee.setId(id);
                    employee.setName(name);
                    employee.setSurname(surname);
                    employee.setAge(age);
                    employee.setAddress(address);
                    employee.setPhone(phone);
                    employee.setEmail(email);
                    if(dao.update(employee)){
                        result = "Employee's information was successfully updated";
                    }
                    else{
                        result = "Updated failed";
                    }
                    request.setAttribute("result", result);
                }
                else if(request.getParameter("btnDelete") != null){
                    int id = Integer.parseInt(request.getParameter("inputID"));
                    if(dao.remove(id)){
                        result = "Employee register with id" + String.valueOf(id) + 
                                 "was successfully deleted";
                    }
                    else{
                        result = "Could not delete register";
                    }
                    request.setAttribute("result", result);
                }
                else if(request.getParameter("btnSearch") != null){
                    String filter = request.getParameter("comboSearch");
                    String rexExp = request.getParameter("txtRegExp");
                    List<Employee> searchResult;
                    if(request.getParameter("checkBoxAge") != null){
                        int minAge = Integer.parseInt(request.getParameter("txtMinAge"));
                        int maxAge = Integer.parseInt(request.getParameter("txtMaxAge"));
                        searchResult = dao.search(rexExp, filter, minAge, maxAge); 
                    }
                    else{
                        searchResult = dao.search(rexExp, filter); 
                    }
                    if(searchResult.isEmpty()){
                        result = "Cound not find employees with such parameters";
                    }
                    else {
                        if(searchResult.size() == 1)
                            result = "One employee was found";
                        else
                            result = searchResult.size() + " employees were found";
                    }
                    request.setAttribute("result", result);
                    request.setAttribute("searchResult", searchResult);
                } 
                else if(request.getParameter("btnReadAll") != null){
                    List<Employee> searchResult = dao.readAll();                    
                    result = "Listado completo";
                    request.setAttribute("result", result);
                    request.setAttribute("searchResult", searchResult);
                }
                request.getRequestDispatcher("EmployeeView.jsp").forward(request, response);
            }
            catch(NumberFormatException ex){
                Logger.getLogger(EmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
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
