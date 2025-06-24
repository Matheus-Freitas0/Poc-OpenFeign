# 📦 Projeto: POC OpenFeign - Consulta de Endereço via CEP

Este projeto é uma **prova de conceito (POC)** utilizando **Spring Boot 3.5.3** com **Spring Cloud OpenFeign**, que realiza chamadas HTTP externas de forma declarativa. O exemplo implementa uma consulta de endereço através do serviço público da **ViaCEP**.

---

## 🚀 Tecnologias Utilizadas

- Java 21
- Spring Boot 3.5.3
- Spring Cloud 2025.0.0
- OpenFeign
- Maven

---

## 🔧 Funcionalidade

A aplicação expõe uma interface cliente utilizando o `@FeignClient` para buscar informações de endereço a partir de um CEP informado, consumindo o serviço da [ViaCEP](https://viacep.com.br/).

Além disso, disponibiliza um endpoint REST próprio para consulta via HTTP:

```http
GET /api/endereco/cep/{cep}
```

Esse endpoint retorna a mesma estrutura `EnderecoResponse` com os dados do endereço.

### Exemplo de Cliente Feign:
```java
@FeignClient(url = "https://viacep.com.br/ws/", name = "viacep-client")
public interface ViaCepClient {
    @GetMapping("/{cep}/json")
    EnderecoResponse buscarEnderecoPorCep(@PathVariable String cep);
}
```

### Exemplo de Controller:

```java
@RestController
@RequestMapping("/api/endereco")
public class ViaCepController {

    @Autowired
    private ViaCepClient viaCepClient;

    @GetMapping("/cep/{cep}")
    public ResponseEntity<EnderecoResponse> buscarEnderecoPorCep(@PathVariable("cep") String cep) {
        return ResponseEntity.ok().body(viaCepClient.buscarEnderecoPorCep(cep));
    }
}
```

### Resposta esperada:
```json
{
  "cep": "01001-000",
  "logradouro": "Praça da Sé",
  "complemento": "lado ímpar",
  "bairro": "Sé",
  "localidade": "São Paulo",
  "uf": "SP"
}
```

---

## 🛠️ Como rodar o projeto localmente

1. **Clone o repositório:**
```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
```

2. **Acesse a pasta do projeto:**
```bash
cd openfeign
```

3. **Compile o projeto com o Maven:**
```bash
./mvnw clean install
```

4. **Execute a aplicação:**
```bash
./mvnw spring-boot:run
```

---

## 🛠️ Como testar o endpoint

Após rodar a aplicação, faça uma requisição HTTP (por exemplo com curl ou Postman):

```bash
curl http://localhost:8080/api/endereco/cep/01001000
```

Resposta JSON esperada:

```json
{
  "cep": "01001-000",
  "logradouro": "Praça da Sé",
  "complemento": "lado ímpar",
  "bairro": "Sé",
  "localidade": "São Paulo",
  "uf": "SP"
}
```

---

## ✅ Pré-requisitos

- Java 21 instalado
- Maven 3.8+ instalado (ou usar o wrapper `./mvnw`)
- Acesso à internet (para consumir a API ViaCEP)

---

## 📁 Estrutura do Projeto

```
com.poc.openfeign
├── OpenfeignApplication.java
├── api
│   ├── client
│   │   └── ViaCepClient.java
│   ├── controller
│   │   └── ViaCepController.java
│   └── response
│       └── EnderecoResponse.java
```

---

## 📌 Observações

- A aplicação utiliza chamadas externas via Feign e disponibiliza um endpoint REST para consulta de CEP.
- Ideal para aprender a configurar e consumir APIs externas com Feign em poucos minutos.

---

## 🧑‍💻 Autor

Matheus M. Freitas  
Desenvolvedor Full Stack | Java & Spring | React  
[LinkedIn](https://www.linkedin.com/in/matheus-m-freitas/)

---
