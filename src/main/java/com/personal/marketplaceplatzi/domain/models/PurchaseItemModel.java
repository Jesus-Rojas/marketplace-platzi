package com.personal.marketplaceplatzi.domain.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurchaseItemModel {
  private int productId;
  private int amount;
  private double total;
  private boolean active;
}
