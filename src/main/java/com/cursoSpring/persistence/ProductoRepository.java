package com.cursoSpring.persistence;

import com.cursoSpring.domain.Product;
import com.cursoSpring.domain.repository.ProductRepository;
import com.cursoSpring.persistence.crud.ProductoCrudRespository;
import com.cursoSpring.persistence.entity.Producto;
import com.cursoSpring.persistence.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository  implements ProductRepository {
    private ProductoCrudRespository productoCrudRespository;
    private ProductMapper mapper;

@Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRespository.findAll();
        return mapper.toProducts(productos);
    }


    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos= productoCrudRespository.findByIdCategoriaOrderByNombreAsc(categoryId);

    return Optional.of(mapper.toProducts(productos));

    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
    Optional <List<Producto>> productos=productoCrudRespository.findByCantidadStockLessThanAndEstado(quantity, true);

        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {

    return productoCrudRespository.findById(productId).map(producto -> mapper.toProduct((producto)));
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
    return mapper.toProduct(productoCrudRespository.save(producto));
    }








    @Override
    public void delete(int productId){
        productoCrudRespository.deleteById(productId);
    }


}
