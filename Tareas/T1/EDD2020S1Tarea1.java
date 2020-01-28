package edd2020s1.tarea1;

import java.util.Scanner;

public class EDD2020S1Tarea1 {

    static Scanner Entrada = new Scanner(System.in);
    static int M, indice;
    public static void main(String[] args) {
        boolean stop = false;
        boolean continuar = false;
        
        do {
            do {
                System.out.println("Coloque el tamaño de la matriz que desea.");
                M = Entrada.nextInt();
            
                if (M<=0){
                    stop = true;
                    System.out.println("Utilice números enteros de 1 a infinitum");
                } else {
                    stop = false;
                }
            } while (stop);
            String Matriz[][] = new String[M][M];
            indice = 0;
            relleno(Matriz);
            
            System.out.println("Desea hacer esto otra vez? Si/No");
            switch(Entrada.next()){
                case "Si":
                        continuar = true;
                    break;
                case "No":
                        continuar = false;
                    break;
                case "no":
                        continuar = false;
                    break;
                case "si":
                        continuar = true;
                    break;
                default:
                        continuar = false;
                    break;
            }
        } while (continuar);
        
    }
    
    public static void relleno(String[][] matriz){
        if (indice < matriz.length){
            if (indice == 0){
                int n = 0;
                while(n < matriz.length) {
                    matriz[0][n] = "1";
                    n++;
                }
                
            } else if (indice == matriz.length -1){
                int n = 0;
                while(n < matriz.length) {
                    matriz[indice][n] = "1";
                    n++;
                }
            } else {
                matriz[indice][0] = "1";
                matriz[indice][matriz.length-1]= "1";
            }
            indice++;
            relleno(matriz);
        } else {
            for (int j = 0; j < matriz.length; j++){
                for (int i = 0; i<matriz[j].length; i++) {
                    if (matriz[j][i]== null){
                        System.out.print(" ");
                    } else {
                        System.out.print(matriz[j][i]);
                    }
                }
                System.out.print("\n");
            }
        }
    }
    
}
