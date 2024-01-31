import java.util.Arrays;

public class Sorts<T extends Comparable<T>> implements ISorts<T>{

// #################  SORT DEL GNOMO. CONSIDERADO EL ORDENAMIENTO DEL TONTO. #######################
    /**
    * Sorts an array of objects by their natural order. This is a method to be used by sort ()
    * 
    * @param arreglo - Array of objects to
    */
    public T[] GnomeSort(T[] arreglo) {
        int index = 0;
        int n = arreglo.length;
        // Find the next element in the array.
        while (index < n) {
            // Increments the index of the next element.
            if (index == 0) {
                index++;
            }
            // Move the index of the first element to the end of the array.
            if (index < n && arreglo[index].compareTo(arreglo[index - 1]) >= 0) {
                index++;
            } else {
                // Move the index of the next element to the end of the array.
                if (index < n) {
                    T aux = arreglo[index];
                    arreglo[index] = arreglo[index - 1];
                    arreglo[index - 1] = aux;
                    index--;
                }
            }
        }

        return arreglo;
    }
    
//#################  FIN SORT DEL GNOMO #######################

// #################  INICIO MERGE SORT #######################
    /**
    * Mergesort a array of T. The merge is done in O ( n ) time where n is the length of the arreglo
    * 
    * @param arreglo - Array to be sorted
    */
    @Override
    public T[] MergeSort(T[] arreglo) {
        int n = arreglo.length;
        // Returns the arreglo if it is not null or n 1
        if(arreglo == null || n <=1){
            return arreglo;
        }

        T[] aux = Arrays.copyOf(arreglo, n);

        // Merge the two tamano values into the same order.
        for(int tamano = 1; tamano < n; tamano *=2) {
            // Merge the data from the input and medio.
            for(int inicio = 0; inicio < n - tamano; inicio += 2 * tamano) {
                int medio = inicio + tamano -1;
                int fin = Math.min(inicio + 2 * tamano - 1,  n - 1);
                merge(arreglo, aux, inicio, medio, fin);
            }
        }

        return arreglo;
    }

    /**
    * Merges two sorted arrays arr [ low.. mid ] and arr [ mid + 1.. high ].
    * 
    * @param arr - the array to be merged. It must be sorted in ascending order.
    * @param aux - the auxiliary array that will be used to store the merge result.
    * @param low - the first index in arr to be merged.
    * @param mid - the second index in arr to be merged.
    * @param high - the last index in arr to be merged. This is a linear search
    */
    private void merge(T[] arr, T[] aux, int low, int mid, int high){
        // Set auxiliary values to the array
        for(int i= low; i<=high; i++){
            aux[i] = arr[i];
        }
        int i = low;
        int j = mid + 1;
        int k = low;

        // This method is used to sort the array by the index and the index of the first element in the array.
        while (i <= mid && j <= high) {
            // Move the item at the index i and j to the end of the array.
            if (aux[i].compareTo(aux[j]) <= 0) {
                arr[k++] = aux[i++];
            } else {
                arr[k++] = aux[j++];
            }
        }

        // Put the auxiliary data into the array.
        while (i <= mid) {
            arr[k++] = aux[i++];
        }
    }

//#################  FIN MERGE SORT #######################

// #################  INICIO QUICK SORT CON RECURSIÓN (SOLO ASÍ SE PUEDE XD) #######################
    /**
    * Metodo que permite ordenar la pantalla de cada arreglo. Aqui se realiza el recursivo
    * 
    * @param arreglo - Array con los elementos que se desea ord
    */
    public T[] QuickSort(T[] arreglo) {
        int n = arreglo.length;
        // Returns the arreglo if it is not null or n 1
        if(arreglo == null || n <=1){
            return arreglo;
        }
        Recursivo(arreglo, 0, n-1);
        return arreglo;

    }
    /**
    * Metodo que permite recursivamente el arreglo de objetos T.
    * 
    * @param arr - Arreglo de objetos T.
    * @param low - Numero de elementos que tienen la matriz.
    * @param high - Numero de elementos que tienen la matriz
    */
    private void Recursivo(T[] arr, int low, int high) {
        // Recursivo de la mitad de la array
        if (low < high) {
            int Index = mitad(arr, low, high);

            Recursivo(arr, low, Index - 1);
            Recursivo(arr, Index + 1, high);
        }
    }

