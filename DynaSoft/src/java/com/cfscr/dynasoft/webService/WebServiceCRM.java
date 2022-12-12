/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cfscr.dynasoft.webService;

import com.cfscr.dynasoft.entities.Uen;
import com.cfscr.dynasoft.entities.DocumentosCRM;
import com.cfscr.dynasoft.entities.PropietarioOp;
import com.cfscr.dynasoft.entities.ClientePotencial;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.mashape.unirest.http.*;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 *
 * @author pablo.elizondo
 */
public class WebServiceCRM {
    
    private final String webApi = "https://cfssistemas1.api.crm.dynamics.com/api/data/v9.2/";
    private final String oportunidades = webApi + "opportunities";
    private final String oportunidades2 = oportunidades + "?$skiptoken=%3Ccookie%20pagenumber=%222%22%20pagingcookie=%22%253ccookie%2520page%253d%25221%2522%253e%253copportunityid%2520last%253d%2522%257bC42E05FB-4DA9-E711-813F-E0071B6A4261%257d%2522%2520first%253d%2522%257bDD37B14B-EE17-ED11-B83E-000D3A102BC2%257d%2522%2520%252f%253e%253c%252fcookie%253e%22%20istracking=%22False%22%20/%3E";
    private final String uen = webApi + "ap_uens";
    private final String clientePotencial = webApi + "accounts";
    private final String propietario = webApi + "systemusers";
    
    //Retorna el vector de oportunidades
    public ArrayList<DocumentosCRM> realizaConsulta(String bodyAuthorization, String bodyCookie, String fechaInicio, String fechaFin) {
        ArrayList<DocumentosCRM> docsCRM = new ArrayList<>();
        ArrayList<Uen> uens = new ArrayList<>();
        ArrayList<ClientePotencial> clientes = new ArrayList<>();
        ArrayList<PropietarioOp> propietarios = new ArrayList<>();
        
        try{
            //Consulta al API Web
            Unirest.setTimeouts(0, 0);
            HttpResponse responseOps1 = Unirest.get(oportunidades).header("Authorization", bodyAuthorization).header("Cookie", bodyCookie).asString();
            HttpResponse responseOps2 = Unirest.get(oportunidades2).header("Authorization", bodyAuthorization).header("Cookie", bodyCookie).asString();
            HttpResponse responseUens = Unirest.get(uen).header("Authorization", bodyAuthorization).header("Cookie", bodyCookie).asString();
            HttpResponse responseClientes = Unirest.get(clientePotencial).header("Authorization", bodyAuthorization).header("Cookie", bodyCookie).asString();
            HttpResponse responsePropietarios = Unirest.get(propietario).header("Authorization", bodyAuthorization).header("Cookie", bodyCookie).asString();
            
            //Cargar objetos JSON
            JSONObject objJsonOps = new JSONObject(responseOps1.getBody().toString());
            JSONObject objJsonOps2 = new JSONObject(responseOps2.getBody().toString());
            JSONObject objJsonUens = new JSONObject(responseUens.getBody().toString());
            JSONObject objJsonClientes = new JSONObject(responseClientes.getBody().toString());
            JSONObject objJsonPropietario = new JSONObject(responsePropietarios.getBody().toString());
            
            //Cargar vectores JSON
            JSONArray jsonArrayops1 = objJsonOps.getJSONArray("value");
            JSONArray jsonArrayops2 = objJsonOps2.getJSONArray("value");
            JSONArray jsonArrayUens = objJsonUens.getJSONArray("value");
            JSONArray jsonArrayClientes = objJsonClientes.getJSONArray("value");
            JSONArray jsonArrayPropietarios = objJsonPropietario.getJSONArray("value");
            
            //Cargar Vectores de trabajo
            docsCRM = documentosCRM(jsonArrayops1, docsCRM, StringToDate(fechaInicio), StringToDate(fechaFin));
            docsCRM = documentosCRM(jsonArrayops2, docsCRM, StringToDate(fechaInicio),StringToDate(fechaFin));
            uens = cargarUENS(jsonArrayUens, uens);
            clientes = cargarClientes(jsonArrayClientes, clientes);
            propietarios = cargarPropietarios(jsonArrayPropietarios, propietarios);
        
            //Generar vector de oportunidades
            for(int i=0; i<docsCRM.size(); i++){
                for(int j=0; j<uens.size(); j++){
                    if(docsCRM.get(i).getUEN().equals(uens.get(j).getIdUEN())){
                        docsCRM.get(i).setUEN(uens.get(j).getNombreUEN()); 
                    }
                }
                for(int j=0; j<clientes.size(); j++){
                    if(docsCRM.get(i).getClientePotencial().equals(clientes.get(j).getIdCliente())){
                        docsCRM.get(i).setClientePotencial(clientes.get(j).getNombreCliente());
                    }
                }
                for(int j=0; j<propietarios.size(); j++){
                    if(docsCRM.get(i).getPropietario().equals(propietarios.get(j).getIdPropietario())){
                        docsCRM.get(i).setPropietario(propietarios.get(j).getNombrePropietario());
                    }
                }
            }
        } catch (UnirestException ex){
            Logger.getLogger(WebServiceCRM.class.getName()).log(Level.SEVERE, null, ex);
        }
        return docsCRM;
    }
    
