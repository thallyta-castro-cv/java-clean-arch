package com.thallyta.user.clean.architecture.user.config;

import com.thallyta.user.clean.architecture.user.application.gateway.sale.SaleRepository;
import com.thallyta.user.clean.architecture.user.application.gateway.ticket.TicketRepository;
import com.thallyta.user.clean.architecture.user.application.gateway.ticket.TypeTicketRepository;
import com.thallyta.user.clean.architecture.user.application.gateway.user.UserRepository;
import com.thallyta.user.clean.architecture.user.application.usecase.sale.CreateSaleUseCase;
import com.thallyta.user.clean.architecture.user.application.usecase.sale.ListSaleUseCase;
import com.thallyta.user.clean.architecture.user.infra.gateway.sale.SaleEntityMapper;
import com.thallyta.user.clean.architecture.user.infra.gateway.sale.SaleRepositoryJpa;
import com.thallyta.user.clean.architecture.user.infra.gateway.ticket.TicketEntityMapper;
import com.thallyta.user.clean.architecture.user.infra.persistence.sale.RepositorySale;
import com.thallyta.user.clean.architecture.user.infra.persistence.user.RepositoryUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SaleConfig {

    @Bean
    CreateSaleUseCase createSale(SaleRepository saleRepository, UserRepository userRepository,
                                 TypeTicketRepository typeTicketRepository, TicketRepository ticketRepository) {
        return new CreateSaleUseCase(saleRepository, userRepository, typeTicketRepository, ticketRepository);
    }

    @Bean
    ListSaleUseCase listSalesUseCase(SaleRepository saleRepository){
        return new ListSaleUseCase(saleRepository);
    }

    @Bean
    SaleRepositoryJpa createRepositorySaleJpa(RepositorySale repositorySale, SaleEntityMapper userEntityMapper, RepositoryUser repositoryUser){
        return new SaleRepositoryJpa(repositorySale, userEntityMapper, repositoryUser);
    }

    @Bean
    SaleEntityMapper entitySaleMapper(TicketEntityMapper ticketEntityMapper){
        return new SaleEntityMapper(ticketEntityMapper);
    }
}
