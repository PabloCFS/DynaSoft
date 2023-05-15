/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cfscr.dynasoft.controllers;

import com.cfscr.dynasoft.entities.DocumentoAgrupacion;
import com.cfscr.dynasoft.entities.DocumentoComparativa;
import com.cfscr.dynasoft.entities.DocumentosCRM;
import com.cfscr.dynasoft.entities.DocumentosERP;
import com.cfscr.dynasoft.services.ServiceDocElectronicoImpl;
import jakarta.servlet.ServletConfig;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author pablo.elizondo
 */
public class ListarDocs extends HttpServlet {

    ServiceDocElectronicoImpl serviceDocImpl = new ServiceDocElectronicoImpl();
    
    public ListarDocs(){
        super();
    }
    
    public void init(ServletConfig config) throws ServletException{
        String initial = config.getInitParameter("initial");
        serviceDocImpl = new ServiceDocElectronicoImpl();
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
        
        HttpSession session = request.getSession();
        
        response.setContentType("text/html;charset=utf-8");
       
        String fecha1 = (request.getParameter("fecha1"));
        String fecha2 = (request.getParameter("fecha2"));
        String authorization = (request.getParameter("textAuthorization"));
        String cookie = (request.getParameter("textCookie"));
        
        ArrayList<DocumentosERP> docsERP = new ArrayList<>();
        ArrayList<DocumentosCRM> docsCRM = new ArrayList<>();
        
        ArrayList<DocumentosERP> docsERP2 = new ArrayList<>();
        ArrayList<DocumentosCRM> docsCRM2 = new ArrayList<>();
        
        ArrayList<DocumentoComparativa> docsComparativa = new ArrayList<>();
        ArrayList<DocumentoAgrupacion> docsAgrupacion = new ArrayList<>();
       
        docsERP = serviceDocImpl.obtenerERP(docsERP, fecha1, fecha2);
        docsCRM = serviceDocImpl.obtenerCRM(docsCRM, authorization, cookie, fecha1, fecha2);
        
        docsERP2 = serviceDocImpl.obtenerERP(docsERP2, fecha1, fecha2);
        docsCRM2 = serviceDocImpl.obtenerCRM(docsCRM2, authorization, cookie, fecha1, fecha2);
        
        docsComparativa = serviceDocImpl.creaComparativa(docsCRM2, docsERP2, docsComparativa);
        docsAgrupacion = serviceDocImpl.creaAgrupacion(docsComparativa, docsAgrupacion);
        serviceDocImpl.cargarExcel();
        
        request.setAttribute("valor", "2");
        session.setAttribute("valor", "2");
        request.setAttribute("docsERP", docsERP);
        session.setAttribute("docsERP", docsERP);
        request.setAttribute("docsCRM", docsCRM);
        session.setAttribute("docsCRM", docsCRM);
        request.setAttribute("docsComparativa", docsComparativa);
        session.setAttribute("docsComparativa", docsComparativa);
        request.setAttribute("docsAgrupacion", docsAgrupacion);
        session.setAttribute("docsAgrupacion", docsAgrupacion);
        
        request.getRequestDispatcher("ListarDocsElectronicos.jsp").forward(request, response);
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
