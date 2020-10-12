package Polinomios;

/**
 * Termino
 */
public class Termino {

    private int e;
    private double c;

    public Termino(int e, double c) {
        this.e = e;
        this.c = c;
    }

    /**
     * Obtener el exponente
     *
     * @return
     */
    public int getE() {
        return e;
    }

    /**
     * Fijar el exponente
     *
     * @param e
     */
    public void setE(int e) {
        this.e = e;
    }

    /**
     * Obtener el Coeficiente del termino
     *
     * @return
     */
    public double getC() {
        return c;
    }

    /**
     * Fijar el coeficiente
     *
     * @param c
     */
    public void setC(double c) {
        this.c = c;
    }
}