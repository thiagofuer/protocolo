# protocolo
PREPARAÇÃO DO AMBIENTE
##1-Download e instalação Banco de dados MySQL Community Server 5.6.27: https://dev.mysql.com/downloads/mysql/ 
  1.1-Criar Schema chamado "protocolo"    
  1.2-Cirar usuário "protocolo" e senha "protocolo" com permissão total   
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


#Principais Tecnologias Utilizadas
1-Java 8
2-JavaEE
3-Maven
4-JPA/Hibernate
5-CDI


#Como usar o sistema:
1-Popular o banco de dados com os registros iniciais:
  Acesse (Execute apenas uma vez): http://localhost:8080/protocolo/protocolar/gerar
  Com isso o sistema ira popular o banco de dados com os registros      
2-Para protocolar o processo acesse: http://localhost:8080/protocolo/protocolar/novo/1/1          
onde /1/1 são os parametros do WS para a distribuição do protocolo.     
O primeiro parametro representa o id da ClasseProcessual     
O segundo parametro representa o id da Comarca      

Após a execução o WS retornará uma String informando o número único do processo e o nome da vara em que ele foi distribuído.      
