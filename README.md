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
    2.2.2.1-Adicionar o arquivo module.xml e mysql-connector-java-5.1.36-bin.jar     
    
##3-Abrir o projeto no eclipse      
##4-Adicionar o wildfly no eclipse
##5-Importar o projeto protocolo no eclipse
##6-Compilar e rodar
