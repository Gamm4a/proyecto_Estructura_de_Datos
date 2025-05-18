/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;

import Implementaciones.ArbolBinarioBusqueda;
import Interfaz.IEstudiantes;
import ObjetosNegocio.Estudiantes;
import ObjetosNegocio.Accion;
import static ObjetosNegocio.Accion.Tipo.*;

/**
 *
 * @author Luis Rafael
 */
public class FEstudiantes implements IEstudiantes{
    private ArbolBinarioBusqueda<Estudiantes> arbol = new ArbolBinarioBusqueda();
    
    @Override
    public void registrarEstudiante(Estudiantes estudiante) {
        arbol.insertar(estudiante);
        
        Accion accion = new Accion(REGISTRO_ESTUDIANTE, estudiante, null, null, null, 0);
        FDeshacer.registrarAccion(accion);
    }

    @Override
    public void eliminarEstudiante(String matricula) {
        Estudiantes estudiante = arbol.buscarPorAtributo(e -> e.getMatricula(), matricula);
        arbol.eliminar(estudiante);
        
        Accion accion = new Accion(ELIMINAR_ESTUDIANTE, estudiante, null, null, null, 0);
        FDeshacer.registrarAccion(accion);
    }
    
    @Override
    public Estudiantes buscarEstudiante(String matricula){
        return arbol.buscarPorAtributo(e -> e.getMatricula(), matricula);
    }
}
