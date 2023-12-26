package com.personal.marketplaceplatzi.web.controllers;

import com.personal.marketplaceplatzi.domain.models.PurchaseModel;
import com.personal.marketplaceplatzi.domain.services.PurchaseService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("purchases")
@Tag(name = "Purchase Controller", description = "APIs for managing purchases")
public class PurchaseController {
  @Autowired
  private PurchaseService purchaseService;

  @GetMapping("")
  public ResponseEntity<List<PurchaseModel>> getAll() {
    return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
  }

  @PostMapping("")
  public ResponseEntity<PurchaseModel> save(
      @RequestBody PurchaseModel purchase
  ) {
    return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
  }

  @GetMapping("client/{clientId}")
  public ResponseEntity<List<PurchaseModel>> getByClientId(
      @PathVariable("clientId") String clientId
  ) {
    return purchaseService
        .getByClientId(clientId)
        .map(purchases -> new ResponseEntity<>(purchases, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }
}
