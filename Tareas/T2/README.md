## TDA. Moneda.
* **Racional:** Tipo de dato es IngresarUsuario, TransBolsa, TransUsuario, Push.
* **Descripción:** La moneda tiene un sistema de cantidad máxima para monedas y sistema de transacciones de monedas entre usuarios.
* **Operaciones:**
  * IngresarUsuari(nombre: string, monto,bolsa: entero, NomMoneda: string) devuelve (Usuario)
    *efecto: Devuelve un usuario con el monto que se le colocó, el monto siempre será menor al máximo de monedas creadas.
  * TransBolsa(monto: entero, codigo: entero) devuelve (vacío)
    * restricción: El monto debe ser menor o igual que lo existente en bolsa.
    * modifica: modifica la cantidad existente en la bolsa restandole la cantidad del monto.
    * efecto: aumenta la cantidad del usuario al que seleccionó con el codigo.
  * TransUsuario(monto: entero, codigo1: entero, codigo2: entero) devuelve (vacío)
    * restricción: el monto debe ser menor o igual al dinero que tiene el usuario "codigo1".
    * modifica: la cantidad que tenga el usuario codigo1 restandole el monto y la cantidad que tenga el usuario codigo2 aumentandole el monto.
    * efecto: aumenta la cantidad de un usuario y disminuye el de otro.
  * Push(nom: string, cant: entero) devuelve (moneda: moneda)
    * efecto: Crea una moneda con el nombre "nom" y una cantidad en bolsa que también será la máxima con el valor de "cant".
