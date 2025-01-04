package com.thallyta.user.clean.architecture.user.application.gateway.sale;

import com.thallyta.user.clean.architecture.user.domain.sale.Sale;

import java.util.List;

public interface SaleRepository {

    Sale create(Sale sale);

    List<Sale> getAll();
}
