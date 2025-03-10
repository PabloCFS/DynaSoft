/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cfscr.dynasoft.connection;

import com.cfscr.dynasoft.entities.Usuario;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author pablo.elizondo
 */

/**
 * Capa de consulta de usuarios
 **/
public class DAOusuario extends ConexionERP{
    private ResultSet rs;
    //private final Connection cn = ConexionERP.getConnection();
    
    /** INSERTAR USUARIOS**/
    public void insertarUsuario(Usuario pUsuario){
        String SQL_INSERTAR = "SP_INSERTAR_USUARIO ?,?";
        
        try{
            Connection cn = ConexionERP.getConnection();
            CallableStatement csta=cn.prepareCall(SQL_INSERTAR);
            
            csta.setString(1,pUsuario.getNombre());
            csta.setString(2,pUsuario.getClave());
            
            rs=csta.executeQuery();
        } catch (SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    /**ELIMINAR USUARIO**/
    public boolean eliminar(String pNombre){
        String SQL_ELIMINAR = "SP_ELIMINAR_USUARIO ?";
        try{
            Connection cn = ConexionERP.getConnection();
            CallableStatement csta = cn.prepareCall(SQL_ELIMINAR);
            csta.setString(1,pNombre);
            int n = csta.executeUpdate();
            
            if(n >= 0){
                return true;
            }
            
        } catch(SQLException ex){
            return false;
        }
        return false;
    }
    
    /**LISTAR USUARIOS**/
    public ArrayList<Usuario> ListarUsuarios(){
        ArrayList<Usuario> usuario = new ArrayList<>();
        String SQL_LISTAR;
        CallableStatement csta;
                
        try{
            Connection cn = ConexionERP.getConnection();
             SQL_LISTAR = "LISTAR_USUARIOS";
            
            csta = cn.prepareCall(SQL_LISTAR);
            rs = csta.executeQuery();
            
            while(rs.next()){
                Usuario us = new Usuario(rs.getString("nombre"),rs.getString("clave"));
            
                usuario.add(us);
            }
            return usuario;
            
        } catch(SQLException ex){
            System.out.println(ex.toString());
            return null;
        }
    }
    
    /**OBTENER UN USUARIO**/
    public Usuario obtenerUsuario(String pNombre){
        Usuario user = new Usuario();
        
        try{
            Connection cn = ConexionERP.getConnection();
            String SQL_CONSULTAR_USUARIO = "SP_CONSULTAR_UN_USUARIO ?";
            
            CallableStatement csta = cn.prepareCall(SQL_CONSULTAR_USUARIO);
            csta.setString(1, pNombre);
            rs = csta.executeQuery();
            
            if(rs.next()){
                user = new Usuario(rs.getString("nombre"), rs.getString("clave"));
            }
            
            return user;
        } catch(SQLException ex){
            System.out.println(ex);
            return user;
        }
    }
    
    /**MODIFICAR UN USUARIO**/
    public boolean actualizarUsuario(Usuario user){
        try{
            Connection cn = ConexionERP.getConnection();
            String SQL_MODIFICAR_USUARIO = "SP_ACTUALIZAR_USUARIO ?,?";
            
            CallableStatement cst = cn.prepareCall(SQL_MODIFICAR_USUARIO);
            cst.setString(1, user.getNombre());
            cst.setString(2, user.getClave());
            
            cst.executeQuery();
            
            return true;
        } catch(SQLException ex){
            System.out.println(ex);
            return false;
        }
    }
}
