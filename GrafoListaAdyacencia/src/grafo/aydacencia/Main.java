package grafo.aydacencia;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        GrafoAdcia grafo = new GrafoAdcia(GrafoAdcia.maxVerts);
        
        int numVertices = 0;
        while (numVertices <= 0 || numVertices > GrafoAdcia.maxVerts) {
            System.out.print("Ingrese el número de vértices (máximo " + GrafoAdcia.maxVerts + "): ");
            numVertices = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
            
            if (numVertices <= 0 || numVertices > GrafoAdcia.maxVerts) {
                System.out.println("Número de vértices inválido. Por favor, ingrese un numero entre 1 y " + GrafoAdcia.maxVerts + ".");
            }
        }
        
        for (int i = 0; i < numVertices; i++) {
            System.out.print("Ingrese el nombre de la ciudad del vértice " + i + ": ");
            String nombreCiudad = scanner.nextLine();
            grafo.agregarVertice(nombreCiudad);
        }
        
        // Ingresar arcos
        System.out.print("Ingrese el número de arcos: ");
        int numArcos = scanner.nextInt();
        
        for (int i = 0; i < numArcos; i++) {
            System.out.print("Ingrese el vértice de origen del arco " + i + ": ");
            int origen = scanner.nextInt();
            
            System.out.print("Ingrese el vértice de destino del arco " + i + ": ");
            int destino = scanner.nextInt();
            
            System.out.print("Ingrese el peso del arco " + i + ": ");
            double pesoDKm = scanner.nextDouble();
            
            grafo.agregarArco(origen, destino, pesoDKm);
        }
        
        System.out.println("Recorrido Profundidad desde el vértice 0:");
        grafo.Profundidad(0);
        
        scanner.close();
    }
}
