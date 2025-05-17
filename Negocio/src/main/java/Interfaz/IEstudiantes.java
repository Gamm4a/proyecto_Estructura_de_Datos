/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaz;

import ObjetosNegocio.Estudiantes;

/**
 *
 * @author 52644
 */
public interface IEstudiantes {

    void registrarEstudiante(Estudiantes estudiante);

    Estudiantes buscarEstudiante(String matricula);
}
