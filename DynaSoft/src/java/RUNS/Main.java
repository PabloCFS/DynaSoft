/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RUNS;

import com.cfscr.dynasoft.webService.WebServiceCRM;
import com.mashape.unirest.http.*;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pablo.elizondo
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String []args){
        // TODO code application logic here
           
        WebServiceCRM crm = new WebServiceCRM();
        
        String bodyAuthorization = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6IjJaUXBKM1VwYmpBWVhZR2FYRUpsOGxWMFRPSSIsImtpZCI6IjJaUXBKM1VwYmpBWVhZR2FYRUpsOGxWMFRPSSJ9.eyJhdWQiOiJodHRwczovL2Nmc3Npc3RlbWFzMS5jcm0uZHluYW1pY3MuY29tLyIsImlzcyI6Imh0dHBzOi8vc3RzLndpbmRvd3MubmV0LzUwODQ1YTQ0LTI2MGItNDdlNi1iMjAzLWQ4YWFjYjEwN2UzNC8iLCJpYXQiOjE2NzA2MTUwMDMsIm5iZiI6MTY3MDYxNTAwMywiZXhwIjoxNjcwNjE5NjI5LCJhY3IiOiIxIiwiYWdlR3JvdXAiOiIzIiwiYWlvIjoiQVRRQXkvOFRBQUFBWU9QNkM5dmVNNm81OUhVWUFsQ1h1Ty9icDYxOFRhOVBlOFUxeEtPdUI5VG5Keld3ekZMQTNuSHFTNkQ5YVF5OCIsImFtciI6WyJwd2QiXSwiYXBwaWQiOiIxODRlZTUyOS1iNjYxLTRiZDUtYjFjYy02ZGI4MmExNzRhNGYiLCJhcHBpZGFjciI6IjAiLCJmYW1pbHlfbmFtZSI6IkVsaXpvbmRvIiwiZ2l2ZW5fbmFtZSI6IlBhYmxvIiwiaXBhZGRyIjoiMTg2LjE3Ny4xODcuMjM5IiwibmFtZSI6IlBhYmxvIEVsaXpvbmRvIiwib2lkIjoiZWM0M2M0NGQtMGI1My00Y2VjLTk3MTgtZTFiMDVlMDQ2YzNmIiwicHVpZCI6IjEwMDMyMDAxMzM5Mjc1MDgiLCJyaCI6IjAuQVc4QVJGcUVVQXNtNWtleUE5aXF5eEItTkFjQUFBQUFBQUFBd0FBQUFBQUFBQUJ2QVBJLiIsInNjcCI6InVzZXJfaW1wZXJzb25hdGlvbiIsInN1YiI6ImJyZnFoQkhOcjNVaDFnNEd3QnlzZHJ4SWZYNVkyX2h4bzRLRDc4Zl9sVzgiLCJ0aWQiOiI1MDg0NWE0NC0yNjBiLTQ3ZTYtYjIwMy1kOGFhY2IxMDdlMzQiLCJ1bmlxdWVfbmFtZSI6InBhYmxvLmVsaXpvbmRvQGNmc2NyLmNvbSIsInVwbiI6InBhYmxvLmVsaXpvbmRvQGNmc2NyLmNvbSIsInV0aSI6Imx4YXdrcEhJTDBXSGJHLTV4eFNaQVEiLCJ2ZXIiOiIxLjAifQ.UVWAC8-PHGaKJFfllR0YW8UNo5UrlRoo-t0MjmYzK6hgVDriN1KXpIU-5hs_q40wOvp7hbxIZ-StU3v_BwKTNZHW8PPO0iQLCEmZjyAC_9rwaRD5VZDYa5Xj14XdyQV3gN_mKEJXLuiW0a24XHsLWa4vY3iF1jw1afO-Z_xifmoYLMOc8HI2J4iz6qylnM8T6XyTeo9VWFK_hEYIGrcSLJ4F36OGJPW1oJ1An0_rmokGxRwUpD-HBc3Si6GIY9hi0gj-268x8ZX38y97RgBJM9u5YyKzPSy0bfG9OxO_edBlID2Vk1h-uIRD21j0-WF4cq7CwmgTVJawXPWp0gIRMA";
        
        
        String bodyCookie = "ReqClientId=0cf19070-4625-45d6-95c0-da1ab4e04749; orgId=24dd677f-a23c-4d40-abe1-166c541f866e";
        
        
        String fechaInicio = "2021-12-31 23:59:59.000";
        String fechaFin = "2023-01-01 00:00:01.000";
        
        crm.realizaConsulta(bodyAuthorization, bodyCookie, fechaInicio, fechaFin);
        
    }
}
