package com.personal.marketplaceplatzi.domain.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductModel {
  private int id;
  private String name;
  private int categoryId;
  private double price;
  private int stock;
  private boolean active;
  private CategoryModel category;
}
