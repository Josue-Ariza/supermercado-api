package com.cursoSpring.persistence;

import com.cursoSpring.persistence.crud.ProductoCrudRespository;
import com.cursoSpring.persistence.entity.Producto;

import java.util.List;

public class ProductoRepository {
    private ProductoCrudRespository productoCrudRespository;

    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRespository.findAll();
    }
}
