/*
 * Parameter manager class
 */
package com.jgranados.koky.interpreter.symbolstable;

/**
 *
 * @author bryan
 */
public class Parameter {
        private String nombre;
        private int valor;

        public Parameter(String nombre, int valor) {
            this.nombre = nombre;
            this.valor = valor;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getValor() {
            return valor;
        }

        public void setValor(int valor) {
            this.valor = valor;
        }
        
        
    
}
