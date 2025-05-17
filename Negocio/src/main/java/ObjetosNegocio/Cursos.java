/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObjetosNegocio;

import Implementaciones.ListaDobleCircular;
import Implementaciones.ListaEstudiantes;

/**
 *
 * @author Luis Rafael
 */
public class Cursos {
    private String nombre;
    private ListaEstudiantes<Estudiantes> inscritos;
    private ListaDobleCircular<Estudiantes> listaEspera;

    public Cursos(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
}
