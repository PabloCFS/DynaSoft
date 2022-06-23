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
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;


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
        
        System.out.println("Main-50 "+pFecha1);
        System.out.println("Main-51 "+pFecha2);
        nc = serviceDoc.obtenerDocumentos(pFecha1, pFecha2, 'C');
        System.out.println("Fui a la base");
        
        for(int i=0; i<nc.size(); i++){
            System.out.println("CLIENTE -> " + nc.get(i).getCliente());
            System.out.println("FECHA -> " + nc.get(i).getCreateDate());
        }
        
        serviceDoc.cargarExcel(nc);
        System.out.println("Cargue el excel");
        
        
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        
        /*
        Date fecha2 = null;
        Date fecha1 = formatter.parse(pFecha1);
        String formattedDateString = formatter.format(fecha1);
        
        System.out.println("============================");
        System.out.println(fecha1);
        System.out.println(formattedDateString);
        System.out.println("============================");
        */
        
        
        //serviceDoc.obtenerDocumentos(fecha1, fecha2, 'F');
        
        
    }
    
}
