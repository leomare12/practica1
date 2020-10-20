package Matriz;
/**
 * @file
 *  Matriz.
 *
 * Implementación con lista ligada simple, a través de la clase anidada nodoMatrix.
 * Se utiliza una clase anidada para mejorar la encapsulación.
 */

public class matrizListaLigada {

	/**
	 * Propiedades de  Matriz.
	 */
	private int filas = 0;

	private int columnas = 0;

	private int numElementos = 0;

	private nodoMatrix inicio = null;

	/**
	 * Elemento de Matriz .
	 */
	class nodoMatrix {

		public int valor;

		public int x;

		public int y;

		public nodoMatrix sig = null;

		nodoMatrix(int valor, int x, int y) {

			this.valor = valor;
			this.x = x;
			this.y = y;
		}
	}

	/**
	 * Constructor.
	 */

	public matrizListaLigada(int l, int c) {

		this.filas = l;
		this.columnas = c;
	}

	/**
	 * Método de búsqueda.
		*
		* Buscar si hay un elemento con coordenadas "x" e "y" en la Matriz .
		*/
	public nodoMatrix search(int x, int y) {

		if (this.is_empty()) return null;

		nodoMatrix p = this.inicio;

		while(p != null) {

			if ((p.x == x) && (p.y == y)) return p;

			if (p.x > x) return null;

			if ((p.x == x) && (p.y > y)) return null;

			p = p.sig;
		}

		return null;
	}

	/**
	 * Buscar método anterior. 
	 * 
	 * Buscar elemento anterior con coordenadas "x" e "y" en la Matriz .
	 *
	 */
	public nodoMatrix search_anterior(int x, int y) {

		if (this.is_empty()) return null;

		nodoMatrix p = this.inicio;

		while(p.sig != null) {

			if ((p.sig.x == x) && (p.sig.y == y)) return p;

			if (p.sig.x > x) return p;

			if ((p.sig.x == x) && (p.sig.y > y)) return p;

			p = p.sig;
		}

		return p;
	}

	/**
	 * Método Add.
	 *
	 *Agregar un elemento en Matriz . Siempre inserta un valor en la matriz,
	 * reemplazar un valor existente o crear un nuevo elemento dentro de la matriz.
	 */

	public void add(int valor, int x, int y) {

		if ((x < 0) || (y < 0)) return;

		if ((x >= this.filas) || (y >= this.columnas)) return; 

		nodoMatrix anterior = this.search_anterior(x, y);

		nodoMatrix element = this.search(x, y);

		// Matriz  vacia.
		if ((anterior == null) && (element == null)) {

			this.numElementos++;
			
			nodoMatrix node = new nodoMatrix(valor, x, y);

			this.inicio = node;
		}
		// primer elemento.
		else if((anterior == null) && (element != null)) {

			element.valor = valor;
		}
		else if((anterior != null) && (element == null)) {

			// siguiente elemento.
			if (anterior.sig == null) {

				this.numElementos++;
				
				nodoMatrix node = new nodoMatrix(valor, x, y);

				anterior.sig = node;
			}
			// Elemento intermedio.
			else {

				this.numElementos++;
				
				nodoMatrix node = new nodoMatrix(valor, x, y);

				node.sig = anterior.sig;
				anterior.sig = node;
			}	
		}
		// Elemento al final.

		else if((anterior != null) && (element != null)) {

			element.valor = valor;
		}
	}

	/**
	 * método remover.
	 *
	 * remueve un elementpo en la Matriz .
	 */
	public int remove(int x, int y) {

		if (this.is_empty()) return -5;

		nodoMatrix node = this.search(x, y);

		if (node != null) {
			
			int valor = node.valor;

			nodoMatrix anterior = this.search_anterior(x, y);

			if (anterior != null) {
				
				anterior.sig = node.sig;
			}
			else {
				this.inicio = node.sig;
			}

			return valor;
		}

		return -5;
	}

	/**
	 * Método completo.
	 *
	 *Determina si la  Matriz está llena.
	 *
	 * @return boolean
	 */
	
	public boolean is_full() {

		return this.numElementos == (this.filas * this.columnas);
	}

	/**
	 * Método vacio
	 *
	 * Determina si la matriz  esta vacia.
	 *
	 */
	public boolean is_empty() {

		return this.numElementos == 0;
	}

	/**
	 * Método "toString".
	 *
	 * Permite mostrar la matriz en pantalla

	 */
	public String toString() {

		if (this.is_empty()) return "Matriz vacia";

		nodoMatrix p = this.inicio;

		String description = "Matriz : \n ";

		for (int i = 0; i < this.filas; i++) {
			
			for (int j = 0; j < this.columnas; j++) {
				
				if ((p != null) && (p.x == i && p.y == j)) {
					
					description += String.format("%2d", p.valor);
					p = p.sig;
				}
				else {

					description += String.format("%2d", 0);
				}

				description += "  ";
			}

			description += " \n ";
		}

		description += "Elementos: " + this.numElementos + " \n ";

		return description;
	}
}