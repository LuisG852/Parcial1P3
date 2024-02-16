package org.example;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();

        // Definir la matriz de ventas (5 filas x 12 columnas)
        int[][] ventas = new int[5][12];

        // Generar valores aleatorios para las ventas
        for (int i = 0; i < ventas.length; i++) {
            for (int j = 0; j < ventas[i].length; j++) {
                ventas[i][j] = random.nextInt(10000) + 1; // Ventas entre 1 y 10000
            }
        }

        // Imprimir la matriz generada
        System.out.println("Matriz generada:");
        imprimirMatriz(ventas);

        // Imprimir la matriz por filas
        System.out.println("\nMatriz por filas:");
        Arrays.stream(ventas)
                .forEach(fila -> {
                    Arrays.stream(fila)
                            .forEach(venta -> System.out.printf("%-6d", venta));
                    System.out.println();
                });

        // Ordenar los elementos de la matriz por columna
        for (int col = 0; col < ventas[0].length; col++) {
            final int columna = col;
            Arrays.sort(ventas, Comparator.comparingInt(row -> row[columna]));
        }

        // Imprimir la matriz ordenada por columna
        System.out.println("\nMatriz ordenada por columna:");
        imprimirMatriz(ventas);

        // Filtrar elementos de la matriz por un criterio (ventas mayores a 6550)
        int[][] ventasFiltradas = Arrays.stream(ventas)
                .map(row -> Arrays.stream(row)
                        .filter(sale -> sale > 6550)
                        .toArray())
                .toArray(int[][]::new);

        // Imprimir la matriz filtrada
        System.out.println("\nMatriz filtrada por ventas mayores a 5000:");
        imprimirMatrizPorFilas(ventasFiltradas);
    }

    // Método para imprimir una matriz por filas
    private static void imprimirMatrizPorFilas(int[][] matriz) {
        Arrays.stream(matriz)
                .forEach(fila -> {
                    Arrays.stream(fila)
                            .forEach(venta -> System.out.printf("%-6d", venta));
                    System.out.println();
                });
    }

    // Método para imprimir una matriz completa
    private static void imprimirMatriz(int[][] matriz) {
        Arrays.stream(matriz)
                .forEach(fila -> System.out.println(Arrays.toString(fila)));
    }
}
