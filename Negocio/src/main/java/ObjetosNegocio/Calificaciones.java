/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObjetosNegocio;

/**
 *
 * @author Luis Rafael
 * @param <T>
 */
public class Calificaciones implements Comparable<Calificaciones>{

    private double promedio;
    private Estudiantes estudiante;

    /**
     * constructor que crea una instancia calificaion donde se guarda la referencia
     * a un estudiante y su promedio.
     * @param estudiante 
     * @param promedio 
     */
    public Calificaciones(Estudiantes estudiante, double promedio) {
        this.promedio = promedio;
        this.estudiante = estudiante;
    }
    public double getPromedio() {
        return promedio;
    }

    public Estudiantes getEstudiante() {
        return estudiante;
    }

    /**
     * compara la calificacion de un estudiante con otra, para el arbol AVL.
     * @param o
     * @return 
     */
    @Override
    public int compareTo(Calificaciones o) {
        int comp = Double.compare(this.promedio, o.promedio);
        if (comp == 0) {
            return this.estudiante.getMatricula().compareTo(o.estudiante.getMatricula());
        }
        return comp;
    }
}
