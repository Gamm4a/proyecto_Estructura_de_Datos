/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;

import Implementaciones.ArbolAVL;
import Implementaciones.ArbolBinarioBusqueda;
import Implementaciones.ArbolBinarioBusqueda.Nodo;
import Implementaciones.Diccionario;
import Interfaz.IReportes;
import ObjetosNegocio.Calificaciones;
import ObjetosNegocio.Cursos;
import ObjetosNegocio.Estudiantes;

/**
 *
 * @author Luis Rafael
 */
public class FReportes implements IReportes{

    private Diccionario<String, Cursos> cursos;
    private ArbolAVL<Calificaciones> promediosEstudiantes;
    ArbolBinarioBusqueda<Estudiantes> arbol;
    
    @Override
    public Estudiantes rotarRol(String clave) {
        Cursos cursoMoverRol = cursos.get(clave);
        if (cursoMoverRol.getRolEstudiantes().vacia()) {
            System.out.println("no hay estudiantes para asignar rol");
        }
        cursoMoverRol.setLider(cursoMoverRol.getLider().getSig());
        return cursoMoverRol.getLider().getDato();
    }

    @Override
    public void listarPorPromedio() {
        promediosEstudiantes = new ArbolAVL<>();

        llenarAVLConPromedios(arbol.raiz);

        System.out.println("Estudiantes ordenados por promedio:");
        promediosEstudiantes.inOrder();
    }

    private void llenarAVLConPromedios(Nodo<Estudiantes> nodo) {
        if (nodo == null) {
            return;
        }

        llenarAVLConPromedios(nodo.getIzq());

        Estudiantes estudiante = nodo.getDato();

        Calificaciones cal = new Calificaciones(estudiante);
        promediosEstudiantes.insertar(cal);

        llenarAVLConPromedios(nodo.getDer());
    }
}
