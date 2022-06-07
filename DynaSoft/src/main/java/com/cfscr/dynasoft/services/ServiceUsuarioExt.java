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
public interface ServiceUsuarioExt extends ServiceUsuario{
    @Override
    ArrayList<Usuario> obtenerTodosUsuarios();
    
    @Override
    Usuario obtenerUsuario(String nombre, String contrasenia);
    
    @Override
    void CargarUsuario(ArrayList<Usuario> usuario);
}
