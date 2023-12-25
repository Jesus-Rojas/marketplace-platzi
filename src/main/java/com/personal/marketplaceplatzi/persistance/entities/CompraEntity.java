package com.personal.marketplaceplatzi.persistance.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "compras")
public class CompraEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_compra")
  private Integer idCompra;

  @Column(name = "idCliente")
  private Integer idCliente;

  private LocalDateTime fecha;

  @Column(name = "medio_pago")
  private String medioPago;

  private String comentario;
  private String estado;
}
