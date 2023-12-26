package com.personal.marketplaceplatzi.persistance.mappers;

import com.personal.marketplaceplatzi.domain.models.PurchaseModel;
import com.personal.marketplaceplatzi.persistance.entities.CompraEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = { PurchaseItemMapper.class })
public interface PurchaseMapper {
  @Mappings({
      @Mapping(source = "idCompra", target = "id"),
      @Mapping(source = "idCliente", target = "clientId"),
      @Mapping(source = "fecha", target = "date"),
      @Mapping(source = "medioPago", target = "paymentMethod"),
      @Mapping(source = "comentario", target = "comment"),
      @Mapping(source = "estado", target = "state"),
      @Mapping(source = "compraProductos", target = "items"),
  })
  PurchaseModel toPurchase(CompraEntity compra);
  List<PurchaseModel> toPurchases(List<CompraEntity> compras);

  @InheritInverseConfiguration
  @Mappings({
      @Mapping(target = "cliente", ignore = true),
  })
  CompraEntity toCompra(PurchaseModel purchase);
}
