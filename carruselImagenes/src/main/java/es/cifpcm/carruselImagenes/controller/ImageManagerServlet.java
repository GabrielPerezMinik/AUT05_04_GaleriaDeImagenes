package es.cifpcm.carruselImagenes.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


//Se ha definido un limite de 10MB de subida
@Controller
public class ImageManagerServlet {
    String FILEPATH = "src\\main\\resources\\uploadsJimenezGonzalez";


    @PostMapping("/subidaImagen")
    public String PostgestionFichero(@RequestParam MultipartFile img, HttpSession laSession) {


        if (img != null) {

            try {
                File guardado = new ClassPathResource(FILEPATH).getFile();
                Path ruta = Paths.get(guardado.getAbsolutePath() + File.separator + img.getOriginalFilename());
                Files.copy(img.getInputStream(), ruta, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                System.out.println("Hubo un problema al abrir el archivo: traza completa " + e.getLocalizedMessage());
            }

            laSession.setAttribute("mensaje", "Imagen subida con exito");

        }

        return "redirect:/{pagina de visualizacion}";
    }

    // Hay 2 versiones prueba si alguna de las dos te vale, deberian servir ambas pero por si acaso

    @GetMapping("/obtenerImagen")
    public void GetgestionFichero() {

        File ficheros = new File(FILEPATH);
        List<String> lista = new ArrayList<>();
        for (final File f : ficheros.listFiles()) {
            lista.add(f.getAbsolutePath());
        }

    }

    @GetMapping("/obtenerImagenV2")
    public void prueba(){
        String dir = FILEPATH;
        List<String> lista = new ArrayList<>();
        try (Stream<Path> paths = Files.walk(Paths.get(dir))) {
            paths
                    .filter(Files::isRegularFile)
                    .forEach(path -> lista.add(path.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
