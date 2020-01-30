package tarea2;

import java.util.Scanner;

public class Usuarios {
    
    public Scanner entrada = new Scanner(System.in);
    
    public class Persona{
        String nombre;
        int Monedas;
        int id;
        String Moneda;
        Persona siguiente;
        
        public Persona(){}
        
        public Persona(String n, int c, int d, String m){
            this.nombre = n;
            this.Monedas = c;
            this.id = d;
            this.Moneda = m;
            siguiente = null;
        }
        
        public void TransaccionPlus(int monto){
            this.Monedas = this.Monedas + monto;
        }
        
        public void TransaccionMinus(int monto){
            if (this.Monedas < monto){
                monto = this.Monedas;
                this.Monedas = 0;
            } else {
                this.Monedas = this.Monedas - monto;
            }
        }
        
    }
    
    Persona fin;
    Persona cima = new Persona();
    Persona fondo = new Persona();
    Persona Aux;
    int Tamaño;
    
    public Usuarios (){
        fin = null;
        Tamaño = 0;
    }
    
    public void push (String nombre, int monto, int tot, String Moneda){
        
        Persona nuevo = new Persona(nombre, monto, Tamaño, Moneda);
        
        if (fin == null) {
            fondo.nombre = nombre;
            fondo.Monedas = monto;
            fondo.id = Tamaño;
            fondo.Moneda = Moneda;
            fin = nuevo;
            Aux = nuevo;
        } else {
            nuevo.siguiente = fin;
            fin = nuevo;
            Aux = nuevo;
        }
        Tamaño++;
    }
    
    
    public void imprimir(){
        Persona auxiliar = new Persona();
        auxiliar = fin;
        while(auxiliar != null){
            System.out.println("El usuario: " + auxiliar.nombre);
            System.out.println("Tiene un total de " + auxiliar.Monedas + "de " + auxiliar.Moneda);
            auxiliar = auxiliar.siguiente;
        }
    }
    
    public void imprimirCod(){
        Persona auxi;
        auxi = fin;
        while(auxi !=null){
            System.out.println("Codigo: " + auxi.id + " Nombre: " + auxi.nombre + " Monedas: " + auxi.Monedas);
            auxi = auxi.siguiente;
        }
    }
    
    public void buscarTansPlus(int m, int monto){
        Persona aux;
        aux = fin;
        while(aux != null && aux.id != m){
            System.out.println(aux.id);
            aux = aux.siguiente;
        }
        if (aux != null){
            aux.TransaccionPlus(monto);
            System.out.println("El monto actual de " + aux.nombre + " es: " + aux.Monedas);
        } else {
            System.out.println("No se encontró un usuario con ese codigo");
        }
    }
    
    public int buscarTransMinus(int m, int monto){
        Persona aux;
        aux = fin;
        while(aux != null && aux.id != m){
            aux = aux.siguiente;
        }
        if (aux != null){
            
            if (aux.Monedas < monto){
                monto = aux.Monedas;
                aux.Monedas = 0;
                
            } else {
              aux.TransaccionMinus(monto);
            }
            System.out.println("El monto actual de " + aux.nombre + " es: " + aux.Monedas);
        } else {
            System.out.println("No se encontró un usuario con ese codigo");
        }
        return monto;
    }
}
