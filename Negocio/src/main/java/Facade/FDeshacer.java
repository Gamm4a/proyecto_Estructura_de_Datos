/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;

import Implementaciones.Pila;
import Interfaz.IDeshacer;
import ObjetosNegocio.Accion;



/**
 *
 * @author Luis Rafael
 */
public class FDeshacer implements IDeshacer{
    
    private static Pila<Accion> pila = new Pila<>();
    
    /**
     * metodo para registra una accion
     * @param accion accion
     */
    public static void registrarAccion(Accion accion) {
        pila.push(accion);
    }

    /**
     * metodo para deshacer una accion
     * @return 
     */
    @Override
    public String deshacerAccion() {
        return null;
    }
}
