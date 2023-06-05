This project contains API test for attestata website. <br>
In order to execute the tests on different environments you'll need to use the following commands: <br>

PROD environment: <br>
mvn clean test -DbaseURL="https://attestata.ca" <br>

DEV environment: <br>
mvn clean test -DbaseURL="https://attestata.axamit.com"

QA environment: <br>
mvn clean test -DbaseURL="https://qa-attestata.axamit.com"