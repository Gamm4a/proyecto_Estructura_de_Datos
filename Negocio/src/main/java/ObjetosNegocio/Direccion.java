/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObjetosNegocio;

/**
 *
 * @author Luis Rafael
 */
public class Direccion {
    private String calle;
        private String numero;
        private String colonia;
        private String ciudad;

        /**
         * constructor que crea la direccion.
         * @param calle calle del estudiante
         * @param numero numero de la casa del estudiante
         * @param colonia colonia del estudiante
         * @param ciudad ciudad del estudiante
         */
        public Direccion(String calle, String numero, String colonia, String ciudad) {
            this.calle = calle;
            this.numero = numero;
            this.colonia = colonia;
            this.ciudad = ciudad;
        }
        
        /**
         * metodo para imprimir
         * @return cadena de valores de direccion
         */
        @Override
        public String toString() {
            return calle + " #" + numero + ", " + colonia + ", " + ciudad;
        }
}
