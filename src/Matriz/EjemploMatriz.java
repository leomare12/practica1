
package Matriz;

import java.util.Random;

public class EjemploMatriz {

    public static void main(String[] args) {
        Random r = new Random();
        int matriz[][] = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j] = r.nextInt(2);
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println("");
        }

        // Aqui es donde se crea la matriz dispersa
        MatrizDispersaListaLigadaForma1 mdf1 = new MatrizDispersaListaLigadaForma1();
        mdf1.generarCabezas(matriz.length, matriz[0].length);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matriz[i][j] == 1)
                    mdf1.insertar(i, j, matriz[i][j]);
            }
        }

        mdf1.mostrar();
    }
}
