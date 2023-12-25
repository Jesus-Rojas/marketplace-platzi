package com.personal.marketplaceplatzi.persistance.cruds;

import com.personal.marketplaceplatzi.persistance.entities.ProductoEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrud extends CrudRepository<ProductoEntity, Integer> {
  List<ProductoEntity> findByIdCategoriaOrderByNombreAsc(int idCategoria);
  Optional<List<ProductoEntity>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}
