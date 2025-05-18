/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;

import Interfaz.ICursos;
import Implementaciones.Diccionario;
import ObjetosNegocio.Cursos;
import ObjetosNegocio.Accion;
import static ObjetosNegocio.Accion.Tipo.*;

/**
 *
 * @author Luis Rafael
 */
public class FCursos implements ICursos{

    private Diccionario<String, Cursos> cursos;

    @Override
    public void agregarCurso(String clave, Cursos curso) {
        cursos.put(clave, curso);
        Accion accion = new Accion(AGREGAR_CURSO, null, curso, null, null, 0);
        accion.getPila().add(accion);
    }

    @Override
    public void eliminarCurso(String clave) {
        Cursos cursoEliminado = cursos.get(clave);
        cursos.remove(clave);
        Accion accion = new Accion(ELIMINAR_CURSO, null, cursoEliminado, null, null, 0);
        accion.getPila().add(accion);
    }

    @Override
    public void mostrarCursos() {
        cursos.imprimir();
    }
}
