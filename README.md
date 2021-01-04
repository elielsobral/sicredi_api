
<!-- PROJECT LOGO -->
<br />
<p align="center">
  <a href="https://github.com/othneildrew/Best-README-Template">
    <img src="https://seeklogo.com/images/J/Java-logo-6BBEB11CBA-seeklogo.com.png" alt="Logo" width="80" height="80">
  </a>

  <h3 align="center">Aplicacao Sicredi Cooperativa</h3>

  <p align="center">
    Projeto desenvolvido em 12h (até o momento)
    <br />
  </p>
</p>





<!-- ABOUT THE PROJECT -->
## Sobre o Projeto

Arquitetura Hexagonal:


<img src="https://i0.wp.com/www.dineshonjava.com/wp-content/uploads/2020/02/hexagonal-architecture.png?w=530&ssl=1" alt="Logo" width="560" height="280">

### Frameworks utilizados

* [Java 11](#)
* [kafka ](#)
* [Quartz Scheduler](#)
* [Slf4j](#)
* [OpenFeign](#)
* [Lombok](#)



### Tutorial

1. Necessario cassandra: http://www.apache.org/dyn/closer.lua/cassandra/3.11.2/apache-cassandra-3.11.2-bin.tar.gz  
Feito o download, descompacte o arquivo, os diretórios mais importantes são:

● bin: contém os scripts de interação com o Cassandra.

● data: contém os dados que o Cassandra armazena.

● conf: contém os yml’s de configuração do banco.

Nesse momento, consideraremos que o Java 1.8 já está instalado na máquina. Acesse o diretório /bin e execute o seguinte comando:

 ```sh./cassandra```
 
Caso esteja no Windows, utilize o arquivo .bat.
Pronto! O Cassandra já está rodando localmente em apenas um nó, por default ele sobe na porta: 9042.

Retorne para a pasta e execute o  ```sh./cqlsh``` para criar o keyspace necessario:
Execute o comando:
 ```sh
CREATE KEYSPACE keyspace_sicredi
  WITH REPLICATION = {
   'class' : 'SimpleStrategy',
   'replication_factor' : 1
  };


```


## TODO
Testes unitarios
Adicionar Swagger. 
Conectar ao Splunk. 
Provisionar na AWS/OpenShift. 


<!-- CONTACT -->
## Contato

Linked-in: Link: [https://www.linkedin.com/in/philipe-antunes/](https://www.linkedin.com/in/philipe-antunes/)

Project Link: [https://github.com/phiantunes/sicredi_api](https://github.com/phiantunes/sicredi_api)

<!-- LICENSE -->
## License
Distributed under the MIT License. See `LICENSE` for more information.



