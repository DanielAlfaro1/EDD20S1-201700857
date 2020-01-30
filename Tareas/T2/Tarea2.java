package tarea2;

import java.util.Scanner;

public class Tarea2 {

    public static void main(String[] args) {
        Monedas Fichas = new Monedas();
        
        Scanner Ingreso = new Scanner(System.in);
        
        
                    System.out.println("Ingrese el nombre para la moneda");
                    String nom = Ingreso.next();
                    System.out.println("Ingrese cantidad máxima para las monedas");
                    boolean pasa = false;
                    int can = 0;
                    do {
                        try{
                            can = Ingreso.nextInt();
                            pasa = false;
                        }catch(Exception e){
                            pasa = true;
                            System.out.println("Solo puede colocar numeros enteros");
                        }    
                    }while(pasa);
                    
            
                    Fichas.push(nom, can);
                    Fichas.imprimir();
                    System.out.println("Desea agregar usuarios? y/n");
                    if (Ingreso.next().equals("y")){
                        Fichas.usuario();
                    }
                    
    }
    
}
