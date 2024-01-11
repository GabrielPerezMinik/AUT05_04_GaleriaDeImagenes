package es.cifpcm.carruselImagenes.controller;

//import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;


//Se ha definido un limite de 10MB de subida
@Controller
public class ImageManagerServlet {
    File ficheroUpdown;
    String FILEPATH = "src\\main\\resources\\uploadsJimenezGonzalez";


    public void PostgestionFichero() {

        // Crear objeto File
        File folder = new File(FILEPATH);
//        InputStream imageInputStream = obtainImageInputStream();


        // Comprobar si la carpeta existe
        if (folder.exists()) {
//            Files.copy(imageInputStream, FILEPATH, StandardCopyOption.COPY_ATTRIBUTES);
        } else {
            System.out.println("La carpeta no existe.");
        }
    }


    public void GetgestionFichero() {

        File ficheros = new File(FILEPATH);

        for (final File f : ficheros.listFiles()) {
            System.out.println(f.getName());
            try {
                BufferedReader br = new BufferedReader(new FileReader(f));
                System.out.println("file content: ");
                int r = 0;
                while ((r = br.read()) != -1) {
                    System.out.print((char) r);
                }
                System.out.print("\n");
            } catch (Exception e) {
                //e.printStackTrace();
                System.out.println("Hubo un problema al abrir el archivo: traza completa "+e.getLocalizedMessage());
            }
        }
    }


    /*@GetMapping(
            value = "/get-image-with-media-type",
            produces = MediaType.IMAGE_JPEG_VALUE
    )
    public @ResponseBody byte[] getImageWithMediaType() throws IOException {
        InputStream in = getClass()
                .getResourceAsStream("/com/baeldung/produceimage/image.jpg");
        return IOUtils.toByteArray(in);
    }*/

    /** Esta clase es para recibir un archivo generico
     @GetMapping(value = "/image")
     public @ResponseBody byte[] getImage() throws IOException {
     InputStream in = getClass()
     .getResourceAsStream("/com/baeldung/produceimage/image.jpg");
     return IOUtils.toByteArray(in);
     }
     **/


}