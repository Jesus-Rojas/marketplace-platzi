package com.personal.marketplaceplatzi.domain.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class PurchaseModel {
  private int id;
  private String clientId;
  private LocalDateTime date;
  private String paymentMethod;
  private String comment;
  private String state;
  private List<PurchaseItemModel> items;
}
