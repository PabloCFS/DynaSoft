/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.cfscr.dynasoft.controllers;

import com.cfscr.dynasoft.entities.Usuario;
import com.cfscr.dynasoft.services.ServiceUsuarioImpl;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author pablo.elizondo
 */
@WebServlet(name = "ServletLogin", urlPatterns = {"/ServletLogin"})
public class ServletLogin extends HttpServlet {
    
    ServiceUsuarioImpl usuarioServiceImpl;
    
    public ServletLogin(){
        super();
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException{
        String initial = config.getInitParameter("initial");
        usuarioServiceImpl = new ServiceUsuarioImpl();
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
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession Session;
        
        System.out.println("51");
        
        response.setContentType("text/html;charset=UTF-8");
        
        String usuario;
        String contrasenia;
        
        Usuario aux;
        System.out.println("59");
        try{
            usuario = (request.getParameter("username"));
            contrasenia = (request.getParameter("password"));
            System.out.println("63");
        } catch(Exception e){
            System.out.println("65");
            request.getRequestDispatcher("Home.jsp").forward(request, response);
            
            return;
        }
        
        aux = usuarioServiceImpl.obtenerUsuario(usuario,contrasenia);
        System.out.println("72");
        if(aux != null){
            System.out.println("74");
            
            Session = request.getSession(true);
            Session.setAttribute("usuario", aux.getNombre());
            
            System.out.println("79");
            
             response.sendRedirect("ListarContacto");
            
            System.out.println("83");
        }
        if(aux == null){
            System.out.println("86");
            request.getRequestDispatcher("Home.jsp").forward(request, response);
            System.out.println("88");
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
