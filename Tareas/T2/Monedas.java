package tarea2;

import java.util.Scanner;

public class Monedas {

    static class Coin {

        String nombre;
        static int Bolsa, Max;
        Coin siguiente;
        boolean otro = false;
        Scanner entrada = new Scanner(System.in);
        //Propietarios
        Usuarios Personas = new Usuarios();
        //Transferencias

        public Coin() {
        }

        public Coin(String n, int M) {
            this.nombre = n;
            this.Max = M;
            this.Bolsa = M;

        }

        public void IngrearUsuario() {
            do {
                System.out.println("Ingrese el nombre del usuario");
                String name = entrada.next();
                System.out.println("Ingrese el monto inicial de monedas");
                System.out.println("NOTA: Si el monto es mayor a la cantidad de monedas en la bolsa el monto inicial para el usuario será la cantidad de la bolsa");
                System.out.println("La cantidad disponible en la bolsa es: " + this.Bolsa);
                int monto = entrada.nextInt();

                if (monto > Bolsa) {
                    monto = Bolsa;
                    Bolsa = 0;
                } else {
                    Bolsa = Bolsa - monto;
                }

                Personas.push(name, monto, this.Bolsa, nombre);
                System.out.println("Desea ingresar otro usuario? y/n");

                if (entrada.next().equals("y")) {
                    otro = true;
                } else {
                    otro = false;
                }
            } while (otro);
            Personas.imprimir();
            String respuesta;
            do {
                System.out.println("Desea hacer alguna trasacción? y/n");
                respuesta = entrada.next();
                if (respuesta.equals("y")) {
                    System.out.println("Que tipo de transacción desea?");
                    System.out.println("1. Transacción desde la bolsa de la moneda");
                    System.out.println("2. Transacción de un usuario a otro");
                    System.out.println("1/2");
                    String tra = entrada.next();
                    if (tra.equals("1")) {
                        //transacción desde la bolsa
                        TransBolsa();
                    } else if (tra.equals("2")) {
                        //transacción de un usuario a otro
                        this.TransUsuario();
                    }

                }
            } while (respuesta.equals("y"));

        }

        public void TransBolsa() {
            System.out.println("Ingrese la cantidad ");
            System.out.println("Recuerde que si ingresa una cantidad mayor a la cantidad en la bolsa, se utilizará esa cantidad para la transacción");
            System.out.println("La cantidad en la bolsa es de: " + this.Bolsa);
            int cantidad = entrada.nextInt();
            if (cantidad > this.Bolsa){
                cantidad = Bolsa;
                Bolsa = 0;
            } else {
                Bolsa = Bolsa -  cantidad;
            }
            System.out.println("A que usuario desea trasladar el dinero (use el codigo del usuario)");
            Personas.imprimirCod();
            int codigo = entrada.nextInt();
            Personas.buscarTansPlus(codigo, cantidad);
        }
        
        public void TransUsuario(){
            System.out.println("Que usuario trasladará dinero");
            Personas.imprimirCod();
            int codigo1 = entrada.nextInt();
            System.out.println("Que cantidad va a trasladar");
            System.out.println("Si la cantidas es mayor a lo que el usuario tiene, el monto se modificará a la cantidad máxima que ese usuario tenía");
            int monto = entrada.nextInt();
            monto = Personas.buscarTransMinus(codigo1, monto);
            System.out.println("Elija al usuario que recibirá el dinero");
            Personas.imprimirCod();
            int codigo2 = entrada.nextInt();
            Personas.buscarTansPlus(codigo2, monto);
        }
    }

    Coin fin;
    Coin cima = new Coin();
    Coin fondo = new Coin();
    Coin Aux;

    int tamaño;
    Scanner entrada = new Scanner(System.in);

    public Monedas() {
        fin = null;
        tamaño = 0;
    }

    public void push(String nom, int cant) {
        tamaño++;
        Coin nuevo = new Coin(nom, cant);
        if (fin == null) {
            fondo.nombre = nom;
            fondo.Bolsa = cant;
            fin = nuevo;
            Aux = nuevo;
        } else {
            nuevo.siguiente = fin;
            fin = nuevo;
            Aux = nuevo;
        }
    }

    public void usuario() {
        Aux.IngrearUsuario();
    }

    public void imprimir() {
        Coin auxiliar = new Coin();
        auxiliar = fin;
        while (auxiliar != null) {
            System.out.println("La moneda: " + auxiliar.nombre);
            System.out.println(" Tiene una cantidad de " + auxiliar.Bolsa + " en bolsa");
            auxiliar = auxiliar.siguiente;
        }
    }
}
