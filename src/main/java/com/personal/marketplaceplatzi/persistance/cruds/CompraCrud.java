package com.personal.marketplaceplatzi.persistance.cruds;

import com.personal.marketplaceplatzi.persistance.entities.CompraEntity;
import com.personal.marketplaceplatzi.persistance.entities.ProductoEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CompraCrud extends CrudRepository<CompraEntity, Integer> {
  Optional<List<CompraEntity>> findByIdCliente(Integer idCliente);
}
