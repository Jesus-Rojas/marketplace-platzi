package com.personal.marketplaceplatzi.domain.repositories;

import com.personal.marketplaceplatzi.domain.models.PurchaseModel;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
  List<PurchaseModel> getAll();
  Optional<List<PurchaseModel>> getByClientId(int clientId);
  PurchaseModel save(PurchaseModel purchase);
}
