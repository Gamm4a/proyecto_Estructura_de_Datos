/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaz;

/**
 *
 * @author 52644
 */
public interface IInscripciones {
    
    void inscribirEstudianteEnCurso(String matricula, String clave);

    void eliminarEstudianteDeCurso(String matricula, String clave);

    String mostrarInscritos(String clave);
    
    String mostrarListaEspera(String clave, int cantidad);

    String recorrerListaEsperaAdelante(String clave);

    String recorrerListaEsperaAtras(String clave);
}
