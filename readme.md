Analyze sales data and generate summarized report
=================================================

The goal of this project is to watch an input folder that receives sales data in specific file format and create a summarized report.  

The input file has the following sections:

**Salesman data**  
Salesman data has the format id 001 and the line will have the following format:  
  ```
001çCPFçNameçSalary
  ```

**Customer data**  
Customer data has the format id 002 and the line will have the following format:  
  ```
002çCNPJçNameçBusiness Area
  ```

**Sales data**
Sales data has the format id 003. Inside the sales row, there is the list of items, which is wrapped by square brackets []. The line will have the following format:  
  ```
003çSale IDç[Item ID-Item Quantity-Item Price]çSalesman name
  ```
## Input and output files

The input files must be stored in %HOMEPATH%/data/in. Their extensions must be ".dat".  
The output files will be created at %HOMEPATH%/data/out. The output file will have the same name of the input file, but its extension will be ".done.dat".  

## Technologies

The technologies used in this project are:

* **Gradle 2.11**: Used to automate the build.
* **JUnit 4.12**: Used to implement tests.
* **Java 8 u101**: Used to write the code.

## Running the application

After clonning this project you must build and launch the application.

  ```
  gradlew clean  
  gradlew jar  
  ```

To launch the application, run the following command:

  ```
  java -jar .\build\libs\sales-report-0.1.0-SNAPSHOT.jar  
  ```

