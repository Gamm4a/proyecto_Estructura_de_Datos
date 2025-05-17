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

    void mostrarInscritos(String clave);
    
    void mostrarListaEspera(String clave, int cantidad);

    void recorrerListaEsperaAdelante(String clave);

    void recorrerListaEsperaAtras(String clave);
}
