#include <iostream>
#include "Lista.h"

using namespace std;


int main() {
    cout << "Holi aquí funciono" <<endl;

    lista* ejemplo = new lista();
    nodo* elim = new nodo();
    ejemplo->insertar(1, "201700857", "Daniel Alfaro");
    ejemplo->insertar(2, "123456789", "Un usuario random");
    ejemplo->insertar(5, "123451984", "Te eliminare");

    ejemplo->imprimir();

//solo buscar
    cout << "Buscando a 2, random" << endl;
    ejemplo->buscar(2);
    cout<<"Buscando un no existente" << endl;
    nodo* alv = ejemplo->buscar(4);
//El que voy a eliminar
    cout << "Voy a borrar al usuario 2"<< endl;
    elim = ejemplo->buscar(2);
    ejemplo->eliminar(elim);
//Revisamos que si se haya borrado
    ejemplo->imprimir();
    
    return 0;
}