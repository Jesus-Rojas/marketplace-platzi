package com.personal.marketplaceplatzi.domain.services;

import com.personal.marketplaceplatzi.domain.models.PurchaseModel;
import com.personal.marketplaceplatzi.domain.repositories.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
  @Autowired
  private PurchaseRepository purchaseRepository;

  public List<PurchaseModel> getAll() {
    return purchaseRepository.getAll();
  }

  public Optional<List<PurchaseModel>> getByClientId(String clientId) {
    return purchaseRepository.getByClientId(clientId);
  }

  public PurchaseModel save(PurchaseModel purchase) {
    return purchaseRepository.save(purchase);
  }
}
