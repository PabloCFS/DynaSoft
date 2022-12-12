/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RUNS;

import com.cfscr.dynasoft.entities.DocumentosERP;
import com.cfscr.dynasoft.entities.DocumentosCRM;
import com.cfscr.dynasoft.excel.CargarDocCRM;
import com.cfscr.dynasoft.excel.LecturaExcel;

import com.cfscr.dynasoft.services.ServiceDocElectronicoImpl;
import java.io.File;

import java.text.ParseException;

import java.util.ArrayList;
import java.util.List;

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

        System.out.println("----------------------------");
        
        /*GESTION DE USUARIOS*/
        /*
        DAOusuario us = new DAOusuario();
        ArrayList<Usuario> usuarios = us.ListarUsuarios();
        
        for(int i=0; i<usuarios.size(); i++){
            System.out.println("Nombre -> " + usuarios.get(i).getNombre());
            System.out.println("Clave -> " + usuarios.get(i).getClave());
        }
        */
        
        System.out.println("============================");
        
        /*TRABAJO CON DOCUMENTOS ELECTRONICOS*/
   
        ArrayList<DocumentosERP> nc;
        ServiceDocElectronicoImpl serviceDoc = new ServiceDocElectronicoImpl();

        //String pFecha1= "2021-12-31 23:59:59.000";
        String pFecha1 = "2021-12-31 23:59:59.000";
        String pFecha2= "2023-01-01 00:00:01.000";

        nc = serviceDoc.obtenerDocumentos(pFecha1, pFecha2, 'F');
        
        File f = new File("C:/Users/Pablo.Elizondo/Documents/Desarrollos/1-ERP-CRM/Proyecto/DynaSoft/ReporteDynamics.xlsx");
        List lista = new ArrayList<>();
        
        LecturaExcel crm = new LecturaExcel();
        CargarDocCRM cargarCRM = new CargarDocCRM();
        
        lista = crm.leerExcel(f);
        
        cargarCRM.obtener(lista);
        ArrayList<DocumentosCRM> docsCRM; 
        docsCRM = cargarCRM.obtener(crm.leerExcel(f));
        
        serviceDoc.cargarExcel(nc,docsCRM);
        System.out.println("Cargue el excel");
    }
}