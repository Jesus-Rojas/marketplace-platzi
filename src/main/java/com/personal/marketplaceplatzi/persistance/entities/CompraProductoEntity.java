package com.personal.marketplaceplatzi.persistance.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "compras_productos")
public class CompraProductoEntity {
  @EmbeddedId
  private CompraProductoPK id;

  private Integer cantidad;
  private Double total;
  private Boolean estado;
}
