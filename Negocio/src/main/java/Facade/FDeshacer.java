/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;

import Interfaz.IDeshacer;



/**
 *
 * @author Luis Rafael
 */
public class FDeshacer implements IDeshacer{
    
    private static Pila<Accion> pila = new Pila<>();
    
    public static void registrarAccion(Accion accion) {
        pila.push(accion);
    }

    @Override
    public void deshacerUltimaAccion() {
        
    }
}
