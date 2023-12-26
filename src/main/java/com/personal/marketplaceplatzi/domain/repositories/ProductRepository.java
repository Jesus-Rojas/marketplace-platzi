package com.personal.marketplaceplatzi.domain.repositories;

import com.personal.marketplaceplatzi.domain.models.ProductModel;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
  List<ProductModel> getAll();
  Optional<List<ProductModel>> getByCategoryId(int categoryId);
  Optional<ProductModel> getProduct(int productId);
  ProductModel save(ProductModel product);
  void delete(int productId);
}
