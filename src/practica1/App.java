package practica1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Polinomios.PolinomioVectorForma1;

public class App {
    public static void main(String[] args) throws Exception {
        char opcion = 0;

        String strPolinomio = "";
        String arrPolinomio[];
        String strTermino;
        String arrTermino[];
        int coeficiente;
        int exponente;

        Scanner teclado = new Scanner(System.in);

        List<PolinomioVectorForma1> listaPolinomios = new ArrayList<>();

        do {
            // Menu para la manipulacion de polinomios
            opcion = menu();

            switch (opcion) {
                case '1':
                    do {
                        System.out.println("Ingrese el polinomio número " + (listaPolinomios.size() + 1)
                                + "  \n El polinomio debe ser creado de la siguiente manera: Ex: 6x^3 -2x^2 +5");
                        strPolinomio = teclado.nextLine();

                        PolinomioVectorForma1 polinomio = new PolinomioVectorForma1();

                        arrPolinomio = strPolinomio.split(" ");

                        for (int i = 0; i < arrPolinomio.length; i++) {
                            strTermino = arrPolinomio[i];
                            arrTermino = strTermino.split("\\^");
                            String var = arrTermino[0].substring(arrTermino[0].length() - 1);

                            if (arrTermino.length <= 1) {
                                exponente = 1;
                            } else {
                                exponente = Integer.parseInt(arrTermino[1]);
                            }

                            switch (var) {
                                case "x":
                                    coeficiente = Integer.parseInt(arrTermino[0].split("x")[0]);
                                    break;
                                // case "y":
                                // coeficiente = Integer.parseInt(arrTermino[0].split("y")[0]);
                                // break;
                                default:
                                    coeficiente = Integer.parseInt(strTermino);
                                    exponente = 0;
                                    break;
                            }

                            // System.out.println(polinomio.getCoeficiente(exponente));
                            polinomio = polinomio.sumar(coeficiente, exponente);
                        }

                        System.out.println(polinomio);
                        listaPolinomios.add(polinomio);

                    } while (listaPolinomios.size() < 2);
                    break;
                case '2':
                    for (int i = 0; i < listaPolinomios.size(); i++) {
                        System.out.println((i + 1) + ". " + listaPolinomios.get(i));
                    }
                    break;
                case '3':
                    System.out.println("Elija el primer polinomio que multiplicará");
                    int pol1 = teclado.nextInt();
                    System.out.println(listaPolinomios.get(pol1 - 1));

                    System.out.println("Elija el segundo polinomio que multiplicará");
                    int pol2 = teclado.nextInt();
                    System.out.println(listaPolinomios.get(pol2 - 1));

                    // Resultado de la multiplicacion en un nuevo polinomio
                    int gradoPolinomioProducto = listaPolinomios.get(pol1 - 1).getGrado()
                            + listaPolinomios.get(pol2 - 1).getGrado();
                    PolinomioVectorForma1 producto = new PolinomioVectorForma1(gradoPolinomioProducto);
                    producto = listaPolinomios.get(pol1 - 1).Multiplicar(listaPolinomios.get(pol2 - 1));
                    System.out.println("El resultado de la multiplicación es: " + producto);
                    break;
                case '4':
                    System.out.println("Elija el polinomio a dividir");
                    int primerPolinomio = teclado.nextInt();

                    PolinomioVectorForma1 polAD = listaPolinomios.get(primerPolinomio - 1);

                    System.out.println("Elija el polinomio divisor");
                    int segundoPolinomio = teclado.nextInt();

                    PolinomioVectorForma1 polimonioResultado = listaPolinomios.get(segundoPolinomio - 1);

                    System.out.println(polAD);
                    System.out.println(polimonioResultado);
                    // Garantizar que se pueda realizar la division
                    if (polAD.getGrado() < polimonioResultado.getGrado()) {
                        System.out.println(
                                "El polinomio a dividir debe ser de igual o mayor grado que le polinomio divisor");
                    } else {

                        PolinomioVectorForma1 polCD;

                        polCD = new PolinomioVectorForma1();
                        polCD = polAD.Dividir(polimonioResultado);

                        System.out.println("El resultado de la division es: " + polCD);
                    }
                    break;
                case '5':
                    System.out.println("Elija el polinomio que derivará");
                    int polinomioDerivar = teclado.nextInt();
                    // Garantizar que existe el polinomio
                    if (polinomioDerivar <= 0 || polinomioDerivar > (listaPolinomios.size() + 1)) {
                        System.out.println("El polinomio no existe");
                    } else {
                        System.out.println(
                                "El resultado al derivar es: " + listaPolinomios.get(polinomioDerivar - 1).Derivar());
                    }
                    break;
                case '6':
                    System.out.println("Elija el polinomio que evaluará");
                    int polinomioEvaluar = teclado.nextInt();

                    // Garantizar que existe el polinomio
                    if (polinomioEvaluar <= 0 || polinomioEvaluar > (listaPolinomios.size() + 1)) {
                        System.out.println("El polinomio no existe");
                    } else {
                        System.out.println("Ingrese el valor a evaluar");
                        int valor = teclado.nextInt();

                        System.out.println(
                                "El resultado es: " + listaPolinomios.get(polinomioEvaluar - 1).Evaluar(valor));
                    }
                    break;
            }
        } while (opcion != '7');

    }

    public static char menu() {
        char opc;

        do {
            System.out.println("\nMenu");
            System.out.println("1. Ingresar polinomios");
            System.out.println("2. Mostrar polinomios");
            System.out.println("3. Multiplicar polinomios");
            System.out.println("4. Dividir polinomios");
            System.out.println("5. Derivar polinomios");
            System.out.println("6. Evaluar polinolinomio");
            System.out.println("7. Salir");

            Scanner teclado = new Scanner(System.in);
            opc = teclado.next().charAt(0);

        } while (opc < '1' || opc > '7');
        return opc;
    }
}
