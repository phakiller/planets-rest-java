# Planets

Conjunto de APIs para realizar o gerenciamento de Planetas que aparecem na franquia [Star Wars](https://www.starwars.com) com um integração com a API Publica de dados da franquia, [SWAPI](https://swapi.co).




## Tecnologias Utilizadas

* [**Java 8**](https://www.java.com/pt_BR/download/faq/java8.xml)

* [**MongoDB**](https://www.mongodb.com)

* [**Docker**](https://www.docker.com)

* [**Docker Compose**](https://docs.docker.com/compose/)

* [**Swagger UI**](https://swagger.io/tools/swagger-ui/)

  


## Subindo o serviço

### Requisitos

* Rodar dentro de um container:

    * [**Docker**](https://www.docker.com)
    * [**Docker Compose**](https://docs.docker.com/compose/)

* Rodar direto na máquina:
    * [**Gradle**](https://gradle.org) >= 5.4.1
    * [**Java 8**](https://www.java.com/pt_BR/download/faq/java8.xml)

### Preparando e Rodando o Serviço

**Subindo com o docker**

1. Build do Projeto: 
   
    ```sh
    make buildgradle
    ```
    
2. Build da Imagem do container:

    ```sh
    make buildimage
    ```

3. Subir o Serviço juntamente com o MongoDB:

    ```sh
    make drun
    ```

4. Para para a execução do serviço:

    ```sh
    make dstop
    ```



**Subindo direto na máquina**

1. Build do Projeto:

   ```sh
   make buildgradlelocal
   ```

2. Subir o serviço:

   ```sh
   make jrun
   ```

   Obs.: Utilizando desta forma o MongoDB deverá ser iniciado separadamente, para subir utilizando o ambiente esperado pela aplicação, basta executar o comando:

   ```sh
   make runmongo
   ```

   

Uma vez que o serviço esteja funcionando basta utilizar, as rotas serão expostas em:

[http://localhost:6606](http://localhost:6606/)

E a documentação em:

[http://localhost:6606/swagger-ui.html](http://localhost:6606/swagger-ui.html)

Utilizando a interface da Documentação, é possivel interagir com todas as rotas disponiveis e ver os objetos que recebem/retornam.

![Swagger Home](/images/swagger_homescreen.png "Swagger Home")



### Número de Filmes por Planeta

Na hora de criar um novo filme é feita uma requisição para [SWAPI](https://swapi.co/), se houver algum problema de conexão esse atributo ficará `null`. Se o serviço retornar mais de um Planeta durante a busca, o atributo será setado como `-1`. Se o serviço devolver apenas um planeta porém o nome for divergente do nome passado na request o atributo será setado como `-1`.

Só irá ser valido a contagem, se o serviço **SWAPI** retornar apenas um planeta e que o nome seja igual ao enviado na request para ser salvo.



### Pontos de Melhoria

* Utilizar o [Feign](https://github.com/OpenFeign/feign) ao invés do [Retrofi](https://square.github.io/retrofit/)
* Escrever Testes