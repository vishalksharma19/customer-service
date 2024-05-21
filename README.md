# customer-service

Customer service consume the entire multiline string as input and produce the following report as the console log

  - The number of unique customerId for each contractId
  - The number of unique customerId for each geozone
  - The average buildduration for each geozone
  - The list of unique customerId for each geozone


### Service Configuration

- Java
- Maven

### Used library

- [Junit](https://junit.org/junit5/)
- [Assertj](https://assertj.github.io/doc/)

### Run the project
- Make sure to be in the root directory
- Clean and build the project, run the command:
```aidl
mvn install
```
This will also generate a jar file with all the dependencies which we will run once
it has been created.
- Run the `Main` method in `CustomerApplication.java` by running
```
mvn exec:java
```
- Alternatively, you can run the `main` method in `Application.java` in your chosen IDE, e.g. `IntelliJ`

- Once service started input multiline text in console.
- After valid input give one empty line to start the process and terminate the console reading.
- Output will be available in console log.