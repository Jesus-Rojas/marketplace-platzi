package com.personal.marketplaceplatzi.persistance.mappers;

import com.personal.marketplaceplatzi.domain.models.PurchaseItemModel;
import com.personal.marketplaceplatzi.persistance.entities.CompraProductoEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = { ProductMapper.class })
public interface PurchaseItemMapper {
  @Mappings({
      @Mapping(source = "id.idProducto", target = "productId"),
      @Mapping(source = "cantidad", target = "amount"),
      @Mapping(source = "estado", target = "active"),
  })
  PurchaseItemModel toPurchaseItem(CompraProductoEntity compraProducto);

  @InheritInverseConfiguration
  @Mappings({
      @Mapping(target = "compra", ignore = true),
      @Mapping(target = "producto", ignore = true),
      @Mapping(target = "id.idCompra", ignore = true),
  })
  CompraProductoEntity toCompraProducto(PurchaseItemModel purchaseItem);
}
