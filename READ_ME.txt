http://localhost:8081/swagger-ui.html#!/person45controller/getPersonByIdUsingGET

---For MYSQL DB----
spring.jpa.hibernate.ddl-auto=none
spring.datasource.url=jdbc:mysql://localhost:3306/myappdb(or any db where you have created tables)
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.show-sql=true
spring.data.jpa.database-platform=org.hibernate.dialect.MySQL5InnoDBDialect