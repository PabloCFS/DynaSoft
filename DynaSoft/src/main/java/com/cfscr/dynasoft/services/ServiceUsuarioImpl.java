/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cfscr.dynasoft.services;

import com.cfscr.dynasoft.connection.DAOusuario;
import com.cfscr.dynasoft.entities.Usuario;

import java.util.ArrayList;

/**
 *
 * @author pablo.elizondo
 */
public class ServiceUsuarioImpl implements ServiceUsuarioExt {
    private final DAOusuario daoUsuario = new DAOusuario();
    
    @Override
    public ArrayList<Usuario> obtenerTodosUsuarios() {
        return  daoUsuario.ListarUsuarios();
    }
    
    @Override
    public Usuario obtenerUsuario(String nombre, String contrasenia){
        Usuario nuevoUsuario = daoUsuario.obtenerUsuario(nombre);
       
        return nuevoUsuario;
    }
    
    @Override
    public void CargarUsuario(ArrayList<Usuario> usuarios) {
        //excel.cargarExcel(usuarios);
    }   
}
