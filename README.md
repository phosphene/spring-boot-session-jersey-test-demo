Spring Boot Jersey REST API
=====================

# Build

* Oracle [Java SE](http://www.oracle.com/technetwork/java/javase/downloads/index.html) 7

The project should build normally

    $ mvn clean compile

This is a Jersey 2.x project: see pom.xml for details



# Test

    $ mvn verify

The tests are focused on integration tests.

The test framework is RestAssured

The current minimal test proves that sessions based authentication works but that it uses a cookie strategy rather than a header strategy as is defined in the security config.
