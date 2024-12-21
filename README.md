# Projeto: Cadastro de Usuários com Arquitetura Limpa

Este projeto implementa um sistema de cadastro de usuários utilizando os princípios da **Arquitetura Limpa** (Clean Architecture).
O objetivo é organizar o código de forma que seja independente de frameworks, fácil de manter e de escalar, promovendo a separação de responsabilidades entre as camadas.

## Estrutura do Projeto
A estrutura do projeto segue o modelo exibido no diagrama abaixo:

```
|-- application
|   |-- gateway
|   |   \-- UserRepository
|   |-- usecase
|       |-- CreateUserUseCase
|       \-- ListUsersUseCase
|-- config
|   \-- UserConfig
|-- domain
|   \-- entities.user
|       |-- User
|       |-- UserBuilder
|       \-- Address
|-- infra
|   |-- controller
|   |   \-- dto
|   |       \-- UserController
|   |-- gateway
|   |   |-- UserEntityMapper
|   |   \-- UserRepositoryJpa
|   \-- persistence
|       |-- RepositoryUser
|       \-- UserEntity
\-- UserApplication
```

### Descrição das Camadas

#### **1. Application**
Essa camada concentra os casos de uso e interfaces que permitem que os dados transitem entre as camadas sem depender de implementações concretas.

- **gateway/UserRepository**: Interface que define os contratos para operações de persistência relacionadas ao usuário.
- **usecase/CreateUserUseCase**: Caso de uso para criar novos usuários.
- **usecase/ListUsersUseCase**: Caso de uso para listar os usuários registrados.

#### **2. Config**
- **UserConfig**: Arquivos de configuração do projeto, como beans do Spring ou outras dependências.

#### **3. Domain**
Camada onde estão as entidades do domínio e regras de negócio puras.

- **entities.user/User**: Classe que representa a entidade Usuário.
- **entities.user/UserBuilder**: Classe Builder para criar objetos do tipo Usuário.
- **entities.user/Address**: Classe que representa o endereço do usuário.

#### **4. Infra**
Camada responsável pelas interações externas, como frameworks e bibliotecas.

- **controller/dto/UserController**: Controlador REST para exposição de endpoints relacionados aos usuários.
- **gateway/UserEntityMapper**: Mapper para conversão entre objetos de entidades e DTOs.
- **gateway/UserRepositoryJpa**: Implementação concreta do repositório usando JPA.
- **persistence/RepositoryUser**: Interface que representa as operações no banco de dados.
- **persistence/UserEntity**: Classe que representa a entidade Usuário no banco de dados.

#### **5. UserApplication**
Classe principal para inicializar a aplicação.

---

## Tecnologias Utilizadas
- **Java**
- **Spring Boot**
- **Spring Data JPA**
- **Postgres SQL**
- **Maven**

## Configuração do Ambiente
1. Clone o repositório:
   ```bash
   git clone https://github.com/thallyta/clean-architecture-user.git
   ```

2. Acesse o diretório do projeto:
   ```bash
   cd clean-architecture-user
   ```

3. Compile o projeto:
   ```bash
   mvn clean install
   ```

4. Execute a aplicação:
   ```bash
   mvn spring-boot:run
   ```


## Testes
Os testes de unidade e integração estão localizados no diretório `src/test/java`. Para executar os testes:
```bash
mvn test
```

## Referências Futuras
Esta documentação serve como referência para o uso e manutenção do projeto. Considere as boas práticas adotadas aqui como base para futuros sistemas que utilizem a Arquitetura Limpa.


## Autor
- **Thallyta Castro**  
  [LinkedIn](https://www.linkedin.com/in/thallyta-castro)  
  [GitHub](https://github.com/thallyta)

