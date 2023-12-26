package com.personal.marketplaceplatzi.web.controllers;

import com.personal.marketplaceplatzi.domain.models.ProductModel;
import com.personal.marketplaceplatzi.domain.services.ProductService;
import com.personal.marketplaceplatzi.web.config.ResponseCode;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
@Tag(name = "Product Controller", description = "APIs for managing products")
public class ProductController {
  @Autowired
  private ProductService productService;

  @GetMapping("")
  @ApiResponse(responseCode = ResponseCode.OK)
  @Operation(summary = "Get a list of all products")
  public ResponseEntity<List<ProductModel>> getAll() {
    return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
  }

  @GetMapping("{productId}")
  @Operation(summary = "Search a product with an ID")
  @ApiResponses({
      @ApiResponse(responseCode = ResponseCode.OK),
      @ApiResponse(
          responseCode = ResponseCode.NOT_FOUND,
          description = "Product not found"
      )
  })
  public ResponseEntity<ProductModel> getProduct(
      @Parameter(description = "The id of the product", required = true, example = "1")
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
