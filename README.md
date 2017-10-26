# protocolo alterado MAC e mergeado no windows

PREPARAÇÃO DO AMBIENTE
##1-Download e instalação Banco de dados MySQL Community Server 5.6.27: https://dev.mysql.com/downloads/mysql/ 
  1.1-Acessar o banco   
    `mysql -u root -p`    
  1.2-Criar Schema chamado "protocolo"    
  `CREATE DATABASE protocolo;`    
  1.2-Cirar usuário "protocolo" e senha "protocolo" com permissão total   
  ```
  CREATE USER 'protocolo'@'%' IDENTIFIED BY 'protocolo';     
  GRANT ALL ON protocolo.* TO 'protocolo'@'%' IDENTIFIED BY 'protocolo';        
  FLUSH PRIVILEGES;           
  ```
##2-Donwload e Configuração do Wildfly 9.0.2.Final: http://wildfly.org/downloads/
  2.1-Descompactar o arquivo baixado      
  2.2-Configurar o standalone.xml que se encotra em: wildfly-9.0.2.Final\standalone\configuration\standalone.xml    
    2.2.1-Adicionar o datasource     
```
                <datasource jta="true" jndi-name="java:jboss/datasources/protocolo-ds" pool-name="protocolo" enabled="true" use-java-context="true" use-ccm="true">
                    <connection-url>jdbc:mysql://localhost:3306/protocolo</connection-url>
                    <driver>mysql</driver>
                    <transaction-isolation>TRANSACTION_READ_COMMITTED</transaction-isolation>
                    <pool>
                        <min-pool-size>1</min-pool-size>
                        <max-pool-size>100</max-pool-size>
                        <prefill>true</prefill>
                    </pool>
                    <security>
                        <user-name>protocolo</user-name>
                        <password>protocolo</password>
                    </security>
                    <statement>
                        <prepared-statement-cache-size>32</prepared-statement-cache-size>
                        <share-prepared-statements>true</share-prepared-statements>
                    </statement>
                </datasource>
                <drivers>
                    <driver name="mysql" module="com.mysql">
                        <xa-datasource-class>com.mysql.jdbc.jdbc2.optional.MysqlXADataSource</xa-datasource-class>
                    </driver>
                </drivers>
```      
  2.2.2-Criar o modulo de conexão mysql em: wildfly-9.0.2.Final\modules\system\layers\base\com\mysql\main      
    2.2.2.1Criar o arquivo module.xml com o seguinte conteudo
``` 
<?xml version="1.0" encoding="UTF-8"?>
<module xmlns="urn:jboss:module:1.3" name="com.mysql">
    <resources>
        <resource-root path="mysql-connector-java-5.1.36-bin.jar"/>
    </resources>

    <dependencies>
        <module name="javax.api" />
        <module name="javax.transaction.api"/>
        <module name="javax.servlet.api" optional="true"/>
    </dependencies>
</module>
``` 
    2.2.2.2-Adicione o jar do mysql: mysql-connector-java-5.1.36-bin.jar       
   [https://downloads.mysql.com/archives/c-j/]
    
##3-Importar o projeto no eclipse      
##4-Adicionar o wildfly como server no eclipse
##5-Compilar e executar       
Após fazer o deploy da aplicação no wildfly, acesse http://localhost:8080/protocolo/index.xhtml 

#Principais Tecnologias Utilizadas
1-Java 8     
2-JavaEE     
3-Maven     
4-JPA/Hibernate     
5-CDI     
6-JUnit   
7-Gson    
8-Angular 1   
9-Bootstrap 

#Live Preview
[http://wildfly-tfigueiredo.rhcloud.com/protocolo/index.xhtml]

#Como usar o sistema:
Selecione a comarca de destino,a classe processual e então clique no botão distribuir.
O sistema vai fazer a analise de qual a vara da comarca que deve receber o processo, faz a distribuiço e depois retorna uma mensagem informando para qual vara foi distribuida e qual o número único do processo.
