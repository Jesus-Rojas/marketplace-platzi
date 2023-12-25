package com.personal.marketplaceplatzi.persistance.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "clientes")
public class ClienteEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String nombre;
  private String apellidos;
  private Integer celular;
  private String direccion;

  @Column(name = "correo_electronico")
  private String correoElectronico;
}
