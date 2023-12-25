package com.personal.marketplaceplatzi.persistance.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "productos")
public class ProductoEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_producto")
  private Integer idProducto;

  private String nombre;

  @Column(name = "id_categoria")
  private Integer idCategoria;

  @Column(name = "codigo_barras")
  private String codigoBarras;

  @Column(name = "precio_venta")
  private Double precioVenta;

  @Column(name = "catidad_stock")
  private Integer cantidadStock;

  private Boolean estado;

  @ManyToOne
  @JoinColumn(name = "id_categoria", insertable = false, updatable = false)
  private CategoriaEntity categoria;
}
