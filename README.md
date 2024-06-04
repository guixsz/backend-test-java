<h1 align="center">
    Desafio BackEnd Fcamara
</h1>

Criação de API para cadastrar veículos, estabelecimentos e fazer o gerenciamento das entradas e saídas de um veiculo em um estabelecimento, essa proposta faz parte  [desse desafio](https://github.com/fcamarasantos/backend-test-java) para pessoas desenvolvedoras backend.

## Tecnologias

- [Java](https://www.java.com/es/download/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [PostgresSQL](https://www.postgresql.org/)
- [Postman](https://www.postman.com/)

## Práticas adotadas

- SOLID, DRY, YAGNI, KISS
- POO
- API REST
- Consultas com Spring JPA
- Tratamento de respostas de erros

## Como Executar

- Clonar repositório
- Construir o projeto :
```
$ ./mvnw clean package
```
- Execultar a aplicação :
```
$ java -jar target/backend-test-java-0.0.1-SNAPSHOT.jar
```
A API poderá ser acessada em [localhost:8080](http://localhost:8080).

## Veículo
### Cadastro de veiculos

- Método POST
- Utilize essa URL - [localhost:8080/vehicle](http://localhost:8080/vehicle)
- Estrutura Json para cadastro abaixo
```
{
    "plate": "PKT-2204",
    "brand": "Wolksvagem",
    "color": "Branco",
    "model": "Gol g7",
    "type": "2017"
}
```

### Busca por veículos cadastrado

- Método GET
- Utilize essa URL - [localhost:8080/vehicle](http://localhost:8080/vehicle)

### Deletar veículo

- Método DELETE
- Informe a placa do veiculo no final da URL
- Utilize essa URL - [localhost:8080/vehicle/placa](http://localhost:8080/vehicle)

## Estabelecimento

### Cadastro de estabelecimento
- Método POST
- Utilize essa URL - [localhost:8080/establishment](http://localhost:8080/establishment)
- Estrutura Json para cadastro abaixo

```
 {
        "cnpj": "5468796541",
        "name": "update-establishment-100",
        "address": "update-address-establishment-100",
        "phone": "7777-5555",
        "numberMoto": 3,
        "numberCar": 2
 }
```

### Busca pelos estabelecimento

- Método GET
- Utilize essa URL - [localhost:8080/establishment](http://localhost:8080/establishment)

## Entrada e saida

### Cadastro de entradas e saídas

- Método POST
- Utilize essa URL - [localhost:8080/entry-exit/placa/cnpj](http://localhost:8080/entry-exit)
- Informe a placa do carro que ira ser registrado e o CNPJ do estabelecimento na URL


### Busca pelas entradas e saídas

- Método GET
- Utilize essa URL - [localhost:8080/entry-exit](http://localhost:8080/entry-exit)


