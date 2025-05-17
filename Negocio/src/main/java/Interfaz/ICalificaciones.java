/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaz;

/**
 *
 * @author 52644
 */
public interface ICalificaciones {

    void agregarCalificacion(String matricula, double calificacion);

    void eliminarCalificacion(String matricula, int posicion);

    double calcularPromedio(String matricula);

    void modificarCalificacion(String matricula, double calificacion, double calNueva);
}
