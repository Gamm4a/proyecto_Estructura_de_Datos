/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObjetosNegocio;

import Implementaciones.ListaDobleCircular;
import Implementaciones.ListaEstudiantes;
import Implementaciones.ListaEnlazadaCircular;
import Implementaciones.ListaEnlazadaCircular.Nodo;

/**
 *
 * @author Luis Rafael
 */
public class Cursos {
    private String nombre, clave;
    private ListaEstudiantes<Estudiantes> inscritos;
    private ListaDobleCircular<Estudiantes> listaEspera;
    private ListaEnlazadaCircular<Estudiantes> rolEstudiantes;
    private Nodo<Estudiantes> lider;
    
    public static final int MAX_INSCRITOS = 30;

    /**
     * constructor que crea un nuevo curso e inicializa las listas.
     * @param clave
     * @param nombre 
     */
    public Cursos(String clave, String nombre) {
        this.clave = clave;
        this.nombre = nombre;
        this.rolEstudiantes = new ListaEnlazadaCircular();
        this.inscritos = new ListaEstudiantes();
        this.listaEspera = new ListaDobleCircular();
        this.lider = rolEstudiantes.getInicio();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public ListaEstudiantes<Estudiantes> getInscritos() {
        return inscritos;
    }

    public void setInscritos(ListaEstudiantes<Estudiantes> inscritos) {
        this.inscritos = inscritos;
    }

    public ListaDobleCircular<Estudiantes> getListaEspera() {
        return listaEspera;
    }

    public void setListaEspera(ListaDobleCircular<Estudiantes> listaEspera) {
        this.listaEspera = listaEspera;
    }

    public ListaEnlazadaCircular<Estudiantes> getRolEstudiantes() {
        return rolEstudiantes;
    }

    public void setRolEstudiantes(ListaEnlazadaCircular<Estudiantes> estudiantesConRol) {
        this.rolEstudiantes = estudiantesConRol;
    }

    public Nodo<Estudiantes> getLider() {
        return lider;
    }

    public void setLider(Nodo<Estudiantes> lider) {
        this.lider = lider;
    }

    public static int getMAX_INSCRITOS() {
        return MAX_INSCRITOS;
    }
}
