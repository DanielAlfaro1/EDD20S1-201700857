#include <iostream>
#include <bits/stdc++.h>

using namespace std;

class nodo 
{
        
    public:
    int id;
    char letra;
    nodo* siguiente;
    nodo* anterior;
    nodo (){};

    nodo (int d, char l)
    {
        id = d;
        letra = l;
        siguiente;
        anterior;
    };

};

class lista
{

    
        
    nodo* inicio = new nodo();
    nodo* fin = new nodo();
    nodo* aux = new nodo();
    int size = 0;

    public:
    lista ()
    {
        fin;
        inicio;
    };

    void insertarPrimero (char letra)
    {
        
        nodo* nuevo = new nodo(size, letra);
        if (size == 0){
            inicio = nuevo;
            fin = nuevo;
            aux = nuevo;
        } else {
            nuevo->anterior = aux;
            aux->siguiente = nuevo;
            fin = nuevo;
            aux = nuevo;
        }
        size++;
    };

    void EliminarUltimo(){
        fin = fin->anterior;
        aux = fin;
        size--;
    }

    void imprimir() {
        nodo* auxa = inicio;
        int su = 0;
        int lin = 0;
        int esp = 0;
        do{
            cout << auxa->letra;
            auxa = auxa->siguiente;
            su++;
        } while (su < size);

        cout << endl;
    }

    void buscar(string n)
    {
        nodo* obs = inicio;
        bool encontrado = false;
        int su = 0;
        int largo = n.length();
        char letters[largo+1];
        strcpy(letters, n.c_str());
        while (su < size)
        {
            if (obs->letra == letters[0]){
                encontrado = true;
                cout << "se encontro ";cout<< obs->letra <<endl;
                break;
            } else {
                obs = obs->siguiente;
                su++;
            }
        }
        if (su == size){
            cout << "No se encontro nada "<< endl;
        }
        

    };
};
