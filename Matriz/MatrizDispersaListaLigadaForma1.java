
package Matriz;

public class MatrizDispersaListaLigadaForma1 {
    private Nodo cab;

    public MatrizDispersaListaLigadaForma1() {
        cab = null;
    }

    public void generarCabezas(int f, int c) {
        cab = new Nodo(f, c, 0);
        Nodo nuevo;
        Nodo ult = cab;
        for (int i = 0; i < f; i++) {
            nuevo = new Nodo(i, i, 0);
            nuevo.setL(cab);
            ult.setL(nuevo);
            nuevo.setLc(nuevo);
            nuevo.setLf(nuevo);
            ult = nuevo;
        }
    }

    public void insertar(int f, int c, double dato) {
        Nodo p, q;
        Nodo nuevo = new Nodo(f, c, dato);

        p = cab.getL();
        while (p.getF() != f) {
            p = p.getL();
        }
        q = p;
        p = p.getLf();
        while (p.getLf() != q) {
            p = p.getLf();
        }

        p.setLf(nuevo);
        nuevo.setLf(q);

        p = cab.getL();
        while (p.getC() != c) {
            p = p.getL();
        }
        q = p;
        p = p.getLc();
        while (p.getLc() != q) {
            p = p.getLc();
        }

        nuevo.setLc(q);
        p.setLc(nuevo);
    }

    public void mostrar() {
        Nodo p, q;
        p = cab;
        System.out.println(p + ": [" + p.getF() + ", " + p.getC() + "], " + p.getDato() + " (" + p.getL() + ")");
        p = cab.getL();
        while (p != cab) {
            System.out
                    .print(p + ": [" + p.getF() + ", " + p.getC() + "], " + p.getDato() + " (" + p.getL() + ")" + "\t");
            q = p.getLf();
            while (q != p) {
                System.out.print(q + ": [" + q.getF() + ", " + q.getC() + "], " + q.getDato() + "\t");
                q = q.getLf();
            }
            p = p.getL();
            System.out.println("");
        }
    }
}
