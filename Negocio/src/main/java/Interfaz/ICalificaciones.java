/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaz;

import FCalificacionesException.FCalificacionesException;
import ObjetosNegocio.Accion;

/**
 *
 * @author 52644
 */
public interface ICalificaciones {

    void agregarCalificacion(Accion accion) ;

    void eliminarCalificacion(String matricula, int posicion) throws FCalificacionesException;

    double calcularPromedio(String matricula);

    boolean modificarCalificacion(Accion accion);
    
    void enviarSolicitudAgregarCalificaion(String matricula, double calificacion) throws FCalificacionesException;
    
    void enviarSolicitudModificarCalificaion(String matricula, double calificacion, double calNueva) throws FCalificacionesException;
    
    void procesarSolicitud() throws FCalificacionesException;
}
