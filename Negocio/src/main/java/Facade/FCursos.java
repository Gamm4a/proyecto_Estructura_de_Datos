/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;

import Interfaz.ICursos;
import Implementaciones.Diccionario;
import Interfaz.IDeshacer;
import ObjetosNegocio.Cursos;
import ObjetosNegocio.Accion;
import static ObjetosNegocio.Accion.Tipo.*;

/**
 *
 * @author Luis Rafael
 */
public class FCursos implements ICursos{
    private Accion accion;
    private Diccionario<String, Cursos> cursos;

    /**
     * constructor que inicializa la clase con el parametro diccionario, el cual
     * se comparte entre diferentes clases.
     * @param cursos 
     */
    public FCursos(Diccionario<String, Cursos> cursos) {
        this.cursos = cursos;
    }
    
    /**
     * metodo para agregar un curso
     * @param clave clave del curso
     * @param curso curso a ingresar
     */
    @Override
    public void agregarCurso(String clave, Cursos curso) {
        cursos.put(clave, curso);
        accion = new Accion(AGREGAR_CURSO, null, curso, null, null, 0);
        FDeshacer.registrarAccion(accion);
    }
    
    /**
     * metodo para eliminar un curso
     * @param clave clave del curso
     */
    @Override
    public void eliminarCurso(String clave) {
        Cursos cursoEliminado = cursos.get(clave);
        cursos.remove(clave);
        accion = new Accion(ELIMINAR_CURSO, null, cursoEliminado, null, null, 0);
        FDeshacer.registrarAccion(accion);
    }
    
    /**
     * metodo que muestra todos los cursos 
     */
    @Override
    public void mostrarCursos() {
        IDeshacer deshacer = new FDeshacer();
        FDeshacer.registrarAccion(accion);
    }
}
