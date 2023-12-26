package com.personal.marketplaceplatzi.persistance.respositories;

import com.personal.marketplaceplatzi.domain.models.ProductModel;
import com.personal.marketplaceplatzi.domain.repositories.ProductRepository;
import com.personal.marketplaceplatzi.persistance.cruds.ProductoCrud;
import com.personal.marketplaceplatzi.persistance.entities.ProductoEntity;
import com.personal.marketplaceplatzi.persistance.mappers.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {
  private ProductoCrud productoCrud;
  private ProductMapper productMapper;

  public List<ProductModel> getAll() {
    List<ProductoEntity> productos = (List<ProductoEntity>) productoCrud.findAll();
    return productMapper.toProducts(productos);
  }

  public Optional<List<ProductModel>> getByCategory(int categoryId) {
    return Optional.of(
        productMapper.toProducts(
            productoCrud.findByIdCategoriaOrderByNombreAsc(categoryId)
        )
    );
  }

  public Optional<List<ProductModel>> getScarseProducts(int amount) {
    return productoCrud
        .findByCantidadStockLessThanAndEstado(amount, true)
        .map(productos -> productMapper.toProducts(productos));
  }

  public Optional<ProductModel> getProduct(int productId) {
    return productoCrud
        .findById(productId)
        .map(producto -> productMapper.toProduct(producto));
  }

  public ProductModel save(ProductModel product) {
    ProductoEntity producto = productMapper.toProducto(product);
    return productMapper.toProduct(productoCrud.save(producto));
  }

  public void delete(int productId) {
    productoCrud.deleteById(productId);
  }
}
