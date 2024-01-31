import java.io.*;

public class Crearchart {

    private int[] arr;

    /**
    * Returns the array of int values. Note that this is a copy and not a copy of the array
    */
    public int[] getArr() {
        return arr;
    }

    /**
    * Sets the array to be used for the data. It is assumed that the array is of size n
    * 
    * @param arr - the array to be
    */
    public void setArr(int[] arr) {
        this.arr = arr;
    }

    /**
    * Crea un archivo en formato csv y el arreglo de numeros aleatorios
    * 
    * @param archivon - Nombre del archivo a mostrar
    * @param no - Numero de elementos a mostr
    */
    public void Crear(String archivon, int no) {
        try (FileWriter writer = new FileWriter(archivon + ".csv")) {
            int[] array = new int[no];

            // Generates a random number of random numbers.
            for (int i = 0; i < array.length; i++) {
                int randomNumber = (int) (Math.random() * 3000 + 1);
                writer.write(randomNumber + ",");
                array[i] = randomNumber;
            }

            // Asignar el array generado a 'arr'
            setArr(array);
            System.out.println("Se ha creado el archivo");
        } catch (IOException e) {
            throw new RuntimeException("Error al escribir en el archivo");
        }
    }
}