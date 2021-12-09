## JDK11 TestNG framework template

#### 1. Test Execution

- Run all end2end tests from [all.xml](../testSuites/all.xml)

```bash
mvn clean test 
```

- Run single test class

```bash
mvn clean test -Dtest=End2EndUiTest 
```

- Run single test method

```bash
mvn clean test -Dtest=IntegrationTest#integrationTest1 
```

- Run tests filtering by groups

```bash
mvn clean test -Dgroups=end2end
```

- Run tests from different testNG suite XML

```bash
mvn clean test -DtestNGXml=testSuites/end2end.xml -Dgroups=api
```

***

#### 2. Tech stack

- [Java JDK11](https://www.oracle.com/ro/java/technologies/javase-jdk11-downloads.html)
- [Maven 3](https://maven.apache.org/download.cgi)
- [Lombok](https://projectlombok.org/features/all)
- [TestNG](https://testng.org/doc/) - test runner
- [SLF4g](http://www.slf4j.org/manual.html) & [Logback](http://logback.qos.ch/manual/index.html) - logging
- [AssertJ](https://assertj.github.io/doc/) - fluent assertions
- [RestAssured](https://rest-assured.io/) - API testing
- [Vavr.io](https://www.vavr.io/)

***

#### 3. Project structure 

- [maven POM](./pom.xml)
- [logger configuration](./src/test/resources/logback.xml)
- [testNG XML suites](./testSuites)

***

#### 4. Resources
- TestNG
  - [Documentation](https://testng.org/doc/documentation-main.html)
  - [Parallel tests](https://testng.org/doc/documentation-main.html#parallel-tests)