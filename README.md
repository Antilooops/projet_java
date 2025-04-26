# Java PVZ project

## Introduction

This a Java backend for a Plant Vs Zombie game frontend. It mainly manipulates three objects such as maps, plants and zombies using the available routes detailed below.

## Requirements

To use the backend, please check that you have the following requirements :

- Java21
- Maven
- Tomcat10
- MariaDB

(J'utilise Archlinux qui n'a pas MySQL dans son package manager. Je dois donc utiliser MariaDB qui est l'alternative que la distro propose. Voir: https://wiki.archlinux.org/title/MariaDB)

## Technologies

Every dependencies can be found in the `pom.xml` file.

- Springframework
- MariaDB
- Jakarta
- Jackson

## API routes

Calls to the backend should be done using : http://localhost:8080

### Plantes

- GET `/plantes`
- GET `/plantes/{id}`
- POST `/plantes`
- PUT `/plantes/{id}`
- DELETE `/plantes/{id}`

### Zombies

- GET `/zombies`
- GET `/zombies/{id}`
- POST `/zombies`
- PUT `/zombies/{id}`
- DELETE `/zombies/{id}`

### Maps

- GET `/maps`
- GET `/maps/{id}`
- POST `/maps`
- PUT `/maps/{id}`
- DELETE `/maps/{id}`

## Notes and choices

### Global structure

Because I wanted to learn how to do it the "proper way" I decided to not simplify the structure of the code. The final code structure is the following :

```
src/
└── main/
    ├── java/
    │   └── com/
    │       └── epf/
    │           ├── api/
    │           │   ├── controller/
    │           │   │   └── ...
    │           │   ├── exception/
    │           │   │   └── ...
    │           │   ├── dto/
    │           │   │   └── ...
    │           │   └── mapper/
    │           │       └── ...
    │           ├── config/
    │           │   ├── JDBCconfig.java
    │           │   └── WebAppInit.java
    │           ├── core/
    │           │   ├── exception/
    │           │   │   └── ...
    │           │   ├── model/
    │           │   │   └── ...
    │           │   └── service/
    │           │       └── ...
    │           └── persistance/
    │               ├── dao/
    │               │   └── ...
    │               ├── entity/
    │               │   └── ...
    │               ├── exception/
    │               │   └── ...
    │               ├── mapper/
    │               │   └── ...
    │               └── repository/
    │                   └── ...
    ├── resources/
    └── webapp/
        └── WEB-INF/
            ├── spring-config.xml
            └── web.xml
```

### Data validation

Validation of data is done mainly in the core layer. Incoming data from the controller is checked by the controller's getters or/and by services. DTOs serve as temporary containers to hold information just received by the backend. No check are made for wrong data format or else.

Note that ids are checked differently: multiple steps are done at different moments to maintain data integrity. First, controllers (ones who require an id in the URL) check if the given id is negative. Then in services, a check is done in the database to see if the id exists or not.

### Error handling
