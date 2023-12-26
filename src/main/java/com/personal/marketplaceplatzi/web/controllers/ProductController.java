package com.personal.marketplaceplatzi.web.controllers;

import com.personal.marketplaceplatzi.domain.models.ProductModel;
import com.personal.marketplaceplatzi.domain.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {
  @Autowired
  private ProductService productService;

  @GetMapping("")
  public ResponseEntity<List<ProductModel>> getAll() {
    return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
  }

  @GetMapping("{productId}")
  public ResponseEntity<ProductModel> getProduct(
      @PathVariable("productId") int productId
  ) {
    return productService
        .getProduct(productId)
        .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PostMapping("")
  public ResponseEntity<ProductModel> save(
      @RequestBody ProductModel product
  ) {
    return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
  }

  @DeleteMapping("{productId}")
  public ResponseEntity<HttpStatus> delete(
      @PathVariable("productId") int productId
  ) {
    return new ResponseEntity<>(
        productService.delete(productId) ? HttpStatus.OK : HttpStatus.NOT_FOUND
    );
  }

  @GetMapping("category/{categoryId}")
  public ResponseEntity<List<ProductModel>> getByCategoryId(
      @PathVariable("categoryId") int categoryId
  ) {
    return productService
        .getByCategoryId(categoryId)
        .map(products -> new ResponseEntity<>(products, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }
}
