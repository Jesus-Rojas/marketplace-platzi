package com.personal.marketplaceplatzi.persistance.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "categorias")
public class CategoriaEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_categoria")
  private Integer idCategoria;

  private String descripcion;
  private Boolean estado;

  @OneToMany(mappedBy = "categoria")
  private List<ProductoEntity> productos;
}
