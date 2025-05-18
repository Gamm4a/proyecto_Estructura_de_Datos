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
public class FEstudiantes implements IEstudiantes {

    private ArbolBinarioBusqueda<Estudiantes> arbol;
    
    /**
     * constructor que crea un nueva fachada del estudiante
     * @param arbolCompartido arbol
     */
    public FEstudiantes(ArbolBinarioBusqueda<Estudiantes> arbolCompartido) {
        this.arbol = arbolCompartido;
    }
    
    /**
     * metodo para registrar un estudiante
     * @param estudiante estudiante
     */
    @Override
    public void registrarEstudiante(Estudiantes estudiante) {
        if (estudiante == null) {
            System.out.println("Estudiante no puede ser null.");
            return;
        }

        if (arbol.buscarPorAtributo(e -> e.getMatricula(), estudiante.getMatricula()) != null) {
            System.out.println("Ya existe un estudiante con esa matrícula.");
            return;
        }

        arbol.insertar(estudiante);
        System.out.println("Estudiante registrado correctamente.");

        Accion accion = new Accion(Accion.Tipo.REGISTRO_ESTUDIANTE, estudiante, null, null, null, 0);
        FDeshacer.registrarAccion(accion);
    }
    
    /**
     * metodo para buscar un estudiante
     * @param matricula matricula del estudiante
     * @return estudiante encontrado
     */
    @Override
    public Estudiantes buscarEstudiante(String matricula) {
        if (matricula == null || matricula.isEmpty()) {
            System.out.println("Matrícula no válida.");
            return null;
        }

        Estudiantes encontrado = arbol.buscarPorAtributo(e -> e.getMatricula(), matricula);

        if (encontrado == null) {
            System.out.println("Estudiante no encontrado.");
        }

        return encontrado;
    }
    
    /**
     * metodo que elimina un estudiante
     * @param matricula matricula del estudiante
     */
    @Override
    public void eliminarEstudiante(String matricula) {
        Estudiantes estudiante = arbol.buscarPorAtributo(e -> e.getMatricula(), matricula);

        if (estudiante == null) {
            System.out.println("No se encontró un estudiante con esa matrícula.");
            return;
        }

        arbol.eliminar(estudiante);
        System.out.println("Estudiante eliminado del sistema.");

        Accion accion = new Accion(Accion.Tipo.ELIMINAR_ESTUDIANTE, estudiante, null, null, null, 0);
        FDeshacer.registrarAccion(accion);
    }
}
