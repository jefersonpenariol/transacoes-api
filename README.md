# Transacoes - api
 Projeto que simula a rotina de transaçoes realizadas por meio de cartão.
 
# Requisitos para execução e construção
 - Java 11
 - Gradle
 - Docker
 
 
# Comandos
 Os comandos descritos abaixo devem ser executados no diretório raiz do projeto
 
# Build
gradlew build

# BootJar
gradlew bootJar 

# Executar a aplicação por container Docker
- Criar o container: docker-compose build
- Iniciar o container: docker-compose up
- Encerrar o contrainer: docker-compose down

# Documentação da aplicação
	http://localhost:8090/swagger-ui.html
	
# Configuração do acesso ao banco de dados em memória H2
	http://localhost:8090/h2-console/

- Driver: org.h2.Driver
- URL: jdbc:h2:mem:db
- username=sa
- password=sa 

# Configuração para execução da aplicação em banco de dados ORACLE
Alterar os parâmetros de configuração com o banco de dados no arquivo application.properties, informando os parâmetros para conexão com o banco desejado: 
- spring.datasource.driver-class-name=oracle.jdbc.driver.OracleDriver
- spring.datasource.url=jdbc:oracle:thin:@//IP:PORT/DB
- spring.datasource.username=USUARIO
- spring.datasource.password=SENHA

Executar os scripts de criação e carga disponíveis na pasta scripts/oracle.
