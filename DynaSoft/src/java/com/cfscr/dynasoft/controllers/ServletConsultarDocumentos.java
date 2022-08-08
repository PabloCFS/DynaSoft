/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cfscr.dynasoft.controllers;

import com.cfscr.dynasoft.entities.DocumentoElectronico;
import com.cfscr.dynasoft.services.ServiceDocElectronicoImpl;

import java.util.ArrayList;
import java.io.IOException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author pablo.elizondo
 */
@WebServlet(name = "ServletConsultarDocumentos", urlPatterns = {"/ServletConsultarDocumentos"})
public class ServletConsultarDocumentos extends HttpServlet {
    
    ServiceDocElectronicoImpl serviceDoc = new ServiceDocElectronicoImpl();
    
    public ServletConsultarDocumentos(){
        super();
    }
       
    @Override
    public void init(ServletConfig config) throws ServletException {
        String initial = config.getInitParameter("initial");
        serviceDoc = new ServiceDocElectronicoImpl();
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
        
         
         
         
        try{
            
            /*REVISAR*/
            //SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            //Date fecha_1 = formatter.parse(fecha1);
            /*REVISAR*/
            
            /*
            
            */
            //
            //
            
            request.getRequestDispatcher("ListarDocsElectronicos.jsp").forward(request, response);
        } catch(ServletException | IOException  e){
            
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
        HttpSession session = request.getSession();
        
        String fecha1, fecha2;
        fecha1 = (request.getParameter("fecha1"));
            fecha1 = fecha1 + " 00:00:00.000";
            
            fecha2 = (request.getParameter("fecha2"));
            fecha2 = fecha2 + " 00:00:00.000";
            
            System.out.println("Fecha 1 | "+fecha1 +"\n" + "Fecha 2 | "+fecha2);
            
            ArrayList<DocumentoElectronico> documentos = new ArrayList<>();     System.out.println("Servlet-68");
            documentos = serviceDoc.obtenerDocumentos(fecha1, fecha2, 'C');     System.out.println("Servlet-69");
            
            serviceDoc.cargarExcel(documentos);
            System.out.println("Cargar excel");
            
            request.setAttribute("documentos", documentos);
            session.setAttribute("documentos", documentos);
        request.getRequestDispatcher("ListarDocsElectronicos.jsp").forward(request, response);
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
