package com.example.demo.Controller;


import com.example.demo.Bean.cursosBean;
import com.example.demo.Bean.estudianteBean;
import com.example.demo.Service.estudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/estudiante")
@CrossOrigin(origins = "https://frontj92.azurewebsites.net")

public class estudianteController {


    @Autowired
    private estudianteRepository estuRepo;

    @GetMapping("/obtener")
    public List<estudianteBean> obtenerEstudiante (){
        List<estudianteBean> listaEstudiante = new ArrayList<>();
        listaEstudiante = (List<estudianteBean>) estuRepo.findAll();
        return listaEstudiante;
    }

    @PostMapping("/insertar")
    public void insertarEstudiante(@RequestBody estudianteBean estuBean){
        estuRepo.save(estuBean);
    }

    @PutMapping("/modificar")
    public void modificarAlumno (@RequestBody estudianteBean estuBean) {
        estuRepo.save(estuBean);
    }

    @DeleteMapping("/eliminar")
    public void eliminar (@RequestBody estudianteBean estuBean){
        estuRepo.deleteById(estuBean.getIdestudiante());
    }

    @PutMapping("/modificar/{idestudiante}")
    public void modificarAlumnoUnico (@PathVariable("idestudiante") Integer idestudiante, @RequestBody estudianteBean estuBean) {
        estuBean.setIdestudiante(idestudiante);
        estuRepo.save(estuBean);
    }

    @GetMapping("/obtener/{idestudiante}")
    public ResponseEntity<estudianteBean> obtenerEstudianteUnico(@PathVariable ("idestudiante") Integer idestudiante){
        estudianteBean listEstudianteEncontrado =  estuRepo.findById(idestudiante).orElseThrow();
        return ResponseEntity.ok(listEstudianteEncontrado);
    }

    @DeleteMapping("/eliminar/{idestudiante}")
    public void eliminar (@PathVariable ("idestudiante") Integer idestudiante){
        estuRepo.deleteById(idestudiante);
    }

}
