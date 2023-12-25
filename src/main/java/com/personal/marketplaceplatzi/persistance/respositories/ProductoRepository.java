package com.personal.marketplaceplatzi.persistance.respositories;

import com.personal.marketplaceplatzi.persistance.cruds.ProductoCrud;
import com.personal.marketplaceplatzi.persistance.entities.ProductoEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository {
  private ProductoCrud productoCrud;

  public List<ProductoEntity> getAll() {
    return (List<ProductoEntity>) productoCrud.findAll();
  }

  public List<ProductoEntity> getByCategoria(int idCategoria) {
    return productoCrud.findByIdCategoriaOrderByNombreAsc(idCategoria);
  }

  public Optional<List<ProductoEntity>> getEscasos(int cantidad) {
    return productoCrud.findByCantidadStockLessThanAndEstado(cantidad, true);
  }

  public Optional<ProductoEntity> getProducto(int idProducto) {
    return productoCrud.findById(idProducto);
  }

  public ProductoEntity save(ProductoEntity producto) {
    return productoCrud.save(producto);
  }

  public void delete(int idProducto) {
    productoCrud.deleteById(idProducto);
  }
}
