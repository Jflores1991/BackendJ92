package com.example.demo.Service;

import com.example.demo.Bean.cursosBean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface cursoRepository extends CrudRepository <cursosBean,Integer>{
}
