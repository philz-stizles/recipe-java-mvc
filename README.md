# recipe-java-mvc

## H2

http://localhost:8080/h2-console

## Project Lombok

- Install Lombok Annotation extension in VS Code
- Configure pom.xml:

  ```xml
    <dependency>
      <groupId>org.projectlombok</groupId>
      <artifactId>lombok</artifactId>
    </dependency>
  ```

- Short:

## Web Jars

```xml
  <dependency>
      <groupId>org.webjars</groupId>
      <artifactId>bootstrap</artifactId>
      <version>5.1.0</version>
  </dependency>
```

usage:

```html

```

## JUnit Test

- Install Lombok Annotation extension in VS Code
- Configure pom.xml:

  ```xml
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-test</artifactId>
      <scope>test</scope>
    </dependency>

    <dependency>
      <groupId>org.junit.vintage</groupId>
      <artifactId>junit-vintage-engine</artifactId>
      <scope>test</scope>
      <exclusions>
        <exclusion>
          <groupId>org.hamcrest</groupId>
          <artifactId>hamcrest-core</artifactId>
        </exclusion>
      </exclusions>
    </dependency>
  ```
