/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaz;
import FCalificacionesException.FCursosException;
import ObjetosNegocio.Cursos;
/**
 *
 * @author 52644
 */
public interface ICursos {

    void agregarCurso(String clave, Cursos curso) throws FCursosException;
    
    void eliminarCurso(String clave) throws FCursosException;
    
    String mostrarCursos();
}
