/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObjetosNegocio;

import Implementaciones.ArregloCalificaciones;
/**
 * clase que representa a los estudiantes
 * @author Luis Rafael
 */
public class Estudiantes implements Comparable<Estudiantes> {
    private String nombre, matricula, telefono, correo;
    private Direccion direccion;
    private ArregloCalificaciones<Double> calificaciones;

    /**
     * constructor que crea un estudiante.
     * @param matricula matricula del estudiante
     * @param nombre nombre del estudiante
     * @param telefono telefono del estudiante
     * @param correo correo del estudiante
     * @param direccion direccion del estudiante
     */
    public Estudiantes(String matricula, String nombre, String telefono, String correo, Direccion direccion){
        this.matricula = matricula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.calificaciones = new ArregloCalificaciones(5);
    }

    
    /**
     * Compara el estudiante con otro por su matricula, para el arbol de busqueda.
     * @param o estudiante a comparar
     * @return 
     */
    @Override
    public int compareTo(Estudiantes o) {
        return this.matricula.compareTo(o.matricula);
    }
    
    // getters y setters de los atributos 
    public String getMatricula() {
        return matricula;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public ArregloCalificaciones<Double> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(ArregloCalificaciones<Double> calificaciones) {
        this.calificaciones = calificaciones;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "nombre=" + nombre + ", matricula=" + matricula + ", telefono=" + telefono + ", correo=" + correo + ", direccion=" + direccion + '}';
    }
}
