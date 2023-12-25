package com.personal.marketplaceplatzi.persistance.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "compras")
public class CompraEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_compra")
  private Integer idCompra;

  private LocalDateTime fecha;

  @Column(name = "medio_pago")
  private String medioPago;

  private String comentario;
  private String estado;

  @ManyToOne
  @JoinColumn(name = "id_cliente", insertable = false, updatable = false)
  private ClienteEntity cliente;

  @OneToMany(mappedBy = "compra")
  private List<CompraProductoEntity> compraProductos;
}
