/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;

import Implementaciones.ArbolBinarioBusqueda;
import Interfaz.IEstudiantes;
import ObjetosNegocio.Estudiantes;

/**
 *
 * @author Luis Rafael
 */
public class FEstudiantes implements IEstudiantes{
    private ArbolBinarioBusqueda<Estudiantes> arbol = new ArbolBinarioBusqueda<>();
    
    @Override
    public void registrarEstudiante(Estudiantes estudiante) {
        arbol.insertar(estudiante);
    }

    @Override
    public void eliminarEstudiante(String matricula) {
        Estudiantes estudiante = arbol.buscarPorAtributo(e -> e.getMatricula(), matricula);
        arbol.eliminar(estudiante);
    }
    
    @Override
    public Estudiantes buscarEstudiante(String matricula){
        return arbol.buscarPorAtributo(e -> e.getMatricula(), matricula);
    }
}
