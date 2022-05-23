DRAGONS

Api de CRUD para cadastro de dragoes <br/>

Como funciona: <br/>

1- Rodar a classe DragonApplication <br/>
2- Acessar o Swagger http://localhost:8080/swagger-ui.html <br/>
3- Aplicação utiliza mongodb embutido atraves da "lib de.flapdoodle.embed.mongo" <br/>
4- Criada a classe DragonConverter de conversao de model/entity para DTO e vice versa <br/>
5- Criada a classe DragonService para encapsular toda a logica de negocio e comunicacao entre o controller e o repository <br/>
6- Toda a classe anotada com @Configuration (exemplo SwaggerConfig) sera iniciada no start da aplicacao <br/>
