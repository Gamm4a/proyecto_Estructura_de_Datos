/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

/**
 * clase de implementacion de un diccionario
 * 
 * @author Camila Zubía
 * @param <K> Tipo genérico de los elementos almacenados en la lista.
 * @param <V> Tipo genérico de los elementos almacenados en la lista.
 */
public class Diccionario<K, V> {

    /**
     * clase interna que representa una entrada en el diccionario.
     * @param <K> Tipo genérico de los elementos almacenados en la entrada.
     * @param <V> Tipo genérico de los elementos almacenados en la entrada.
     */
    public static class Entrada<K, V> {

        private final K llave;
        private V valor;

        /**
         * construye una nueva entrada con clave y valor especificados.

         * @param llave Clave de la entrada.
         * @param valor Valor asociado a la clave.
         */
        public Entrada(K llave, V valor) {
            this.llave = llave;
            this.valor = valor;
        }

        @Override
        public String toString() {
            return llave + ": " + valor;
        }
    }

    private final ListaEnlazada<Entrada<K, V>> tablaHash[];
    private int nEntradas;
    private final int tamTablaHash;

    /**
     * construye un nuevo diccionario con la tabla hash y tamaño especificados.
     *
     * @param tablaHash Arreglo de listas enlazadas usado como tabla hash.
     * @param tamTablaHash Tamaño de la tabla hash.
     */
    public Diccionario(ListaEnlazada<Entrada<K, V>>[] tablaHash, int tamTablaHash) {
        this.tablaHash = tablaHash;
        this.tamTablaHash = tamTablaHash;
    }

    /**
     * obtiene el indice que corresponde a la clave.
     * 
     * @param llave llave de la entrada
     * @return posicion
     */
    private int getIndexHashTable(K llave) {
        return Math.abs(llave.hashCode()) % tamTablaHash;
    }

    /**
     * regresa el valor que corresponde a la clave.
     * 
     * @param llave de la entrada
     * @return valor
     */
    public V get(K llave) {
        int indice = getIndexHashTable(llave);
        ListaEnlazada<Entrada<K, V>> balde = tablaHash[indice];
        if (balde == null) {
            return null;
        }
        return get(balde, llave, 0);
    }
    
    /**
     * regresa el valor que corresponde a la clave.
     * 
     * @param balde balde
     * @param llave llave
     * @param i posicion
     * @return valor
     */
    private V get(ListaEnlazada<Entrada<K, V>> balde, K llave, int i) {
        if (i >= balde.size()) {
            return null;
        }
        Entrada<K, V> entrada = balde.get(i);
        if (entrada.llave.equals(llave)) {
            return entrada.valor;
        }
        return get(balde, llave, i + 1);
    }

    /**
     * verifica que la llave este en el diccionario.
     * 
     * @param llave la llave que se busca.
     * @return cuenta
     */
    public boolean contains(K llave) {
        int indice = getIndexHashTable(llave);
        ListaEnlazada<Entrada<K, V>> balde = tablaHash[indice];
        if (balde == null) {
            return false;
        }
        return contains(balde, llave, 0);
    }

    /**
     * verifica qe la llave este en el diccionario.
     * 
     * @param balde balde
     * @param llave llave
     * @param i posicion
     * @return cuenta
     */
    private boolean contains(ListaEnlazada<Entrada<K, V>> balde, K llave, int i) {
        if (i >= balde.size()) {
            return false;
        }
        if (balde.get(i).llave.equals(llave)) {
            return true;
        }
        return contains(balde, llave, i + 1);
    }

    /**
     * vacia el diccionario.
     */
    public void clear() {
        clear(0);
        nEntradas = 0;
    }

    private void clear(int i) {
        if (i >= tablaHash.length) {
            return;
        }
        if (tablaHash[i] != null) {
            tablaHash[i].clear();
            tablaHash[i] = null;
        }
        clear(i + 1);
    }

    /**
     * devuelve una lista con todas las llaves.
     * 
     * @return llaves 
     */
    public ListaEnlazada<K> keys() {
        ListaEnlazada<K> resultado = new ListaEnlazada<>();
        keys(0, resultado);
        return resultado;
    }
    
    /**
     * devuelve una lista con todas las llaves.
     * 
     * @param i posicion
     * @param resultado resultado
     */
    private void keys(int i, ListaEnlazada<K> resultado) {
        if (i >= tablaHash.length) {
            return;
        }
        if (tablaHash[i] != null) {
            keysInBucket(tablaHash[i], 0, resultado);
        }
        keys(i + 1, resultado);
    }
    
