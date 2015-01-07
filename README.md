Spring Boot Jersey REST API
=====================

This is a minimal project that consists of Spring Boot, Jersey, and Spring Sessions Library with tests to prove that sessions management is functional.


# Build

* Oracle [Java SE](http://www.oracle.com/technetwork/java/javase/downloads/index.html) 7

The project should build normally

    $ mvn clean compile

This is a Jersey 2.x project: see pom.xml for details



# Test

    $ mvn verify

The tests are focused on integration tests.

The test framework is RestAssured

The current minimal test now proves that sessions based authentication works now proves that a header strategy is in place and functional.
