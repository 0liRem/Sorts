import java.io.*;
import java.io.File;
import java.util.ArrayList; // import the ArrayList class
import java.util.Arrays;
import java.util.Random;
public class Crearchart {
    public void Crear(String archivon,int no){
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String linea = null;
        try {
            //Cargamos el archivo de la ruta relativa
            archivo = new File(archivon+".csv");
            //Cargamos el objeto FileReader
            fr = new FileReader(archivo);
            //Creamos un buffer de lectura
            br = new BufferedReader(fr);
            System.out.println("Se ha abierto con exito");
        } catch (Exception e) {
            try(FileWriter writer=new FileWriter(archivon+".csv")){
                System.out.println("Se ha creado el archivo");
            }
            catch (Exception e2){
                e2.printStackTrace();
            }
        }
        finally {
            random(archivon,no);
        }
    }
    public  void random(String archivon, int no){
        int array[];
        int randomNumber;
        try(FileWriter writer=new FileWriter(archivon+".csv")){
            array=new int[no];

            for (int i=0;i<array.length;i++){
                randomNumber=(int)(Math.random()*3000+1);
                writer.write(randomNumber+",");
            }
        }
        catch (Exception e2){
            throw new RuntimeException("Archivo No Encontrado");
        }

    }
}
