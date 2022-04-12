package LecturaPrint;
import Codificadores.CesarCodification;
import Codificadores.EnderCodification;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ClassCodificacionPOM {
    public static String PlayTestClassCodificacionPOM(String Directorio){

        BufferedReader br = null;
        try {
            //Crear un objeto BufferedReader al que se le pasa
            //Un objeto FileReader con el nombre del fichero
            br = new BufferedReader(new FileReader(Directorio));
            //Leer la primera línea, guardando en un String
            String texto = br.readLine();
            //Repetir mientras no se llegue al final del fichero

            while(texto != null)
            {
                if(texto.contains("Cesar:")){
                    int pos = texto.indexOf(":")+1;
                    System.out.println("Palabra sin codificar: ("+texto.substring(pos)+") Palabra Codificada: ("+ CesarCodification.cifradoCesar(texto.substring(pos),1)+")");
                }else if (texto.contains("Ender:")){
                    int pos = texto.indexOf(":")+1;
                    System.out.println("Palabra sin codificar: "+texto.substring(pos)+" Palabra Codificada: ("+ EnderCodification.cifradoEnder(texto.substring(pos))+")");
                }else{
                    int pos = texto.indexOf(":")+1;
                    System.out.println("La palabra ("+texto.substring(pos)+") no tiene un codigo de codificacion valido en el archivo txt, por favor verifique el archivo");
                }
                texto = br.readLine();

            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Error: Fichero no encontrado");
            System.out.println(e.getMessage());
        }
        catch(Exception e) {
            System.out.println("Error de lectura del fichero");
            System.out.println(e.getMessage());
        }
        finally {
            try {
                if(br != null)
                    br.close();
            }
            catch (Exception e) {
                System.out.println("Error al cerrar el fichero");
                System.out.println(e.getMessage());
            }
        }
        return null;
    }
}
