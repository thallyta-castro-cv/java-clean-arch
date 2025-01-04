package com.thallyta.user.clean.architecture.user.application.usecase.sale;

import com.thallyta.user.clean.architecture.user.application.gateway.sale.SaleRepository;
import com.thallyta.user.clean.architecture.user.domain.sale.Sale;

import java.util.List;

public class ListSaleUseCase {

    public final SaleRepository saleRepository;

    public ListSaleUseCase(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public List<Sale> getAll() {
        return saleRepository.getAll();
    }
}
