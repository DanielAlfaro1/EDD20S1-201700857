#include <iostream>
#include "ListaDoble.h"

using namespace std;

int main (){
    lista *letras = new lista();

    letras->insertarPrimero('T');
    letras->insertarPrimero('a');
    letras->insertarPrimero('r');
    letras->insertarPrimero('e');
    letras->insertarPrimero('a');
    letras->insertarPrimero('4');
    letras->insertarPrimero('E');
    letras->insertarPrimero('D');
    letras->insertarPrimero('D');

    letras->imprimir();
    cout<<"vamos a borrar"<< endl;
    letras->EliminarUltimo();
    letras->imprimir();
    //Vamos a buscar la letra r de rae
    cout << "Buscamos r de rae" << endl;
    letras->buscar("rae");
    //Vamos a buscar la letra e de estadistica
    cout << "Buscamos la e de estadistica"<< endl;
    letras->buscar("estadistica");
    //Vamos a buscar una letra no metida en la lista
    cout << "Buscamos la l de lola"<< endl;
    letras->buscar("lola");

    return 0;

}