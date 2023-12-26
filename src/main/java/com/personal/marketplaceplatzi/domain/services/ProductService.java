package com.personal.marketplaceplatzi.domain.services;

import com.personal.marketplaceplatzi.domain.models.ProductModel;
import com.personal.marketplaceplatzi.domain.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
  @Autowired
  private ProductRepository productRepository;

  public List<ProductModel> getAll() {
    return productRepository.getAll();
  }

  public Optional<List<ProductModel>> getByCategoryId(int categoryId) {
    return productRepository.getByCategoryId(categoryId);
  }

  public Optional<ProductModel> getProduct(int productId) {
    return productRepository.getProduct(productId);
  }

  public ProductModel save(ProductModel product) {
    return productRepository.save(product);
  }

  public boolean delete(int productId) {
    return getProduct(productId)
        .map(product -> {
          productRepository.delete(productId);
          return true;
        })
        .orElse(false);
  }
}
