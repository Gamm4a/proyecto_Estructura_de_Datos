/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObjetosNegocio;

import Implementaciones.ArregloCalificaciones;
/**
 *
 * @author Luis Rafael
 */
public class Estudiantes implements Comparable<Estudiantes> {
    
    public class Direccion {
    private String calle;
    private String numero;
    private String colonia;
    private String ciudad;

    public Direccion(String calle, String numero, String colonia, String ciudad) {
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return calle + " #" + numero + ", " + colonia + ", " + ciudad;
    }
}
    private String nombre, matricula, telefono, correo;
    private Direccion direccion;
    private ArregloCalificaciones<Double> calificaciones;
    
    public Estudiantes(String matricula, String nombre, String telefono, String correo, Direccion direccion){
        this.matricula = matricula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.calificaciones = new ArregloCalificaciones(5);
    }

    
    @Override
    public int compareTo(Estudiantes o) {
        return this.matricula.compareTo(o.matricula);
    }
    
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

    public ArregloCalificaciones<Integer> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(ArregloCalificaciones<Integer> calificaciones) {
        this.calificaciones = calificaciones;
    }
}
