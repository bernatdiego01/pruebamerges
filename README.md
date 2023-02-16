# WebService Project
## Autors
Bernat Diego Carreras & Juan Sánchez Gayoso

## Numero de grup
Grupo 6

## Temàtica
Concierto de música

## Informació / Objectiu projecte
Elaboración de un WebService de una base de datos con información de la temática correspondiente mediante el uso de Spring Boot y JPA/Hibernate para compartir datos con el exterior.

## Informació tècnica de la implementació de codi feta
1. __Creación del proyecto con Spring Boot__
    * Requisitos Proyecto
      1. Maven Project
      2. Java Language
      3. Versión 3.0.2 Spring Boot 
      4. JAR Packaging
      5. Versión 17 Java
    * Dependencias
       1. Spring Web
       2. Spring Boot Dev Tools
       3. Spring Data JPA
       4. MySQL Driver
       
2. __Creación de la Base de Datos__ (conciertomusica)
   * Tabla Concierto
       1. Id autoincrementable (PK)
       2. Nombre Cantante (Varchar)
       3. Fecha Concierto (Date)
       4. Entradas Disponibles (int)
       
3. Una vez importado el proyecto, se define la __conexión a la BBDD__ a través del archivo ``application.properties``
```
spring.datasource.url=jdbc:mysql://localhost:3306/conciertomusica
spring.datasource.username=root
spring.datasource.password=

spring.jpa.show-sql=true
```
4. __Desarrollo del WebService__

   4.1 __Clase DemoApplication__, que será la clase a ejecutar
   ```
   package com.example.demo;

   import org.springframework.boot.SpringApplication;
   import org.springframework.boot.autoconfigure.SpringBootApplication;
   import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

   @SpringBootApplication
   @EnableJpaAuditing
   public class DemoApplication {
      public static void main(String[] args) {
         SpringApplication.run(DemoApplication.class, args);
      }
   }
   ```
   4.2 __Definición del POJO (Concierto.java)__ , donde se mapearán los atributos con los respectivos campos de la base de datos concierto.
   
   4.3 __Interfaz ConciertoRepository.java__ , en esta se definen dos operaciones/métodos que serán utilizados por la clase ConciertoController 
   ```
   @Repository
   public interface ConciertoRepository extends JpaRepository<Concierto, Long>{

       List<Concierto> findByCantante(@Param("cantante") String cantante);

       List<Concierto> findByFecha(@Param("fecha") Date fecha);
   }
   ```
   4.4 __Implementación ConciertoController.java__ , esta clase controla la API Rest y contiene los métodos necesarios para llevar a cabo un CRUD.
   
      * GET : devuelve todos los conciertos alamcenados en la base de datos
      ```
      @GetMapping("/conciertos")
      public List<Concierto> allConciertosJSON(){
         return repository.findAll();
      }
      ```
      
      * POST : permite crear un nuevo concierto
      ```
      @PostMapping("/concierto")
      public Concierto createConcierto(@RequestBody Concierto concierto) {
         return repository.save(concierto);
      }
      ```
      
      * PUT : actualiza un determinado concierto a partir de su Id
      ```
      @PutMapping("/concierto/{id}")
      public Concierto updateConcierto(@PathVariable Long id ,@RequestBody Concierto concierto) {
         return repository.save(concierto);
      }
      ```
      
      * DELETE : elimina un concierto según el Id indicado
      ```
      @DeleteMapping("/concierto/{id}")
      public void deleteConcierto(@PathVariable("id") Long id) {
         repository.deleteById(id);
      }
      ```
      
5. ___User Stories___
   * US3 (Autenticación) :
   * US4
   
      1. Para eliminar todos los registros de nuestra base de datos hacemos uso de ``repository.deleteAll()``
          
          ```
          @DeleteMapping("/conciertos")
          public void deleteAllConciertos(){
            repository.deleteAll();
          }
          ```
          
          ![Imagen]

      2. Mediante ``repository.count()`` obtenemos el número de filas que contiene la BBDD
          ```
          @GetMapping("/total_conciertos")
          public Long countConciertos(){
            return repository.count();
          }
          ```
          ![Imagen]
          
   * US5 : para poder realizar el intercambio de datos mediante el uso de xml hemos implementado : 
      1. El ``pom.xml``, añadiendo la dependencia correspondiente para dar formato xml

            ```
            <dependency>
               <groupId>com.fasterxml.jackson.dataformat</groupId>
               <artifactId>jackson-dataformat-xml</artifactId>
            </dependency>
            ```
       2. Las anotaciones y métodos de la clase ConciertoController

            En las anotaciones, se ha definido un endpoint para cada formato, el cual viene especificado mediante ``produces={"application/formato"}`` .

            Para los métodos, siguiendo la misma línea, se ha creado uno para cada tipo de formato.

            Ambos procedimientos se han llevado a cabo para todos las operaciones de GET.

            ```
            @GetMapping(value = "/conciertos_json", produces={"application/json"})
            public List<Concierto> allConciertosJSON(){
               return repository.findAll();
            }
            
            @GetMapping(value = "/conciertos_xml", produces={"application/xml"})
            public List<Concierto> allConciertosXML(){
               return repository.findAll();
            }
            ```
            
            ![Imagen]
            
            ![Imagen]


## Data de començament i fi de l’sprint
Comienzo: 26 de enero de 2023     

Final: 13/15 de febrero de 2023 

## Si no s’han pogut complir els objectius de l’sprint, explicar per què
