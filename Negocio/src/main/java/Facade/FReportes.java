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
public class FReportes implements IReportes {

    private Diccionario<String, Cursos> cursos;
    private ArbolBinarioBusqueda<Estudiantes> arbolEstudiantes;
    private FCalificaciones gestorCalificaciones;
    
    /**
     * constructor para crear una fachada de reportes
     * @param cursos
     * @param arbolEstudiantes
     * @param gestorCalificaciones 
     */
    public FReportes(
            Diccionario<String, Cursos> cursos,
            ArbolBinarioBusqueda<Estudiantes> arbolEstudiantes,
            FCalificaciones gestorCalificaciones
    ) {
        this.cursos = cursos;
        this.arbolEstudiantes = arbolEstudiantes;
        this.gestorCalificaciones = gestorCalificaciones;
    }
    
    /**
     * metodo para rotar el rol
     * @param claveCurso clave del curso 
     */
    @Override
    public void rotarRol(String claveCurso) {
        Cursos curso = cursos.get(claveCurso);

        if (curso == null) {
            System.out.println("Curso no encontrado.");
            return;
        }

        if (curso.getRolEstudiantes() == null || curso.getRolEstudiantes().vacia()) {
            System.out.println("No hay estudiantes para rotar el rol.");
            return;
        }

        if (curso.getLider() == null) {
            curso.setLider(curso.getRolEstudiantes().getInicio());
        } else {
            curso.setLider(curso.getLider().getSig());
        }

        Estudiantes nuevoLider = curso.getLider().getDato();
        System.out.println("Nuevo líder: " + nuevoLider.getNombre());
    }
    
    /**
     * metodo para listar por promedio
     */
    @Override
    public void listarPorPromedio() {
        ArbolAVL<Calificaciones> arbolPromedios = new ArbolAVL<>();

        recorrerEInsertar(arbolEstudiantes.raiz, arbolPromedios);

        System.out.println("Estudiantes ordenados por promedio:");
        arbolPromedios.inOrder();
    }
    
    /**
     * metodo para recorrer el arbol para insertar un estudiante
     * @param nodo nodo de estudiantes
     * @param arbolPromedios arbol de calificaciones 
     */
    private void recorrerEInsertar(Nodo<Estudiantes> nodo, ArbolAVL<Calificaciones> arbolPromedios) {
        if (nodo == null) {
            return;
        }

        recorrerEInsertar(nodo.getIzq(), arbolPromedios);

        Estudiantes estudiante = nodo.getDato();
        double promedio = gestorCalificaciones.calcularPromedio(estudiante.getMatricula());

        Calificaciones c = new Calificaciones(estudiante, promedio);
        arbolPromedios.insertar(c);

        recorrerEInsertar(nodo.getDer(), arbolPromedios);
    }
}
