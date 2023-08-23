package grafo.aydacencia;

import java.util.List;
import java.util.Stack;
public class GrafoAdcia {
	
	int numVerts;
	static int maxVerts = 20;
	VerticeAdy[] tablAdc;
	
	public GrafoAdcia(int mx) {
		tablAdc = new VerticeAdy[mx];
		numVerts = 0;
		maxVerts = mx;
	}
	
	public void agregarVertice(String nombreCiudad) {
		if (numVerts < maxVerts) {
			VerticeAdy nuevoVertice = new VerticeAdy(nombreCiudad);
			nuevoVertice.asigVert(numVerts);
			tablAdc[numVerts++] = nuevoVertice;
		}
	}
	
	public void agregarArco(int origen, int destino, double pesoDKm) {
		if (origen >= 0 && origen < numVerts && destino >= 0 && destino < numVerts) {
			Arco nuevoArco = new Arco(destino, pesoDKm);
			if (!adyacente(origen, destino)) {
				tablAdc[origen].lad.add(nuevoArco);
			}
		}
	}
	
	public boolean adyacente(int origen, int destino) {
		if (origen >= 0 && origen < numVerts && destino >= 0 && destino < numVerts) {
			List<Arco> listaAdy = tablAdc[origen].lad;
			for (Arco arco : listaAdy) {
				if (arco.destino == destino) {
					return true;
				}
			}
		}
		return false;
	}
	//Metodo para hacer el recorrido en profundidad
	public void Profundidad(int inicio) {
		if (inicio < 0 || inicio >= numVerts) {
			return;
		}
		
		boolean[] visitado = new boolean[numVerts];
		Stack<Integer> stack = new Stack<>();
		
		stack.push(inicio);
		visitado[inicio] = true;
		
		while (!stack.isEmpty()) {
			int actual = stack.pop();
			System.out.println(tablAdc[actual].nomVertice()); // Procesar el vértice
			
			List<Arco> listaAdy = tablAdc[actual].lad;
			for (Arco arco : listaAdy) {
				int destino = arco.destino;
				if (!visitado[destino]) {
					stack.push(destino);
					visitado[destino] = true;
				}
			}
		}
	}
}

