import java.util.Arrays;
import java.util.Scanner;
public class Vista {
    Scanner sc=new Scanner(System.in);
    public void menu(){
        Crearchart crear=new Crearchart();
        Controlador controlador = new Controlador();
        Sorts<Integer> ordenar = new Sorts<>();
        String arch= "Archivo";
        System.out.println("Ingrese la cantidad de numeros que quiere ordenar (0<n<3000)");
        int no=sc.nextInt();
        crear.Crear(arch,no);
        int[] arr = crear.getArr();
        Integer[] arreglo_Integer = new Integer[arr.length];
        for(int i = 0; i < arr.length; i++){
            arreglo_Integer[i] = arr[i];
        }

        while(arch != "Salir"){
            System.out.println("Binevenido a Sorts, elija que sort quiere utilizar: \n 1: Gnome \n 2: Merge \n 3: Quick \n 4: Radix \n 5: Insercion \n 6: Salir ");
            arch=sc.next();
            switch(arch) {
                case "Gnome":
                    arreglo_Integer = ordenar.GnomeSort(arreglo_Integer);
                    System.out.println(Arrays.toString(arreglo_Integer));
                    
                    break;
                case "Merge":
                    arreglo_Integer = ordenar.MergeSort(arreglo_Integer);
                    System.out.println(Arrays.toString(arreglo_Integer));
                    
                    break;
                case "Quick":
                    arreglo_Integer = ordenar.QuickSort(arreglo_Integer);
                    System.out.println(Arrays.toString(arreglo_Integer));
                    
                    break;
                case "Radix":
                    arreglo_Integer = ordenar.RadixSort(arreglo_Integer);
                    System.out.println(Arrays.toString(arreglo_Integer));
                    break;
                case "Insercion":
                    arreglo_Integer = ordenar.insertionSort(arreglo_Integer);
                    System.out.println(Arrays.toString(arreglo_Integer));
                    break;

                case "Salir":
                    System.out.println("Hasta la proxima.");
                default:
                    throw new RuntimeException("Tipo de dato inexistente");
                }
        }
      }
    }