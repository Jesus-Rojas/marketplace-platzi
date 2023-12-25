package com.personal.marketplaceplatzi.persistance.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class CompraProductoPK implements Serializable {
  @Column(name = "id_compra")
  private Integer idCompra;

  @Column(name = "id_producto")
  private Integer idProducto;
}