    /**
    * Mitad is a method that takes two arrays and swaps them. In this method the elements in the first array are swapped with the elements in the second array.
    * 
    * @param arr - The array to be sorted. It is assumed that arr [ low ] is less than arr [ high ].
    * @param low - The index of the first element in the array.
    * @param high - The index of the last element in the array.
    * 
    * @return The index of the last element in the array after swapping the elements in the first array with the elements in the second
    */
    private int mitad(T[] arr, int low, int high) {
        T pivote = arr[high];
        int i = low - 1;

        // Swap the array with the pivote in the array
        for (int j = low; j < high; j++) {
            // Swap the index of the first element in the array.
            if (arr[j].compareTo(pivote) <= 0) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

//#################  FIN QUICK SORT #######################

//#################  INICIO RADIX SORT #######################
/**
* Sorts the array using Radix Sort. The algorithm is O ( n ) where n is the number of elements in the array
* 
* @param arreglo - Array to be sorted
*/
public T[] RadixSort(T[] arreglo) {
    // Devuelve el arreglo de la propiedad arreglo.
    if (arreglo == null || arreglo.length <= 1) {
        return arreglo;
    }

    T max = arreglo[0];
    for (T element : arreglo) {
        // Set the maximum element to the maximum value.
        if (element.compareTo(max) > 0) {
            max = element;
        }
    }

    // Sorts the number of digits in the alphabetical order.
    for (int exp = 1; getMaxDigit(max) / exp > 0; exp *= 10) {
        countingSort(arreglo, exp);
    }

    return arreglo;
}

/**
* Returns the maximum digit that can be represented by the number. This is used to distinguish between numbers that are larger than 2^31 - 1
* 
* @param max - the maximum value to be represented
* 
* @return the maximum digit that can be represented by the number or 0 if there is no maximum value in the
*/
private int getMaxDigit(T max) {
    String str = max.toString();
    return str.length();
}

/**
* Sorts an array of T using counting sort. The array is modified in place. This is a destructive operation and should be avoided if performance is a concern
* 
* @param arr - Array to be sorted.
* @param exp - Exp of the hash function to be used for
*/
private void countingSort(T[] arr, int exp) {
    int n = arr.length;
    T[] output = Arrays.copyOf(arr, n);

    int[] count = new int[10];  // Hay 10 dígitos posibles (0-9)

    // Counts the number of times the hash code is a number of digits.
    for (int i = 0; i < n; i++) {
        count[(arr[i].hashCode() / exp) % 10]++;
    }


    // This method is used to calculate the number of times the number of times the number of times the number of times the number of times the number of times the number of times the number of times the number of times the number of times the number of times the number of times the number of times the number of times the number of times the number of times the number of times the number of times the number of times the number of times the number of times the number of times the number of times the number of times the number of times the number of times the number of times the number of times the number of times the number of times
    for (int i = 1; i < 10; i++) {
        count[i] += count[i - 1];
    }


    // Compute the output of the last element of the array.
    for (int i = n - 1; i >= 0; i--) {
        output[count[(arr[i].hashCode() / exp) % 10] - 1] = arr[i];
        count[(arr[i].hashCode() / exp) % 10]--;
    }

    System.arraycopy(output, 0, arr, 0, n);
}

//#################  FIN RADIX SORT #######################

//#################  INICIO ORDENAMIENTO DE INSERCIÓN #######################
/**
* Sorts an array of objects in ascending order. This is a standard insertion sort. The array is modified in place
* 
* @param arreglo - Array of objects to
*/
public T[] insertionSort(T[] arreglo) {
    int n = arreglo.length;
    // Returns the arreglo if any.
    if (arreglo == null || n <= 1) {
        return arreglo;
    }

    // Mover los elementos de los elementos de los elementos de los elementos de los elementos de los elementos de los elementos de los elementos de la posición.
    for (int i = 1; i < n; ++i) {
        T key = arreglo[i];
        int j = i - 1;

        // Mover los elementos mayores que key a una posición adelante de su posición actual
        // Move the item at the end of the array to the end of the array.
        while (j >= 0 && arreglo[j].compareTo(key) > 0) {
            arreglo[j + 1] = arreglo[j];
            j = j - 1;
        }
        arreglo[j + 1] = key;
    }

    return arreglo;
}

//#################  FIN ORDENAMIENTO DE INSERCIÓN #######################
    /**
    * Swaps two elements in an array. Used to implement Arrays. swap (... ) and Arrays. subarray (... )
    * 
    * @param arr - the array to be swapped
    * @param i - the index of the first element to be swapped
    * @param j - the index of the second element to be swap
    */
    private void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
