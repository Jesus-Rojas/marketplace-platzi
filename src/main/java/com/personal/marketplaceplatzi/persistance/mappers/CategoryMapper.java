package com.personal.marketplaceplatzi.persistance.mappers;

import com.personal.marketplaceplatzi.domain.models.CategoryModel;
import com.personal.marketplaceplatzi.persistance.entities.CategoriaEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
  @Mappings({
      @Mapping(source = "idCategoria", target = "id"),
      @Mapping(source = "descripcion", target = "name"),
      @Mapping(source = "estado", target = "active"),
  })
  CategoryModel toCategory(CategoriaEntity categoria);

  @InheritInverseConfiguration
  @Mapping(target = "productos", ignore = true)
  CategoriaEntity toCategoria(CategoryModel category);
}
