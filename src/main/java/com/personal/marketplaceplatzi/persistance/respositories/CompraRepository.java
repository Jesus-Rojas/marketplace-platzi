package com.personal.marketplaceplatzi.persistance.respositories;

import com.personal.marketplaceplatzi.domain.models.PurchaseModel;
import com.personal.marketplaceplatzi.domain.repositories.PurchaseRepository;
import com.personal.marketplaceplatzi.persistance.cruds.CompraCrud;
import com.personal.marketplaceplatzi.persistance.entities.CompraEntity;
import com.personal.marketplaceplatzi.persistance.mappers.ProductMapper;
import com.personal.marketplaceplatzi.persistance.mappers.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CompraRepository implements PurchaseRepository {
  @Autowired
  private CompraCrud compraCrud;

  @Autowired
  private PurchaseMapper purchaseMapper;

  @Override
  public List<PurchaseModel> getAll() {
    return purchaseMapper.toPurchases((List<CompraEntity>) compraCrud.findAll());
  }

  @Override
  public Optional<List<PurchaseModel>> getByClientId(int clientId) {
    return compraCrud
        .findByIdCliente(clientId)
        .map(compras -> purchaseMapper.toPurchases(compras));
  }

  @Override
  public PurchaseModel save(PurchaseModel purchase) {
    CompraEntity compra = purchaseMapper.toCompra(purchase);
    compra
        .getCompraProductos()
        .forEach(compraProducto -> compraProducto.setCompra(compra));

    return purchaseMapper.toPurchase(compraCrud.save(compra));
  }
}
