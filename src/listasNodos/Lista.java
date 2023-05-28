package listasNodos;

public class Lista {
	private Nodo primero;

	// METODOS DE CLASE

	public void mostrar() {
		Nodo iterador = this.primero;

		while (iterador != null) {
			System.out.print(iterador.elemento + " ");
			iterador = iterador.siguiente;
		}
		System.out.println();
	}

	public void agregarAdelante(int elementoNuevo) {
		// SE CREA UN NUEVO NODO, EL QUE VA A SER AGREGADO
		// A LA LISTA

		Nodo nuevoNodo = new Nodo();
		nuevoNodo.elemento = elementoNuevo;
		nuevoNodo.siguiente = this.primero;
		this.primero = nuevoNodo;
	}

	public void agregarAtras(int elemento) {
		Nodo nuevoNodo = new Nodo();
		nuevoNodo.elemento = elemento;

		Nodo iterador = this.primero;

		while (iterador.siguiente != null) {
			iterador = iterador.siguiente;
		}

		iterador.siguiente = nuevoNodo;
	}

	public void descomponerPares() {
		Nodo actual = this.primero;

		while (actual != null) {
			if (actual.elemento % 2 == 0) {
				Nodo nuevo = new Nodo();
				nuevo.elemento = actual.elemento * 2;
				actual.elemento = actual.elemento / 2;

				// AGREGO EL NUEVO A LA LISTA DE NODOS
				nuevo.siguiente = actual.siguiente;
				actual.siguiente = nuevo;

				// MUEVO EL ACTUAL AL NUEVO NODO, SI NO EL CICLO NUNCA TERMINA
				actual = actual.siguiente;
			}
			actual = actual.siguiente;
		}
	}

	public void filtrarElementosEnRango(int k, int m) {
		Nodo iterador = this.primero;

		while (iterador != null && iterador.siguiente != null) {
			if (iterador.siguiente.elemento < k || iterador.siguiente.elemento > m) {
				iterador.siguiente = iterador.siguiente.siguiente;
			} else {
				// Solo avanzamos si no borro
				iterador = iterador.siguiente;
			}
		}
		// Elimino el primero despues de recorrer los nodos
		if (this.primero.elemento < k || this.primero.elemento > m) {
			this.primero = this.primero.siguiente;
		}
	}

	public void acomodarPorSigno() {
		Nodo actual = this.primero;

		while (actual != null && actual.siguiente != null) {
			if (actual.siguiente.elemento < 0) {
				agregarAdelante(actual.siguiente.elemento);
				actual.siguiente = actual.siguiente.siguiente;
			} else {
				// Avanzo de nodo
				actual = actual.siguiente;
			}
		}
	}

	public void intercalarConCeros() {
		Nodo actual = primero;

		while (actual != null && actual.siguiente != null) {
			if (actual.siguiente.elemento != 0 && actual.elemento != 0) {
				Nodo nodoCero = new Nodo();
				nodoCero.elemento = 0;

				nodoCero.siguiente = actual.siguiente;
				actual.siguiente = nodoCero;
				actual = actual.siguiente.siguiente;
			} else {
				actual = actual.siguiente;
			}
		}
	}

	// EJERCICO 2 - A
	public void rotarDerecha() {
		Nodo actual = primero;

		while (actual.siguiente.siguiente != null) {
			actual = actual.siguiente;
		}
		actual.siguiente.siguiente = primero;
		primero = actual.siguiente;
		actual.siguiente = null;
	}

	// EJERCICIO 2 - B
	public void agregarEnPosicion(int pos, int elem) {
		if (pos == 0) {
			agregarAdelante(elem);
		}

		int index = 0;
		Nodo actual = primero;

		while (index != pos - 1) {
			actual = actual.siguiente;
			index++;
		}
		Nodo nuevo = new Nodo();
		nuevo.elemento = elem;

		nuevo.siguiente = actual.siguiente;
		actual.siguiente = nuevo;
	}

	// EJERCICO 2 - C
	public void insertarOrdenado(int e) {
		Nodo actual = primero;
		Nodo nuevo = new Nodo();
		nuevo.elemento = e;

		// VERIFICO SI ES MAS CHICO QUE EL PRIMERO
		if (primero.elemento >= e) {
			nuevo.siguiente = primero;
			primero = nuevo;
			return;
		}

		while (actual != null && actual.siguiente != null) {
			if (actual.siguiente.elemento <= e) {
				actual = actual.siguiente;
			} else {
				nuevo.siguiente = actual.siguiente;
				actual.siguiente = nuevo;
				return;
			}
		}
	}

	// EJERCICOS DE PARCIAL - INCOMPLETO
	public Lista extraerPares() {
		Lista listaPares = new Lista();
		Nodo actual = primero;

		while (actual.siguiente != null) {
			System.out.println(actual.siguiente.elemento);
			if (actual.siguiente.elemento % 2 == 0) {

				if (listaPares.primero == null) {
					System.out.println(actual.siguiente.elemento);
					listaPares.primero = actual.siguiente;
				} else {
					actual.siguiente.siguiente = listaPares.primero.siguiente;
					listaPares.primero = actual.siguiente;
				}

				actual.siguiente = actual.siguiente.siguiente;
			} else {
				actual = actual.siguiente;
			}
		}
		return listaPares;
	}

	// EJERCICIO 2 - D
	public static void intercambiarColas(Lista lista1, int pos1, Lista lista2, int pos2) {
		Nodo actualL1 = lista1.primero;

		for (int i = 0; i < pos1 - 1; i++) {
			actualL1 = actualL1.siguiente;
		}

		// GUARDO EL NODO EN UNA VARIABLE
		Nodo colaLista1 = actualL1.siguiente;

		// DESCVINCULAR EL NODO
		actualL1.siguiente = null;

		// -----------------LISTA 2 ----------------------------

		Nodo actualL2 = lista2.primero;

		for (int i = 0; i < pos2 - 1; i++) {
			System.out.println("hola");
			actualL2 = actualL2.siguiente;
		}

		Nodo colaLista2 = actualL2.siguiente;

		actualL2.siguiente = null;

		// ------------------ LINKEO DE COLAS -----------------
		actualL1.siguiente = colaLista2;
		actualL2.siguiente = colaLista1;
	}
	
	public void filtrarElementosEnRangoo(int k, int m) {
		Nodo actual = primero;
		
		while(actual.siguiente != null) {
			if(actual.siguiente.elemento > k && actual.siguiente.elemento < m) {
				actual.siguiente = actual.siguiente.siguiente;
			}
			else {
				actual = actual.siguiente;
			}
		}
		
		if(primero.elemento > k && primero.elemento < m) {
			primero = primero.siguiente;
		}
	}
	
	public  void escalerasHastaCero() {
		Nodo actual = primero;
		
		while(actual.elemento >= 0 && actual.siguiente != null) {
			if(actual.siguiente.elemento == actual.elemento -1) {
				actual = actual.siguiente;
				
			}else if(actual.elemento != 0){
				Nodo nuevo = new Nodo();
				nuevo.elemento = actual.elemento - 1 ;
				nuevo.siguiente = actual.siguiente;
				
				actual.siguiente = nuevo; 
			}else {
				actual = actual.siguiente;
			}
		}
	}
}