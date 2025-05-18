/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaz;
import ObjetosNegocio.Cursos;
/**
 *
 * @author 52644
 */
public interface ICursos {

    void agregarCurso(String clave, Cursos curso);
    
    void eliminarCurso(String clave);
    
    void mostrarCursos();
}
