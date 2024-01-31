import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PruebasUnitarias {
    @Test
    void testGnomeSort() {
        Integer[] Entrada = { 5, 3, 9, 1, 4 };
        Integer[] Esperado = { 1, 3, 4, 5, 9 };
        Sorts<Integer> ordenar = new Sorts<>();

        
        Integer[] sortedArray = ordenar.GnomeSort(Entrada);
        assertArrayEquals(Esperado, Entrada, "Arreglo Ordenado Ascendentemente y sin errores.");

    }
    @Test
    void testMergeSort() {

        Integer[] Entrada = { 5, 3, 9, 1, 4 };
        Integer[] Esperado = { 1, 3, 4, 5, 9 };
        Sorts<Integer> ordenar = new Sorts<>();

 
        Integer[] sortedArray = ordenar.MergeSort(Entrada);
        assertArrayEquals(Esperado, sortedArray, "Arreglo ordenado ascendentemente y sin errores.");
    }

    @Test
    void testQuickSort() {

        Integer[] Entrada = { 5, 3, 9, 1, 4 };
        Integer[] Esperado = { 1, 3, 4, 5, 9 };
        Sorts<Integer> ordenar = new Sorts<>();

  
        Integer[] sortedArray = ordenar.QuickSort(Entrada);
        assertArrayEquals(Esperado, sortedArray, "Arreglo ordenado ascendentemente y sin errores.");
    }

    @Test
    void testRadixSort() {
  
        Integer[] Entrada = { 5, 3, 9, 1, 4 };
        Integer[] Esperado = { 1, 3, 4, 5, 9 };
        Sorts<Integer> ordenar = new Sorts<>();

   
        Integer[] sortedArray = ordenar.RadixSort(Entrada);
        assertArrayEquals(Esperado, sortedArray, "Arreglo ordenado ascendentemente y sin errores.");
    }

    @Test
    void testInsertionSort() {
        
        Integer[] Entrada = { 5, 3, 9, 1, 4 };
        Integer[] Esperado = { 1, 3, 4, 5, 9 };
        Sorts<Integer> ordenar = new Sorts<>();

       
        Integer[] sortedArray = ordenar.insertionSort(Entrada);
        assertArrayEquals(Esperado, sortedArray, "Arreglo ordenado ascendentemente y sin errores.");
    }
    
}
