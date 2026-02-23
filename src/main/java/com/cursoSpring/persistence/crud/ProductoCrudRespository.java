package com.cursoSpring.persistence.crud;

import com.cursoSpring.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoCrudRespository extends CrudRepository<Producto,Integer> {

}
