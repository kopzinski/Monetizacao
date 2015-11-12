# senac_montetizacao
Trabalho da disciplina de Programação pra Internet II com o Professor Ries
===========
TODO (real):
 - Extrato por cliente (relatorio)
 - Aplicar as DAOs...
 - Facelift...
 - Inserir as annotations nos Entities

===========
Especificação OFICIAL do Trabalho....

Este trabalho consiste em desenvolver uma aplicação Web utilizando Java Server Faces (JSF) e que realize persistência através do Java Persistence API (JPA). O objetivo é desenvolver a aplicação Web aplicando os padrões MVC e MOR, e utilizar as técnicas e funcionalidades vistas na disciplina de Programação para Internet II.

Instruções gerais

Com base na especificação realizada anteriormente, o grupo de alunos (um ou dois alunos) deverá realizar uma aplicação Web dando continuidade ao Trabalho I. A aplicação ainda deverá ser composta por um CRUD de pelo menos três entidades, uma ou mais funcionalidades específicas (dependendo do escopo), além de autenticação por login e senha, tendo dois níveis de usuário (ex: admin e comum). Mas nesse trabalho, essas funcionalidades deverão fazer uso de persistência utilizando JPA. Além disso, dois relatórios e uma busca deverão ser aplicados no trabalho. O tipo de relatório e a busca são livres, mas pelo menos uma dessas funcionalidades deverá ter integração de duas ou mais tabelas.

Caso o aluno não tenha enviado a especificação, ele deverá manter o tema definido no Trabalho I (no Anexo do Trabalho I). No entanto, nesse trabalho, os dados deverão ser persistidos e todas as funcionalidades (incluindo os relatórios) deverão ser implementados. Os alunos poderão realizar o trabalho individualmente ou em dupla (mantendo a dupla do Trabalho I).

A aplicação desenvolvida deverá contemplar alguns assuntos vistos em aula. Assim, a avaliação será baseada de acordo com as funcionalidades a serem desenvolvidas e com os conceitos de JSF e JPA vistos em aula empregados no desenvolvimento dessa aplicação.

Avaliação

O conceito desse trabalho será baseado de acordo com as funcionalidades realizadas no trabalho e com os conceitos de JSF e JPA empregados no trabalho. Abaixo segue a relação de conceitos e features a serem realizadas no trabalho:

===Conceito C:
CRUDs completos utilizando JPA (através do EntityManagerFactory ou criando o Pool adequadamente) e trabalhando adequadamente com JSF;
Navegação adequada; OK
Interface gráfica razoavelmente adequada (ex: empregando h:panelGrid); 
Realização das entidades de maneira adequada; 
Aplicação dos DAOs de maneira correta;
Realizar pelo menos uma consulta adequadamente – implementando o relatório ou a busca;
Utilização dos beans de maneira adequada; OK
Realização de Login e Logout. OK


===Conceito B:

Realização das funcionalidades para o conceito C;
Realização da(s) funcionalidade(s) específica(s);
Realização de Login com os dois níveis de usuário;
Realização dos relatórios e buscas de maneira correta utilizando JPQL;
Uso de Facelets e layout adequado, utilizando CSS.
Conceito A:

Realização das funcionalidades para o conceito B;
Realização de consultas bem elaboradas e/ou utilização da API Criteria e de Named Queries.
Layout excelente e preferencialmente responsivo, com o uso de bootstrap;
Utilização de um framework não trabalhado em aula (ex: Primefaces);
Utilização de filtros para bloquear usuários não autenticados corretamente.
Apresentação e Entrega:

O trabalho deverá ser realizado individualmente ou em dupla. Os alunos deverão estar presentes em aula para apresentar o trabalho. A entrega deverá ser realizada pelo Moodle do professor (http://www.profries.com.br/moodle), anexando o projeto como arquivo zipado (zip), contendo o código fonte e todas as bibliotecas extras utilizadas (alinhadas conforme o projeto). Caso o grupo tenha utilizado o Github, poderá relacionar o link em um arquivo readme.txt dentro do projeto.