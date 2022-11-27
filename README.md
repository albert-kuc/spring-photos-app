# Photos

## Overview

Spring Boot Photos App to upload and store images.

### Sources

Based on tutorial by Marco Behler, initially found at 
[JetBrains Tutorials](https://www.jetbrains.com/idea/guide/tutorials/marco-codes-spring-boot/).
Available also on YT on "Marco Codes" channel [here](https://www.youtube.com/watch?v=QuvS_VLbGko).

Other tutorials by Marco: https://www.marcobehler.com/

### Alterations

Few changes are included compared to the source code:
* schema.sql - newer Spring Boot version required to SQL data to be defined as: `data BINARY LARGE OBJECT`
* DownloadController.java - includes additional "view" endpoint for comparison
* Photo.java - model uses Project Lombok for boilerplate code reduction

### Data

App stores data using JDBC inside `/data/myDB.db` file (which is not uploaded to GitHub repo),
but eventually will get created on initial data storage.

### Endpoints

By default, the launched app is available under: http://localhost:8080  

Browser endpoints:

* `/` - Hello world
* `/photos` - all photos JSON
* `/photos/1`- specific photo JSON
* `/upload.html` - page for uploading files
* `/download/1` - download file
* `/view/1` - display file

## Setup

### Initialize Spring Boot App

https://start.spring.io/

Details used for this project:
* Project --> Maven Project
* Language --> Java
* Spring Boot --> 2.7.5
* Project Metadata:
  * Group --> com.qc
  * Artifact --> photos
  * Name --> photos
  * Description --> left self generated
  * Package name --> left self generated
* Packaging --> Jar
* Java --> 17
* Dependencies:
  * Spring Data JDBC
  * Spring Web
  * H2 Database
  * Lombok

### Deploy

#### Pack

Select `Maven` -> `Clean` + `Package`, 

or from the terminal execute `./mvnw clean package`

#### Run

File is generated in the `/target` location: photos-0.0.1-SNAPSHOT.jar. 
This file may be launched without IDE but with Java 17. 
On launch a new database to store files will be generated inside the same repository.

To launch, open the file location and execute: `java -jar .\photos-0.0.1-SNAPSHOT.jar`