package com.personal.marketplaceplatzi.persistance.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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

  @ManyToOne
  @JoinColumn(name = "id_compra", insertable = false, updatable = false)
  private CompraEntity compra;

  @ManyToOne
  @JoinColumn(name = "id_producto", insertable = false, updatable = false)
  private CompraEntity producto;
}
