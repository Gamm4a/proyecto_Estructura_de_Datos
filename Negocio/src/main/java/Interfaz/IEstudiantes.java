/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaz;

import ObjetosNegocio.Estudiantes;

/**
 *
 * @author 52644
 */
public interface IEstudiantes {

    public abstract void agregarCalificacion(double calificacion);
    
    public double calcularPromedio();
    
    
    public boolean modificarCalificacion(double calificacion, double calNueva);
    

    public void registrarEstudiante(Estudiantes estudiante);
}
