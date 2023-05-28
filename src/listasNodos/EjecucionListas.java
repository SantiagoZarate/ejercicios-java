package listasNodos;

public class EjecucionListas {

	public static void main(String[] args) {
		Lista nuevaLista = new Lista();
		
		nuevaLista.agregarAdelante(2);
//		nuevaLista.agregarAdelante(6);
		nuevaLista.agregarAdelante(4);
		nuevaLista.agregarAdelante(3);
//		nuevaLista.agregarAdelante(12);
//		nuevaLista.agregarAdelante(7);
		
		nuevaLista.mostrar();
		
//		nuevaLista.filtrarElementosEnRangoo(5,9);
		nuevaLista.escalerasHastaCero();
		
		nuevaLista.mostrar();
	}
}
