import java.util.Scanner;
public class Vista {
    Scanner sc=new Scanner(System.in);
    public void menu(){
        Controlador controlador = new Controlador();
        System.out.println("Binevenido a Sorts, elija que sort quiere utilizar: \n 1: Gnome \n 2: Merge \n 3: Quick \n 4: Radix \n 5: Insercion ");
        String arch=sc.next();
        System.out.println("Ingrese la cantidad de numeros que quiere ordenar (0<n<3000)");
        int no=sc.nextInt();
        switch(arch) {
            case "Gnome":
                controlador.crear.Crear(arch,no);
                break;
            case "Merge":
                controlador.crear.Crear(arch,no);
                break;
            case "Quick":
                controlador.crear.Crear(arch,no);
                break;
            case "Radix":
                controlador.crear.Crear(arch,no);
                break;
            case "Insercion":
                controlador.crear.Crear(arch,no);
                controlador.merge(arch);
                break;
            default:
                throw new RuntimeException("Tipo de dato inexistente");
            }
        }
    }