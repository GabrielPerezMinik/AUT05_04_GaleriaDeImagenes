package es.cifpcm.carruselImagenes.controller;

import org.springframework.stereotype.Controller;

import java.io.File;

@Controller
public class ImageManagerServlet {
    File ficheroUpdown;
    String FILEPATH="src\\main\\resources\\uploadsJimenezGonzalez";



    public void PostgestionFichero(){

                // Crear objeto File
                File folder = new File(FILEPATH);

                // Comprobar si la carpeta existe
                if (folder.exists()) {
                    System.out.println("La carpeta existe.");
                } else {
                    System.out.println("La carpeta no existe.");
                }
            }



    public void GetgestionFichero(){

        File ficheros= new File(FILEPATH);

        System.out.println(ficheros.list().length);

        for (final File f:ficheros.listFiles()){
            System.out.println( f.getName());
        }

          //  System.out.println(ficheros[i].getName());
        }



}
