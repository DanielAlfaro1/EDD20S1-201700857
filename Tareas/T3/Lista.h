#include <iostream>

using namespace std;

class nodo 
{
        
    public:
    int id;
    string carnet;
    string nombre;
    nodo* siguiente;
    nodo ()
    {

    };

    nodo (int d, string c, string n)
    {
        id = d;
        carnet = c;
        nombre = n;
        siguiente;
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

    void insertar (int d, string carnet, string name)
    {
        nodo* nuevo = new nodo(d, carnet, name);
        if (size == 0){
            inicio = nuevo;
            fin = nuevo;
            aux = nuevo;
            size++;
        } else {
            aux->siguiente = nuevo;
            fin = nuevo;
            aux = nuevo;
            size++;
        }
    };

    void eliminar(nodo* seleccionado)
    {
        nodo* aux1;
        aux1 = inicio;
        bool nolisto = true;
        if (seleccionado == NULL){
            cout << "No se puede eliminar un elemento vacío" << endl;
        } else if (seleccionado == inicio) {
            inicio = inicio->siguiente;
        } else {
            do{
                if (aux1->siguiente != NULL ){
                    if (seleccionado == aux1->siguiente){
                        aux1->siguiente = aux1->siguiente->siguiente;
                        cout << "Nodo eliminado" << endl;
                        nolisto = false;
                    } else {
                        aux1 = aux1->siguiente;
                        
                    }
                    
                } else {
                    nolisto = false; 

                }
            } while (nolisto);
        };

    };

    void imprimir() {
        nodo* auxa = inicio;
        int su = 0;
        do{
            cout << auxa->id << endl;
            auxa = auxa->siguiente;
            su++;
        } while (su < size);
    }

    nodo* buscar(int n)
    {
        nodo* obs = inicio;
        bool encontrado = false;

        while (obs != 0)
        {
            if (obs->id == n){
                encontrado = true;
                cout << "se encontro "; cout<< obs->nombre; cout<< obs->id <<endl;
                return obs;
            } else {
                obs = obs->siguiente;
            }
        }

        cout << "No se encontro nada "<< endl;
        return obs;

    };
};
