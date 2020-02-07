#include <iostream>
#include "Lista.h"

using namespace std;


int main() {
    cout << "Holi aquí funciono" <<endl;

    lista* ejemplo = new lista();
    nodo* elim = new nodo();
    ejemplo->insertar(1, "201700857", "Daniel Alfaro");
    ejemplo->insertar(2, "123456789", "Un usuario random");
    ejemplo->insertar(3, "123456789", "otro usuario random");
    ejemplo->insertar(5, "123451984", "Te eliminare");
    ejemplo->insertar(6, "123456789", "sexto usuario random");

    ejemplo->imprimir();

//solo buscar
    cout << "Buscando a 2, random" << endl;
    ejemplo->buscar(2);
    cout<<"Buscando un no existente" << endl;
    nodo* alv = ejemplo->buscar(4);
//El que voy a eliminar
    cout << "Voy a borrar al usuario 5"<< endl;
    elim = ejemplo->buscar(5);
    ejemplo->eliminar(elim);
//Revisamos que si se haya borrado
    ejemplo->imprimir();
    
    return 0;
}