/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;

import Interfaz.ICursos;
import Implementaciones.Diccionario;
import ObjetosNegocio.Cursos;

/**
 *
 * @author Luis Rafael
 */
public class FCursos implements ICursos{

    private Diccionario<String, Cursos> cursos;

    @Override
    public void agregarCurso(String clave, Cursos curso) {
        cursos.put(clave, curso);
    }

    @Override
    public void eliminarCurso(String clave) {
        cursos.remove(clave);
    }

    @Override
    public void mostrarCursos() {
        cursos.imprimir();
    }
}
