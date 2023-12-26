package com.personal.marketplaceplatzi.persistance.respositories;

import com.personal.marketplaceplatzi.domain.models.ProductModel;
import com.personal.marketplaceplatzi.domain.repositories.ProductRepository;
import com.personal.marketplaceplatzi.persistance.cruds.ProductoCrud;
import com.personal.marketplaceplatzi.persistance.entities.ProductoEntity;
import com.personal.marketplaceplatzi.persistance.mappers.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {
  @Autowired
  private ProductoCrud productoCrud;

  @Autowired
  private ProductMapper productMapper;

  @Override
  public List<ProductModel> getAll() {
    return productMapper.toProducts((List<ProductoEntity>) productoCrud.findAll());
  }

  @Override
  public Optional<List<ProductModel>> getByCategoryId(int categoryId) {
    return Optional.of(
        productMapper.toProducts(
            productoCrud.findByIdCategoriaOrderByNombreAsc(categoryId)
        )
    );
  }

  @Override
  public Optional<ProductModel> getProduct(int productId) {
    return productoCrud
        .findById(productId)
        .map(producto -> productMapper.toProduct(producto));
  }

  @Override
  public ProductModel save(ProductModel product) {
    ProductoEntity producto = productMapper.toProducto(product);
    return productMapper.toProduct(productoCrud.save(producto));
  }

  @Override
  public void delete(int productId) {
    productoCrud.deleteById(productId);
  }
}
