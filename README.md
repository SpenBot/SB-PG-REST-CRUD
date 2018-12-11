# SB-PG-REST-CRUD
Java, Spring-Boot, Hibernate, JPA, Postgres Restful CRUD API


## DATABASE LOCAL START UP (on linux) :

  - install postgresql and confirm
```
      $ sudo apt update
      $ sudo apt install postgresql postgresql-contrib
      $ psql --version
```
  - sign in to psql CLI
```
      $ sudo -u postgres psql postgres
```
  - now insert the .sql file with full-path into psql (path can be copied by right-clicking file in your text-editor)
  - (don't forget the ;)
  - then quit psql
```  
      # \i ....<full-path>/SB-PG-REST-CRUD/db/southpark.sql;
      # \q
```
