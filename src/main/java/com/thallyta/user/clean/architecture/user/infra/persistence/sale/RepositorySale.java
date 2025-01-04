package com.thallyta.user.clean.architecture.user.infra.persistence.sale;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorySale extends JpaRepository<SaleEntity, Long> {
}
