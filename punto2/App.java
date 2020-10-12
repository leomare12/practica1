package punto2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ListaLigada.ListaLigadaSimpleConCabeza;
import Matriz.MatrizDispersaListaLigadaForma1;
import Polinomios.Termino;
import Polinomios.Nodo;

public class App {
    public static void main(String[] args) throws Exception {
        char opc;
        String var = "";
        int[] formula = new int[3];
        String strFormula = "";
        Scanner teclado = new Scanner(System.in);
        List<ListaLigadaSimpleConCabeza> listaPolinomios = new ArrayList<>();
        ListaLigadaSimpleConCabeza p;
        JTextField coeficiente = new JTextField(5);
        JTextField exponente = new JTextField(5);

        do {
            opc = Menu();
            switch (opc) {

                case '1':

                    for (int i = 0; i < 3; i++) {
                        if (i == 0)
                            var = "A";
                        if (i == 1)
                            var = "B";
                        if (i == 2)
                            var = "C";

                        System.out.println("Ingrese el exponente para el término " + (i + 1) + ": (" + var + "t ^ ?)");
                        formula[i] = teclado.nextInt();

                        strFormula = strFormula + var + "t^" + formula[i] + " ";
                        if (i == 2)
                            System.out.println("La fórmula creada es " + strFormula);
                    }

                    break;

                case '2':

                    if (strFormula != "") {
                        int addTermino;
                        do {
                            JPanel nuevoTermino = new JPanel();
                            nuevoTermino.add(new JLabel("Coeficiente:"));
                            nuevoTermino.add(coeficiente);
                            nuevoTermino.add(Box.createHorizontalStrut(15));
                            nuevoTermino.add(new JLabel("Exponente: "));
                            nuevoTermino.add(exponente).disable();

                            ListaLigadaSimpleConCabeza polinomio = new ListaLigadaSimpleConCabeza();
                            Nodo cA = polinomio.getCabeza();

                            for (int i = 0; i < 3; i++) {

                                if (i == 0)
                                    var = "A";
                                if (i == 1)
                                    var = "B";
                                if (i == 2)
                                    var = "C";

                                coeficiente.setText("");
                                exponente.setText(Integer.toString(formula[i]));
                                int result = JOptionPane.showConfirmDialog(null, nuevoTermino,
                                        "Crear término para variable " + var, JOptionPane.OK_CANCEL_OPTION);

                                if (result == JOptionPane.OK_OPTION) {
                                    Nodo n = new Nodo(new Termino(formula[i], Integer.parseInt(coeficiente.getText())));
                                    cA.setLiga(n);
                                    cA = n;
                                }
                            }

                            listaPolinomios.add(polinomio);
                            addTermino = JOptionPane.showConfirmDialog(null, "Desea continuar agregando términos?",
                                    "Question", JOptionPane.YES_NO_OPTION);

                        } while (addTermino == JOptionPane.YES_OPTION);

                        // Crear Matriz
                        MatrizDispersaListaLigadaForma1 matriz = new MatrizDispersaListaLigadaForma1();
                        matriz.generarCabezas(listaPolinomios.size(), 3);

                        for (int i = 0; i < listaPolinomios.size(); i++) {
                            p = listaPolinomios.get(i);
                            for (int j = 0; j < 3; j++) {
                                matriz.insertar(i, j, p.getCoeficiente(formula[j]));
                                System.out.println(p.getCoeficiente(formula[j]) + "\t");
                            }
                        }

                        matriz.mostrar();

                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Debes crear primero la fórmula antes de ingresar polinomios");
                    }
                    break;
            }
        } while (opc != '3');
    }

    static char Menu() {
        char opcion;
        do {
            opcion = JOptionPane.showInputDialog(null, "\n" + "Seleccione alguna opción" + "\n\n"
                    + "[1] - Crear fórmula" + "\n" + "[2] - Crear Polinomios" + "\n" + "[3] - Salir" + "\n" + "\n")
                    .charAt(0);
        } while (opcion < '1' || opcion > '6');
        return opcion;
    }
}