    /**
     * busca la cubeta
     * @param balde balde
     * @param j posicion
     * @param resultado resultado
     */
    private void keysInBucket(ListaEnlazada<Entrada<K, V>> balde, int j, ListaEnlazada<K> resultado) {
        if (j >= balde.size()) {
            return;
        }
        resultado.add(balde.get(j).llave);
        keysInBucket(balde, j + 1, resultado);
    }

    /**
     * devuelve una lista con todos los valores
     * 
     * @return lista de los valores
     */
    public ListaEnlazada<V> values() {
        ListaEnlazada<V> resultado = new ListaEnlazada<>();
        values(0, resultado);
        return resultado;
    }
    
    /**
     * obtiene el valor
     * 
     * @param i posicion
     * @param resultado resultado
     */
    private void values(int i, ListaEnlazada<V> resultado) {
        if (i >= tablaHash.length) {
            return;
        }
        if (tablaHash[i] != null) {
            valuesInBucket(tablaHash[i], 0, resultado);
        }
        values(i + 1, resultado);
    }

    private void valuesInBucket(ListaEnlazada<Entrada<K, V>> balde, int j, ListaEnlazada<V> resultado) {
        if (j >= balde.size()) {
            return;
        }
        resultado.add(balde.get(j).valor);
        valuesInBucket(balde, j + 1, resultado);
    }

    /**
     * inserta una clave con un valor, pero si la clave ya existe entonces 
     * modifica el valor.
     * 
     * @param llave llave
     * @param valor valor
     * @return modificacion
     */
    public V put(K llave, V valor) {
        int indice = getIndexHashTable(llave);
        if (tablaHash[indice] == null) {
            tablaHash[indice] = new ListaEnlazada<>();
        }
        return put(tablaHash[indice], llave, valor, 0);
    }
    
    /**
     * inserta una clave con un valor, pero si la clave ya existe entonces 
     * modifica el valor.
     * 
     * @param balde balde
     * @param llave llave
     * @param valor valor
     * @param i posicion
     * @return modificacion
     */
    private V put(ListaEnlazada<Entrada<K, V>> balde, K llave, V valor, int i) {
        if (i >= balde.size()) {
            balde.add(new Entrada<>(llave, valor));
            nEntradas++;
            return null;
        }
        Entrada<K, V> entrada = balde.get(i);
        if (entrada.llave.equals(llave)) {
            V valorAnterior = entrada.valor;
            entrada.valor = valor;
            return valorAnterior;
        }
        return put(balde, llave, valor, i + 1);
    }

    /**
     * elimina una llave del diccionario.
     * 
     * @param llave llave
     * @return eliminacion
     */
    public V remove(K llave) {
        int indice = getIndexHashTable(llave);
        if (tablaHash[indice] == null) {
            return null;
        }
        return remove(tablaHash[indice], llave, 0);
    }
    
    /**
     * elimina una llave del diccionario
     * 
     * @param balde balde
     * @param llave llave
     * @param i posicion
     * @return eliminacion
     */
    private V remove(ListaEnlazada<Entrada<K, V>> balde, K llave, int i) {
        if (i >= balde.size()) {
            return null;
        }
        Entrada<K, V> entrada = balde.get(i);
        if (entrada.llave.equals(llave)) {
            V valor = entrada.valor;
            balde.remove(i);
            nEntradas--;
            return valor;
        }
        return remove(balde, llave, i + 1);
    }

    /**
     * regresa el tamaño del diccionario.
     * 
     * @return tamaño
     */
    public int size() {
        return nEntradas;
    }

    /**
     * verifica si el diccionario esta vacio.
     * 
     * @return vacio
     */
    public boolean empty() {
        return nEntradas == 0;
    }

    /**
     * imprime todo el diccionario.
     */
    public void imprimir() {
        imprimir(0);
    }
    
    /**
     * imprime todo el diccionario.
     * @param i posicion
     */
    private void imprimir(int i) {
        if (i >= tablaHash.length) {
            return;
        }
        ListaEnlazada<Entrada<K, V>> balde = tablaHash[i];
        if (balde != null) {
            imprimirBalde(balde, 0);
        }
        imprimir(i + 1);
    }
    
    /**
     * imprime el balde
     * @param balde balde
     * @param j posicion
     */
    private void imprimirBalde(ListaEnlazada<Entrada<K, V>> balde, int j) {
        if (j >= balde.size()) {
            return;
        }
        System.out.println(balde.get(j));
        imprimirBalde(balde, j + 1);
    }
}
