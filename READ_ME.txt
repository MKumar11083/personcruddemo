http://localhost:8081/swagger-ui.html#!/person45controller/getPersonByIdUsingGET

---For MYSQL DB----
spring.jpa.hibernate.ddl-auto=none
spring.datasource.url=jdbc:mysql://localhost:3306/myappdb(or any db where you have created tables)
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.show-sql=true
spring.data.jpa.database-platform=org.hibernate.dialect.MySQL5InnoDBDialect

----Create table for MYSQL---
create table person(person_id int primary key not null auto_increment,person_firstname varchar(255) not null,
person_lastname varchar(255),person_dob datetime not null);

create table address(id int primary key not null auto_increment,address_lineone varchar(500) not null,address_linetwo varchar(500),
city varchar(255) not null,postal_code varchar(100) not null,country varchar(255) not null,
person_id int not null,CONSTRAINT fk_person FOREIGN KEY (person_id) REFERENCES person(person_id) ON UPDATE CASCADE ON DELETE CASCADE
);