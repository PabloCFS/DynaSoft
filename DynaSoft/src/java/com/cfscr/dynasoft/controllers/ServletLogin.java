/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.cfscr.dynasoft.controllers;

import com.cfscr.dynasoft.entities.Usuario;
import com.cfscr.dynasoft.services.ServiceUsuarioImpl;
import jakarta.servlet.ServletConfig;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author pablo.elizondo
 */
@WebServlet(name = "ServletLogin", urlPatterns = {"/ServletLogin"})
public class ServletLogin extends HttpServlet {
    
    ServiceUsuarioImpl usuarioImplement;
    
    public ServletLogin(){
        super();
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        String initial = config.getInitParameter("initial");
        usuarioImplement = new ServiceUsuarioImpl();
    }
    
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
        
        HttpSession Session = request.getSession();
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String user;
        String password;
        
        //Esta validacion se debe realizar desde la base de datos
        Usuario aux = new Usuario("Usuario","123");
        
        try{
            user = (request.getParameter("username"));
            password = (request.getParameter("password"));
        } catch(Exception e){
            request.getRequestDispatcher("Home.jsp").forward(request, response);
        }
        
       
        
        if(aux != null){
            Session = request.getSession(true);
            Session.setAttribute("usuario", aux.getNombre());
            
            request.getRequestDispatcher("ListarDocsElectronicos.jsp").forward(request, response);
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
