# Personal Portfolio - WC

This is a web automation project using Page Object Model as a design pattern. Made with Java, Selenium-Cucumber and Serenity, with a BDD approach.

* Pre-requisites:
    * Java 17+
    * Maven 3.9.x


### Execution Tags

mvn clean verify -Dcucumber.filter.tags=@{TAG} -Denvironment=prd

| Tag | Descripción                            |
| ------------- |----------------------------------------|
| `@regression` | Run all scenarios                      |
| `@parabank-account` | Run scenarios of Account Feature       |
| `@parabank-registerUser` | Run scenarios of Register User Feature |


### Report path

The Serenity test report will be generated in the directory: `target/site/serenity`.

