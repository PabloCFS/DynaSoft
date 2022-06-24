/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cfscr.dynasoft.connection;

import com.cfscr.dynasoft.entities.DocumentoElectronico;
import com.cfscr.dynasoft.entities.Usuario;

import com.cfscr.dynasoft.services.ServiceDocElectronicoImpl;

import java.text.ParseException;

import java.util.ArrayList;

/**
 *
 * @author pablo.elizondo
 */
public class NewMain2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        System.out.println("Hola");
        DAOusuario us = new DAOusuario();
        ArrayList<Usuario> usuarios = us.ListarUsuarios();
        
        
        for(int i=0; i<usuarios.size(); i++){
            System.out.println("Nombre -> " + usuarios.get(i).getNombre());
            System.out.println("Clave -> " + usuarios.get(i).getClave());
        }
      
        System.out.println("============================");
        
        /*TRABAJO CON DOCUMENTOS ELECTRONICOS*/
        ArrayList<DocumentoElectronico> nc;
        ServiceDocElectronicoImpl serviceDoc = new ServiceDocElectronicoImpl();

        String pFecha1= "2022-06-09 00:00:00.000";
        String pFecha2= "2022-06-11 00:00:00.000";        

        nc = serviceDoc.obtenerDocumentos(pFecha1, pFecha2, 'C');
        System.out.println("Fui a la base");
        
        serviceDoc.cargarExcel(nc);
        System.out.println("Cargue el excel");
        
    }
    
}
