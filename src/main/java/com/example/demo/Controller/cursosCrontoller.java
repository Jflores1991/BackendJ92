package com.example.demo.Controller;

import com.example.demo.Bean.cursosBean;
import com.example.demo.Service.cursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")

public class cursosCrontoller {


    @Autowired
    private cursoRepository curRepo;


    @GetMapping
    public List<cursosBean> obtenerCurso() {
        return (List<cursosBean>) curRepo.findAll();
    }

    @PostMapping
    public void insertarCurso(@RequestBody cursosBean curBean) {
        curRepo.save(curBean);
    }

    @PutMapping("/modificar")
    public void modificarcurso(@RequestBody cursosBean curBean) {
        curRepo.save(curBean);
    }

    @DeleteMapping (value = "/{idRecibido}")
    public void eliminarCurso (@PathVariable ("idRecibido") Integer id){
        curRepo.deleteById(id);
    }

}