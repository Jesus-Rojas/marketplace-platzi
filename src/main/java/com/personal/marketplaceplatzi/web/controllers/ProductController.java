package com.personal.marketplaceplatzi.web.controllers;

import com.personal.marketplaceplatzi.domain.models.ProductModel;
import com.personal.marketplaceplatzi.domain.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
  @Autowired
  private ProductService productService;

  @GetMapping("/")
  public List<ProductModel> getAll() {
    return productService.getAll();
  }

  @GetMapping("/{productId}")
  public Optional<ProductModel> getProduct(
      @PathVariable("productId") int productId
  ) {
    return productService.getProduct(productId);
  }

  @PostMapping("/")
  public ProductModel save(
      @RequestBody ProductModel product
  ) {
    return productService.save(product);
  }

  @DeleteMapping("/{productId}")
  public boolean delete(
      @PathVariable("productId") int productId
  ) {
    return productService.delete(productId);
  }

  @GetMapping("/category/{categoryId}")
  public Optional<List<ProductModel>> getByCategory(
      @PathVariable("categoryId") int categoryId
  ) {
    return productService.getByCategory(categoryId);
  }
}
