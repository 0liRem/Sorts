public interface ISorts <T extends Comparable<T>>{


    /**
    * Metodo per ordenar la prima inizializzazione della arreglo
    * 
    * @param arreglo - Array che rappresenta la prima
    */
    T[] GnomeSort(T[] arreglo);
    /**
    * Mergesort the elements of arreglo and returns the result. This is a destructive operation and may be undone with respect to the sort order of the array
    * 
    * @param arreglo - Array to be sorted
    */
    T[] MergeSort(T[] arreglo);
    /**
    * Sort a array using quicksort. This is a convenience method for sorting an array of objects. The array is not modified in any way and may be returned by reference.
    * 
    * @param arreglo - Array to be sorted. This array must have at least one element
    */
    T[] QuickSort(T[] arreglo);
    /**
    * Sorts an array using Radix Sort. The result is stored in arreglo. It is assumed that the array is already sorted.
    * 
    * @param arreglo - Array to be sorted. This array must have at least 2 elements
    */
    T[] RadixSort(T[] arreglo);
    /**
    * Sorts an array of objects according to their natural ordering. This is useful for sorting a list of objects in a way that preserves the order of the objects in the array.
    * 
    * @param arreglo - The array to be sorted. This array must be in natural order
    */
    T[] insertionSort(T[] arreglo);
    


} 
