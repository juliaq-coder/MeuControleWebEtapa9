# MeuControleWeb - Etapa 9

Projeto desenvolvido para a Etapa 9 do Projeto Integrador.

## Sobre o projeto

O MeuControle é uma aplicação web para gerenciamento de contas pessoais, permitindo cadastrar e gerenciar pessoas, categorias e contas.

Nesta etapa, o projeto desktop desenvolvido anteriormente foi integrado a uma aplicação Java Web utilizando Spring, banco de dados MySQL e as páginas desenvolvidas no front-end.

## Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring MVC
- Spring Data JPA
- Thymeleaf
- MySQL
- HTML
- CSS
- JavaScript
- Maven
- JUnit
- Git e GitHub

## Funcionalidades

- Página inicial com resumo dos dados
- Cadastro e listagem de pessoas
- Cadastro e listagem de categorias
- Cadastro de contas
- Edição de contas
- Exclusão de contas
- Associação de pessoas e categorias às contas
- Validação de dados
- Persistência em banco de dados MySQL

## Estrutura

O projeto está organizado em camadas:

- Model
- Repository
- Service
- Controller
- Templates
- Recursos estáticos

## Banco de dados

A aplicação utiliza o banco de dados MySQL `MeuControle`.

As configurações de acesso ao banco estão no arquivo:

`src/main/resources/application.properties`

A senha do banco deve ser configurada localmente antes da execução da aplicação.

## Testes

Foram integrados ao projeto os testes automatizados previstos na Etapa 7.

Resultado da execução:

- 6 testes executados
- 0 falhas
- 0 erros
- BUILD SUCCESS

Também foram realizados testes manuais das principais funcionalidades da aplicação.

## Bugtracking

O GitHub Issues foi utilizado para registrar uma falha encontrada durante o desenvolvimento.

Foi identificado um erro no carregamento do template da página Pessoas. O problema foi corrigido e a funcionalidade foi retestada com sucesso.

## Versionamento

O projeto foi versionado utilizando Git e publicado em um novo repositório no GitHub, conforme solicitado na Etapa 9.

## Autora

Júlia Quadros