    //Carga las oportunidades en el vector de Oportunidades
    private ArrayList<DocumentosCRM> documentosCRM(JSONArray jsonArray, ArrayList<DocumentosCRM> docsCRM, Date fechaInicio, Date fechaFinal){
        
        for(int i=0; i<jsonArray.length(); i++){
            JSONObject objetoJson = jsonArray.getJSONObject(i);
           
            //Evalua el rango de fechas que debe cargar
            if((!objetoJson.get("new_estimatedbillingdate").equals(null)) && 
                (StringToDate(objetoJson.getString("new_estimatedbillingdate")).after(fechaInicio)) &&
                (StringToDate(objetoJson.getString("new_estimatedbillingdate")).before(fechaFinal)) &&
                (objetoJson.get("statecode").equals(1))
            ){
                DocumentosCRM docCRM = new DocumentosCRM();
                
                docCRM.setOportunidad((objetoJson.get("new_contadorautonumerico").equals(null)) ? null : objetoJson.getString("new_contadorautonumerico"));
                docCRM.setTema((objetoJson.get("name").equals(null)) ? null : objetoJson.getString("name"));
                docCRM.setUEN((objetoJson.get("_ap_uen_value").equals(null)) ? null : objetoJson.getString("_ap_uen_value"));
                docCRM.setClientePotencial((objetoJson.get("_customerid_value").equals(null)) ? null : objetoJson.getString("_customerid_value"));
                docCRM.setIngresosReales((objetoJson.get("actualvalue").equals(null)) ? 0.f : objetoJson.getFloat("actualvalue"));
                docCRM.setEstProfit((objetoJson.get("new_estprofit").equals(null)) ? 0.f : objetoJson.getFloat("new_estprofit"));
                docCRM.setFechaCierre((objetoJson.get("actualclosedate").equals(null)) ? null : StringToDate(objetoJson.getString("actualclosedate")));
                docCRM.setFechaEstimada(StringToDate(objetoJson.getString("new_estimatedbillingdate")));
                docCRM.setPropietario((objetoJson.get("_ownerid_value").equals(null)) ? null : objetoJson.getString("_ownerid_value"));     //Consumir servicio
                
                docsCRM.add(docCRM);
            }
        }
        return docsCRM;
    }
    
    //Cargar las UENS en el vector
    private ArrayList<Uen> cargarUENS(JSONArray jsonArray, ArrayList<Uen> arrayUens){
         for(int i=0; i<jsonArray.length(); i++){
             JSONObject objetoJson = jsonArray.getJSONObject(i);
             Uen miUen = new Uen(objetoJson.getString("ap_uenid"),objetoJson.getString("ap_name"));
             arrayUens.add(miUen);
         }
        return arrayUens;
    }
    
    //Cargar los clientes en el vector
    private ArrayList<ClientePotencial> cargarClientes(JSONArray jsonArray, ArrayList<ClientePotencial> arrayClientes){
        for(int i=0; i<jsonArray.length(); i++){
            JSONObject objetoJson = jsonArray.getJSONObject(i);
            ClientePotencial cliente = new ClientePotencial(objetoJson.getString("accountid"),objetoJson.getString("name"));
            arrayClientes.add(cliente);
        }
        return arrayClientes;
    }
    
    //Cargar propietarios de oportunidades
    private ArrayList<PropietarioOp> cargarPropietarios(JSONArray jsonArray, ArrayList<PropietarioOp> arrayPropietarios){
        for(int i=0; i<jsonArray.length(); i++){
            
            JSONObject objetoJson = jsonArray.getJSONObject(i);
            
            PropietarioOp propietarioOp = new PropietarioOp();
            propietarioOp.setIdPropietario((objetoJson.get("ownerid").equals(null)) ? null : objetoJson.getString("ownerid") );
            propietarioOp.setNombrePropietario((objetoJson.get("yomifullname").equals(null)) ? null : objetoJson.getString("yomifullname"));
            arrayPropietarios.add(propietarioOp);
        }
        return arrayPropietarios;
    }
    
    //Castea un String a Date
    private Date StringToDate(String fecha) {
        Date f = null;
        try {
            f = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(WebServiceCRM.class.getName()).log(Level.SEVERE, null, ex);
        }
        return f;
    }
}
