/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;

import FCalificacionesException.FCursosException;
import Interfaz.ICursos;
import Implementaciones.Diccionario;
import ObjetosNegocio.Cursos;
import ObjetosNegocio.Accion;
import static ObjetosNegocio.Accion.Tipo.*;

/**
 * Clase fachada de Cursos
 *
 * @author Luis Rafael
 */
public class FCursos implements ICursos {

    private Accion accion;
    private Diccionario<String, Cursos> cursos;

    /**
     * constructor que inicializa la clase con el parametro diccionario, el cual
     * se comparte entre diferentes clases.
     *
     * @param cursos
     */
    public FCursos(Diccionario<String, Cursos> cursos) {
        this.cursos = cursos;
    }

    /**
     * metodo para agregar un curso
     *
     * @param clave clave del curso
     * @param curso curso a ingresar
     */
    @Override
    public void agregarCurso(String clave, Cursos curso) throws FCursosException {

        if (clave.isBlank() || clave == null) {
            throw new FCursosException("Ingrese una clave al curso");
        }
        if (curso.getNombre().isBlank() || curso.getNombre() == null) {
            throw new FCursosException("Ingrese un nombre al curso");

        }

        if (curso == null) {
            throw new FCursosException("El curso no existe");
        }
        cursos.put(clave, curso);
        accion = new Accion(AGREGAR_CURSO, null, curso, null, null, 0);
        FDeshacer.registrarAccion(accion);
    }

    /**
     * metodo para eliminar un curso
     *
     * @param clave clave del curso
     */
    @Override
    public void eliminarCurso(String clave) throws FCursosException {
        if (clave.isBlank() || clave == null) {
            throw new FCursosException("Ingrese una clave de un curso");
        }

        Cursos cursoEliminado = cursos.get(clave);
        cursos.remove(clave);
        accion = new Accion(ELIMINAR_CURSO, null, cursoEliminado, null, null, 0);
        FDeshacer.registrarAccion(accion);
    }

    /**
     * metodo que muestra todos los cursos
     *
     * @return
     */
    @Override
    public String mostrarCursos() {
        return cursos.imprimir();
    }
}
