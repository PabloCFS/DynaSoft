/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cfscr.dynasoft.services;

import com.cfscr.dynasoft.entities.Usuario;
import java.util.ArrayList;

/**
 *
 * @author pablo.elizondo
 */
public interface ServiceUsuario {
    
    ArrayList<Usuario> obtenerTodosUsuarios();
    
    Usuario obtenerUsuario(String nombre, String clave);
    
    void CargarUsuario(ArrayList<Usuario> usuarios);

}
