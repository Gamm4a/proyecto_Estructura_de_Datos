/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObjetosNegocio;

/**
 *
 * @author Luis Rafael
 */
public class Calificaciones implements Comparable<Calificaciones>{

    private double promedio;
    private Estudiantes estudiante;

    /**
     * constructor que crea una instancia calificaion donde se guarda la referencia
     * a un estudiante y su promedio.
     * @param estudiante estudiante
     * @param promedio promedio del estudiante
     */
    public Calificaciones(Estudiantes estudiante, double promedio) {
        this.promedio = promedio;
        this.estudiante = estudiante;
    }
    // getters de la clase
    public double getPromedio() {
        return promedio;
    }

    public Estudiantes getEstudiante() {
        return estudiante;
    }
    
    /**
     * compara la calificacion de un estudiante con otra, para el arbol AVL.
     * @param o calificacion a comparar
     * @return compocision
     */
    @Override
    public int compareTo(Calificaciones o) {
        int comp = Double.compare(this.promedio, o.promedio);
        if (comp == 0) {
            return this.estudiante.getMatricula().compareTo(o.estudiante.getMatricula());
        }
        return comp;
    }

    @Override
    public String toString() {
        return "Calificaciones{" + "promedio=" + promedio + ", estudiante=" + estudiante.toString() + '}';
    } 
}
