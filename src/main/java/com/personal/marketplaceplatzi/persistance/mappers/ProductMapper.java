package com.personal.marketplaceplatzi.persistance.mappers;

import com.personal.marketplaceplatzi.domain.models.CategoryModel;
import com.personal.marketplaceplatzi.domain.models.ProductModel;
import com.personal.marketplaceplatzi.persistance.entities.CategoriaEntity;
import com.personal.marketplaceplatzi.persistance.entities.ProductoEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
  @Mappings({
      @Mapping(source = "idCategoria", target = "id"),
      @Mapping(source = "nombre", target = "name"),
      @Mapping(source = "idCategoria", target = "categoryId"),
      @Mapping(source = "precioVenta", target = "price"),
      @Mapping(source = "cantidadStock", target = "stock"),
      @Mapping(source = "estado", target = "active"),
      @Mapping(source = "categoria", target = "category"),
  })
  ProductModel toProduct(ProductoEntity producto);
  List<ProductModel> toProducts(List<ProductoEntity> productos);

  @InheritInverseConfiguration
  @Mapping(target = "codigoBarras", ignore = true)
  ProductoEntity toProducto(ProductModel product);
}
