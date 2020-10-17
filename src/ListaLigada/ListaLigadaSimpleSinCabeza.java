package ListaLigada;

import Polinomios.Termino;
import Polinomios.Nodo;

/**
 * ListaLigadaSimpleSinCabeza
 */
public class ListaLigadaSimpleSinCabeza {

    private Nodo primero;
    int size = 0;

    public ListaLigadaSimpleSinCabeza() {
    }

    public ListaLigadaSimpleSinCabeza(Nodo primero) {
        this.primero = primero;
    }

    public Nodo getPrimero() {
        return primero;
    }

    public void addNodo(Nodo nuevo) {
        nuevo.setLiga(primero);
        primero = nuevo;
        size++;
    }

    public void addDato(Termino dato) {
        Nodo nuevo = new Nodo(dato);
        this.addNodo(nuevo);
    }

    public boolean isFinal(Nodo r) {
        return (r == null);
    }

    public int size() {
        return size;
    }
}