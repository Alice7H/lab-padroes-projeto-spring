## Explorando Padrões de Projetos na Prática com Java

- Ministrado por Venilton Falvo Jr.

### Padrões de Projetos

São soluções para problemas recorrentes no desenvolvimento e manutenção de software orientado a objetos.
Neste projeto usamos os padrões:

- Singleton:
  Permite a criação de uma única instância de uma classe e fornece um modo para recuperá-la.
  Uso: @Bean e @Autowired.

- Strategy:
  Simplificar a variação de algoritmos para a resolução de um mesmo problema.
  Uso: @Service e @Repository.

- Facade:
  Prover uma interface que reduz a complexidade nas integrações com subsistemas.
  Uso: API REST com Spring Data JPA (usando o h2) e ViaCEP(Feign).

- Recorremos ao spring initializr para gerar o projeto, contendo as dependência Spring Web, H2 database, OpenFeign e Spring Data JPA.

- Adicionamos a dependência `springdoc-openapi-starter-webmvc-ui` para cuidar da documentação.

### Implementações

- Criar pasta exception
- Remover complexidade da classe de serviço para retornar as ResponseEntities
- Atribuir à classe GlobalExceptionHandler o tratamento das exceções
- Tratar de exceções causadas por declarações incorretas do cliente.
- Tratar de exceções por validações dos campos no corpo da requisição do cliente.
- Criar classe ErrorResult para retornar mensagens customizadas no corpo da resposta.
- Criar classe RecordNotFoundException e usá-las na classe de serviço.

### Próximos passos

- Refatoração
