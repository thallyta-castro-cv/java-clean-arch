package com.thallyta.user.clean.architecture.user.infra.gateway.sale;

import com.thallyta.user.clean.architecture.user.application.gateway.sale.SaleRepository;
import com.thallyta.user.clean.architecture.user.domain.sale.Sale;
import com.thallyta.user.clean.architecture.user.infra.persistence.sale.RepositorySale;
import com.thallyta.user.clean.architecture.user.infra.persistence.sale.SaleEntity;
import com.thallyta.user.clean.architecture.user.infra.persistence.user.RepositoryUser;
import com.thallyta.user.clean.architecture.user.infra.persistence.user.UserEntity;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

public class SaleRepositoryJpa implements SaleRepository {

    private final RepositorySale repositorySale;
    private final SaleEntityMapper saleEntityMapper;
    private final RepositoryUser repositoryUser;

    public SaleRepositoryJpa(RepositorySale repositorySale, SaleEntityMapper saleEntityMapper, RepositoryUser repositoryUser) {
        this.repositorySale = repositorySale;
        this.saleEntityMapper = saleEntityMapper;
        this.repositoryUser = repositoryUser;
    }

    @Override
    @Transactional
    public Sale create(Sale sale) {
        SaleEntity saleEntity = new SaleEntity();

        UserEntity userEntity = repositoryUser.findById(sale.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        saleEntity.setUser(userEntity);
        saleEntityMapper.toEntity(sale);
        repositorySale.save(saleEntity);
        return saleEntityMapper.toDomain(saleEntity);
    }

    @Override
    public List<Sale> getAll() {
        return repositorySale.findAll().stream()
                .map(saleEntityMapper::toDomain)
                .collect(Collectors.toList());
    }
}
