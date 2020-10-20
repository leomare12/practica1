package ListaLigada;

import Polinomios.Termino;
import Polinomios.Nodo;

/**
 * ListaLigadaSimpleConCabeza
 */
public class ListaLigadaSimpleConCabeza {

    private final Nodo cabeza;

    /**
     * Constructor para un polinomio sin terminos
     */
    public ListaLigadaSimpleConCabeza() {
        cabeza = new Nodo(null);
        cabeza.setLiga(null);
    }

    /**
     * Obtener el nodo cabeza de la lista
     *
     * @return
     */
    public Nodo getCabeza() {
        return cabeza;
    }

    @Override
    public String toString() {
        StringBuilder polinomio = new StringBuilder();
        Nodo p = cabeza.getLiga();
        while (!finRecorrido(p)) {
            Termino ti = p.getTermino();
            double j = ti.getC();
            int i = ti.getE();
            // Para adicionar el simbolo del coeficiente para numeros positivos, excluyendo
            // el simbolo + del primer termino si es positivo.
            if (j >= 0) {
                polinomio.append("+");
            }
            polinomio.append(j).append("X^").append(i).append(" ");
            p = p.getLiga();
        }
        return polinomio.toString();
    }

    public int getGrado() throws Exception {
        Nodo primero = cabeza.getLiga();
        if (primero == null) {
            return 0;
        }
        return primero.getTermino().getE();
    }

    /**
     * Metodo para sumar dos polinomios, suma el polinomio a con el polinomio b que
     * se pasa como parametros, no se modifica el polinomio a.
     *
     * @param polB polinomio a sumar
     * @return polinomio con el resultado de la suma.
     */
    public ListaLigadaSimpleConCabeza sumar(ListaLigadaSimpleConCabeza polB) {

        ListaLigadaSimpleConCabeza polC = new ListaLigadaSimpleConCabeza();

        // Variables para los recorridos en polinomios a,b y c
        Nodo prA = this.getCabeza().getLiga();
        Nodo prB = polB.getCabeza().getLiga();
        Nodo uC = polC.getCabeza();

        // Recorrido de los terminos en alguna de las dos listas
        while (!finRecorrido(prA) && !finRecorrido(prB)) {
            // Variables de exponente y coeficiente de terminos
            int eA = prA.getTermino().getE();
            double cA = prA.getTermino().getC();
            int eB = prB.getTermino().getE();
            double cB = prB.getTermino().getC();

            if (eA > eB) { // Traslado datos del Termino de A.
                Termino t = new Termino(eA, cA);
                Nodo n = new Nodo(t);
                uC.setLiga(n);
                uC = n;
                prA = prA.getLiga(); // recorro la lista polinomio de a
            } else if (eA == eB) { // Opero terminos de a y b
                double posibleCoeficienteC = cA + cB;
                // Si el coeficiente resultado es 0 no se lleva a polinomio c.
                if (posibleCoeficienteC != 0) {
                    Termino t = new Termino(eA, posibleCoeficienteC);
                    Nodo n = new Nodo(t);
                    uC.setLiga(n);
                    uC = n;
                }
                // recorro la lista de polinomio a y b
                prA = prA.getLiga();
                prB = prB.getLiga();
            } else {
                Termino t = new Termino(eB, cB);
                Nodo n = new Nodo(t);
                uC.setLiga(n);
                uC = n;
                prB = prB.getLiga(); // recorro la lista polinomio de b
            }
        }

        // Si la lista de terminos del polinomio b finalizo primero
        while (!finRecorrido(prB)) {
            // Variables para exponente y coefiente de lista polinomio a
            int eA = prA.getTermino().getE();
            double cA = prA.getTermino().getC();
            // Creo el nuevo termino, nuevo nodo y ligo en c
            Termino t = new Termino(eA, cA);
            Nodo n = new Nodo(t);
            uC.setLiga(n);
            uC = n;
            // me sigo moviendo en lista a
            prA = prA.getLiga();
        }

        // Si la lista de terminos del polinomio a finalizo primero
        while (!finRecorrido(prA)) {
            // Variables para exponente y coefiente de lista polinomio a
            int eB = prB.getTermino().getE();
            double cB = prB.getTermino().getC();
            // Creo el nuevo termino, nuevo nodo y ligo en c
            Termino t = new Termino(eB, cB);
            Nodo n = new Nodo(t);
            uC.setLiga(n);
            uC = n;
            // me sigo moviendo en lista b
            prB = prB.getLiga();
        }

        return polC;
    }

    public int getCoeficiente(int exponente) {
        // Variables para los recorridos en polinomios a,b y c
        Nodo prA = this.getCabeza().getLiga();

        int coeficiente = 0;
        while (!finRecorrido(prA)) {
            if (prA.getTermino().getE() == exponente) {
                return prA.getTermino().getC();
            }
            prA = prA.getLiga();
        }
        return coeficiente;
    }

    public int getDiferentesCero() {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    private boolean finRecorrido(Nodo p) {
        return p == null;
    }

    public void ingresar(double coeficiente, int exponente) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

}